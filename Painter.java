import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Painter extends Applet{
	public int colorMode;
	public int shapeMode;
	public int solidMode = 2;
	public boolean shapeLock = true;
	public boolean colorLock = true;
	public boolean freeDraw= false;
	public int eraserMode = 0;	
	public int xs;
	public int xe;
	public int ys;
	public int ye;
	Button pencil = new Button("Pencil");
	Button eraser = new Button("Eraser");
	Button red = new Button("Red");
	Button black = new Button("Black");
	Button green = new Button("Green");
	Button blue = new Button("Blue");
	Button rectangle = new Button("Rectangle");
	Button oval = new Button("Oval");
	Button line = new Button("Line");
	Button undo = new Button("Undo");
	Button clear = new Button("ClearAll");
	Checkbox solid = new Checkbox("Solid"); 
	ArrayList<Shape> sarr = new ArrayList<Shape>();
	
	public void init(){
		add(solid);
		add(pencil);
		add(eraser);
		add(black);
		add(red);
		add(green);
		add(blue);
		add(rectangle);
		add(oval);
		add(line);
		add(undo);
		add(clear);
		
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				switch(shapeMode){
				case 1:
					xs = xe = e.getX();
				    ys = ye = e.getY();
					sarr.add(new Line(e.getX(), e.getY(), e.getX(), e.getY(), colorMode, shapeMode));
				break;
				case 2:
					sarr.add(new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), colorMode, shapeMode, solidMode));
				break;
				case 3:
					sarr.add(new Oval(e.getX(), e.getY(), e.getX(), e.getY(), colorMode, shapeMode, solidMode));
				break;
				}
			Painter.this.repaint();
			} 
		});
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(colorLock == false && shapeLock == false){
					sarr.get(sarr.size()-1).setX2(e.getX());
					sarr.get(sarr.size()-1).setY2(e.getY());
					Painter.this.repaint();
				}
			} 
		});
		
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(colorLock == false && shapeLock == false){
					if(freeDraw == true){
						switch(eraserMode){
						case 1:
							sarr.add(new Rectangle(e.getX(), e.getY(), e.getX()+20, e.getY()+20, 5 , 2, 1));
							repaint();
						break;
						case 0:
						    xe = e.getX();
							ye = e.getY();
							sarr.add(new Line(xs, ys, xe, ye, colorMode, 1));
							xs = xe;
							ys = ye;
							repaint();
						break;
						}
					}
					else{
						sarr.get(sarr.size()-1).setX2(e.getX());
						sarr.get(sarr.size()-1).setY2(e.getY());
						Painter.this.repaint();
					}
				}
			} 
		});
		
		pencil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				freeDraw = true;
				shapeLock = false;
				eraserMode =0;
				shapeMode = 1;
			}
		});
		
		eraser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				freeDraw = true;
				eraserMode = 1;	
				shapeMode = 1;
			}
		});
		
		black.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorMode = 1;
				colorLock = false;
			}
		});
		
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorMode = 2;
				colorLock = false;
			}
		});
		
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorMode = 3;
				colorLock = false;
			}
		});
		
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorMode = 4;
				colorLock = false;
			}
		});
				
		line.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeMode = 1;
				shapeLock = false;
				freeDraw = false;
			}
		});
		
		rectangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeMode = 2;
				shapeLock = false;
				freeDraw = false;
			}
		});
		
		oval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeMode = 3;
				shapeLock = false;
				freeDraw = false;	
			}
		});
		
		solid.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				solidMode = e.getStateChange();
			}
		});
		
		clear.addActionListener(new ActionListener(){
			int init;
			public void actionPerformed(ActionEvent e){
				if(sarr.size() != 0){
					for(int i=0 ; i < sarr.size() ; i++)
						sarr.get(i).setLifeMode(-1);
				repaint();
				}
			}
		});
		
		
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){		
				if(sarr.size() != 0){
					if(sarr.get(sarr.size()-1).getLifeMode() == -1){
						for(int i = 0; i < sarr.size(); i++){
							sarr.get(i).setLifeMode(1);
						}
						repaint();
					}
					else{
						sarr.remove(sarr.size()-1);
						repaint();
					}		
				}
			}
		});
	}
	
	public void paint(Graphics g){	
		if(shapeLock == false && colorLock == false){
			for(int i=0 ; i <sarr.size() ; i++){	
				if(sarr.get(i).getLifeMode() == 1){
					switch(sarr.get(i).getColor()){
						case 1:
							g.setColor (Color.BLACK);
						break;
						case 2:
							g.setColor(Color.RED);
						break;
						case 3:
							g.setColor(Color.GREEN);
						break;
						case 4:
							g.setColor(Color.BLUE);
						break;
						case 5:
							g.setColor(Color.WHITE);
						break;
					}
					
					switch(sarr.get(i).getShape()){
						case 1:
							g.drawLine(sarr.get(i).getX1(),sarr.get(i).getY1(), sarr.get(i).getX2(), sarr.get(i).getY2());
						break;
						case 2:
							if(sarr.get(i).getMode()== 2)
								g.drawRect(sarr.get(i).getX1(), sarr.get(i).getY1(), sarr.get(i).getX2(), sarr.get(i).getY2());
							else
								g.fillRect(sarr.get(i).getX1(), sarr.get(i).getY1(), sarr.get(i).getX2(), sarr.get(i).getY2());
						break;
						case 3:
							if(sarr.get(i).getMode()==2)
								g.drawOval(sarr.get(i).getX1(), sarr.get(i).getY1(), sarr.get(i).getX2(), sarr.get(i).getY2());
							else
								g.fillOval(sarr.get(i).getX1(), sarr.get(i).getY1(), sarr.get(i).getX2(), sarr.get(i).getY2());
						break;
					}
				}
			}
		}
	}
}