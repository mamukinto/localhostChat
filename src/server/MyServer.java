package server;

import java.io.IOException;


public class MyServer {
    public static void main(String[] args) {

        try {

            Server server = new Server(9999);
        // some new comments added from github
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
