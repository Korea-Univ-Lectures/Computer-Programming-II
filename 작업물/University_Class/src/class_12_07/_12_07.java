package class_12_07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class _12_07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStreamReader r = new InputStreamReader(System.in);
		FileWriter o = new FileWriter("save.txt");
		
		int c=0;
		while(c!='q') {
			try {
				c=r.read();
				o.write(c);
			}
			catch(IOException e) {
				System.out.println("shit");
				return;
			}
			o.flush();
		}
	
	}

}
