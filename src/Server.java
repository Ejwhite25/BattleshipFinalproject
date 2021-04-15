import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static int playerID = 0;
    private Object lock= new Object();
    Runnable jobOne;
    Runnable jobTwo;
    Thread threadOne;
    Thread threadTwo;
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
            Socket connection = server.accept();

                jobOne = new JobOne(connection);
                threadOne = new Thread(jobOne);
                threadOne.start();
                Socket connectionTwo = server.accept();
                jobTwo = new JobTwo(connectionTwo);
                threadTwo = new Thread(jobOne);
                threadTwo.start();

            } catch (IOException ioException) {
            ioException.printStackTrace();
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
                notifyLock();
                waitForLock();
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
                    System.out.println("First player: ");
                    System.out.println("First player: ");
                    try {
                        msg = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    notifyLock();
                }
            }
        }
}


