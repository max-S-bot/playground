package io.github.mxz_schwarz.solitaire;

class Pile extends Cards {

    private final Card[] hidden;
    private final Card[] shown = new Card[13];
    private int cur = -1;
    private int idx = -1;

    public Pile(int cap) {
        hidden = new Card[cap-1];
    }

    @Override
    void deal(Card c) {
        if (++cur == hidden.length)
            shown[++idx] = c;
        else hidden[cur] = c;
    }

    Card top() {
        return cur == -1 ? null : hidden[cur];
    }

    Card take() throws SolitaireException {
        if (cur == -1)
            throw new SolitaireException("No more cards");
        return hidden[cur--];
    }
}
