
import java.io.*;
import java.net.Socket;
import java.util.*;

	public class Client {
		public static void main( String[] args )  throws IOException {
		
			Socket server = null;
                
			try {
				server = new Socket( "localhost", 10000 );
				OutputStream outS = server.getOutputStream( );
				PrintWriter out = new PrintWriter(outS);
				Scanner in = new Scanner(server.getInputStream());
				for( int i = 0; i < 10; i++ ){
					out.println(i);
					out.flush();
					System.out.println(in.nextInt());
					
				}	
				
			}
			catch( IOException e ) {
				e.printStackTrace( );
			}
			finally {
				server.close( );
			}

		}
	}
  
 
