package io.github.mxz_schwarz.solitaire;

class Deck {

    private final Card[] cards;

    private int pos = 51;

    // super inefficient. will totally fix later.
    {
        Card[] cards = new Card[52];
        for (Card c : Card.cards) {
            int idx = (int) (52*Math.random());
            while (cards[idx] != null)
                idx = (int) (52*Math.random());
            cards[idx] = c;
        }
        this.cards = cards;
    }

    Card draw() {
        Card c = cards[pos];
        skipToNext();
        return c;
    }

    Card take() {
        Card c = cards[pos];
        cards[pos] = null;
        skipToNext();
        return c;
    }

    private void skipToNext() {
        do pos = ((pos - 1) % 52 + 52) % 52;
        while (cards[pos] == null);
    }

}