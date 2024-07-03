package sockets;

import java.io.*;
import java.net.Socket;

public class ClientBasicOperations {
    public static void establishClientConnection() {

        try (
                Socket mySocket = new Socket("192.168.1.7", 7777);
                // preparing Two channels here one for input and another for output
                InputStream comingStreamFromServer = mySocket.getInputStream();
                OutputStream sendingStreamFromServer = mySocket.getOutputStream();
                // ---------- You will need to read and write to this server -------
                // This step for receiving data from the server
                Reader r = new InputStreamReader(comingStreamFromServer);
                BufferedReader readDataFromServer = new BufferedReader(r);
//                we need to send data to the server
                Writer w = new OutputStreamWriter(sendingStreamFromServer);
                BufferedWriter sendDataToServer = new BufferedWriter(w);

        ) {
            // [1- INPUT ]
            String name = "Mohamed Alaa amer made this connection";
            // [2- PROCESSING]

            // [3- OUTPUT ]
            sendDataToServer.write(name);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}

