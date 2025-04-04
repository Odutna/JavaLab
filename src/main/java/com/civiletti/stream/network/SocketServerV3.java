package com.civiletti.stream.network;

import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServerV3 {
    public static void main(String[] args) {
        System.out.println("Server in ascolto sulla porta 6789...");

        try (ServerSocket serverSocket = new ServerSocket(6789)) {
            while (true) {  // 🔄 Mantiene il server attivo
                System.out.println("In attesa di una connessione...");

                try (Socket socket = serverSocket.accept();
                     Scanner inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
                     PrintWriter outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true)) { // true -> Auto-flush attivo

                    // Connessione stabilita, legge una riga dal client
                    String s = inputStream.nextLine();

                    // Risposta al client
                    outputStream.println("Bene, " + s + " è un buon linguaggio di programmazione!");

                    System.out.println("Messaggio ricevuto: " + s);
                    System.out.println("Connessione chiusa.");
                } catch (Exception e) {
                    System.err.println("Errore durante la comunicazione con il client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Errore nell'avvio del server: " + e.getMessage());
        }
    }
}
