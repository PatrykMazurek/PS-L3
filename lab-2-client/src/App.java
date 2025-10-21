import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Socket clientSocket = new Socket("localhost", 5500);
        PrintWriter writer = new PrintWriter(
                clientSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        String line ="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("nawiązano komunikację z serwerem");
        while (true) {
            System.out.println(reader.readLine());
            line = scanner.nextLine();
            if(line.trim().equals("q")){
                writer.println(line);
                break;
            }
            writer.println(line);
        }
        System.out.println("zakończona komunikację z serwerem");
        reader.close();
        writer.close();
        clientSocket.close();
    }
}
