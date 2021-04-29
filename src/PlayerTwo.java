import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerTwo {
    private Socket socket;
    private static InputStreamReader readerSocket;
    private static PrintWriter writerSocket;
    private static BufferedReader bufferedReader;
    private static boolean state = false;
    Controller controller = new Controller();
    GUIController guiController = new GUIController();
    private ArrayList<String> ships = new ArrayList<String>(4);


    public static void main(String[] args){
        new PlayerTwo().go();
    }

    private void go(){
        try {
            socket = new Socket("127.0.0.1", 7000);
            receiveRead();
            playerSetup();
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
        String input = guiController.inputLine;
        ships.add("Carrier");
        ships.add("Destroyer");
        ships.add("Battleship");
        ships.add("Submarine");
        int[][] board1 = new int[10][10];
        int[][] board2 = new int[10][10];
        Board board = new Board(board1,board2);
        Controller.player2.setBoard(board);
        Controller.player2board = Controller.player2.getBoard();
        for (String ship : ships) {
            System.out.println("player 2:Enter X coordinate for: " + ship);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input = bufferedReader.readLine();
            int x = Integer.parseInt(input);
            System.out.println("player2:Enter Y coordinate for:" + ship);
            input = bufferedReader.readLine();
            int y = Integer.parseInt(input);
            switch (ship) {
                case "Destroyer" -> {
                    Destroyer destroyer = new Destroyer(x, y);
                    Controller.player2.setDestroyer(destroyer);
                    Controller.player2destroyer = Controller.player2.getDestroyer();
                    Controller.player2.destroyer.createShip(2);
                }
                case "Carrier" -> {
                    Carrier carrier = new Carrier(x,y);
                    Controller.player2.setCarrier(carrier);
                    Controller.player2carrier = Controller.player2.getCarrier();
                    Controller.player2.carrier.createShip(2);
                }
                case "Battleship" -> {
                    Battleship battleship = new Battleship(x, y);
                    Controller.player2.setBattleship(battleship);
                    Controller.player2battleship = Controller.player2.getBattleship();
                    Controller.player2.battleship.createShip(2);
                }
                case "Submarine" -> {
                    Submarine submarine = new Submarine(x, y);
                    Controller.player2.setSubmarine(submarine);
                    Controller.player2submarine = Controller.player2.getSubmarine();
                    Controller.player2.submarine.createShip(2);
                }
            }

        }

    }
    private void writeSend() throws IOException {
        Controller.player2board.displayBoard();
        String input;
        guiController.gui.setOutputText("Player2> Enter your guess in the format: X,Y");
        input = guiController.inputLine;
        if(input != null){
            writerSocket = new PrintWriter(socket.getOutputStream());
            writerSocket.println(input);
            writerSocket.flush();
        }

    }

    private void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }

}
