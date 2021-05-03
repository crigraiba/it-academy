package controller;

import java.util.List;
import java.util.ArrayList;

import model.service.RocketRepository;
import model.domain.Rocket;

public class RocketController {
	
	private RocketRepository rocketRepository;
	private List<List<Thread>> list;
	
	public RocketController() {
		rocketRepository = new RocketRepository();
		list = new ArrayList<>();
	}
	
	public void createRocket(String identifier, int[] maxPowerArray) {
		Rocket rocket = new Rocket(identifier, maxPowerArray);
		
		rocketRepository.addRocket(rocket);
	}
	
	public void printRockets() {
		for (Rocket rocket : rocketRepository.getRockets())
			System.out.println(rocket.toString());
	}
	
	public void printRocket(String identifier) throws Exception {
		Rocket rocket = rocketRepository.retrieveRocket(identifier);
		
		System.out.println(rocket.toString());
	}
	
	public void changeIncrement(String identifier, int input) throws Exception {
		rocketRepository.changeIncrement(identifier, input);
		
		System.out.println("Coet " + identifier + " Increment/W = " + input);
	}
	
	public void changeTotalPower(String identifier, int[] targetPowerArray) throws Exception {
		try {
			List<Thread> threads = rocketRepository.changeTotalPower(identifier, targetPowerArray);
			
			list.add(threads);
			
			for (Thread t : threads) {
				if (t != null) // NullPointerException
					t.join();
			}
			
			list.remove(threads);
		} catch (InterruptedException e) {
			System.err.println("\t" + identifier + " Fils interromputs."); // TODO
			
			return;
		} finally {
			this.printRocket(identifier);
		}
	}
	
	public void changeVelocity(String identifier, int targetVelocity) throws Exception {
		int[] targetPowerArray = rocketRepository.getTargetPowerArray(identifier, targetVelocity);
		
		this.changeTotalPower(identifier, targetPowerArray);
	}

	public void threads(String identifier, int input, final int option) {
		// 2 fils concurrents (1 fil/coet) -> 3/6 fils concurrents (1 fil/propulsor)
		
		for (List<Thread> threads : list) {
			for (Thread t : threads) {
				if (t.getName().contains(identifier))
					t.interrupt();
			}
		}
		
		Thread t = new Thread(() -> {
			try {
				switch (option) {
					case 1:
						changeVelocity(identifier, input);
						break;
					case 2:
						changeIncrement(identifier, input);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		});
		
		t.start();
	}
	
}
