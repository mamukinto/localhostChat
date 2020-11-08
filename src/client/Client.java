package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String userName;
    private static Scanner scanner = new Scanner(System.in);

    public Client(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.inputStream = socket.getInputStream();
        this.dataInputStream = new DataInputStream(inputStream);
        this.outputStream = socket.getOutputStream();
        this.dataOutputStream = new DataOutputStream(outputStream);


        System.out.print("Enter username: ");
        this.userName = scanner.nextLine();

        new Thread(() -> {
            String message;
            while (true) {
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();
                try {
                    dataOutputStream.writeUTF(userName + " : " + message);
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        while (true) {
            System.out.println(dataInputStream.readUTF());
        }



    }


}
