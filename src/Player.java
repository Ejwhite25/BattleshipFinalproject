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
            socket = new Socket("127.0.0.1", 9000);
            writer = new PrintWriter(socket.getOutputStream());
            reader =new InputStreamReader(socket.getInputStream());
            BufferedReader buffer = new BufferedReader(reader);
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            System.out.println("Welcome to the game");
            System.out.println("Enter a guess");
            String reteval = clientReader.readLine();
            if(reteval != null) {
                System.out.println(reteval);
            }
            while((line = bufferedReader.readLine()) != null){
                    writer.println(line);
                    writer.flush();
                    reteval = clientReader.readLine();
                    System.out.println(reteval);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
