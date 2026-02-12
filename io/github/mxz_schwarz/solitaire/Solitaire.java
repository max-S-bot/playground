package io.github.mxz_schwarz.solitaire;

import javax.swing.JFrame;
import java.awt.Graphics;

class Solitaire extends javax.swing.JPanel {

    static void main(String[] args) {
        JFrame frame = new JFrame("Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 450);
        frame.add(new Solitaire(frame.getSize()));
        frame.setVisible(true);
    }

    private final int w;
    private final int h;
    private final Deck deck;
    private final Pile[] piles = new Pile[7];
    private final Pile[] stocks = new Pile[4];

    Solitaire(java.awt.Dimension d) {
        w = d.width;
        h = d.height;
        deck = new Deck();
        for (int i = 0; i < 7; i++)
            for (int j = i; j < 7; j++)
                try {
                    piles[j].add(deck.take());
                } catch(SolitaireException tae) {
                    throw new RuntimeException(tae);
                }
        java.util.Arrays.setAll(stocks, i -> new Pile(13));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}