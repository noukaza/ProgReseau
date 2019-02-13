package TP3;

import TP3.server.Server;

import java.io.IOException;

public class mainServer {
    public static void main(String argc[]) throws IOException {
        new Server(2020).start();
    }
}
