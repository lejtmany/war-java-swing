//yosef shalom lejtman
package com.lejtman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardFrame extends JFrame {

    CardPanel cardPanel;

    public CardFrame(int width, int height) {
       // this.setPreferredSize(new Dimension(50, 50));      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardPanel = new CardPanel(width, height);
        cardPanel.setPreferredSize(new Dimension(width, height));
        //this.setLayout(new BorderLayout());
        this.add(cardPanel);
        pack();
        this.setVisible(true);
    }

    class CardPanel extends JPanel {

        List<Card> cards;
        Card current;
        int width, height;
        int counter = 0;

        public CardPanel(int width, int height) {
            cards = Deck.getFullDeck().asList();
            current = cards.get(counter++);
            Collections.shuffle(cards);
            this.width = width;
            this.height = height;
            this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                current = cards.get((counter++ % cards.size()) - 1);
                cardPanel.repaint();
            }
        });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2 = (Graphics2D) g;
            Font font = new Font("Courrier", Font.BOLD, 90);
            g2.setFont(font);
            FontMetrics fontMetrics = g2.getFontMetrics();
            
            setCardColor(g2);
            
            int suitWidth = (int) g2.getFontMetrics().getStringBounds(current.getSuit().getCardString(), g2).getWidth();
            int suitHeight = (int) g2.getFontMetrics().getStringBounds(current.getSuit().getCardString(), g2).getHeight();
            
            g2.drawString(current.getSuit().getCardString() , (width / 2) - (suitWidth / 2), (height / 2) + (suitHeight / 4));
            g2.drawString(current.getRank().getCardString(), 0, 70);

            AffineTransform at = AffineTransform.getTranslateInstance(width, height);
            AffineTransform rt = AffineTransform.getRotateInstance(Math.toRadians(180));
            
            g2.transform(at);
            g2.transform(rt);
            
            g2.drawString(current.getRank().getCardString(), 0, 70);
        }

        private void setCardColor(Graphics2D g2) {
            if(current.getSuit() == Suit.Diamonds || current.getSuit() == Suit.Hearts)
                g2.setColor(Color.RED);
            else
                g2.setColor(Color.BLACK);
        }
    }
}
