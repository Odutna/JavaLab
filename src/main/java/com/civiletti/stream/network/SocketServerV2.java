package com.civiletti.stream.network;

import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServerV2 {

    public static void main(String[] args) {

        System.out.println("In attesa di una connessione.");

        try (ServerSocket serverSocket = new ServerSocket(6789);
             Socket socket = serverSocket.accept();
             Scanner inputStream = new Scanner(new InputStreamReader(socket.getInputStream()));
             PrintWriter outputStream = new PrintWriter(new DataOutputStream(socket.getOutputStream()))) {

            // Connessione stabilita, legge una riga dal client
            String s = inputStream.nextLine();

            // Visualizza il testo sul client
            outputStream.println("Bene, ");
            outputStream.println(s + " è un buon linguaggio di programmazione!");
            outputStream.flush();

            System.out.println("Chiusura della connessione da " + s);

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
