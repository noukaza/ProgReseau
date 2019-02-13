package TP3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class RepeatNetwork implements Runnable{
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private Client client;
    private ReadableByteChannel readableByteChannel;

    public RepeatNetwork(SocketChannel socketChannel, Client client) {
        this.socketChannel = socketChannel;
        this.client = client;
        this.byteBuffer = ByteBuffer.allocate(512);
        this.readableByteChannel = Channels.newChannel(System.in);
    }

    @Override
    public void run() {
        while (client.isConnected()){
            try {
                this.socketChannel.read(this.byteBuffer);
                this.byteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                CharBuffer charBuffer = charset.decode(byteBuffer);
                System.out.println(charBuffer.toString());
            } catch (IOException e) {
                this.client.setConnected(false);
                System.out.println("Client is not here !");
                e.printStackTrace();
            }
        }
    }
}
