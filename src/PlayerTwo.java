import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.Socket;

public class PlayerTwo {
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufReader;
    boolean state = false;
    public static void main(String[] args){
        new PlayerTwo().go();
    }
    private void go(){
        try {
            socket = new Socket("127.0.0.1", 9000);
            recieveRead();


            while(true) {

                if(state) {
                    writeSend();
                    state = false;

                }
                else {
                    recieveRead();
                    state = true;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    void writeSend() throws IOException {
        System.out.println("player 2:: input message: ");
        bufReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufReader.readLine();
        System.out.println("input = "+input);
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();
    }

    void recieveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufReader = new BufferedReader(readerSocket);
        String line = bufReader.readLine();//prints date from incoming connexion
        System.out.println("player 2:: from server >  "+line);
    }

}
