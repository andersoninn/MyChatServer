package io.codeForAll.fanSTATICs;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private String userName;
    private Server server;


    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }


    @Override
    public void run() {
        System.out.println("- ServerWorker started on thread ID: " + Thread.currentThread().getId());
        try {
            BufferedReader clientInputMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter clientOutputMessage = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));


            clientOutputMessage.write("\nWelcome to MyChatServer\n");
            clientOutputMessage.write("Please enter your name:\n");
            clientOutputMessage.flush();

            this.userName = clientInputMessage.readLine();
            server.addClient(clientSocket, this.userName);

            clientOutputMessage.write("\n\nHello, " + userName + "! You are now connected.\n\n");
            clientOutputMessage.flush();

            //print all connected users -------------
            //server.printClientNames();


            while (true) {
                String messageInTheTerminal = clientInputMessage.readLine();

                if (messageInTheTerminal == null) {
                    System.out.println("- Client" + userName + " disconnected.");
                    break;
                }

                System.out.println("-- MESSAGE from " + userName + ": " + messageInTheTerminal);
                //server.broadcastMessage(userName + ": " + messageInTheTerminal);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) clientSocket.close();
                server.removeClient(clientSocket);
                System.out.println(userName + " has disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

