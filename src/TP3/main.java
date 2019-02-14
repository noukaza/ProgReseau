package TP3;

import TP3.client.Client;
import TP3.server.Server;

import java.io.IOException;

public class main {

    public static void main(String argc[]) throws IOException {

        new Server(2020).start();

        new Client("127.0.01",2020);

    }
}
