import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFilter extends Frame implements WindowListener, ActionListener{
	Choice mode = new Choice();
	
	Button appb = new Button("Apply");
	Button saveb = new Button("Save");
	Button changeb = new Button("Change Image");
	
	FileDialog fd = new FileDialog(this, "choose and image file", FileDialog.LOAD);
	FileDialog fd2 = new FileDialog(this, "Save the image", FileDialog.SAVE);
	
	GraphDisplay gd1;
	GraphDisplay gd2;
	GraphDisplay gd3;
	
	ImageDisplay id;
	
	public ImageFilter() {
		// TODO Auto-generated constructor stub
		gd1=new GraphDisplay();
		gd2=new GraphDisplay();
		gd3=new GraphDisplay();
		id=new ImageDisplay(gd1, gd2, gd3);
		
		setLayout(new BorderLayout());
		
		add(id, BorderLayout.CENTER);
		
		Panel leftp=new Panel(new GridLayout(3, 1));
		leftp.add(gd1);
		leftp.add(gd2);
		leftp.add(gd3);
		
		Panel leftside=new Panel(new BorderLayout());
		leftside.add(leftp, BorderLayout.CENTER);
		
		Panel bottomp=new Panel(new GridLayout(1, 2));
		bottomp.add(appb);
		bottomp.add(saveb);
		bottomp.add(changeb);
		
		saveb.addActionListener(this);
		appb.addActionListener(this);
		changeb.addActionListener(this);
		
		mode.add("RGB");
		mode.add("HSB");
		
		leftside.add(mode, BorderLayout.NORTH);
		leftside.add(bottomp, BorderLayout.SOUTH);
		add(leftside, BorderLayout.EAST);
		
		fd.setVisible(true);
		
		File f=new File(fd.getDirectory()+fd.getFile());
		
		if(f.exists()){
			id.open(f);
		}
		
		int width = 0;
		int height = 0;
		
		try {
			BufferedImage bimg = ImageIO.read(f);
			width = bimg.getWidth();
			height = bimg.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int hcheck, wcheck;
//		hcheck = wcheck = 0;
//		while (height > 1000 || width > 1000) {
//			width = width/2;
//			height = height/2;
//		}
		
		setTitle("Image Color Editor");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==appb){
			id.setMode(mode.getSelectedIndex());
			id.repaint();
		}
		else if(e.getSource()==saveb){
			id.setMode(mode.getSelectedIndex());
			try{
				fd2.setVisible(true);
				BufferedImage product=id.render();
				String fname=fd2.getFile();
				String ext="jpg";
				
				if(fname.contains(".")){
					ext=fname.substring(fname.indexOf(".")+1, fname.length());
				}
				else{
					fname+=".jpg";
				}
				ImageIO.write(product, ext, new File(fd2.getDirectory()+fname));
			}catch(Exception ex){
				Toolkit.getDefaultToolkit().beep();
			}
		}
		else if(e.getSource() == changeb) {
			ImageFilter imageFilter = new ImageFilter();
			this.dispose();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		((Frame)e.getSource()).dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
