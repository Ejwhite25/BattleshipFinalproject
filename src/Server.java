
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static PrintWriter writerSocket;
    private static BufferedReader buffedReader;
    public static String player1shipHit;
    Controller controller = Controller.returnController();
    private static String sharedMessage;
    int shipsLeftPlayer1 = 4;
    int shipsLeftPlayer2 = 4;
    public static String player2hit;
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
            try {
                readerSocket = new InputStreamReader(socket.getInputStream());
                buffedReader = new BufferedReader(readerSocket);

            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                writerSocket.println("Player1> Enter your guess in the format: X,Y");
                writerSocket.flush();
                try {
                    sharedMessage = buffedReader.readLine();
                    String[] coordinates = sharedMessage.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    System.out.println("X:" + x);
                    int y = Integer.parseInt(coordinates[1]);
                    System.out.println("Y:" + y);
                    Turn turn = new Turn(1, x, y);
                    if (controller.player2.testHit(turn)) {
                        controller.player1.board.updateBoard("Hit",turn.firstCoordinate,turn.secondCoordinate);
                        sharedMessage = "Player 2 has been hit!";
                        writerSocket.println(sharedMessage);
                        writerSocket.flush();
                        if (controller.player2.testShip(player1shipHit, x, y)) {
                            sharedMessage = "Player 2's" + player1shipHit + " is Down";
                            writerSocket.println(sharedMessage);
                            writerSocket.flush();
                            shipsLeftPlayer2--;
                            if (shipsLeftPlayer2 == 0) {
                                sharedMessage = "Player 1 has won!";
                                writerSocket.println(sharedMessage);
                                writerSocket.flush();
                            }
                        }
                    } else {
                        sharedMessage = "Player 1 misses!";
                        controller.player1.board.updateBoard("Miss",turn.firstCoordinate,turn.secondCoordinate);
                        writerSocket.println(sharedMessage);
                        writerSocket.flush();
                    }

                } catch(IOException e){
                    e.printStackTrace();
                }
                notifyLock();
                waitForLock();
                try {
                    writerSocket = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writerSocket.println("From player 2:"  + sharedMessage);
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
            try {
                readerSocket = new InputStreamReader(socket.getInputStream());
                buffedReader = new BufferedReader(readerSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                waitForLock();
                writerSocket.println("Player2>" + sharedMessage);
                writerSocket.flush();
                try {
                    sharedMessage = buffedReader.readLine();
                    String[] coordinates = sharedMessage.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    Turn turn = new Turn(2,x,y);
                    if(controller.player1.testHit(turn)){
                        controller.player2.board.updateBoard("Hit",x,y);
                        sharedMessage = "Player 2 has a hit";
                        writerSocket.println(sharedMessage);
                        writerSocket.flush();
                        if(controller.player1.testShip(player2hit,x,y)){
                            sharedMessage = "Player1s" + player2hit + "is down!";
                            writerSocket.println(sharedMessage);
                            writerSocket.flush();
                            shipsLeftPlayer1--;
                            if(shipsLeftPlayer1 == 0){
                                sharedMessage = "PLayer 2 has won!";
                                writerSocket.println(sharedMessage);
                                writerSocket.flush();
                            }
                        }
                    }
                    else{
                        controller.player2.board.updateBoard("Miss",turn.firstCoordinate,turn.secondCoordinate);
                        sharedMessage = "PLayer 2 has a miss.";
                        writerSocket.println(sharedMessage);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                notifyLock();
            }
        }
    }
}


