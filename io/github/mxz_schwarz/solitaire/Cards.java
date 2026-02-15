package io.github.mxz_schwarz.solitaire;

// this would be an interface
// if java wasn't so strict about
// them only defining a 'public contract'
// and I like my access modifiers.
abstract class Cards {

    void deal(Card c) throws SolitaireException {
        throw new SolitaireException("Cannot add to this Cards");
    }

    abstract Card top() throws SolitaireException;

    abstract Card take() throws SolitaireException;

    abstract void draw(java.awt.Graphics g);

}
