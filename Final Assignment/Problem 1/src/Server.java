/**
 Server.java
 @author Dr. M. Ilhan Akbas
 @modified by Maegan Lucas

 Server takes input of weight in kilograms and height in meters
 from client and provides Body Mass Index (BMI) back to client.

 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server extends JFrame {
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        // Place text area on the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + "\n");

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());

            // This section has been modified by Maegan Lucas
            while (true) {
                // Receive weight and height from client
                double weight = inputFromClient.readDouble();
                double height = inputFromClient.readDouble();

                // Compute BMI
                double bmi = weight / (height * height);

                // Send BMI back to the client
                outputToClient.writeDouble(bmi);

                jta.append("Weight received from client: " + weight + "\n");
                jta.append("Height received from client: " + height + "\n");
                jta.append("BMI calculated: " + bmi + "\n");
            }
        }
        catch(IOException ex) {
            System.err.println(ex);
        }
    }
}