package controller;

import java.util.List;

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
	
	public void changeTotalPower(int[] targetPowerArray1, int[] targetPowerArray2) {
		try {
			List<Thread> threads;
			
			threads = rocketRepository.changeTotalPower(0, targetPowerArray1);
			threads.addAll(rocketRepository.changeTotalPower(1, targetPowerArray2));
		
			for (Thread t : threads) {
				try {
					if (t != null) // NullPointerException
						t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void changeVelocities(int targetVelocity1, int targetVelocity2) {
		try {
			int[] targetPowerArray1, targetPowerArray2;
			
			System.out.println("\nCANVI DE VELOCITAT");
		
			targetPowerArray1 = rocketRepository.getTargetPowerArray(0, targetVelocity1);
			targetPowerArray2 = rocketRepository.getTargetPowerArray(1, targetVelocity2);
		
			this.changeTotalPower(targetPowerArray1, targetPowerArray2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
