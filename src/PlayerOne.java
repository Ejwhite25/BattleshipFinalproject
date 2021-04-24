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
    BufferedReader bufferedReader;
    boolean state = true;
    Controller controller = new Controller();
    private ArrayList<String> ships = new ArrayList<String>(4);

    public static void main(String[] args){
        new PlayerOne().go();
    }
    private void go(){
        try {
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
    void writeSend() throws IOException {
        String input = null;
        ships.add("Carrier");
        ships.add("Destroyer");
        ships.add("Battleship");
        ships.add("Submarine");
        for(int i =0; i < ships.size(); i++){
            System.out.println("player 1:Enter X coordinate for: " + ships.get(i));
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            int x = Integer.parseInt(input);
            System.out.println("player1:Enter Y coordinate for:" + ships.get(i));
            input = bufferedReader.readLine();
            int y = Integer.parseInt(input);
            switch (ships.get(i)) {
                case "Destroyer" -> {
                    Destroyer destroyer = new Destroyer(x, y);
                    controller.player1.setDestroyer(destroyer);
                    controller.player1.destroyer.createShip(1);
                }
                case "Carrier" -> {
                    Carrier carrier = new Carrier(x, y);
                    controller.player1.setCarrier(carrier);
                    controller.player1.carrier.createShip(1);
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

