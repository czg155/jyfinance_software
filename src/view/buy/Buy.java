package view.buy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.BuyDatabase;
import view.index.BaseFrame;
import model.buy.ModelBuy;

public class Buy {

    public JPanel buyView() {
    	BaseFrame f = BaseFrame.getInstance();
    	f.setTitle("��ⵥ");
    	JPanel panel = new JPanel();
    	
    	JLabel title = new JLabel("��ⵥ");
    	panel.add(title);
    	
    	JLabel lb_c = new JLabel("������λ");
    	panel.add(lb_c);
    	JComboBox<String> cb_company = new JComboBox<String>();
    	cb_company.addItem("c1");
    	cb_company.addItem("c2");
    	cb_company.addItem("c3");
    	panel.add(cb_company);
    	
    	JLabel lb_p = new JLabel("��Ʒ����");
    	panel.add(lb_p);
    	JComboBox<String> cb_product = new JComboBox<String>();
    	cb_product.addItem("p1");
    	cb_product.addItem("p2");
    	cb_product.addItem("p3");
    	panel.add(cb_product);
    	
    	JLabel lb_t = new JLabel("���");
    	panel.add(lb_t);
    	JComboBox<String> cb_type = new JComboBox<String>();
    	cb_type.addItem("t1");
    	cb_type.addItem("t2");
    	cb_type.addItem("t3");
    	panel.add(cb_type);
    	
    	JLabel lb_begin = new JLabel("��ʼ���ڣ�");
    	JTextField tf_begin = new JTextField(20);
    	JLabel lb_end = new JLabel("�������ڣ�");
    	JTextField tf_end = new JTextField(20);
    	panel.add(lb_begin);
    	panel.add(tf_begin);
    	panel.add(lb_end);
    	panel.add(tf_end);
    	
    	JButton bt_find = new JButton("����");
    	JButton bt_refresh = new JButton("ˢ��");
    	JButton bt_state = new JButton("����");
    	panel.add(bt_find);
    	panel.add(bt_refresh);
    	panel.add(bt_state);
    	
    	JButton bt_add = new JButton("����");
    	bt_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = BaseFrame.getInstance();
				f.remove(panel);
				f.repaint();
				f.add(new AddBuy().addBuyView());
				f.setVisible(true);
			}
		});
    	JButton bt_operate = new JButton("����");
    	JButton bt_price = new JButton("����");
    	panel.add(bt_add);
    	panel.add(bt_operate);
    	panel.add(bt_price);
    	
    	JScrollPane scrollPanel = new JScrollPane();
    	String[] columnNames = {"���", "����", "������λ", "��Ʒ", "���", "���䳵��", "����"};
    	List<ModelBuy> list = new BuyDatabase().getBuy();
    	int dataSize = list.size();
    	Object[][] rowData = new Object[dataSize][columnNames.length];
    	for (int i = 0; i < dataSize; i++) {
   			rowData[i][0] = list.get(i).getNumber();
   			rowData[i][1] = list.get(i).getDate();
   			rowData[i][2] = list.get(i).getCompany();
   			rowData[i][3] = list.get(i).getProduct();
   			rowData[i][4] = list.get(i).getType();
   			rowData[i][5] = list.get(i).getCar();
   			rowData[i][6] = list.get(i).getWeight();
    	}
    	JTable table = new JTable(rowData, columnNames);
    	scrollPanel.setViewportView(table);
    	panel.add(scrollPanel);
    	
        return panel;
        
    }
}
