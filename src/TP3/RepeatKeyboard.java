package TP3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

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

        }
    }
}
