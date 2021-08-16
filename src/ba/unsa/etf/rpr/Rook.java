package ba.unsa.etf.rpr;

import java.lang.instrument.IllegalClassFormatException;

public class Rook extends ChessPiece implements Cloneable {
    Rook(String pozicij, Color boja) {

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
    public void  move(String position) throws IllegalChessMoveException {
        position=position.toUpperCase();
       super.move(position);
        if(!((position.charAt(0) != pozicija.charAt(0) && position.charAt(1) == pozicija.charAt(1)) ||
                position.charAt(0) == pozicija.charAt(0) && position.charAt(1) != pozicija.charAt(1)))
            throw new IllegalChessMoveException("Neispraval potez");
        pozicija=position;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rook novi=new Rook(pozicija,boja);
        return novi;
    }
}
