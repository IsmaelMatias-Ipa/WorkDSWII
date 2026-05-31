package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class ProjCrudSoapApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjCrudSoapApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(ProjCrudSoapApplication.class, args);

		productoImplement service = context.getBean(productoImplement.class);

		Endpoint.publish("http://localhost:1517/ws/producto", service);

	}

}
