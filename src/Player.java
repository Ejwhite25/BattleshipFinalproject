import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.Socket;

public class Player {
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufReader;

    public static void main(String[] args){
        new Player().go();
    }
    private void go(){
        try {
            socket = new Socket("127.0.0.1", 9000);
            while(true) {
                readerSocket = new InputStreamReader(socket.getInputStream());
                bufReader = new BufferedReader(readerSocket);
                String line = bufReader.readLine();//prints date from incoming connexion
                System.out.println("from user :  "+line);

                System.out.println("player> input message: ");
                bufReader = new BufferedReader(new InputStreamReader(System.in));
                bufReader.readLine();
                writerSocket = new PrintWriter(socket.getOutputStream());
                writerSocket.println(bufReader);
                writerSocket.flush();
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
