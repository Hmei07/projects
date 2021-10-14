import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener{
	
	JPanel northPanel, centerPanel;
	JLabel welcomeLbl;
	JButton openFileBtn;
	BufferedImage img;
	JLabel picLabel;

	public Home() {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("detailed-wireframe-modern-techno-landscape-design-vector_20.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picLabel = new JLabel(new ImageIcon(img));
		init();
		
		
		this.setTitle("Image Color Editor");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		northPanel = new JPanel();
		centerPanel = new JPanel();
		welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setForeground(Color.red);
		welcomeLbl.setFont(new Font("TimesRoman", Font.BOLD, 25));
		openFileBtn = new JButton("Open File");
		openFileBtn.addActionListener(this);
		
//		northPanel.add(welcomeLbl);
//		centerPanel.add(openFileBtn);
//		this.add(northPanel, BorderLayout.NORTH);
//		this.add(centerPanel, BorderLayout.CENTER);
		northPanel.add(openFileBtn);
		centerPanel.add(picLabel);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == openFileBtn) {
			ImageFilter imageFilter = new ImageFilter();
			this.dispose();
		}
	}

}
