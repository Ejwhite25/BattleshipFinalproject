import java.io.*;
import java.net.Socket;

public class Player {
    Socket socket;
    InputStreamReader reader;
    PrintWriter writer;

    public static void main(String[] args){
        new Player().go();
    }
    private void go(){
        try {
            socket = new Socket("127.0.0.1", 5000);


            reader =new InputStreamReader(socket.getInputStream());
            BufferedReader buffer = new BufferedReader(reader);
            String msg= buffer.readLine();
            System.out.println(msg);

            writer = new PrintWriter(socket.getOutputStream());
            writer.println("player connected");
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
