package io.codeForAll.fanSTATICs;

import java.net.Socket;

public class ClientInfo {
    private final Socket clientSocket;
    private final String userName;

    public ClientInfo(Socket clientSocket, String name){
        this.clientSocket = clientSocket;
        this.userName =name;
    }

    public Socket getClientSocket(){
        return clientSocket;
    }
    public String getName(){
        return userName;
    }
}
