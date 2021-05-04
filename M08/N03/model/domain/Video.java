package model.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

import controller.UserController;

public class Video {
	
	private String URL, title;
	private LocalTime duration, progress = LocalTime.parse("00:00:00");
	private List<String> tagsList;
	private LocalDateTime uploadDateTime;
	private EUploadStatus uploadStatus;
	private EStatus status;
	
	private enum EUploadStatus {
		UPLOADING, VERIFYING, PUBLIC
		// < 10 s, 10-20 s, > 20 s
	}
	
	private enum EStatus {
		PLAYING, PAUSED, STOPPED
	}
	
	// M�tode constructor:
	public Video() {
		this.tagsList = new ArrayList<>();
	}
	
	// M�todes setter:
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
		} else if (timePassed >= 10 && timePassed <= 20) {
			this.uploadStatus = EUploadStatus.VERIFYING;
		} else { // timePassed > 20
			this.uploadStatus = EUploadStatus.PUBLIC;
		}
	}
	
	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	// M�todes getter:
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
	
	// Altres m�todes:
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		
		return "[URL = " + URL + ", T�tol = " + title + ", Tags = " + tagsList +
			", Data i hora de pujada = " + uploadDateTime.format(formatter) +
			", Estat de pujada = " + uploadStatus + "]";
	}
	
	// Opci� 3 del men�:
	boolean paused;
	public void play() throws Exception {
		if (!uploadStatus.equals(EUploadStatus.PUBLIC))
			throw new Exception("Aquest v�deo encara no �s p�blic.");
		
		// Simula la reproducci� del v�deo:
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					while (!progress.equals(duration)) {
						Thread.sleep(1000);
						
						progress = progress.plusSeconds(1);
						
						synchronized (this) {
							while (paused)
								this.wait();
						}
					}
				} catch (InterruptedException e) { // Stop
					progress = LocalTime.parse("00:00:00");
					return;
				} finally {
					setStatus(EStatus.STOPPED);
					System.out.println("El v�deo s'ha parat.");
					
					System.out.println(getStatus() + " Temps de reproducci� = " + progress);
				}
				
				System.out.println("El v�deo s'ha acabat de reproduir.");
			}
		};
		
		// Comen�a a reproduir-se el v�deo:
		t.start();
		System.out.println("\nEl v�deo s'ha comen�at a reproduir.");
		
		// L'usuari pot pausar/continuar reproduint o parar el v�deo en qualsevol moment durant la seva reproducci�:
		String[] choices = new String[2];
		choices[0] = "Tria una opci�:\n1. Pausar\n2. Parar";
		choices[1] = "Tria una opci�:\n1. Reproduir\n2. Parar";
		
		int choice, i = 0;
		while (t.isAlive()) {
			choice = UserController.requestAction(choices[i]);
			
			if (choice == 1) {
				switch (i) {
					case 0: // Pause
						paused = true;
						i = 1;
						setStatus(EStatus.PAUSED);
						System.out.println("El v�deo s'ha pausat.");
						break;
					case 1: // Play
						paused = false;
						i = 0;
						setStatus(EStatus.PLAYING);
						System.out.println("El v�deo s'est� reproduint.");
				}
				
				synchronized (t) {
					t.notify();
					System.out.println(getStatus() + " Temps de reproducci� = " + progress);
				}
			} else { // choice = 2
				t.interrupt();
				t.join();
				return;
			}
		}
	}
	
}
