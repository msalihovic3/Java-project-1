package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public abstract class ChessPiece implements Cloneable {
    protected String pozicija;
    protected Color boja;
    protected static enum Color{BLACK,WHITE}
    public ChessPiece(String position,Color boja)  {
        if(position.length()!=2 )
            throw new IllegalArgumentException("Neispravna pozicija");
        position=position.toUpperCase();

        if( position.charAt(0)<'A' || position.charAt(0)>'H' || position.charAt(1)<'1' || position.charAt(1)>'8')
            throw new IllegalArgumentException("Neispravan format");
        this.pozicija=position;
        this.boja=boja;
    }

    public void move(String position) throws IllegalChessMoveException {

        position=position.toUpperCase();
        if(position.length() != 2 || position.charAt(0) < 'A' || position.charAt(0) > 'H' || position.charAt(1) < '1' || position.charAt(1) > '8')
            throw new IllegalArgumentException("Neispravna pozicija");

    }

    protected abstract Object clone() throws CloneNotSupportedException;
    public abstract String getPosition();//pozicija figure u tabli npr "A4"
    public abstract Color getColor();// vraca boju figure BLACK or WHITE


}
