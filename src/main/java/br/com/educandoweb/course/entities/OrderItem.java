package br.com.educandoweb.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.educandoweb.course.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// CHAVE COMPOSTA DE ORDER E PRODUCT USAR EmbeddedId
	// ***** NÃO CRIAR GET E SET E NEM POR NO CONSTRUTOR AUTOMATICAMENTE *****
	// O GET/SET E AS REFERENCIAS NO CONSTRUTOR TEM QUE SER CRIADAS MANUALMENTE
	@EmbeddedId
	// PRECISA INSTANCIAR A CLASSE DA CHAVE COMPOSTA
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		
		// PARA USAR A CHAVE PRIMARIA COMPOSTA TEM QUE COLOCAR MANUALMENTE NO CONSTRUTOR E SETAR OS VALORES
		id.setOrder(order);
		id.setProduct(product);
		//
		
		this.quantity = quantity;
		this.price = price;
		
	}
// PARA A CHAVE COMPOSTA TEM QUE CRIAR OS GET E SET MANUALMENTE
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
		}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	

	public Product getProduct() {
		return id.getProduct();
		}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	//       **********************************
	
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
