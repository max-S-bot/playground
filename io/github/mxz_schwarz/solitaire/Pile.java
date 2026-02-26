package io.github.mxz_schwarz.solitaire;

class Pile extends Cards {

    private final Card[] cards;
    private final Card[] stack = new Card[13];
    private int cur = -1;
    private int idx = -1;
    private boolean dealt = false;

    public Pile(int cap) {
        cards = new Card[cap-1];
    }

    @Override // FIXME: handle pile being dealt onto another pile
    void deal(Cards cs) throws SolitaireException {
        Card c = cs.top(); 
        if (cs instanceof Pile pile)
            if (pile.cards[0].r().ordinal() >= top().r().ordinal()-1 && pile.cards[idx].r().ordinal() <= top().r().ordinal()) ;// code goes here 
        else if (dealt)
            if ((idx == -1 && c.r() == Rank.KING) 
                || ((stack[idx].s().ordinal() + 1) % 2 == c.s().ordinal() % 2 
                && stack[idx].r().ordinal() - 1 == c.r().ordinal()))
                stack[++idx] = cs.take();
            else
                throw new SolitaireException("Invalid card");
        else if (cur < cards.length - 1) 
            cards[++cur] = cs.take();
        else if (dealt = !dealt)
            stack[++idx] = cs.take();
    }

    @Override
    Card top() throws SolitaireException {
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
