package com.example.demo;

import com.example.demo.client.Client;
import com.example.demo.server.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedApplication.class, args);

		if (args[0].equalsIgnoreCase("namingserver")) {
			System.out.println("SERVER starting");
			Server server = new Server();
			server.receiveFile();

		} else if (args[0].equalsIgnoreCase("client")) {
			System.out.println("CLIENT starting");
			Client client = new Client();
			client.sendFile();
		}
	}

}
