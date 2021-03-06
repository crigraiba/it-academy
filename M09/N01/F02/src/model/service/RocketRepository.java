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
	
}
