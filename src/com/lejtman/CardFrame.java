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
        this.setVisible(true);
        this.setSize(500,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardPanel = new CardPanel();
        this.add(cardPanel);
        this.pack();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                cardPanel.repaint();
            }
});
    }
    
    class CardPanel extends JPanel{
        
        Deck cards;
        
        public CardPanel(){
            cards = Deck.getFullDeck();
        }
        
        @Override
        public void paint(Graphics g){
            super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Courrier", Font.BOLD + Font.ITALIC, 90);
        g2.setFont(font);

        g2.drawString("\u2660", 100, 100);
       
        AffineTransform at = AffineTransform.getTranslateInstance(100, 300);
        AffineTransform rt = AffineTransform.getRotateInstance(Math.toRadians(180));
        //at.concatenate(rt);
        g2.transform(at);
        g2.transform(rt);

        g2.drawLine(0, 0, 500, 0);
        g2.drawLine(0, 0, 0, 500);
        g2.drawString("\u2660", -200, 0);
        }
    }
}
