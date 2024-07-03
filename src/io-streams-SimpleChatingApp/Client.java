package socketSimpleChatingApp;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void establishingClientConnection() {
        try (
                /*
                 * You will make the initialization step
                 * */
                Socket socket = new Socket("192.168.1.7", 8888);
                // You need to establish channels uaAlaa
                OutputStream fromClient = socket.getOutputStream();
                InputStream toClient = socket.getInputStream();
                // You need to receive some data to server first
                Reader r = new InputStreamReader(toClient);
                BufferedReader bufferedReader = new BufferedReader(r);
                // You need to send or print some data to the server
                PrintStream fromClientToSeverPrinter = new PrintStream(fromClient);

        ) {
            /*
             * Whole process could be put here uaAlaa This is simple task
             * */
            //[1- Input ]
            String clientMessage = "This is a Client message";

            //[2-Processing ]
            fromClientToSeverPrinter.print(clientMessage);
            //[3- output ]

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
