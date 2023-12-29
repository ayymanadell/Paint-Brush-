
abstract class Shape{
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected int color;
	protected int mode;
	protected int shape;
	protected int lifeMode;
	
	
	public int getLifeMode(){
		return lifeMode;
	}

	public int getShape(){
		return shape;
	}
	
	public int getX1(){
		return x1;
	}
	public int getY1(){
		return y1;
	}
	public int getX2(){
		return x2;
	}
	public int getY2(){
		return y2;
	}
	public int getColor(){
		return color;
	}
	public int getMode(){
		return mode;
	}
	
	public void setX1(int x1){
		this.x1 = x1;
	}
	public void setX2(int x2){
		this.x2 = x2;
	}
	public void setY1(int y1){
		this.y1 = y1;
	}
	public void setY2(int y2){
		this.y2 = y2;
	}	
	public void setColor(int color){
		this.color = color;
	} 
	public void setMode(int mode){
		this.mode = mode;
	}
	public void setLifeMode(int lifeMode){
		this.lifeMode = lifeMode;
	}
	
}

class Rectangle extends Shape{
	
	public Rectangle(int x1,int y1, int x2, int y2, int color, int shape  ,int mode){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		this.mode = mode;
		this.shape = shape;
		this.lifeMode =1;
	}
	
	public int getX1(){
		if(x1 <= x2)
			return x1;
		else
			return x2;
	}
	public int getY1(){
		if(y1 <= y2)
			return y1;
		else	
			return y2;
	}
	public int getX2(){
		if(x1 <= x2)
			return x2 -x1;
		else
			return x1-x2;
		
	}
	public int getY2(){
		if(y1 <= y2)
			return y2-y1;
		else	
			return y1-y2;
	}
}

class Oval extends Shape{
	public Oval(int x1,int y1, int x2, int y2, int color,int shape, int mode){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		this.mode = mode;
		this.shape = shape;
		this.lifeMode = 1;
	}
	public int getX1(){
		if(x1 <= x2)
			return x1;
		else
			return x2;
	}
	public int getY1(){
		if(y1 <= y2)
			return y1;
		else	
			return y2;
	}
	public int getX2(){
		if(x1 <= x2)
			return x2 -x1;
		else
			return x1-x2;
		
	}
	public int getY2(){
		if(y1 <= y2)
			return y2-y1;
		else	
			return y1-y2;
	}
		
}

class Line extends Shape{
	public Line(int x1,int y1, int x2, int y2, int color, int shape){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		this.shape = shape;
		this.lifeMode =1;
	}
}




