package model.domain;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import controller.UserController;

import java.util.ArrayList;

public class Video {
	
	private String URL, title;
	private LocalTime duration, progress = LocalTime.parse("00:00:00");
	private List<String> tagsList;
	private LocalDateTime uploadDateTime;
	private EUploadStatus uploadStatus;
	private EStatus status;
	
	private enum EUploadStatus {
		UPLOADING, VERIFYING, PUBLIC
	}
	
	private enum EStatus {
		PLAYING, PAUSED, STOPPED
	}
	
	// Mètode constructor:
	public Video() {
		this.tagsList = new ArrayList<>();
	}
	
	// Mètodes setters:
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	
	public void setTagsList(List<String> tagsList) {
		this.tagsList = tagsList;
	}
	
	public void setUploadDateTime(LocalDateTime uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	
	public void setUploadStatus(LocalDateTime currentDateTime) {
		long timePassed;
			
		// Càlcul del temps transcorregut entre uploadDateTime i currentDateTime:
		timePassed = uploadDateTime.until(currentDateTime, ChronoUnit.SECONDS);
		
		if (timePassed < 10) {
			this.uploadStatus = EUploadStatus.UPLOADING;
		} else if (timePassed > 10 && timePassed < 20) {
			this.uploadStatus = EUploadStatus.VERIFYING;
		} else { // timePassed > 20
			this.uploadStatus = EUploadStatus.PUBLIC;
		}
	}
	
	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	// Mètodes getters:
	public String getURL() {
		return URL;
	}
	
	public String getTitle() {
		return title;
	}
	
	public LocalTime getDuration() {
		return duration;
	}
	
	public List<String> getTagsList() {
		return tagsList;
	}
	
	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}
	
	public String getUploadStatus() {
		return uploadStatus.name();
	}
	
	public String getStatus() {
		return status.name();
	}
	
	// Opció 3 del menú:
	public void play(LocalDateTime currentDateTime) throws Exception {
		/*setUploadStatus(currentDateTime);
		
		if (!uploadStatus.equals(EUploadStatus.PUBLIC))
			throw new Exception("Aquest vídeo encara no és públic.");*/
		
		Thread t = new Thread() {
			@Override
			public void run() {
				while (progress.compareTo(duration) < 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("S'ha interromput el vídeo.");
						progress = duration;
					}
					
					progress = progress.plusSeconds(1);
				}
			}
		};
		
		// Comença a reproduir-se el vídeo:
		t.start();
		System.out.println("El vídeo s'està reproduint.");
		
		// L'usuari pot pausar/continuar reproduint o parar el vídeo en qualsevol moment durant la seva reproducció:
		String[] choices = new String[2];
		choices[0] = "Tria una opció:\n1. Pausar\n2. Parar";
		choices[1] = "Tria una opció:\n1. Reproduir\n2. Parar";
		
		int choice, i = 0;
		boolean asleep = false;
		
		while (t.isAlive()) {
			choice = UserController.requestAction(choices[i]);

			if (i == 0 && choice == 1) {
				asleep = true;
				
				System.out.println("El vídeo s'ha pausat."); // Pause
				
				// i = 1;
			}
			
			if (i == 1 && choice == 1) {
				asleep = false;
				
				System.out.println("El vídeo s'està reproduint."); // Play
				
				// i = 0;
			}
			
			System.out.println("Abans de synchronized");
			
			synchronized (t) {
				System.out.println("Abans de wait");
				
				while (asleep) // FIXME bucle infinit
					t.wait();

				System.out.println("Després de wait");
				t.notify();
			}
			
			System.out.println("Després de synchronized");
			
		}
		
		System.out.print("\n"); // Separació
		
		System.out.println(t.getState() + " Progrés = " + progress + " Reproducció finalitzada." + getStatus());
	}
	
}
