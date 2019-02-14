package TP3.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Server {
    ServerSocketChannel serversocket;
    Selector select;
    ByteBuffer bytebuff;

    public Server(int port) throws IOException {
        this.serversocket = ServerSocketChannel.open();
        SocketAddress sa = new InetSocketAddress(port);
        this.serversocket.bind(sa);
        this.serversocket.configureBlocking(false);
        this.select = Selector.open();
        serversocket.register(select, SelectionKey.OP_ACCEPT);
    }

    public void accept() throws IOException {
        //select.select();
        SocketChannel sc = serversocket.accept();
        sc.configureBlocking(false);
        sc.register(select, SelectionKey.OP_READ);
        System.out.println("nouvelle connexion" + sc);

    }

    public void repeat(SelectionKey k) throws IOException {
        ByteBuffer bb = ByteBuffer.allocateDirect(512);
        System.out.println("Nouveau message ");
        SocketChannel sc = (SocketChannel) k.channel();
        sc.read(bb);

        bb.flip();//mode consultation du buffer
        Charset c = Charset.forName("UTF-8");
        CharBuffer cb = c.decode(bb);
        System.out.println(cb.toString());

        for (SelectionKey k1 : select.keys()) {
            if (k1.isAcceptable()) {

            } else {
                //System.out.println("je suis dans le else");
                SocketChannel sc1 = (SocketChannel) k1.channel();
                bb.rewind();
                sc1.write(bb);
            }
        }
        bb.clear();
    }

    public void start() throws IOException {

        while (true) {
            select.select();
            for (SelectionKey k : select.selectedKeys()) {
                if (k.isAcceptable()) {
                    this.accept();
                } else {
                    this.repeat(k);
                }
            }
            select.selectedKeys().clear();
        }
    }
}
