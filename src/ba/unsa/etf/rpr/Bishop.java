package ba.unsa.etf.rpr;

import javax.security.auth.login.AccountLockedException;

import static java.lang.Math.abs;

public class Bishop extends ChessPiece implements Cloneable {
    Bishop(String pozicij, Color boja) {

        super(pozicij, boja);
    }

    @Override
    public String getPosition() {

        return pozicija;
    }

    @Override
    public Color getColor() {

        return boja;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Bishop novi = new Bishop(pozicija,boja);
        return novi;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
         position=position.toUpperCase();
        super.move(position);
        if(abs(position.charAt(0) - this.getPosition().charAt(0)) != abs(position.charAt(1) - this.getPosition().charAt(1))) throw new IllegalChessMoveException("Neispraval potez");
        pozicija=position;


    }
}
