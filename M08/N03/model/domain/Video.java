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
	
	// M�tode constructor:
	public Video() {
		this.tagsList = new ArrayList<>();
	}
	
	// M�todes setters:
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
			
		// C�lcul del temps transcorregut entre uploadDateTime i currentDateTime:
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
	
	// M�todes getters:
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
	
	// Opci� 3 del men�:
	public void play(LocalDateTime currentDateTime) throws Exception {
		/*setUploadStatus(currentDateTime);
		
		if (!uploadStatus.equals(EUploadStatus.PUBLIC))
			throw new Exception("Aquest v�deo encara no �s p�blic.");*/
		
		Thread t = new Thread() {
			@Override
			public void run() {
				while (progress.compareTo(duration) < 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("S'ha interromput el v�deo.");
						progress = duration;
					}
					
					progress = progress.plusSeconds(1);
				}
			}
		};
		
		// Comen�a a reproduir-se el v�deo:
		t.start();
		System.out.println("El v�deo s'est� reproduint.");
		
		// L'usuari pot pausar/continuar reproduint o parar el v�deo en qualsevol moment durant la seva reproducci�:
		String[] choices = new String[2];
		choices[0] = "Tria una opci�:\n1. Pausar\n2. Parar";
		choices[1] = "Tria una opci�:\n1. Reproduir\n2. Parar";
		
		int choice, i = 0;
		boolean asleep = false;
		
		while (t.isAlive()) {
			choice = UserController.requestAction(choices[i]);

			if (i == 0 && choice == 1) {
				asleep = true;
				
				System.out.println("El v�deo s'ha pausat."); // Pause
				
				// i = 1;
			}
			
			if (i == 1 && choice == 1) {
				asleep = false;
				
				System.out.println("El v�deo s'est� reproduint."); // Play
				
				// i = 0;
			}
			
			System.out.println("Abans de synchronized");
			
			synchronized (t) {
				System.out.println("Abans de wait");
				
				while (asleep) // FIXME bucle infinit
					t.wait();

				System.out.println("Despr�s de wait");
				t.notify();
			}
			
			System.out.println("Despr�s de synchronized");
			
		}
		
		System.out.print("\n"); // Separaci�
		
		System.out.println(t.getState() + " Progr�s = " + progress + " Reproducci� finalitzada." + getStatus());
	}
	
}
