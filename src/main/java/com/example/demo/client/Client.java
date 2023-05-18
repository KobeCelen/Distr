package com.example.demo.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public void sendFile() {
        try {
            Socket socket = new Socket("localhost", 8888); // Connect to the server

            System.out.println("Connected to server. Sending file...");

            // Create an output stream to send file data to the server
            OutputStream outputStream = socket.getOutputStream();

            // Create a file input stream to read the file
            FileInputStream fileInputStream = new FileInputStream("sentThisFile.txt");

            // Read the file data and send it to the server
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent.");

            // Close the streams and socket
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
