package com.springbootdev.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdev.cardatabase.domain.Car;
import com.springbootdev.cardatabase.domain.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping(value="/cars", method = RequestMethod.GET)
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
}
