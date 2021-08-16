package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Knight extends ChessPiece implements Cloneable {
    Knight(String pozicij, Color boja) {

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
        Knight novi =new Knight(pozicija,boja);
        return novi;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {

        position=position.toUpperCase();
       super.move(position);


        if(!(((abs(position.charAt(0)-getPosition().charAt(0))==1) && (abs(position.charAt(1)-getPosition().charAt(1))==2)) ||
                ((abs(position.charAt(1)-getPosition().charAt(1))==1) && (abs(position.charAt(0)-getPosition().charAt(0))==2))))
            throw new IllegalChessMoveException("Neispraval potez");
        pozicija=position;

    }
}
