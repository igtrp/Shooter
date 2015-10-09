
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Персонаж {

float x, y;	
float height, width;
int Scale;

Image im;

//float Vx, Vy;


public Персонаж(String skin, float g, float h, int Scale) {
	
	this.Scale = Scale;
			
//File f = new File("C:\\Users\\Юзвери\\Desktop\\Проекты\\Shooter\\resы\\" + skin);
File f = new File("src\\Res\\" + skin);

try {
			
im = ImageIO.read(f);
			
}

catch (IOException e) {
			
JOptionPane.showMessageDialog(null, "Файл не найден!");
			
e.printStackTrace();

}

height = im.getHeight(null)  * Scale / 100 ;
width = im.getWidth(null)  * Scale / 100 ;

x = g;

y = h;

}

public void paint (Graphics g) {
	
int p_x = (int) x * Scale / 100;
int p_y = (int) y * Scale / 100;
int p_w = (int) width  * Scale / 100;
int p_h = (int)  height  * Scale / 100;

g.setColor(new Color(0, 0, 0));

g.drawImage(im, p_x, p_y, p_w, p_h , null, null );

g.drawRect( p_x, p_y, p_w, p_h);

g.setColor(new Color(220, 120, 100));
g.drawRoundRect(p_x, p_y, p_w, p_w, p_w, p_w);

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
}