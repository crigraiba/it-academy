package controller;

import model.service.RocketRepository;
import model.domain.Rocket;

public class RocketController {
	
	private RocketRepository rocketRepository;
	
	public RocketController() {
		rocketRepository = new RocketRepository();
	}
	
	public void createRocket(String identifier, int[] maxPowerArray) {
		Rocket rocket = new Rocket(identifier, maxPowerArray);
		
		rocketRepository.addRocket(rocket);
	}
	
	public void printRockets() {
		for (Rocket rocket : rocketRepository.getRockets())
			System.out.println(rocket.toString());
	}
	
	public void changeTotalPower(String identifier, int[] targetPowerArray) {
		rocketRepository.changeTotalPower(identifier, targetPowerArray);
	}
	
}
