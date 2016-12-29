package liscieMojeee;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SpadajacyLisc extends Applet implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;
    protected Lisc[] l;
    protected Koszyk kosz;
    private Integer score = 0;
    Random leafNumber = new Random();
    private int N = leafNumber.nextInt(25)+1;

    public void scoring (Dimension d, Koszyk kosz){
        for (Lisc l : l) {
            if ((l.y == d.height - kosz.wys) && ((l.x >= kosz.x) && (l.x <= kosz.x + kosz.szer)))
                score++;
        }
    }

    public void init (){
        setBackground(Color.white);
        setSize(600,600);
        Dimension d = getSize();
        l = new Lisc[N];
        for (int i=0; i<N; i++)		l[i] = new Lisc(d);
        kosz = new Koszyk(d);

        Thread w = new Thread (this);
        w.start();
        addKeyListener(this);
    }

    public void paint(Graphics g){
        for (Lisc l : l)     l.Rysuj(g);
        kosz.RysujKoszyk(g);
        g.drawString("LICZBA TRAFIEŃ: ", 240, 30);
        g.drawString(Integer.toString(score), 350, 30);
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Dimension d = getSize();
            for (Lisc l : l) {
                l.falling(d);
                l.swayingLeft(d);
                l.swayingRight(d);
                l.jumping(d);
            }
            scoring(d, kosz);
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kosz.x = kosz.x + 5;
            }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kosz.x = kosz.x - 5;
            }
        }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}