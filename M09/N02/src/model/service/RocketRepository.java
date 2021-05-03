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
	
	public List<Rocket> getRockets() {
		return rockets;
	}
	
	public List<Thread> changeTotalPower(int i, int[] targetPowerArray) throws Exception {
		List<Thread> threads;
		
		threads = rockets.get(i).changeTotalPower(targetPowerArray);
		
		return threads;
	}
	
	public int[] getTargetPowerArray(int i, int targetVelocity) throws Exception {
		int[] targetPowerArray;
		
		targetPowerArray = rockets.get(i).getTargetPowerArray(targetVelocity);
		
		return targetPowerArray;
	}
	
}
