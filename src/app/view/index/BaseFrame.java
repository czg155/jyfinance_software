package app.view.index;

import javax.swing.JFrame;

public class BaseFrame extends JFrame{
	private static final long serialVersionUID = 4631973786477755945L;
	private static BaseFrame frame = null;
 	public static BaseFrame getInstance(){
 		if(frame==null)
 			frame = new BaseFrame();
 		return frame;
 	}
 	private BaseFrame(){
 		setTitle("欢迎使用河北旌原建设工程有限公司财务软件");
 		setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}
}
