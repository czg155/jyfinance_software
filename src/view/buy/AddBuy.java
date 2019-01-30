package view.buy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.BuyDatabase;
import model.buy.ModelBuy;
import view.index.BaseFrame;

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
		
		JScrollPane panelInputView = new JScrollPane();
		
		String[] columnNames = {"编号", "日期", "供货单位", "产品名称", "规格", "运输车号", "净重", "备注"};
		Object[][] rowData = new Object[5][columnNames.length];
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < columnNames.length; j++) {
				rowData[i][j] = null;
			}
		}
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
		JTable tb_input = new JTable();
		tb_input.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		tb_input.setModel(model);
		
		panelInputView.setViewportView(tb_input);
		panel.add(panelInputView, "Center");
		
		JPanel panelbtn = new JPanel();
		JButton bt_addRow = new JButton("添加行");
		bt_addRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] o = new Object[columnNames.length];
				for (int i = 0; i < 5; i++) {
					model.addRow(o.clone());
				}
			}
		});
		panelbtn.add(bt_addRow);
		
		JButton bt_submit = new JButton("提交");
		bt_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<ModelBuy> list = new ArrayList<ModelBuy>();
				System.out.println(model.getRowCount());
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				for (int i = 0; i < model.getRowCount(); i++) {
					int check = 0;
					ModelBuy buy = new ModelBuy();
					
					Object tempNumber =  model.getValueAt(i, 0);
					if (tempNumber == null) {
						check += 1;
					} else {
						buy.setNumber((String) tempNumber);
					}
					
					try {
						Object tempDate = model.getValueAt(i, 1);
						if (tempDate == null) {
							check += 1;
						} else {
							buy.setDate(format.parse((String) tempDate));
						}
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
					
					Object tempCompany = model.getValueAt(i, 2);
					if (tempCompany == null) {
						check += 1;
					} else {
						buy.setCompany((String) tempCompany);
					}
					
					Object tempProduct = model.getValueAt(i, 3);
					if (tempProduct == null) {
						check += 1;
					} else {
						buy.setProduct((String) tempProduct);
					}
					
					Object tempType = model.getValueAt(i, 4);
					if (tempType == null) {
						check += 1;
					} else {
						buy.setType((String) tempType);
					}
					
					Object tempCar = model.getValueAt(i, 5);
					if (tempCar == null) {
						check += 1;
					} else {
						buy.setCar((String) tempCar);
					}
					
					Object tempWeight = model.getValueAt(i, 6);
					if (tempCar == null) {
						check += 1;
					} else {
						buy.setWeight(Double.parseDouble((String) tempWeight));
					}
					
					Object tempTip = model.getValueAt(i, 7);
					if (tempTip == null) {
						check += 1;
					} else {
						buy.setTip((String) tempTip);
					}
					
					if (check < columnNames.length) {
						list.add(buy);
					}
					
					if (check < model.getColumnCount()) {
						for (int j = 0; j < model.getColumnCount(); j++) {
							System.out.print(model.getValueAt(i, j));
							System.out.print("      ");
						}
						System.out.println();
						new BuyDatabase().addBuy(list);
					}
				}
			}
		});
		panelbtn.add(bt_submit);
		
		panel.add(panelbtn, "South");
		
		return panel;
	}
	
	public static void main(String[] args) {
		JFrame f = BaseFrame.getInstance();
		f.add(new AddBuy().addBuyView());
		f.setVisible(true);
	}
}
