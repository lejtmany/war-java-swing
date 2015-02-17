//yosef shalom lejtman
package com.lejtman;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardFrame extends JFrame{
    
    CardPanel cardPanel;
    
    
    public CardFrame(){
        this.setSize(325, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardPanel = new CardPanel(500, 600);
        cardPanel.setSize(325, 500);
        this.add(cardPanel);
     //   this.pack();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                cardPanel.repaint();
            }
});
    }
    
    class CardPanel extends JPanel{
        
        Deck cards;
        int width, height;
        
        public CardPanel(int width, int height){
            cards = Deck.getFullDeck();
            this.width = width;
            this.height = height;
            this.setSize(width, height);
        }
        
        @Override
        public void paint(Graphics g){
            super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Courrier", Font.BOLD , 90);
        g2.setFont(font);

        g2.drawString("\u2660", width/2, height/2);
        g2.drawString("" + 7 , 0, 70);
        g2.drawString("" + 9 , width, height);

       
        AffineTransform at = AffineTransform.getTranslateInstance(width, height);
        AffineTransform rt = AffineTransform.getRotateInstance(Math.toRadians(180));
        //at.concatenate(rt);
        g2.transform(at);
        g2.drawString("" + 7, 0, 0);
        g2.transform(rt);

        //g2.drawLine(0, 0, 500, 0);
        //g2.drawLine(0, 0, 0, 500);
        g2.drawString("" + 7,0, 70);
        }
    }
}
