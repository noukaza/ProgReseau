package TP3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class main {
    public static void main(String[] args) throws IOException {
        Client client = new Client("access759336177.webspace-data.io",22);

        SocketChannel socketChannel = SocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(2222);
        System.out.println(socketChannel.isConnected());
        socketChannel.connect(socketAddress);
        RepeatNetwork repeatNetwork = new RepeatNetwork(socketChannel,client);
    }
}

