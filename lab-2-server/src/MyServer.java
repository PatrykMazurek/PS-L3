import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyServer implements Runnable{

    private Socket client;
    private PrintWriter writer;
    private BufferedReader reader;

    public MyServer(Socket s){
        client = s;
        try {
            writer = new PrintWriter(client.getOutputStream(), true);
            reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            System.out.println("połaoczon z klientem " + client.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        writer.println("witaj możesz rozpocząć komunikację:");
        String line = "";
        while (true) {
            try {
                line = reader.readLine();
                System.out.println(line);
                if(line.trim().equals("q")){
                    writer.println("pa pa");
                    break;
                }
                writer.println(line.toUpperCase());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        disconnect();
    }
    
    private void disconnect(){
        if(!client.isClosed()){
            try {
                reader.close();
                writer.close();
                client.close();
                System.out.println("zakończono połączenie ");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
