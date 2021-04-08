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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String msg= buffer.readLine();
            System.out.println(msg);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.print("Enter a random number");
            String guess =  bufferedReader.readLine();
            writer.println(guess);
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
