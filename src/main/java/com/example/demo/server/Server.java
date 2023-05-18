package com.example.demo.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void receiveFile() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888); // Server socket listening on port 8888

            System.out.println("Server started. Listening on port 8888...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming client connections

                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create an input stream to receive file data from the client
                InputStream inputStream = clientSocket.getInputStream();

                // Create a file output stream to save the received file
                FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt");

                // Read the file data from the input stream and write it to the file
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File received and saved.");

                // Close the streams and sockets
                fileOutputStream.close();
                inputStream.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
