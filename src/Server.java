
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private static PrintWriter writerSocket;
    private static BufferedReader buffedReader;
    private static String sharedMessage;
    private static InputStreamReader readerSocket;
    private final Object lock= new Object();

    void waitForLock(){
        synchronized (lock){
            try {
                lock.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void notifyLock(){
        synchronized (lock){
            lock.notify();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().go();
    }
    void go() throws IOException {
        ServerSocket server = new ServerSocket(7000);
        Socket connectionOne = server.accept();
        writerSocket = new PrintWriter(connectionOne.getOutputStream());
        writerSocket.println("P1 connected to server");
        writerSocket.flush();
        System.out.println("server>> P1 connected");
        new Thread(new JobOne(connectionOne)).start();


        Socket connectionTwo = server.accept();
        System.out.println("server>> P2 connected");
        writerSocket = new PrintWriter(connectionTwo.getOutputStream());
        writerSocket.println("P2 connected to server");
        writerSocket.flush();
        new Thread(new JobTwo(connectionTwo)).start();

    }


    private class JobOne implements Runnable {
        Socket socket;

        JobOne(Socket name) {
            socket = name;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    readerSocket = new InputStreamReader(socket.getInputStream());
                    buffedReader = new BufferedReader(readerSocket);
                    sharedMessage = buffedReader.readLine();
                    String[] coordinates = sharedMessage.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    Turn turn = new Turn(1,x,y);
                    if(turn.testHit(turn)){
                        sharedMessage = "Player 1 has a hit!";
                    }
                    else{
                        sharedMessage = "Player 1 has a miss. ";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
                waitForLock();
                try {
                    writerSocket = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("server:: p2 >> p2 : " + sharedMessage);
                writerSocket.println(sharedMessage);
                writerSocket.flush();

            }
        }
    }

    private class JobTwo implements Runnable {
        Socket socket;

        JobTwo(Socket name) {
            socket = name;
        }
        @Override
        public void run() {
            while (true) {
                waitForLock();
                try {
                    System.out.println("server:: p1 >> p2 : "+ sharedMessage);
                    writerSocket = new PrintWriter(socket.getOutputStream());
                    writerSocket.println(sharedMessage);
                    writerSocket.flush();

                    readerSocket = new InputStreamReader(socket.getInputStream());
                    buffedReader = new BufferedReader(readerSocket);
                    sharedMessage = buffedReader.readLine();
                    String[] coordinates = sharedMessage.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    Turn turn = new Turn(2,x,y);
                    if(turn.testHit(turn)){
                        sharedMessage = "Player 2 has a hit!";
                    }
                    else{
                        sharedMessage = "Player 2 has a miss\n";
                    }
                    System.out.println("server:: p2 >> "+sharedMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
            }
        }
    }
}


