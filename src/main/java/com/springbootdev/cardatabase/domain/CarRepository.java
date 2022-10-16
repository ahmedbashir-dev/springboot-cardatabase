package com.springbootdev.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long>{

	//Fetch cars by brand
	List<Car> findByBrand(String brand);
	
	//Fetch cars by model
	List<Car> findByModel(@Param("brand") String model);
	
	//Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
	
	//Fetch cars by brand and color
	List<Car> findByBrandAndColor(@Param("brand") String brand, @Param("color") String color);
	
	//Fetch cars by brand or color
	List<Car> findByBrandOrColor(@Param("brand") String brand, @Param("color") String color);
	
	//Fetch by brand order by year asc
	List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);
	
}
