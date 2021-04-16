import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static int playerID = 0;
    // player 1 is 1.
    //player 2 is 2.
    private Object lock= new Object();
    Runnable jobOne;
    Runnable jobTwo;
    Thread threadOne;
    Thread threadTwo;
    Socket connection;
    private BufferedReader reader;
    PrintWriter writer;
    ServerSocket server;
    private String msg;

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

    public static void main(String[] args){
        new Server().go();
    }
    private void go(){
        try {
            server = new ServerSocket(9000);
            while(true) {
                connection = server.accept();
                jobOne = new JobOne(connection);
                threadOne = new Thread(jobOne);
                threadOne.start();

                jobTwo = new JobTwo(connection);
                threadTwo = new Thread(jobOne);
                threadTwo.start();

            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    class JobOne implements Runnable {
        Socket socket;

        JobOne(Socket name) {
            socket = name;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("First player: ");
                try {
                    msg = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                    System.out.println("First player: ");
                    System.out.println("First player: ");
                    try {
                        msg = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}


