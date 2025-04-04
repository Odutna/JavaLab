package com.civiletti.stream.network.chat_v2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient1 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 6789;



    public static void main(String[] args) {

        try {
            System.out.println("Inserire un URL di un sito web da cui leggere i contenuti in uno stream? (s/n) ");
            Scanner scanner = new Scanner(System.in);
            if(new Scanner(System.in).next().toLowerCase().charAt(0) == 's') {
                String url = scanner.nextLine();
                // "https://www.wikipedia.org"
                URL website = new URL(url);

                Scanner inputStream = new Scanner(new InputStreamReader(website.openStream()));

                while (inputStream.hasNextLine()) {
                    String s = inputStream.nextLine();
                    System.out.println(s);
                }

                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                Scanner serverInput = new Scanner(new InputStreamReader(socket.getInputStream()));
                PrintWriter serverOutput = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true);
                Scanner userInput = new Scanner(System.in)
        ) {


            
            System.out.println(serverInput.nextLine()); // Messaggio di benvenuto

            System.out.print("✍ Inserisci il tuo username: ");
            String username = userInput.nextLine();
            serverOutput.println(username);

            // Thread per ricevere messaggi dal server
            Thread receiverThread = new Thread(() -> {
                while (serverInput.hasNextLine()) {
                    System.out.println(serverInput.nextLine());
                }
            });
            receiverThread.start();

            // Legge e invia messaggi
            while (true) {
                String message = userInput.nextLine();
                serverOutput.println(message);
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }
            }

            System.out.println("🔴 Disconnesso.");
            socket.close();
        } catch (IOException e) {
            System.err.println("❌ Errore nel client: " + e.getMessage());
        }
    }
}

