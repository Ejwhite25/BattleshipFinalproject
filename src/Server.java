
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    private Object lock= new Object();

    Thread threadOne;
    Thread threadTwo;
    private BufferedReader reader;
    PrintWriter writer;
    ServerSocket server;
    private String msg;

    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufReader;

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
    private void go() throws IOException {
        server = new ServerSocket(9000);
        Socket connectionOne = server.accept();

        writerSocket = new PrintWriter(connectionOne.getOutputStream());
        writerSocket.println("Connecter One");
        writerSocket.flush();

        //reader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new JobOne(connectionOne)).start();

        Socket connectionTwo = server.accept();
        writerSocket = new PrintWriter(connectionTwo.getOutputStream());
        writerSocket.println("Connected Two");
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
                // System.out.println("player 1=PING> input message: ");
                try {
                    //reading from socket input
                    readerSocket = new InputStreamReader(socket.getInputStream());
                    bufReader = new BufferedReader(readerSocket);
                    msg = bufReader.readLine();

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
                // System.out.println("player2> form player2 =PING> from PONG: " + msg);
                writerSocket.println(msg);
                writerSocket.flush();

            }
        }
    }

    class JobTwo implements Runnable {
        Socket socket;

        JobTwo(Socket name) {
            socket = name;
        }
        @Override
        public void run() {
            while (true) {
                waitForLock();
                try {
                    //writing to socket to send player two msg to player one
                    System.out.println(" player 2=PONG> from PING: "+ msg);
                    writerSocket = new PrintWriter(socket.getOutputStream());
                    writerSocket.println(msg);
                    writerSocket.flush();

                    //input then writes to socket then towards player One
                    //  System.out.println("player 2 =PONG> input message: ");

                    readerSocket = new InputStreamReader(socket.getInputStream());
                    bufReader = new BufferedReader(readerSocket);
                    msg = bufReader.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
            }
        }
    }
}


