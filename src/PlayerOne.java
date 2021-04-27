import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerOne {
    Player1 player1 = new Player1();
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufferedReader;
    boolean state = true;
    GUIController guiController = new GUIController();
    Controller controller = new Controller();
    private ArrayList<String> ships = new ArrayList<String>(4);

    public static void main(String[] args){
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
        String input = guiController.inputLine;
        ships.add("Carrier");
        ships.add("Destroyer");
        ships.add("Battleship");
        ships.add("Submarine");
        for (String ship : ships) {
            System.out.println("player 1:Enter X coordinate for: " + ship);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            int x = Integer.parseInt(input);
            System.out.println("player1:Enter Y coordinate for:" + ship);
            input = bufferedReader.readLine();
            int y = Integer.parseInt(input);
            switch (ship) {
                case "Destroyer" -> {
                    Destroyer destroyer = new Destroyer(x,y);
                    controller.player1.setDestroyer(destroyer);
                    player1.destroyer.createShip(1);
                }
                case "Carrier" -> {
                    Carrier carrier = new Carrier(x,y);
                    controller.player1.setCarrier(carrier);
                    controller.player1carrier.createShip(1);
                }
                case "Battleship" -> {
                    Battleship battleship = new Battleship(x, y);
                    controller.player1.setBattleship(battleship);
                    controller.player1.battleship.createShip(1);
                }
                case "Submarine" -> {
                    Submarine submarine = new Submarine(x, y);
                    controller.player1.setSubmarine(submarine);
                    controller.player1.submarine.createShip(1);
                }
            }

        }

    }
    void writeSend() throws IOException {
        String input;
        System.out.println("player 1:Enter X and Y coordinates: ");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();
    }

    void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        System.out.println("player 1:: from server >  "+line);
    }

}

