package com.civiletti.stream.network.chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 6789;

    public static void main(String[] args) {
        System.out.println("Scegli un nome per entrare in chat: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                Scanner serverInput = new Scanner(new InputStreamReader(socket.getInputStream()));
                PrintWriter serverOutput = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true);
                Scanner userInput = new Scanner(System.in)
        ) {
            System.out.println("Connesso al server. Scrivi 'quit' per uscire.");

            // Thread per ricevere messaggi dal server
            Thread receiverThread = new Thread(() -> {
                while (serverInput.hasNextLine()) {
                    System.out.println(serverInput.nextLine());
                }
            });
            receiverThread.start();

            // Legge messaggi dall'utente e li invia al server
            while (true) {
                System.out.print(input + ": ");
                String message = userInput.nextLine();

                serverOutput.println(message);

                if (message.equalsIgnoreCase("quit")) {
                    break; // Disconnessione dal server
                }
            }

            socket.close();
            System.out.println("Disconnesso dal server.");
        } catch (IOException e) {
            System.err.println("Errore nel client: " + e.getMessage());
        }
    }
}

