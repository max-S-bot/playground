package io.github.mxz_schwarz.solitaire;

public class Pile {

    final Card[] cards;
    int cur = -1;

    public Pile(int cap) {
        cards = new Card[cap];
    }

    void add(Card c) throws TryAgainException {
        cards[++cur] = c;
    }

    Card top() throws TryAgainException {
        return cards[cur];
    }

    Card pop() throws TryAgainException {
        return cards[cur--];
    }
}
