package io.github.mxz_schwarz.solitaire;

class Stock extends Cards {
    
    private final Card[] cards = new Card[13];
    private int idx = -1;
    private final Suite s;

    Stock(Suite s) {
        this.s = s;
    }

    @Override
    void deal(Card c) throws SolitaireException {
        if (c.s() == s && idx + 1 == c.r().ordinal())
            cards[++idx] = c;
        else throw new SolitaireException("Invalid card");
    }

    Card top() {
        return idx == -1 ? null : cards[idx]; 
    }

    Card take() throws SolitaireException {
        if (idx == -1)
            throw new SolitaireException("No more cards");
        return cards[idx];
    }

}
