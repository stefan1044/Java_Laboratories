package lab10.ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = "";
            request = in.readLine();

            while (!request.equals("stop")) {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("Server received " + request);
                out.flush();
                request = in.readLine();
                if (request == null) {
                    break;
                }
            }

            if (request != null && request.equals("stop")) {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("Server stopped");
                out.flush();
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Communication error " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket " + e);
            }
        }
    }
}
