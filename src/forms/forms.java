package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class forms extends JFrame{
	
	int x,y,onX,onY;
	JLabel Title = new JLabel("New Form");
	
	JPanel ContentPane = new JPanel(new BorderLayout());
	
	public forms(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		
		
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, 300, 600, 10, 10));
		setSize(300, 600);
		setLocation((width-600)/2, (height-900)/2);
		
		JPanel fullPane = new JPanel();
		fullPane.setLayout(new BorderLayout());
		fullPane.setBackground(Color.WHITE);

		JPanel ControlPane = new JPanel();
		ControlPane.setPreferredSize(new Dimension(300, 60));
		ControlPane.setLayout(new BorderLayout());
		
		JPanel windowControl = new JPanel();
		windowControl.setPreferredSize(new Dimension(300, 20));
		windowControl.setLayout(new BorderLayout());
		
		BufferedImage closeImg = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		Graphics g = closeImg.createGraphics();
		Color closeColor = new Color(234,99, 90);
		g.setColor(closeColor);
		g.fillRoundRect(0, 0, 10, 10, 20, 20);
		
		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon(closeImg));
		closeBtn.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		windowControl.add(closeBtn, BorderLayout.WEST);
		
		JPanel TitlePane = new JPanel();
		TitlePane.setPreferredSize(new Dimension(300, 40));
		TitlePane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		TitlePane.add(Title);
		
		ControlPane.add(windowControl, BorderLayout.LINE_START);
		ControlPane.add(TitlePane,BorderLayout.PAGE_END);
		
		ContentPane.setPreferredSize(new Dimension(300,540));
		ContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		fullPane.add(ControlPane,BorderLayout.NORTH);
		fullPane.add(ContentPane,BorderLayout.SOUTH);
		add(fullPane);
		
		closeBtn.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent evt){
				System.exit(ABORT);
			}
		});
		
		ControlPane.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt){
				x = evt.getX();
				y = evt.getY();
				
			}
		});
	
		ControlPane.addMouseMotionListener(new MouseMotionAdapter() {			
			public void mouseDragged(java.awt.event.MouseEvent evt){
				onY = evt.getYOnScreen();
				onX = evt.getXOnScreen();
				
				setLocation(onX - x, onY - y);
			}
		});
		
	}
	
	public void setFormName(String name)
	{
		Title.setText(name);
	}

	public void addFormComponent(JPanel panel)
	{
		ContentPane.add(panel, BorderLayout.CENTER);
	}
}
