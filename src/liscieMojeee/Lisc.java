package liscieMojeee;

import java.awt.*;
import java.util.Random;

public class Lisc {
	protected int x;
	protected int y;
	private Color kolor;
	private int szer = 0;
	private int wys = 15;
	Random randCoordinate = new Random();
	private int dx;
	private int dy;
	
	public Lisc (Dimension d){
		Random rnd = new Random();
		kolor = new Color (rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
		x = rnd.nextInt(d.width-szer);
		y = rnd.nextInt(d.height-wys);
	}
	
	public void Rysuj (Graphics g){
		int xpoints[] = {x,x-10,x-5,x-5,x,x+1,x,x+5,x+8,x+10};
		int ypoints[] = {y,y+10,y+15,y+15,y-15,y+10,y+15,y+15,y+10,y+10};
		int npoints = 10;
		g.setColor(kolor);
		g.fillPolygon(xpoints, ypoints, npoints);
	}
	

	
//	public void Rysuj (Graphics g){
//		g.setColor(kolor);
//		g.fillRoundRect(x, y, szer, wys, 8, 8);
//		g.fillRect(x+szer/2, y-wys/3, 2, 15);
//	}
	
	public void falling (Dimension d){
		if (y < d.height - wys)		y += 1;
	}
	
	public void swayingLeft (Dimension d){
		if (y < d.height - wys) x -= randCoordinate.nextInt(8);
	}
	
	public void swayingRight (Dimension d){
        if (y < d.height - wys) x += randCoordinate.nextInt(8);
	}
	
	public void jumping (Dimension d){
		if (y == d.height - wys) {
			y = randCoordinate.nextInt(d.height - wys); 
			x = randCoordinate.nextInt(d.height - szer); 
		}
	}


}
