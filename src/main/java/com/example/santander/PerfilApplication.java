package com.example.santander;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.santander.service.StorageService;

@SpringBootApplication
public class PerfilApplication {
	
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(PerfilApplication.class, args);
	}
	
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
