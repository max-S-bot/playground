package io.github.mxz_schwarz.solitaire;

class Deck extends Cards{

    private final Card[] cards = Card.values();
    private int pos = 51;
    private int count = 52;

    // https://en.wikipedia.org/wiki/Fisher-Yates_shuffle
    {
        for (int i = 1; i < 52; i++) {
            int j = (int) ((i+1) * Math.random());
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    @Override
    void deal(Cards cs) throws SolitaireException {
        if (this == cs)
            next();
        else 
            throw new SolitaireException("Can't add to the deck");
    }

    @Override
    Card top() throws SolitaireException {
        if (count != 0)
            return cards[pos];
        else 
            throw new SolitaireException("Can't draw from empty deck");
    }

    @Override
    Card take() throws SolitaireException {
        if (count == 0)
            throw new SolitaireException("Can't draw from empty deck");
        Card c = cards[pos];
        cards[pos] = null;
        do next(); 
        while (cards[pos] == null);
        return c;
    }

    @Override
    void draw(java.awt.Graphics g   ) {

    }

    private void next() {
        pos = (pos + 51) % 52; // this is effectively subtracting one (% is remainder, not mod)
    }

}