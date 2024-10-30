package io.codeForAll.fanSTATICs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    ServerSocket serverSocket;


    List<ClientInfo> clientsList = new LinkedList<ClientInfo>();

    //use nc localhost 8080

    public Server() { //Created Server
        try {
            System.out.println("- Created server");
            int portNumber = 8080;
            serverSocket = new ServerSocket(portNumber);
            System.out.println("- ServerSocket listening on port " + portNumber);
            System.out.println("  ");

            ExecutorService cachedPool = Executors.newCachedThreadPool();

            while (true) {
                // Wait for a message from the client
                Socket clientSocket = serverSocket.accept();
                //System.out.println("- Conetion accepted from " + clientSocket.getRemoteSocketAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                //clientsList.add(clientSocket);
                cachedPool.submit(clientHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                System.out.println("Server closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addClient(Socket socket, String name) {
        clientsList.add(new ClientInfo(socket, name));
        System.out.println("- Number of connected clients: " + clientsList.size());
    }

    public void removeClient(Socket socket) {
        clientsList.removeIf(clientInfo -> clientInfo.getClientSocket().equals(socket));
        System.out.println("- A client has left the chat: " + socket.getRemoteSocketAddress());
    }

    public void printClientNames() {
        System.out.println("Connected clients: ");
        for (ClientInfo clientInfo : clientsList) {
            System.out.println(clientInfo.getName());
        }
    }

    public void broadcastMessage(String message) {
        for (ClientInfo clientInfo : clientsList) {
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientInfo.getClientSocket().getOutputStream()));
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println("Error sending message to " + clientInfo.getName());
            }
        }
    }


}
