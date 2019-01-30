package view.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Init {
	public static void main(String[] args) {
		BaseFrame frame = BaseFrame.getInstance();
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
				if (u.equals("") && p.equals("")) {
					JPanel panel2 = new Hello().helloView();
					frame.remove(panel);
					frame.repaint();
					frame.add(panel2);
			        frame.setVisible(true);
				}
			}
        	
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}
