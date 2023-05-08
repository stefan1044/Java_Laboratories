package lab10.ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(this.PORT);

            while (true){
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        }catch (IOException e){
            System.err.println("Error when accepting connections!" + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException{
        GameServer gameServer = new GameServer();
    }
}
