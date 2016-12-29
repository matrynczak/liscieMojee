package liscieMojeee;

import java.awt.*;
import java.util.Random;

public class Koszyk {
	protected int x;
    protected int y;
	protected int szer = 80;
	protected int wys = 25;
	Random randCoordinate = new Random();

	
	public Koszyk (Dimension d){
		Random rnd = new Random();
		x = rnd.nextInt(d.width-szer);
		y = d.height-wys;

	}
	
	public void RysujKoszyk (Graphics g){
		g.fillRect(x, y, szer, wys);
	}
	
//	public void koszMovingRight (Dimension d){
//			x += 2;
//	}
//
//	public void koszMovingLeft (Dimension d){
//			x -= 1;
//	}
//
	public void koszMoving (Dimension d){
		if (x + szer != d.width)  	x += 1;
		if (x + szer == d.width) x = 0; //randCoordinate.nextInt(d.width - szer);
			}
}
