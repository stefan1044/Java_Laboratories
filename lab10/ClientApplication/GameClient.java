package lab10.ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    private static Socket socket = null;

    public static void main(String[] args)throws IOException{
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try{
            socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String request = "";
            while(!request.equals("exit")) {
                request = reader.readLine();
                out.println(request);
                String response = in.readLine();
                System.out.println(response);

                if (response.equals("Server stopped")) {
                    break;
                }
            }
        }catch (UnknownHostException e){
            System.err.println("No server listening " + e);
        }finally {
            try{
                socket.close();
                System.exit(0);
            }catch (IOException e){
                System.err.println("Error closing socket " + e);
            }
        }
    }
}
