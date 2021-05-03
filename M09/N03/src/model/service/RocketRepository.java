package model.service;

import java.util.List;
import java.util.ArrayList;

import model.domain.Rocket;

public class RocketRepository {
	
	private List<Rocket> rockets;
	
	public RocketRepository() {
		rockets = new ArrayList<>();
	}
	
	public void addRocket(Rocket rocket) {
		rockets.add(rocket);
	}
	
	public Rocket retrieveRocket(String identifier) throws Exception {
		for (Rocket rocket : rockets) {
			if (identifier.equals(rocket.getIdentifier()))
				return rocket;
		}
		
		throw new Exception("Aquest coet no existeix.");
	}
	
	public List<Rocket> getRockets() {
		return rockets;
	}
	
	public int[] getTargetPowerArray(String identifier, int targetVelocity) throws Exception {
		int[] targetPowerArray = retrieveRocket(identifier).getTargetPowerArray(targetVelocity);
		
		return targetPowerArray;
	}
	
	public void changeIncrement(String identifier, int increment) throws Exception {
		retrieveRocket(identifier).setIncrement(increment);
	}
	
	public List<Thread> changeTotalPower(String identifier, int[] targetPowerArray) throws Exception {
		List<Thread> threads = retrieveRocket(identifier).changeTotalPower(targetPowerArray);
		
		return threads;
	}
	
}
