package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBasicOperation {
    public static void makeServerConnection() {
        try (
//                This is the resource you need to catch this exception uaamer But it in
//                This is the initialization Step uaAlaa
                ServerSocket serverSocket = new ServerSocket(7777);
                Socket clientSocket = serverSocket.accept();    // socket will wait for other client application to send data

                /*  we need to get the input and output channels for the client uaAmer */
                InputStream clientSocketInputStream = clientSocket.getInputStream();
                OutputStream clientSocketOutputStream = clientSocket.getOutputStream();
                /*
                 * End of the channels for the client */

                /*
                 * After you opened the channels you need to read from these channels like the files you used before
                 * You have a lot of class to be used to read from the channels like Printer or Reader or BufferedReader
                 * */

//            These classes used to read from the channels
                Reader reader = new InputStreamReader(clientSocketInputStream);
                BufferedReader clientBufferedReader = new BufferedReader(reader);

                /*
                 *            You need to write the client Socket You could use PrintWriter
                 *             Sending data to the client device
                 * */

                PrintWriter printWriter = new PrintWriter(clientSocketOutputStream);

        ) {
            /*
             * You need to read from the client
             * */
//            [This is the input Steps]
            String clientMessage = clientBufferedReader.readLine();
//            [This is the processing Step]
            String message = "Welcome " + clientMessage;
//            [This is the output step uaAmer]
            System.out.println(message);
        } catch (IOException ex) {
            System.err.println("This is just iOException : " + ex.getMessage());
        }

    }

    public static void establishServerConnection() {

        try
                (
//                    This is the initialization Steps [ 4 step common ]
                        ServerSocket mySever = new ServerSocket(7777);
                        Socket socket = mySever.accept(); // so you will wait for the client to send you data
                        // we need to make our channels uaamer
                        //receiving data From the client
                        InputStream comingDataFromClient = socket.getInputStream();
                        OutputStream outgoingDataToClient = socket.getOutputStream();
                        // You need to send some data to the client
                        Writer w = new OutputStreamWriter(outgoingDataToClient);
                        BufferedWriter bufferedWriter = new BufferedWriter(w);
                        // You need to receive some data to the client
                        Reader r = new InputStreamReader(comingDataFromClient);
                        BufferedReader bufferedReader = new BufferedReader(r);
                ) {
//              [1- Input ]
            String message = "This is the server message ";
//              [1- processing ]

//              [1- output ]
            String clientMessaage = bufferedReader.readLine();
            System.out.println("The client Message is : " + clientMessaage);
        } catch (IOException e) {
            System.out.println("This is a IOException " + e.getMessage());
        }
    }

}
