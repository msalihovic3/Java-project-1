package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class King extends ChessPiece implements Cloneable {
    King(String pozicij, Color boja) {
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
        King novi = new King(pozicija,boja);
        return novi;
    }


    @Override
    public void move(String position) throws  IllegalChessMoveException,IllegalArgumentException { //nedovrseno
        position=position.toUpperCase();
       super.move(position);

        if((abs(position.charAt(0)-this.getPosition().charAt(0))==1 && abs(position.charAt(1)-this.getPosition().charAt(1))==0) ||
                (abs(position.charAt(1)-this.getPosition().charAt(1))==1 && abs(position.charAt(0)-this.getPosition().charAt(0))==0) ||
                (abs(position.charAt(1)-this.getPosition().charAt(1))==1 && abs(position.charAt(0)-this.getPosition().charAt(0))==1)){}
        else throw new IllegalChessMoveException("ilegalan pozet");
        pozicija=position;

    }
}
