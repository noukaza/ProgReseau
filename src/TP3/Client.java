package TP3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    private SocketChannel socketChannel ;
    private boolean isConnected;

    public Client(String adresse, int port) throws IOException {
        socketChannel = SocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(
                InetAddress.getByName(adresse),
                port
        );
        System.out.println(socketChannel.isConnected());
        socketChannel.connect(socketAddress);
        System.out.println(socketChannel.isConnected());
        isConnected = true;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
