//awt�� �ü���� ���� �޶�����.
package Study_05_00;

import java.awt.Button;
import java.awt.Frame;

class basicawt{
	Frame f1 =new Frame("������");
	Button b1 = new Button("������");
	
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
