package app.view.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.view.buy.Buy;

public class Hello {

    public JPanel helloView() {
    	JPanel panel = new JPanel();

        panel.setLayout(null);

        JButton loginButton = new JButton("Èë¿â");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = BaseFrame.getInstance();
				f.remove(panel);
				f.repaint();
				f.add(new Buy().buyView());
				f.setVisible(true);
			}
        	
        });
        
        return panel;
    }
}
