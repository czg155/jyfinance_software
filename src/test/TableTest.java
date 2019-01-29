package test;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import app.view.index.BaseFrame;

public class TableTest {
	public static void main(String[] args) {
		BaseFrame f = BaseFrame.getInstance();
		JPanel panel = new JPanel();
		
		Object[][] o = new Object[3][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
//				o[i][j] = new JTextField();
			}
		}
		String[] oh = {"1", "2", "3", "4"};
		JTable table = new JTable(o, oh);
		panel.add(table);
		f.add(panel);
		f.setVisible(true);	
	}
}
