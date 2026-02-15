package io.github.mxz_schwarz.solitaire;

class Stock extends Cards {
    
    private int idx = -1;
    private final Suite s;

    Stock(Suite s) {
        this.s = s;
    }

    @Override
    void deal(Card c) throws SolitaireException {
        if (c.s() == s && idx + 1 == c.r().ordinal())
            idx++;
        else throw new SolitaireException("Invalid card");
    }

    @Override
    Card top() {
        return idx == -1 ? null : Card.of(s, Rank.RANKS[idx]); 
    }

    @Override
    Card take() throws SolitaireException {
        if (idx == -1)
            throw new SolitaireException("No more cards");
        return Card.of(s, Rank.RANKS[idx]);
    }

    @Override
    void draw(java.awt.Graphics g) {

    }

}
