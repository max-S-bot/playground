package io.github.mxz_schwarz.solitaire;

class Pile extends Cards {

    private final Card[] cards;
    private final Card[] stack = new Card[13];
    private int cur = -1;
    private int idx = -1;

    public Pile(int cap) {
        cards = new Card[cap-1];
    }

    @Override
    void deal(Card c) throws SolitaireException {
        if (cur == cards.length)
            if ((stack[0] == null && c.r() == Rank.KING) 
                || ((stack[0].s().ordinal() + idx + 1) % 2 == c.s().ordinal() % 2 
                && stack[0].r().ordinal() + idx + 1 == c.r().ordinal()))
                cards[++idx] = c;
            else
                throw new SolitaireException("Invalid card");
        else if (++cur == cards.length)
            cards[0] = c;
        else cards[cur] = c;
    }

    @Override
    Card top() {
        return idx == -1 ? null : stack[idx];
    }

    @Override
    Card take() throws SolitaireException {
        if (idx == -1)
            throw new SolitaireException("No more cards");
        return stack[idx];
    }

    @Override
    void draw(java.awt.Graphics g) {
        
    }
}
