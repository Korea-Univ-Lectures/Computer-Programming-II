//awt는 운영체제에 따라 달라진다.
package Study_05_00;

import java.awt.Button;
import java.awt.Frame;

class basicawt{
	Frame f1 =new Frame("ㅎㅎㅎ");
	Button b1 = new Button("ㅋㅋㅋ");
	
	public void creataFrame() {
		f1.add(b1);
		f1.setSize(300,600);
		f1.setVisible(true);
	}
}

public class Study_05_01_awt {

	public static void main(String[] args) {
		basicawt a1 = new basicawt();
		a1.creataFrame();
	}

}
