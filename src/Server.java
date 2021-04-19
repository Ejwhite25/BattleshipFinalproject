
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
        writerSocket.println("1 Connected to server");
        writerSocket.flush();
        System.out.println("player one connected");
        new Thread(new JobOne(connectionOne)).start();

        Socket connectionTwo = server.accept();
        System.out.println("player Two connected");
        writerSocket = new PrintWriter(connectionTwo.getOutputStream());
        writerSocket.println("0 Connected to server");
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
                    msg = bufReader.readLine();//write to
                    System.out.println("server:: p1 >> "+msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
                waitForLock();
                //read (send to player one)
                try {
                    writerSocket = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("server:: p2 >> p2 " + msg);//read
                writerSocket.println(msg);//send
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
                    //read(send to player r2)
                    //from p1 to player2
                    System.out.println(" server:: p1 >> p2 : "+ msg);//read
                    writerSocket = new PrintWriter(socket.getOutputStream());
                    writerSocket.println(msg);//send
                    writerSocket.flush();

                    //from p2 to p1
                    readerSocket = new InputStreamReader(socket.getInputStream());//
                    bufReader = new BufferedReader(readerSocket);
                    msg = bufReader.readLine();//write
                    System.out.println("server:: p2 >> "+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
            }
        }
    }
}


