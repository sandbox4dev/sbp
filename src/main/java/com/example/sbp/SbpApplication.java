package com.example.sbp;

import com.example.sbp.schedulers.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbpApplication {
	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {SbpApplication.class, Scheduler.class}, args);
	}
}
