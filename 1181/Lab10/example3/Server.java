/*A socket is a type of file. A socket pair forms a communication channel.A server sets up a 
ServerSocket and listens for clients to connect. When a client connects, the server accepts
the new client on a new socket. The server keeps listening for new clients on the ServerSocket. 
*/
     /**
        Socket Server to read bytes from a given port and print
     */

import java.io.*;
import java.net.*;
import java.util.*;

public class Server   {
        public static void main( String[] args )  throws IOException  {
		ServerSocket server = null;
		Socket client = null;
		int number=0;
		try {
			server = new ServerSocket( 10000 );
			System.out.println( "Server waiting for client data... " );
			client = server.accept( );
			Scanner in = new Scanner( client.getInputStream( ) );
			PrintWriter out = new PrintWriter( client.getOutputStream( ) );
			System.out.println( "Client connected." );
			int num=0;
			while( in.hasNextInt()) {
				num = in.nextInt() ;
				System.out.println(num);
				out.println(num*num);
				out.flush();
			}
		}
              
		catch( IOException e ){
			e.printStackTrace( );
		}
		finally{
			client.close( );
			server.close( );
		}
	}
}	
  
