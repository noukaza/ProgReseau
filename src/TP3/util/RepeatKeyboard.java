package TP3.util;

import TP3.client.Client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

public class RepeatKeyboard implements Runnable{
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private Client client;
    private ReadableByteChannel readableByteChannel;

    public RepeatKeyboard(SocketChannel socketChannel, Client client) {
        this.socketChannel = socketChannel;
        this.client = client;
        this.byteBuffer = ByteBuffer.allocate(512);
        this.readableByteChannel = Channels.newChannel(System.in);
    }


    @Override
    public void run() {
        while (client.isConnected()){
            try {
                this.readableByteChannel.read(this.byteBuffer);
                this.byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
