package app.view.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.view.buy.Buy;

public class Hello {

    public JPanel helloView() {
    	JPanel panel = new JPanel();

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String u = userText.getText();
				@SuppressWarnings("deprecation")
				String p = passwordText.getText();
				if (u == null && p == null) {
					Init.frame.removeAll();
					Init.frame.add(new Buy().buyView());
				}
			}
        	
        });
        
        return panel;
    }
}
