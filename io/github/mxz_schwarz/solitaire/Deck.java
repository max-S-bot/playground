package io.github.mxz_schwarz.solitaire;

class Deck extends Cards{

    private final Card[] cards = Card.values();

    private int pos = 51;

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
    Card top() {
        Card c = cards[pos];
        skipToNext();
        return c;
    }

    @Override
    Card take() {
        Card c = cards[pos];
        cards[pos] = null;
        skipToNext();
        return c;
    }

    @Override
    void draw(java.awt.Graphics g) {

    }

    private void skipToNext() {
        do pos = (pos + 51) % 52; // this is effectively subtracting one (% is remainder, not mod)
        while (cards[pos] == null); // will adjust this class so that this method isn't needed by shifting elements to the left each time the end of the deck is reached 
    }

}