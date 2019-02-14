package TP3.util;

import TP3.client.Client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

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
        while (client.isConnected()){
            try {
                this.socketChannel.read(this.byteBuffer);

                if(client.getSocketChannel().read(byteBuffer) < 0){
                    client.getSocketChannel().close();
                    client.setConnected(false);
                    return;
                }

                this.byteBuffer.flip();

                Charset charset = Charset.forName("UTF-8");
                CharBuffer charBuffer = charset.decode(byteBuffer);

                System.out.println("msg: "+ charBuffer.toString());

            } catch (IOException e) {
                this.client.setConnected(false);
                System.out.println("Client is not here !");
                e.printStackTrace();
            }
        }
    }
}
