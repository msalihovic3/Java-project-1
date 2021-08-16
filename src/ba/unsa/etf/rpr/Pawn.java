package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece implements Cloneable {
    Pawn(String pozicij, Color boja) {
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
    protected Object clone() {
        Pawn novi=new Pawn(pozicija,boja);
        return novi;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        position=position.toUpperCase();
        super.move(position);

        if(boja==Color.WHITE) {
            if (getPosition().charAt(1) != '2') {
                if (!((position.charAt(0) == getPosition().charAt(0)  && position.charAt(1) == getPosition().charAt(1) + 1)  ||
                        (getPosition().charAt(0)-position.charAt(0)==1 && position.charAt(1)-getPosition().charAt(1)==1) ||
                                (position.charAt(0)-getPosition().charAt(0)==1 && position.charAt(1)-getPosition().charAt(1)==1)))
                    throw new IllegalChessMoveException("ilegalan potez");
            } else {
                if (!((position.charAt(0) == getPosition().charAt(0) && (position.charAt(1) == getPosition().charAt(1) + 1 || position.charAt(1) == getPosition().charAt(1) + 2)) ||
                ((getPosition().charAt(0)-position.charAt(0)==1 && position.charAt(1)-getPosition().charAt(1)==1) ||
                        (position.charAt(0)-getPosition().charAt(0)==1 && position.charAt(1)-getPosition().charAt(1)==1))))
                    throw new IllegalChessMoveException("ilegalan potez"); } }
        else{
            if (getPosition().charAt(1) != '7') {
                if (!((position.charAt(0) == getPosition().charAt(0) && position.charAt(1) == getPosition().charAt(1) - 1 ) ||
                        ((getPosition().charAt(0)-position.charAt(0)==1 && getPosition().charAt(1) - position.charAt(1)==1) ||
                                (position.charAt(0)-getPosition().charAt(0)==1 && getPosition().charAt(1)-position.charAt(1)==1))))
                    throw new IllegalChessMoveException("ilegalan potez");

            } else {
                if (!((position.charAt(0) == getPosition().charAt(0) && (position.charAt(1) == getPosition().charAt(1) - 1 || position.charAt(1) == getPosition().charAt(1) - 2)) ||
                        ((getPosition().charAt(0)-position.charAt(0)==1 && getPosition().charAt(1) - position.charAt(1)==1) ||
                                (position.charAt(0)-getPosition().charAt(0)==1 && getPosition().charAt(1)-position.charAt(1)==1))))
                    throw new IllegalChessMoveException("ilegalan potez");

            }
        }
        pozicija=position;
    }
}
