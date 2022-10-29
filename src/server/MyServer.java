package server;

import java.io.IOException;


public class MyServer {
    public static void main(String[] args) {

        try {

            Server server = new Server(9999);
            System.out.println("sxva raghac");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
