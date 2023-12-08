/**
 Client.java
 @author Dr. M. Ilhan Akbas
 @modified by Maegan Lucas

 Client takes weight in kilograms from user and height
 in meters from user and passes both to server.
 Receives Body Mass Index (BMI) from server and displays
 to user.

 References:
 [1] “How to Use GroupLayout (The JavaTM Tutorials >
 Creating a GUI With JFC/Swing > Laying Out Components Within a Container),” Oracle.com, 2019. https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
    // Text field for receiving weight
    private JTextField jtfWeight = new JTextField();

    // Text field for receiving height
    private JTextField jtfHeight = new JTextField();

    // Text area to display contents
    private JTextArea jta = new JTextArea();

    // IO streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) {
        new Client();
    }

    /**
     @modified by Maegan Lucas for Problem 1
     Uses reference [1]
     */
    public Client() {
        // Panel p to hold the label and text fields
        JPanel p = new JPanel();
        GroupLayout layout = new GroupLayout(p);
        p.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        Label weightLabel = new Label("Enter weight in kilograms");
        Label heightLabel = new Label("Enter height in meters");
        jtfWeight.setHorizontalAlignment(JTextField.RIGHT);
        jtfHeight.setHorizontalAlignment(JTextField.RIGHT);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(weightLabel)
                                .addComponent(heightLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jtfWeight)
                                .addComponent(jtfHeight))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(weightLabel)
                                .addComponent(jtfWeight))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(heightLabel)
                                .addComponent(jtfHeight))
        );

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        jtfWeight.addActionListener(this); // Register listener
        jtfHeight.addActionListener(this); // Register listener

        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  // It is necessary to show the frame here!

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            inputFromServer = new DataInputStream(
                    socket.getInputStream());

            // Create an output stream to send data to the server
            outputToServer =
                    new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            jta.append(ex.toString() + "\n");
        }
    }

    /**
     @modified by Maegan Lucas for Problem 1
     */
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (e.getSource() instanceof JTextField) {
            try {
                // Get the weight from the text field
                double weight = Double.parseDouble(jtfWeight.getText().trim());

                // Get the height from the text field
                double height = Double.parseDouble(jtfHeight.getText().trim());

                // Send the weight and height to the server
                outputToServer.writeDouble(weight);
                outputToServer.writeDouble(height);
                outputToServer.flush();

                // Get BMI from the server
                double bmi = inputFromServer.readDouble();

                // Display to the text area
                jta.append("Weight is " + weight + "\n");
                jta.append("Height is " + height + "\n");
                jta.append("BMI received from the server is " + bmi + "\n");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}