import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerTwo {
    private static Socket socket;
    private static InputStreamReader readerSocket;
    private static PrintWriter writerSocket;
    private static BufferedReader bufferedReader;
    public static String input;
    Controller controller = Controller.returnController();
    GUIController guiController;
    private static boolean state = false;
    boolean setupState = false;
    private ArrayList<String> ships = new ArrayList<String>(4);


    public static void main(String[] args){
        new PlayerTwo().go();
    }


    private void go(){
        guiController = new GUIController();
        controller.player2.displayBoard(guiController);
        try {
            socket = new Socket("127.0.0.1", 5000);
            receiveRead();
            while (true) {
                if (Controller.state1) {
                    writeSend();
                    Controller.state1 = false;
                } else {
                    receiveRead();
                    Controller.state1 = true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeSend() throws IOException {
        while (input == null) {
            input = guiController.inputLine;
        }
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();

    }

    private void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
    }

}
