package io.github.mxz_schwarz.solitaire;

import java.util.List;

class Card { // this is pretty much a really weird enum

    private final Suite s;
    private final Rank r;

    private Card(Suite s, Rank r) {
        this.s = s;
        this.r = r;
    }

    Suite s() { return s; }
    Rank r() { return r; }

    static final List<Card> cards; // List is for immutability

    static {
        Card[] allCards = new Card[52];
        for (Suite s : Suite.SUITES) 
            for (Rank r : Rank.RANKS)
                allCards[4 * s.ordinal() + r.ordinal()] = new Card(s, r);
        cards = List.of(allCards);
    }
}
