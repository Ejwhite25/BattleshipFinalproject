
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static PrintWriter writerSocket;
    private static BufferedReader buffedReader;
    public static String player1shipHit;
    Controller controller = Controller.returnController();
    private static String sharedMessage;
    private static boolean player1Turn = true;
    private static boolean player2Turn = false;
    int shipsLeftPlayer1 = 4;
    int shipsLeftPlayer2 = 4;
    public static String player2hit;
    private static InputStreamReader readerSocket;
    private final Object lock = new Object();

    void waitForLock() {
        synchronized (lock) {
            try {
                lock.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void notifyLock() {
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().go();
    }

    void go() throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket connectionOne = server.accept();
        controller.player1.setUp();
        writerSocket = new PrintWriter(connectionOne.getOutputStream());
        System.out.println("Server>> P1 connected");
        new Thread(new JobOne(connectionOne)).start();


        Socket connectionTwo = server.accept();
        System.out.println("server>> P2 connected");
        controller.player2.setUp();
        writerSocket = new PrintWriter(connectionTwo.getOutputStream());
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
            try {
                readerSocket = new InputStreamReader(socket.getInputStream());
                buffedReader = new BufferedReader(readerSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                if(!socket.isConnected()){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
                Controller.state = false;
                try {
                    writerSocket.println(sharedMessage);
                    writerSocket.flush();
                    writerSocket.println("Player1> Enter your guess in the format: X,Y");
                    writerSocket.flush();
                    sharedMessage = buffedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] coordinates = sharedMessage.split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                if (controller.player2.board.testHit(x, y)) {
                    controller.player1.board.updateBoard("Hit", x, y);
                    sharedMessage = "Player 2 has been hit!";
                    shipsLeftPlayer2--;
                    if (shipsLeftPlayer2 == 0) {
                            sharedMessage = "Player 1 has won!";
                    }
                } else if(!controller.player2.board.testHit(x,y)){
                    sharedMessage = "Player 1 misses!";
                }
                try {
                    writerSocket = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
                writerSocket.println(sharedMessage);
                writerSocket.flush();
                waitForLock();
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
                waitForLock();
                while (true) {
                    if(!socket.isConnected()){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    }
                    try {
                        readerSocket = new InputStreamReader(socket.getInputStream());
                        buffedReader = new BufferedReader(readerSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        writerSocket = new PrintWriter(socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Controller.state1 = false;
                    writerSocket.println(sharedMessage);
                    writerSocket.flush();
                    writerSocket.println("Player 2> Enter the coordinates in the format X,Y:");
                    writerSocket.flush();
                    try {
                        sharedMessage = buffedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] coordinates = sharedMessage.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    Coordinate coordinate = new Coordinate(x, y);
                    if (controller.player1.board.testHit(x, y)) {
                        controller.player2.board.updateBoard("Hit", x, y);
                        sharedMessage = "Player 2 has a hit";
                        shipsLeftPlayer1--;
                        if (shipsLeftPlayer1 == 0) {
                                sharedMessage = "PLayer 2 has won!";
                        }
                    } else {
                        controller.player2.board.updateBoard("Miss", x, y);
                        sharedMessage = "Player 2 has a miss.";
                    }
                    notifyLock();
                    writerSocket.println(sharedMessage);
                    writerSocket.flush();
                }
            }
        }
    }