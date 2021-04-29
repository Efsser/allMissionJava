package All.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class RainGame extends JFrame{
    private static RainGame game_win;
    private static long last_time;
    private static Image BG, GO, drop;
    private static float x = 200, y = -100, speed = 200;
    private static int score = 0;


    public static void main (String[] args) throws IOException {
        BG = ImageIO.read(RainGame.class.getResourceAsStream("/BG.png"));
        GO = ImageIO.read(RainGame.class.getResourceAsStream("/GameOver.png"));
        drop = ImageIO.read(RainGame.class.getResourceAsStream("/Eye.png"));

        last_time = System.nanoTime();
        game_win = new RainGame();
        game_win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_win.setLocation(0,0);
        game_win.setSize(1000,1000);
        game_win.setResizable(false);
        final Field gameF = new Field();
        gameF.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();
                float dr = x + drop.getWidth(null), db = y + drop.getHeight(null);
                boolean isd = mx >= x && mx <= dr && my >= y && my <= db;
                if(isd){
                    y = -100;
                    x = (int)(Math.random() * (gameF.getWidth() - drop.getWidth(null)));
                    speed += 10;
                    score++;
                    game_win.setTitle("Убийств ктулху: "+score);
                }
            }
        });

        game_win.add(gameF);
        game_win.setVisible(true);
    }
    private static void can (Graphics c){
        long cur_time = System.nanoTime();
        float delay_time = (cur_time - last_time) * 0.000000001f;
        last_time = cur_time;

        y = y + speed * delay_time;
        //x = x + speed * delay_time;

        c.drawImage(BG,0,0,game_win.getWidth(),1000,null);
        c.drawImage(drop,(int)x,(int)y,100,120,null);
        //c.fillOval(50,50,100,80);
        //c.drawLine(80,60,200,200 );

        if(y > game_win.getHeight()) c.drawImage(GO,0,-500,game_win.getWidth(),2000,null);
    }
    private static class Field extends JPanel{
        @Override
        protected void paintComponent (Graphics c){
            super.paintComponent(c);
            can(c);
            repaint();
        }
    }
}
