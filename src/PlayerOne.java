import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Iterator;

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
        Controller controller = Controller.returnController();
        int[][] board1 = new int[20][20];
        int[][] board2 = new int[20][20];
        for(int[] ints:board1){
            Arrays.fill(ints,0);
        }
        for (int[] ints : board2) {
            Arrays.fill(ints, 0);
        }
        Board board = new Board(board1,board2);
        controller.player1.setBoard(board);
        for(String ship:controller.player1.ships){
            int x;
            int y;
            switch (ship) {
                case "Destroyer" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(controller.player1.getBoard().board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Destroyer destroyer = new Destroyer(x, y);
                        controller.player1.setDestroyer(destroyer);
                        controller.player1.getDestroyer().createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }
                }
                case "Carrier" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(controller.player1.getBoard().board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Carrier carrier = new Carrier(x, y);
                        controller.player1.setCarrier(carrier);
                        controller.player1.getCarrier().createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }

                }
                case "Battleship" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(controller.player1.getBoard().board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Battleship battleship = new Battleship(x, y);
                        controller.player1.setBattleship(battleship);
                        controller.player1.getBattleship().createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                    }
                }
                case "Submarine"-> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if(controller.player1.getBoard().board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Submarine submarine = new Submarine(x, y);
                        controller.player1.setSubmarine(submarine);
                        controller.player1.getSubmarine().createShip(1);
                    }
                    else{
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                        System.out.println("Error checking...\n");
                    }

                }
            }
        }
        controller.player1.getBoard().displayBoard(guiController);

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


