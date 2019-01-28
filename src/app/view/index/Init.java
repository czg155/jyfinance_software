package app.view.index;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Init {
	public static JFrame frame;
	
	public static void main(String[] args) {    
        frame = new JFrame("欢迎使用河北旌原财务软件");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new Hello().helloView();
        frame.add(panel);
        frame.setVisible(true);
    }
}
