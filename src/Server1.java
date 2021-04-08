import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    Runnable job;
    Thread thread;
    Socket connection;
    InputStreamReader reader;
    PrintWriter writer;
    ServerSocket server;

    public static void main(String[] args){
        new Server1().go();
    }
    private void go(){
        try {
            server = new ServerSocket(5000);
            while(true) {
                connection = server.accept();

                job = new Job(connection);
                thread = new Thread(job);
                thread.start();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    class Job implements Runnable {
        Socket socket;

        Job(Socket name) {
            socket = name;
        }

        @Override
        public void run() {
            try {
                writer = new PrintWriter(connection.getOutputStream());
                writer.println("connected to the server");
                writer.flush();

                reader = new InputStreamReader(connection.getInputStream());
                BufferedReader buffer = new BufferedReader(reader);
                String msg = buffer.readLine();
                System.out.println(msg);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}


