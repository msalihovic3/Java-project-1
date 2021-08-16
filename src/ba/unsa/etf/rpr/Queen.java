package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Queen extends ChessPiece implements Cloneable {
    Queen(String pozicij, Color boja) {
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
        Queen novi = new Queen(pozicija,boja);
        return novi;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {

        position=position.toUpperCase();
        super.move(position);

        if(abs(position.charAt(0) - this.getPosition().charAt(0)) != abs(position.charAt(1) - this.getPosition().charAt(1)) &&
                !((position.charAt(0) != pozicija.charAt(0) && position.charAt(1) == pozicija.charAt(1)) ||
                        position.charAt(0) == pozicija.charAt(0) && position.charAt(1) != pozicija.charAt(1)))
            throw new IllegalChessMoveException("ilegalan pozet");
         pozicija=position;
    }
}
