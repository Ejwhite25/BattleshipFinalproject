import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerTwo {
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufferedReader;
    boolean state = false;
    Controller controller = new Controller();
    GUIController guiController = new GUIController();
    private ArrayList<String> ships = new ArrayList<String>(4);
    public static void main(String[] args){
        new PlayerTwo().go();
    }
    private void go(){
        try {
            socket = new Socket("127.0.0.1", 9000);
            receiveRead();

            while(true) {
                if(state) {
                    playerSetup();
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
                    controller.player2.setDestroyer(destroyer);
                    controller.player2.destroyer.createShip(2);
                }
                case "Carrier" -> {
                    Carrier carrier = new Carrier(x,y);
                    controller.player2.setCarrier(carrier);
                    controller.player2.carrier.createShip(2);
                }
                case "Battleship" -> {
                    Battleship battleship = new Battleship(x, y);
                    controller.player2.setBattleship(battleship);
                    controller.player2.battleship.createShip(2);
                }
                case "Submarine" -> {
                    Submarine submarine = new Submarine(x, y);
                    controller.player2.setSubmarine(submarine);
                    controller.player2.submarine.createShip(2);
                }
            }

        }

    }
    void writeSend() throws IOException {
        String input = guiController.inputLine;
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();

    }

    void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        System.out.println("player 2:: from server >  "+line);
    }

}
