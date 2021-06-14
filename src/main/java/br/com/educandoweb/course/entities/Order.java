package br.com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.educandoweb.course.entities.enums.OrderStatus;

@Entity
// DAR UM NOME PARA A TABELA
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// CONFIGURANDO O HORARIO
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;


	// ENUM POR NUMERO
	private Integer orderStatus;
	
	// LIGAÇÃO MUITOS PARA UM * -> 1
	@ManyToOne
	// CRIAÇÃO DA CHAVE ESTRANGEIRA COM O NOME DE " client_id "
	@JoinColumn(name = "client_id")
	private User client;
	
	// ASSOCIAÇÃO 1 PARA MUITOS RECEBENDO O id DE ORDERITEM E O ORDER QUE ESTÁ DENTRO, RETORNANDO O ID DO ORDER
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	// ASSOACIAÇÃO 1 PARA 0 OU 1    0...1
	// MAPEAR COM CASCADE PARA TANTO O PAYMENT QNT O ORDER TER O MESMO ID
	@OneToOne(mappedBy = "order" , cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		
		// ENUM POR NUMERO
		setOrderStatus(orderStatus);
	}

	public Set<OrderItem> getItems(){
		return items;
	}
	
	// ENUM POR NUMERO
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	// ENUM POR NUMERO
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}
	}

	
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the moment
	 */
	public Instant getMoment() {
		return moment;
	}

	/**
	 * @param moment the moment to set
	 */
	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	/**
	 * @return the client
	 */
	public User getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
