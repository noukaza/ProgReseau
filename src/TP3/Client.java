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
        this.socketChannel = SocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(
                InetAddress.getByName(adresse),
                port
        );
        System.out.println(this.socketChannel.isConnected());
        this.socketChannel.connect(socketAddress);
        System.out.println(this.socketChannel.isConnected());
        this.isConnected = true;

        new RepeatNetwork(this.socketChannel,this).run();
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
