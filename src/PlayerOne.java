import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Iterator;

public class PlayerOne {
    public static Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufferedReader;
    public static String input;
    GUIController guiController;
    boolean state = true;
    Controller controller = Controller.returnController();
    boolean setupState = false;

    public static void main(String[] args){
            new PlayerOne().go();
    }
    private void go(){
        guiController = new GUIController();
        try {
            socket = new Socket("127.0.0.1", 5000);
            receiveRead();
            while(true) {
                if (Controller.state) {
                    writeSend();
                    Controller.state = false;
                } else {
                    receiveRead();
                    Controller.state = true;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    void writeSend()throws IOException {
        while (input == null) {
            input = guiController.inputLine;
        }
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();
        controller.player1.displayBoard(guiController);
    }

    void receiveRead () throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();
        guiController.gui.setOutputText(line);
        controller.player1.displayBoard(guiController);

    }
}


