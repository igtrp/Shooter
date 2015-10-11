
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Target {

float x, y;	
float height, width;
int Scale;

public Target( float x, float y, int Scale ) {
	
	this.Scale = Scale;

	this.x = x;

	this.y = y;

	height = 50;
	
	width = 50;
	
}

public void paint (Graphics g) {
	
int p_x = (int) x; //* Scale / 100;
int p_y = (int) y; //* Scale / 100; 
int p_w = (int) width; // * Scale / 100;
int p_h = (int)  height; // * Scale / 100;

g.setColor(new Color(0, 250, 0));
//g.drawRoundRect(p_x, p_y, p_w, p_h, p_w , p_h);

g.drawRoundRect(p_x+5, p_y+5, p_w-10, p_h-10, p_w-10, p_h-10);

g.drawRoundRect(p_x+10, p_y+10, p_w-20, p_h-20, p_w-20, p_h-20);

g.drawRoundRect(p_x+15, p_y+15, p_w-30, p_h-30, p_w-30, p_h-30);

g.drawRoundRect(p_x+20, p_y+20, p_w-40, p_h-40, p_w-40, p_h-40);

int p_x1 = (int) ((int) p_x+p_w/2);
int p_y1 = (int) ((int) p_y+p_h);
g.drawLine(p_x1, p_y, p_x1, p_y1);

int p_x2 = (int) ((int) p_x+p_w);
int p_y2 = (int) ((int) p_y+p_h/2);
g.drawLine(p_x, p_y2, p_x2, p_y2);
}

public void offset (float f, float deltaY){
	
x = x + f;

y = y + deltaY;
	
}

public float getX() {
	return x;
}

public void setX(float x) {
	this.x = x;
}

public float getY() {
	return y;
}

public void setY(float y) {
	this.y = y;
}

public float getHeight() {
	return height;
}

public void setHeight(float height) {
	this.height = height;
}

public float getWidth() {
	return width;
}

public void setWidth(float width) {
	this.width = width;
}

//p - поля внутрь
	public boolean collision (Персонаж another, int p) {
		// объект выше
		if ( (y+p) >  (another.getY() + another.getHeight() - p)    ) {
			return false;
		}
		
		// объект ниже
		if ( (y + height - p) < (another.getY() + p) ) {
			return false;
		}
		
		// объект левее
		if ( (another.getX() + another.getWidth() - p) < (getX()+p)  ) {
			return false;
		}
		// объект правее
		if ( (x + width - p ) < (another.getX()+p) ) {
			return false;
		}
		
		// Столкновение
		return true;
		
		
		
		
	}

	public void setXY(int m_x, int m_y) {
		// TODO Auto-generated method stub
		x = m_x-width+15;
		y = m_y-height-5;
		
	} 
	
}
