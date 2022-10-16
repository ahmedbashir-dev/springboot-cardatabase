package com.springbootdev.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface CarRepository extends CrudRepository<Car, Long>{

	//Fetch cars by brand
	List<Car> findByBrand(String brand);
	
	//Fetch cars by model
	List<Car> findByModel(String model);
	
	//Fetch cars by color
	List<Car> findByColor(String color);
	
	//Fetch cars by brand and color
	List<Car> findByBrandAndColor(String brand, String color);
	
	//Fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand, String color);
	
	//Fetch by brand order by year asc
	List<Car> findByBrandOrderByYearAsc(String brand);
	
}
