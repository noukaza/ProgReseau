package TP3;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class RepeatNetwork implements Runnable{
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private Client client;

    public RepeatNetwork(SocketChannel socketChannel, Client client) {
        this.socketChannel = socketChannel;
        this.client = client;
        this.byteBuffer = ByteBuffer.allocate(512);
    }

    @Override
    public void run() {

    }
}
