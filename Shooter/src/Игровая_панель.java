
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Игровая_панель extends JPanel implements KeyListener, ActionListener {
	
int MainScale;
Dimension Beg_Size_Main_Win;
	
Image background;

String number_gun = "1";

String name_main_gun;

String name_sight_gun;

String name_reload_gun;

String name_bullet_gun;

float curr_x,curr_y;

boolean choose_started;

boolean mybullet_started;

boolean sight_started;

boolean r_s;

Персонаж gun;

Персонаж bullet;

Персонаж bullet2;

Персонаж bullet3;

Персонаж terror;

Персонаж terror2;

Персонаж terror3;

Персонаж mybullet;

Персонаж sight;

Персонаж reload;

int points;

//Персонаж explosion;

//Персонаж derevo;

public Игровая_панель(int MainScale, Dimension Beg_Size_Main_Win){

this.MainScale = MainScale;
this.Beg_Size_Main_Win = Beg_Size_Main_Win;

// В соответствии с заданным главным масштабом пересчитаем размеры главного окна.
// Установим главному окну рассчитанные размеры.
//setSize( (int) Beg_Size_Main_Win.width * MainScale /100 ,  (int) Beg_Size_Main_Win.height * MainScale /100 );
//setPreferredSize(new Dimension ((int) Beg_Size_Main_Win.width * MainScale /100 ,  (int) Beg_Size_Main_Win.height * MainScale /100 ));

number_gun = JOptionPane.showInputDialog("Выберите оружие (1-5)");
	
//File im = new File("C:\\Users\\Юзвери\\Desktop\\Проекты\\Shooter\\resы\\field.png");
File im = new File("src\\Res\\field.png");

try {
		
background = ImageIO.read(im);

}

catch (IOException e) {
		
JOptionPane.showMessageDialog(null, "Файл не найден!");

e.printStackTrace();

}

if (number_gun.equals("1")){
name_main_gun = "ak47.png";
name_sight_gun = "ak47-s.png";
name_reload_gun = "ak47-r.png";
name_bullet_gun = "mybullet.png";
}

else if (number_gun.equals("2")){
name_main_gun = "ak-12.png";
name_sight_gun = "ak-12-s.png";
name_reload_gun = "ak-12-r.png";
name_bullet_gun = "mybullet.png";
}

else if (number_gun.equals("3")){
name_main_gun = "ft.png";
name_sight_gun = "ft.png";
name_reload_gun = "ft-r.png";
name_bullet_gun = "fre.png";
}

else if (number_gun.equals("4")){
name_main_gun = "pech.png";
name_sight_gun = "sp.png";
name_reload_gun = "pech-r.png";
name_bullet_gun = "mybullet.png";
}

else if (number_gun.equals("5")){
name_main_gun = "p.png";
name_sight_gun = "pispric.png";
name_reload_gun = "r.png";
name_bullet_gun = "mybullet.png";
}

else if (number_gun.equals("chit1961")){
name_main_gun = "rpg.png";
name_sight_gun = "rpg-p.png";
name_reload_gun = "rel.png";
name_bullet_gun = "shoot.png";
}
else {JOptionPane.showMessageDialog(null, "Жаль, но такого оружия нет!!!");
System.exit(0);
return;
}
curr_x = 400;
curr_y = 500;


bullet = new Персонаж("bullet.png", 1366, 250, MainScale);

bullet2 = new Персонаж("bullet.png", 1366, 55, MainScale);

bullet3 = new Персонаж("bullet.png", 1366, 500, MainScale);

terror = new Персонаж("terror.png", 1000, 550, MainScale);

terror2 = new Персонаж("terror.png", 1100, 400, MainScale);

terror3 = new Персонаж("terror.png", 200, 550, MainScale);

mybullet = new Персонаж(name_bullet_gun, 80, 120, MainScale);

sight = new Персонаж(name_sight_gun,80, 120, MainScale);

reload = new Персонаж(name_reload_gun, 80, 120, MainScale);

//explosion = new Персонаж("explosion-1.png", 1000, 1000);

gun = new Персонаж(name_main_gun, curr_x, curr_y, MainScale );

Timer t = new Timer(33, this);

t.start();

}

@Override

protected void paintComponent(Graphics g) {
	
super.paintComponent(g);

//g.drawLine(400, 500, 600, 700);

int currWidth = (int) Beg_Size_Main_Win.width  ;
int currHeight = (int) Beg_Size_Main_Win.height  ;

g.drawImage(background, 0, 0, currWidth, currHeight, null, null);
g.drawRect(0, 0, currWidth, currHeight );


//bullet.paint(g); 

//bullet2.paint(g);

//bullet3.paint(g);

terror.paint(g);

terror2.paint(g);

terror3.paint(g);

gun.paint(g);


//explosion.paint(g);
if(sight_started == true) 
{sight.paint(g);} 
  else
     {sight.setX(gun.getX());
          sight.setY(gun.getY());} 


if(mybullet_started == true) 
	     {mybullet.paint(g);} 
	else
	     {mybullet.setX(gun.getX()-1000);
	     mybullet.setY(gun.getY()-1000);
	     } 

if(r_s == true) 
{reload.paint(g);} 
  else
   {reload.setX(gun.getX());
   reload.setY(gun.getY());} 

g.setColor(Color.WHITE);

Font f = new Font("Arial", Font.BOLD, 32) ;

g.setFont(f);

g.drawString("Очки: " + points, 750, 50);

}

@Override

public void keyPressed(KeyEvent key) {

//System.out.println(key.getKeyCode());

if(key.getKeyCode()== 17 && sight_started == false){
	
sight_started = true;

curr_x = gun.getX();

curr_y = gun.getY();

gun = new Персонаж(name_sight_gun, curr_x, curr_y, MainScale);

}

if(key.getKeyCode()== 82 && r_s == false){

r_s = true;

gun = new Персонаж(name_reload_gun, curr_x, curr_y, MainScale);

}

if(key.getKeyCode()== 27){

choose_started = true;

number_gun = JOptionPane.showInputDialog("Выберите оружие (1-5)");
}

if(key.getKeyCode()== 38){

gun.offset(0, -15);	
	
}

if(key.getKeyCode()== 32){	

mybullet_started = true;

}

if(key.getKeyCode()== 37){

gun.offset(-15, 0);	
	
}

if(key.getKeyCode()== 39){

gun.offset(15, 0);	
	
}

if(key.getKeyCode()== 40){

gun.offset(0, 15);	

}

repaint();
	
}

@Override
public void keyReleased(KeyEvent key) {
	// TODO Auto-generated method stub

	if(key.getKeyCode()== 17 && sight_started == true){

	sight_started = false;
	
	curr_x = gun.getX();

	curr_y = gun.getY();
	
	gun = new Персонаж(name_main_gun, curr_x, curr_y, MainScale);
	}	
	if(key.getKeyCode()== 82 && r_s == true){

	r_s = false;
		
	mybullet_started = false;
	
	curr_x = gun.getX();

	curr_y = gun.getY();
	
	gun = new Персонаж(name_main_gun, curr_x, curr_y, MainScale);
	}
	if(key.getKeyCode()== 32){	

	mybullet_started = false;
	
	}
}

//}

//private float setY(Object getY) {
	// TODO Auto-generated method stub
	//return 0;
//}

//private float setX(float x) {
	// TODO Auto-generated method stub
	//return 0;
//}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent arg0) {	
	
bullet.offset(-21.5f, 0);

bullet2.offset(-22.5f, 0);

bullet3.offset(-23.5f, 0);

//if (gun.collision(bullet, 25)||gun.collision(bullet2, 25)||gun.collision(bullet3, 10)||gun.collision(terror, 20)) {
	//Самолет сталкивается с ракетой или врагом
	
	//explosion.setX(gun.getX());
	//explosion.setY(gun.getY()-200);
	//repaint();
	
	//JOptionPane.showMessageDialog(null, "Вы убиты!");
	
	//System.exit(0);
	
//}

//if (terror.collision(mybullet, 25)) {
	//Самолет сталкивается с ракетой или врагом
	
	//explosion.setX(terror.getX());
	// explosion.setY(terror.getY()-200);
	//repaint();
	//JOptionPane.showMessageDialog(null, "Враги уничтожены! Ваше вознаграждение "+ points + "000 $");
	//System.exit(0);
	
	
//}

//if (terror2.collision(mybullet, 25)) {
	//Самолет сталкивается с ракетой или врагом
	
	//explosion.setX(terror.getX());
	// explosion.setY(terror.getY()-200);
	//repaint();
	//JOptionPane.showMessageDialog(null, "Враги уничтожены! Ваше вознаграждение "+ points + "000 $");
	//System.exit(0);
	
	
//}

//if (terror3.collision(mybullet, 25)) {
	//Самолет сталкивается с ракетой или врагом
	
	//explosion.setX(terror.getX());
	// explosion.setY(terror.getY()-200);
	//repaint();
	//JOptionPane.showMessageDialog(null, "Враги уничтожены! Ваше вознаграждение "+ points + "000 $");
	//System.exit(0);
	
	
//}

if(mybullet_started == true) mybullet.offset(0, 0);

terror.offset(0, 0);

/*if (gun.getX()<-250)
	gun.setX(-250);

if (gun.getY()<350)
	gun.setY(350);	
	*/
if (bullet.getX()<-200){
bullet.setX(1200);
bullet.setY(gun.getY()+55);
}

if (bullet2.getX()<-200){
bullet2.setX(1200);
bullet2.setY((float)(Math.random()* 700));
}

if (bullet3.getX()<-200){
bullet3.setX(1200);
bullet3.setY((float)(Math.random()* 700));
}

if (terror.getX()<-500){
terror.setX(1200);
terror.setY((float)(Math.random()* 700));
}

if (mybullet.getY()>1366)
mybullet_started = false;

points ++;
repaint();

}

}
