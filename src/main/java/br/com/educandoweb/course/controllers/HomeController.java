package br.com.educandoweb.course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	@GetMapping
	public String home() {
		return "<body style=\"background-color:powderblue;\"> <h1>APLICATIVO SEM FRONT-END. SOMENTE PARA USO NO BANCO DE DADOS </h1>" + 
	    "\n <h1> UTILIZE ALGUNS DESSES LINKS NO POSTMAN [ HABILITADO O POST, DELETE E GET ]"
	    + "</h1> <h1> https://databaserequests.herokuapp.com/users </h1>"
	    + " <h1> https://databaserequests.herokuapp.com/orders </h1>"
	    + " <h1> https://databaserequests.herokuapp.com/products </h1>"
	    + " <h1> https://databaserequests.herokuapp.com/categories </h1> </body>";
	}
}
