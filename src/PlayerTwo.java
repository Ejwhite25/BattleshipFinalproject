import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerTwo {
    private Socket socket;
    private static InputStreamReader readerSocket;
    private static PrintWriter writerSocket;
    private static BufferedReader bufferedReader;
    private static boolean state = false;
    boolean setupState = false;
    Controller controller = new Controller();
    GUIController guiController = new GUIController();
    private ArrayList<String> ships = new ArrayList<String>(4);


    public static void main(String[] args){
        new PlayerTwo().go();
    }

    private void go(){
        try {
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
    void playerSetup() throws IOException{
        String input = guiController.inputLine;
        ships.add("Carrier");
        ships.add("Destroyer");
        ships.add("Battleship");
        ships.add("Submarine");
        Controller.player2 = new Player2();

        Board board = new Board();
        int[][] board1 = new int[10][10];
        int[][] board2 = new int[10][10];
        for (int[] ints : board2) {
            Arrays.fill(ints, 0);
        }
        board.setBoard(board1,board2);
        Controller.player2.setBoard(board);
        Controller.player2board = Controller.player2.getBoard();
        for(String ship:ships){
            int x;
            int y;
            switch (ship) {
                case "Destroyer" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player2board.board[x][y] == 0) {
                        System.out.println("Player 2 X:" + x);
                        System.out.println("PLayer 2 Y:" + y);
                        Destroyer destroyer = new Destroyer(x, y);
                        Controller.player2.setDestroyer(destroyer);
                        Controller.player2destroyer = Controller.player2.getDestroyer();
                        Controller.player2.destroyer.createShip(2);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }
                }
                case "Carrier" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player2board.board[x][y] == 0) {
                        Carrier carrier = new Carrier(x, y);
                        Controller.player2.setCarrier(carrier);
                        Controller.player2carrier = Controller.player2.getCarrier();
                        Controller.player2.carrier.createShip(2);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }

                }
                case "Battleship" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player2board.board[x][y] == 0) {
                        Battleship battleship = new Battleship(x, y);
                        Controller.player2.setBattleship(battleship);
                        Controller.player2battleship = Controller.player2.getBattleship();
                        Controller.player2.battleship.createShip(2);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                    }
                }
                case "Submarine"-> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(Controller.player2board.board[x][y] == 0) {
                        Submarine submarine = new Submarine(x, y);
                        Controller.player2.setSubmarine(submarine);
                        Controller.player2submarine = Controller.player2.getSubmarine();
                        Controller.player2.submarine.createShip(2);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                    }

                }
            }
        }
        Controller.player2board.displayBoard(guiController);
    }
    private void writeSend() throws IOException {
        String input;
        input = guiController.inputLine;
        if(input != null){
            writerSocket = new PrintWriter(socket.getOutputStream());
            writerSocket.println(input);
            writerSocket.flush();
        }

    }

    private void receiveRead() throws IOException {
        guiController.gui.setOutputText("Player2> Enter your guess in the format: X,Y");
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }

}
