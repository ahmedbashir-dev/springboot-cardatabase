package com.springbootdev.cardatabase;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootdev.cardatabase.domain.Car;
import com.springbootdev.cardatabase.domain.CarRepository;
import com.springbootdev.cardatabase.domain.Owner;
import com.springbootdev.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner o1 = new Owner("Ahmed","Bashir");
		Owner o2 = new Owner("Zeeshan", "Zulfiqar");
		ownerRepository.saveAll(Arrays.asList(o1,o2));
		
		carRepository.save(new Car("Toyota", "Camry", "Indigo", "PAK-1123",2005,50000,o1));
		carRepository.save(new Car("Toyota", "Corolla", "Black", "LHR-2014",2012,13000,o1));
		carRepository.save(new Car("Toyota", "Avalon", "White", "LIS-2102",2015,80000,o1));
		carRepository.save(new Car("Toyota", "GR86", "Red", "PAK-0007",2022,800000,o2));
		carRepository.save(new Car("Honda", "City", "Green", "PAK-2223",2005,20000,o2));
		carRepository.save(new Car("Honda", "Civic", "Black", "PAK-2023",2009,21000,o2));
		carRepository.save(new Car("Honda", "Accord", "Dark Green", "PAK-5565",2002,50000,o1));
		carRepository.save(new Car("Suzuki", "WagonR", "White", "PAK-5454",2015,17000,o1));
		carRepository.save(new Car("Suzuki", "Swift", "Blue", "PAK-9045",2022,154500,o1));
		carRepository.save(new Car("Suzuki", "Alto", "White", "PAK-0212",2015,10000,o2));
		carRepository.save(new Car("Honda", "NOne", "Maroon", "PAK-2120",2011,50000,o1));
		carRepository.save(new Car("Toyota", "Camry", "Black", "PAK-1543",2009,50000,o2));
		
		
		for(Car c : carRepository.findAll()) {
			logger.info(c.getBrand() + " " + c.getModel() + " " + c.getYear());
		}
	}

}
