package io.github.mxz_schwarz.solitaire;

class Card { // this is pretty much a really weird enum

    private final Suite s;
    private final Rank r;

    private Card(Suite s, Rank r) {
        this.s = s;
        this.r = r;
    }

    Suite s() { return s; }
    Rank r() { return r; }
    
    int ordinal() {
        return 4 * s.ordinal() + r.ordinal();
    }

    void draw(java.awt.Graphics g, boolean faceUp) {

    }

    private static final Card[] cards = new Card[52];

    static {
        for (Suite s : Suite.SUITES) 
            for (Rank r : Rank.RANKS)
                cards[4 * s.ordinal() + r.ordinal()] = new Card(s, r);
    }

    static Card[] values() {
        Card[] copy = new Card[52];
        for (Card c : cards)
            copy[c.ordinal()] = c;
        return copy;
    }

    static Card of(Suite s, Rank r) {
        return cards[4 * s.ordinal() + r.ordinal()];
    }

}
