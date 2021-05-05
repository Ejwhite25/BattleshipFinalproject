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
    GUIController guiController;
    Controller controller = Controller.returnController();
    private static boolean state = false;
    boolean setupState = false;
    private ArrayList<String> ships = new ArrayList<String>(4);


    public static void main(String[] args){
        new PlayerTwo().go();
    }

    private void go(){
        guiController = new GUIController();
        try {
            playerSetup();
            socket = new Socket("127.0.0.1", 7000);
            receiveRead();
            if(Controller.state) {
                    writeSend();
                    Controller.state = false;
                }
                else {
                    receiveRead();
                    Controller.state = true;
                }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    void playerSetup() throws IOException{
        for(String ship: controller.player2.ships){
            int x;
            int y;
            switch (ship) {
                case "Destroyer" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    Destroyer destroyer = new Destroyer(x, y);
                    controller.player2.setDestroyer(destroyer);
                    controller.player2.getDestroyer().createShip(2);
                }
                case "Carrier" -> {
                    x = (int) (Math.random() * (9) + 1);
                    y = (int) (Math.random() * (9) + 1);
                    Carrier carrier = new Carrier(x,y);
                    System.out.println("X:" + x);
                    System.out.println("Y:" + y);
                    controller.player2.setCarrier(carrier);
                    controller.player2.board.createShip(x,y);
                    controller.player2.carrier.createShip(2);

                }
                case "Battleship" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    Battleship battleship = new Battleship(x, y);
                    controller.player2.setBattleship(battleship);
                    controller.player2.getBattleship().createShip(2);
                }
                case "Submarine"-> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    Submarine submarine = new Submarine(x, y);
                    controller.player2.setSubmarine(submarine);
                    controller.player2.getSubmarine().createShip(2);


                }
            }
        }
        controller.player2.displayBoard(guiController);
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
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }

}
