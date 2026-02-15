package io.github.mxz_schwarz.solitaire;

class MouseAdapter extends java.awt.event.MouseAdapter {

    private final Solitaire game;
    private Cards first = null;

    MouseAdapter(Solitaire game) {
        this.game = game;
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (first == null) 
            first = game.at(e.getX(), e.getY());
        else
            try {
                game.at(e.getX(), e.getY()).deal(first);
            } catch (SolitaireException se) {
                game.handle(se);
            } finally {
                first = null;
                game.repaint();
            }
    }
}