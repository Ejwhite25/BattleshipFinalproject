import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerOne {
    GUIController guiController = new GUIController();
    Socket socket;
    InputStreamReader readerSocket;
    PrintWriter writerSocket;
    BufferedReader bufferedReader;
    boolean state = true;

    public static void main(String[] args){
        new PlayerOne().go();
    }
    private void go(){
        try {
            socket = new Socket("127.0.0.1", 9000);
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
        guiController.gui.setOutputText("player 1:: input message: ");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println("input = "+input);
        input = guiController.inputLine;
        writerSocket = new PrintWriter(socket.getOutputStream());
        writerSocket.println(input);
        writerSocket.flush();
    }

    void receiveRead() throws IOException {
        readerSocket = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(readerSocket);
        String line = bufferedReader.readLine();//prints date from incoming connexion
        guiController.gui.setOutputText("player 1:: from server >  "+line);
    }

}

