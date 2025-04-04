package com.civiletti.stream.network.chat_v2;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 6789;
    private static Map<String, PrintWriter> clients = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        System.out.println("Server avviato sulla porta: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start(); // Nuovo thread per ogni client
            }
        } catch (IOException e) {
            System.err.println("❌ Errore nel server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter outputStream;
        private Scanner inputStream;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
                outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true);

                // Loop finché l'utente non sceglie un username valido
                while (true) {
                    outputStream.println("🔹 Inserisci il tuo username:");
                    username = inputStream.nextLine().trim();

                    if (username.equalsIgnoreCase("quit")) {
                        outputStream.println("🔴 Disconnessione...");
                        socket.close();
                        return;
                    }

                    synchronized (clients) {
                        if (!clients.containsKey(username)) {
                            clients.put(username, outputStream);
                            break; // Esce dal loop quando l'username è valido
                        }
                    }
                    outputStream.println("❌ Username già in uso. Riprova con un altro nome.");
                }

                // Dopo aver scelto un username valido
                outputStream.println("✅ Benvenuto nella chat, " + username + "!");
                outputStream.println("[ " + username + " ] > "); // Prompt iniziale
                broadcastMessage("🔔 " + username + " si è unito alla chat!");


                // Loop per ricevere messaggi
                while (inputStream.hasNextLine()) {
                    String message = inputStream.nextLine().trim();
                    if (message.equalsIgnoreCase("quit")) break;

                    if (message.startsWith("@")) {
                        String[] parts = message.split(" ", 2);
                        if (parts.length == 2) {
                            String targetUser = parts[0].substring(1);
                            String privateMessage = parts[1];
                            sendPrivateMessage(username, targetUser, privateMessage);
                        } else {
                            outputStream.println("⚠ Errore: Messaggio privato non valido.");
                        }
                    } else {
                        broadcastMessage("💬 [" + username + "]: " + message);
                    }

                    outputStream.println("[ " + username + " ] > "); // Mostra di nuovo il prompt
                }

            } catch (Exception e) {
                System.err.println("❌ Errore con il client: " + e.getMessage());
            } finally {
                // Rimozione utente
                synchronized (clients) {
                    if (username != null) {
                        clients.remove(username);
                        broadcastMessage("🔴 " + username + " ha lasciato la chat.");
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("❌ Errore chiudendo la connessione: " + e.getMessage());
                }
            }
        }


        private void broadcastMessage(String message) {
            synchronized (clients) {
                for (PrintWriter writer : clients.values()) {
                    writer.println(message);
                }
            }
        }

        private void sendPrivateMessage(String sender, String targetUser, String message) {
            synchronized (clients) {
                PrintWriter targetWriter = clients.get(targetUser);
                if (targetWriter != null) {
                    targetWriter.println("📩 [Privato da " + sender + "]: " + message);
                    outputStream.println("📨 [Privato a " + targetUser + "]: " + message);
                } else {
                    outputStream.println("⚠ Utente " + targetUser + " non trovato.");
                }
            }
        }
    }
}
