import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class PlayerOne {
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    GUIController guiController;
    BufferedReader bufferedReader;
    public static String input;
    boolean state = true;
    boolean setupState = false;
    Iterator<String> iterator;

    public static void main(String[] args){
            new PlayerOne().go();
    }
    private void go(){
        guiController = new GUIController();
        try {
            input = null;
            playerSetup();
            socket = new Socket("127.0.0.1", 7000);
            receiveRead();
            if(state) {
                    writeSend();
                    state = false;
                }
                else {
                    receiveRead();
                    state = true;
                }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    void playerSetup() throws IOException {
        int[][] board1 = new int[10][10];
        int[][] board2 = new int[10][10];
        for (int[] ints : board2) {
            Arrays.fill(ints, 0);
        }
        Board board = new Board();
        board.setBoard(board1,board2);
        Controller.player1.setBoard(board);
        Controller.player1board = Controller.player1.getBoard();
        for(String ship:Controller.player1.shipsPlayer1){
            int x;
            int y;
            switch (ship) {
                case "Destroyer" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player1board.board[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Destroyer destroyer = new Destroyer(x, y);
                        Controller.player1.setDestroyer(destroyer);
                        Controller.player1destroyer = Controller.player1.getDestroyer();
                        Controller.player1.destroyer.createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }
                }
                case "Carrier" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player1board.board[x][y] == 0) {
                        Carrier carrier = new Carrier(x, y);
                        Controller.player1.setCarrier(carrier);
                        Controller.player1carrier = Controller.player1.getCarrier();
                        Controller.player1.carrier.createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }

                }
                case "Battleship" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player1board.board[x][y] == 0) {
                        Battleship battleship = new Battleship(x, y);
                        Controller.player1.setBattleship(battleship);
                        Controller.player1battleship = Controller.player1.getBattleship();
                        Controller.player1.battleship.createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                    }
                }
                case "Submarine"-> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player1board.board[x][y] == 0) {
                        Submarine submarine = new Submarine(x, y);
                        Controller.player1.setSubmarine(submarine);
                        Controller.player1submarine = Controller.player1.getSubmarine();
                        Controller.player1.submarine.createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                        System.out.println("Error checking...\n");
                    }

                }
            }
        }
        Controller.player1board.displayBoard(guiController);

    }
    void writeSend()throws IOException {
        while (input == null) {
            input = guiController.inputLine;
        }
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();
    }

    void receiveRead () throws IOException {
        guiController.gui.setOutputText("Player1> Enter your guess in the format: X,Y");
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }
}


