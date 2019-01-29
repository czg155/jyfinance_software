package app.view.buy;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.view.index.BaseFrame;

public class AddBuy {
	public JPanel addBuyView() {
		BaseFrame f = BaseFrame.getInstance();
    	f.setTitle("增加入库");
    	
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panelTemplate = new JPanel();
		
		JLabel lb_tep_title = new JLabel("模板------");
		JLabel lb_tep_date = new JLabel("日期");
		JTextField tf_tep_date = new JTextField(20);
		JLabel lb_tep_company = new JLabel("供货单位");
		JTextField tf_tep_company = new JTextField(20);
		JLabel lb_tep_product = new JLabel("产品名称");
		JTextField tf_tep_product = new JTextField(20);
		JLabel lb_tep_type = new JLabel("规格");
		JTextField tf_tep_type = new JTextField(20);
		
		panelTemplate.add(lb_tep_title);
		panelTemplate.add(lb_tep_date);
		panelTemplate.add(tf_tep_date);
		panelTemplate.add(lb_tep_company);
		panelTemplate.add(tf_tep_company);
		panelTemplate.add(lb_tep_product);
		panelTemplate.add(tf_tep_product);
		panelTemplate.add(lb_tep_type);
		panelTemplate.add(tf_tep_type);
		
		panel.add(panelTemplate, "North");
		
		return panel;
	}
	
	public static void main(String[] args) {
		JFrame f = BaseFrame.getInstance();
		f.add(new AddBuy().addBuyView());
		f.setVisible(true);
	}
}
