import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class GraphDisplay extends Canvas implements MouseListener, MouseMotionListener, ComponentListener {
	
	BufferedImage screen;
	
	Color[] colors = {Color.red, Color.green, Color.blue};
	
	int[] px;
	int[] py;
	
	boolean down = false;
	

	public GraphDisplay() {
		// TODO Auto-generated constructor stub
		px = new int[2];
		py = new int[2];
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addComponentListener(this);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(50, 50);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(1000, 1000);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	public void refresh() {
		Graphics2D g = (Graphics2D)screen.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(100, 100, 100));
		
		for(int i=1 ; i<8 ; i++) {
			g.drawLine(getWidth()*i/8, 0, getWidth()*i/8, getHeight());
			g.drawLine(0, getHeight()*i/8, getWidth(), getHeight()*i/8);
		}
		
		for(int i=0 ; i<px.length-1 ; i++) {
			g.setColor(Color.white);
			g.drawLine(px[i], py[i], px[i+1], py[i+1]);
			g.fillOval(px[i]-3, py[i]-3, 6, 6);
		}
		
		g.fillOval(px[px.length-1]-3, py[py.length-1]-3, 6, 6);
		repaint(0, 0, getWidth(), getHeight());
		
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		g.drawImage(screen, 0, 0, this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		screen=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		px[0]=0;
		py[0]=getHeight();
		px[1]=getWidth();
		py[1]=0;
		refresh();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		click(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON1) {
			click(e);
			down = true;
		}
		else {
			px = new int[2];
			py = new int[2];
			px[0] = 0;
			py[0] = getHeight();
			px[1] = getWidth();
			py[1] = 0;
			refresh();
		}
	}
	
	public void click(MouseEvent e) {
		boolean found = false;
		
		for(int i=1; i<px.length-1; i++){
			if(e.getX()>px[i]-6&&e.getX()<px[i]+6){
				if(true){
					py[i]=e.getY();
					if(down){
					px[i]=e.getX();
					}
				}
				found=true;
			}
		}
		
		if(!found){
			int[] npx=new int[px.length+1];
			int[] npy=new int[px.length+1];
			int i=0;
			
			while(e.getX()>px[i]){
				npx[i]=px[i];
				npy[i]=py[i];
				i++;
			}
			
			npx[i]=e.getX();
			npy[i]=e.getY();
			i++;
			
			while(i<npx.length){
				npx[i]=px[i-1];
				npy[i]=py[i-1];
				i++;
			}
			
			px=npx;
			py=npy;
		}
		refresh();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		down = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public float evaluate(float f) {
		// TODO Auto-generated method stub
		f*=0.99f;
		f+=0.005f;
		int i=0;
		
		while((float)px[i]/(float)getWidth()<f){
			i++;
		}
		float outpt=(float)(getHeight()-py[i-1])/(float)getHeight()+((float)((getHeight()-py[i])-(getHeight()-py[i-1]))/(float)getHeight())/((float)((px[i])-(px[i-1]))/(float)getWidth())*(f-((float)px[i-1]/(float)getWidth()));
		return outpt;
	}

}
