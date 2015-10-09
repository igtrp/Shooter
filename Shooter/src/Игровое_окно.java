import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;

public class Игровое_окно extends JFrame{

public Игровое_окно(){

int MainScale = 80;
Dimension Beg_Size_Main_Win = new Dimension( 1200 ,800) ;
int MainTitleHeight = 30;


setTitle("Штурм!(версия 1.0)");

Игровая_панель panel = new Игровая_панель(MainScale, new Dimension( Beg_Size_Main_Win.width  * MainScale /100  , Beg_Size_Main_Win.height * MainScale /100 + - MainTitleHeight  ));

add(panel);

addKeyListener(panel);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setPreferredSize(new Dimension( Beg_Size_Main_Win.width  * MainScale /100 +18 , Beg_Size_Main_Win.height * MainScale /100 + 8));

pack();

setLocationRelativeTo(null);

setVisible(true);

}

}
