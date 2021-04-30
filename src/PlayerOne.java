import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerOne {
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    GUIController guiController = new GUIController();
    BufferedReader bufferedReader;
    static String input;
    boolean state = true;

    public static void main(String[] args){
        input = null;
        GUIController guiController1 = new GUIController();
        new PlayerOne().go();

    }
    private void go(){

        try {
            playerSetup();
            socket = new Socket("127.0.0.1", 5000);
            receiveRead();

            while(true) {
                if(state) {
                    writeSend();
                    state = false;
                }
                else {
                    receiveRead();
                    state = true;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    void playerSetup() throws IOException{
        String input = null;
        input = guiController.inputLine;
        int[][] board1 = new int[10][10];
        int[][] board2 = new int[10][10];
        Controller.player1 = new Player1();
        Board board = new Board(board1,board2);
        Controller.player1.setBoard(board);
        Controller.player1board = Controller.player1.getBoard();
        Controller.player1board.displayBoard();
        for (String ship :Controller.player1.shipsPlayer1) {
            System.out.println("Inside for loop\n");
            guiController.gui.setOutputText("player1:Enter X coordinate for:" + ship);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(input);
            guiController.gui.setOutputText("player1:Enter Y coordinate for:" + ship);
            int y = Integer.parseInt(input);
            switch (ship) {
                case "Destroyer" -> {
                    Destroyer destroyer = new Destroyer(x,y);
                    Controller.player1.setDestroyer(destroyer);
                    Controller.player1destroyer = Controller.player1.getDestroyer();
                    Controller.player1.destroyer.createShip(1);
                }
                case "Carrier" -> {
                    Carrier carrier = new Carrier(x,y);
                    Controller.player1.setCarrier(carrier);
                    Controller.player1carrier = Controller.player1.getCarrier();
                    Controller.player1.carrier.createShip(1);
                }
                case "Battleship" -> {
                    Battleship battleship = new Battleship(x, y);
                    Controller.player1.setBattleship(battleship);
                    Controller.player1.battleship.createShip(1);
                }
                case "Submarine" -> {
                    Submarine submarine = new Submarine(x, y);
                    Controller.player1.setSubmarine(submarine);
                    Controller.player1submarine = Controller.player1.getSubmarine();
                    Controller.player1.submarine.createShip(1);
                }
            }

        }

    }
    void writeSend() throws IOException {
        String input = null;
        guiController.gui.setOutputText("Player1> Enter your guess in the format: X,Y");
        input = guiController.inputLine;
        if(input != null){
            writerSocket = new PrintWriter(socket.getOutputStream());
            writerSocket.println(input);
            writerSocket.flush();
        }
    }

    void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }

}

