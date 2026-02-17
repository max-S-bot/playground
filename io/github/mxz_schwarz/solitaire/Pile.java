package io.github.mxz_schwarz.solitaire;

class Pile extends Cards {

    private final Card[] cards;
    private final Card[] stack = new Card[13];
    private int cur = -1;
    private int idx = -1;

    public Pile(int cap) {
        cards = new Card[cap-1];
    }

    @Override // FIXME: handle pile being dealt onto another pile
    void deal(Cards cs) throws SolitaireException {
        Card c = cs.top(); 
        if (cur == cards.length)
            if ((idx == -1 && c.r() == Rank.KING) 
                || ((stack[idx].s().ordinal() + 1) % 2 == c.s().ordinal() % 2 
                && stack[idx].r().ordinal() - 1 == c.r().ordinal()))
                cards[++idx] = c;
            else
                throw new SolitaireException("Invalid card");
        else if (++cur == cards.length)
            cards[++idx] = c;
        else cards[cur] = c;
    }

    @Override
    Card top() throws SolitaireException{
        if (idx != -1)
            return stack[idx];
        else 
            throw new SolitaireException("No more cards");
    }

    Card take() throws SolitaireException {
        if (idx == -1)
            throw new SolitaireException("No more cards");
        else if (idx != 0)
            return stack[idx--];
        Card temp = stack[0];
        if (cur == -1)
            idx = -1;
        else
            stack[0] = cards[cur--];
        return temp;
        
    }

    @Override
    void draw(java.awt.Graphics g) {
        
    }
}
