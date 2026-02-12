package io.github.mxz_schwarz.solitaire;

class Deck extends Cards{

    private final Card[] cards;

    private int pos = 51;

    // super inefficient. will totally fix later.
    {
        Card[] cards = new Card[52];
        for (Card c : Card.cards) {
            int idx;
            do idx = (int) (52 * Math.random());
            while (cards[idx] != null);
            cards[idx] = c;
        }
        this.cards = cards;
    }

    Card top() {
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