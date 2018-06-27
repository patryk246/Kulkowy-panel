import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.w3c.dom.events.MouseEvent;


public class KulkowyPanel extends JPanel{

    private ArrayList<Kulki> KulkowaLista;
    private Timer timer;
    private final int DELAY=30;//opoznienie o 30 ms

    public KulkowyPanel()
    {
        KulkowaLista= new ArrayList<>();

        addMouseListener(new KulkiListener());
        timer=new Timer(DELAY, new KulkiListener());
        setBackground(Color.black);
        timer.restart();

    }

    public void paintComponent(Graphics graf)
    {
        super.paintComponent(graf);
        graf.setColor(Color.pink);

        for(Kulki kule:KulkowaLista)
        {
            graf.fillOval(kule.x - kule.size/2, kule.y - kule.size/2, kule.size, kule.size);
        }
        graf.setColor(Color.white);
    }

    private class KulkiListener implements MouseListener, ActionListener//alt+enter
    {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent me) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent me) {
            KulkowaLista.add(new Kulki(me.getX(),me.getY(), 30));
            repaint();
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent me) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent me) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent me) {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            for(Kulki kula:KulkowaLista){
                kula.update();
            }
            repaint();
        }




    }

    private class Kulki
    {
        public int x;
        public int y;
        public int size;
        public int xspeed;
        public int yspeed;
        private final int MAX_SPEED=5;

        public Kulki(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            xspeed=(int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
            yspeed=(int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
            while(xspeed==0){
                xspeed=(int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
            }
            while(yspeed==0){
                yspeed=(int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
            }

        }
        public void update(){
            x+=xspeed;
            y+=yspeed;
            if(x<size/2 || x>getWidth()-size/2){
                xspeed*=(-1);
            }
            if(y<size/2 || y>getHeight()-size/2){
                yspeed*=(-1);
            }
        }
    }

}

