import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
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

            while(setupState = true) {
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
    void playerSetup() throws IOException {
        int[][] board1 = new int[10][10];
        int[][] board2 = new int[10][10];
        Controller.player1 = new Player1();
        iterator = Controller.player1.shipsPlayer1.iterator();
        Board board = new Board(board1, board2);
        Controller.player1.setBoard(board);
        Controller.player1board = Controller.player1.getBoard();
        guiController.gui.setOutputText("Welcome to battleship\n");
        while(iterator.hasNext()) {
            String ship = iterator.next();
            guiController.gui.setOutputText("Player1:enter coordinates in the format X,Y for:" + ship);
            while (input == null) {
                input = guiController.inputLine;
            }
            String[] parsedInput = input.split(",");
            int x = Integer.parseInt(parsedInput[0]);
            int y = Integer.parseInt(parsedInput[1]);
            switch (ship) {
                case "Destroyer" -> {
                    System.out.println(ship + "Case");
                    Destroyer destroyer = new Destroyer(x, y);
                    Controller.player1.setDestroyer(destroyer);
                    Controller.player1destroyer = Controller.player1.getDestroyer();
                    Controller.player1.destroyer.createShip(1);

                }
                case "Carrier" -> {
                    System.out.println(ship + "Case");
                    Carrier carrier = new Carrier(x, y);
                    Controller.player1.setCarrier(carrier);
                    Controller.player1carrier = Controller.player1.getCarrier();
                    Controller.player1.carrier.createShip(1);
                }
                case "Battleship" -> {
                    System.out.println(ship + "Case");
                    Battleship battleship = new Battleship(x, y);
                    Controller.player1.setBattleship(battleship);
                    Controller.player1battleship = Controller.player1.getBattleship();
                    Controller.player1.battleship.createShip(1);
                }
                case "Submarine" -> {
                    System.out.println(ship + "Case");
                    Submarine submarine = new Submarine(x, y);
                    Controller.player1.setSubmarine(submarine);
                    Controller.player1submarine = Controller.player1.getSubmarine();
                    Controller.player1.submarine.createShip(1);

                }
            }
        }
        Controller.player1board.displayBoard(guiController);
        setupState = true;

    }
        void writeSend () throws IOException {
            guiController.gui.setOutputText("Player1> Enter your guess in the format: X,Y");
            while (input == null) {
                input = guiController.inputLine;
            }
            if (input != null) {
                writerSocket = new PrintWriter(socket.getOutputStream());
                writerSocket.println(input);
                writerSocket.flush();
            }
        }

        void receiveRead () throws IOException {
            readerSocket = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(readerSocket);
            String line = bufferedReader.readLine();
            guiController.gui.setOutputText(line);
        }
    }


