import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageDisplay extends Canvas{
	
	File f;
	BufferedImage img;
	GraphDisplay gd1;
	GraphDisplay gd2;
	GraphDisplay gd3;
	int mode = 0;

	public ImageDisplay(GraphDisplay gda, GraphDisplay gdb, GraphDisplay gdc) {
		// TODO Auto-generated constructor stub
		gd1=gda;
		gd2=gdb;
		gd3=gdc;
	}
	
	public void setMode(int m) {
		mode = m;
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(50, 50);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(1000, 1000);
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(200, 200);
	}
	
	public BufferedImage render() {
		BufferedImage img2=new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g=img2.getGraphics();
		
		for(int x=0; x<img2.getWidth(); x++){
			for(int y=0; y<img2.getHeight(); y++){
				Color tc=new Color(img.getRGB(x, y));
				float tr=gd1.evaluate((float)tc.getRed()/255f);
				float tg=gd2.evaluate((float)tc.getGreen()/255f);
				float tb=gd3.evaluate((float)tc.getBlue()/255f);
				float[] vals=Color.RGBtoHSB(tc.getRed(), tc.getGreen(), tc.getBlue(), null);
				boolean rgb=(mode==0);
				Color newc;
				if(rgb==true){
					newc=new Color((int)(tr*255f), (int)(tg*255f), (int)(tb*255f));
				}else{
					newc=new Color(Color.HSBtoRGB(gd1.evaluate(vals[0]), gd2.evaluate(vals[1]), gd3.evaluate(vals[2])));
				}
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
		return img2;
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		for(int y=0; y<getHeight(); y++){
			for(int x=0; x<getWidth(); x++){
				Color tc=new Color(img.getRGB(x*img.getWidth()/getWidth(), y*img.getHeight()/getHeight()));
				float tr=gd1.evaluate((float)tc.getRed()/255f);
				float tg=gd2.evaluate((float)tc.getGreen()/255f);
				float tb=gd3.evaluate((float)tc.getBlue()/255f);
				float[] vals=Color.RGBtoHSB(tc.getRed(), tc.getGreen(), tc.getBlue(), null);
				boolean rgb=(mode==0);
				Color newc;
				if(rgb==true){
					newc=new Color((int)(tr*255f), (int)(tg*255f), (int)(tb*255f));
				}else{
					newc=new Color(Color.HSBtoRGB(gd1.evaluate(vals[0]), gd2.evaluate(vals[1]), gd3.evaluate(vals[2])));
				}
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
	}
	
	public void open(File file){
		f=file;
		try{
			img=ImageIO.read(f);
		}catch(Exception ex){}
		repaint(0, 0, getWidth(), getHeight());
	}
	
}
