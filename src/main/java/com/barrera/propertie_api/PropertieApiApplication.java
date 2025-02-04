package com.barrera.propertie_api;

import com.barrera.propertie_api.entities.*;
import com.barrera.propertie_api.repositories.PropertyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PropertieApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PropertieApiApplication.class, args);

		PropertyRepository pRepository = context.getBean(PropertyRepository.class);

		Set<Operation> operations = new HashSet<>();


		Set<Price> prices = new HashSet<>();
		prices.add((new Price((float)320000, Currency.USD, 0)));

		operations.add(new Operation(OperationType.SELL, prices));

		PropertyType propType = new PropertyType("AP", 2, "Departamento");

		Location propLocation = new Location("Argentina | Costa Atlantica | Mar Del Plata | Playa Grande", "Playa Grande");

		ArrayList<Photo> photos = new ArrayList<>();
		photos.add(new Photo("", "https://static.tokkobroker.com/original_pictures/99504967725068874680456842025477874485126943892582507987146197966219484534905.jpg", "https://static.tokkobroker.com/thumbs/99504967725068874680456842025477874485126943892582507987146197966219484534905_thumb.jpg"));

		Property prop = new Property("Aristobulo Del Valle  2800",
				4,
				2,
				"PLAYA GRANDE - MAR DEL PLATA    \n\nLiving comedor, pisos porcelanato con ventanles y salida a balcon terraza con deck y     Vista al mar    \nToilette     \nDormitorio en suite con placard y balcon con vista a los troncos    Dormitorio con placard y salida al balcon    \nBaño completo    \nCocina con barra desayunadora,  alacenas y bajomesadas    Calefaccion por losa    \n2 cocheras    \nBaulera    \n93 m2    mas Balcones \nEdificio cuenta con piscina    \nQuincho    Sauna   Laundry    (actualmente esta restringido el uso por la pandemia)\nSeguridad las 24 hs    \nPreparado para 4 personas\r\n        ",
				"Aristobulo Del Valle  2800",
				"0",
				propLocation,
				operations,
				0,
				photos,
				"92.00",
				3,
				"0.00",
				2,
				"m2",
				0,
				"92.00",
				propType);

		pRepository.save(prop);
	}

}
