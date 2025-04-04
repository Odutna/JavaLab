package com.civiletti.stream.network.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 6789;
    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Server avviato sulla porta " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) { // Mantieni il server sempre in ascolto
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuovo client connesso: " + clientSocket.getInetAddress());

                // Assegna un thread al nuovo client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Errore nel server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter outputStream;
        private Scanner inputStream;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
                outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true);

                // Aggiungo l'outputStream alla lista di client connessi
                synchronized (clientWriters) {
                    clientWriters.add(outputStream);
                }

                outputStream.println("Benvenuto nella chat! Scrivi 'quit' per uscire.");

                while (inputStream.hasNextLine()) {
                    String message = inputStream.nextLine();

                    if (message.equalsIgnoreCase("quit")) {
                        break; // Esce dal loop e chiude la connessione
                    }

                    System.out.println("√ Messaggio ricevuto: " + message);
                    broadcastMessage("~ " + message);
                }
            } catch (Exception e) {
                System.err.println("Errore con il client: " + e.getMessage());
            } finally {
                // Rimuove il client dalla lista e chiude la connessione
                synchronized (clientWriters) {
                    clientWriters.remove(outputStream);
                }

                try {
                    socket.close();
                    System.out.println("Client disconnesso.");
                } catch (IOException e) {
                    System.err.println("Errore nella chiusura del socket: " + e.getMessage());
                }
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
