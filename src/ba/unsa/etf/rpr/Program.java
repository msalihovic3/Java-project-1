package ba.unsa.etf.rpr;
import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
public class Program {
    //public void move(Class type, ChessPiece.Color color, String position)
    public static void main(String[] args) throws IllegalChessMoveException, CloneNotSupportedException {
        Board tablaSaha=new Board();
        String potez="";
        Scanner ulaz = new Scanner(System.in);
        ChessPiece.Color boja= ChessPiece.Color.WHITE;
        Petlja:  do {
            if (boja == ChessPiece.Color.WHITE)
                System.out.println("While move: ");
            else System.out.println("Black move: ");
            potez = ulaz.nextLine();
            if(potez.equals("X") || potez.equals("x") ) break Petlja;
            try{
                if (potez.charAt(0) == 'K')
                    tablaSaha.move(King.class, boja, potez.substring(1,potez.length()));
                else if (potez.charAt(0) == 'Q') {
                    tablaSaha.move(Queen.class, boja, potez.substring(1,potez.length()));
                } else if (potez.charAt(0) == 'R')
                    tablaSaha.move(Rook.class, boja, potez.substring(1,potez.length()));
                else if (potez.charAt(0) == 'B')
                    tablaSaha.move(Bishop.class, boja, potez.substring(1,potez.length()));
                else if (potez.charAt(0) == 'N')
                    tablaSaha.move(Knight.class, boja, potez.substring(1,potez.length()));
                else
                    tablaSaha.move(Pawn.class, boja, potez);


                if(boja== ChessPiece.Color.WHITE)
                    boja= ChessPiece.Color.BLACK;
                else
                    boja= ChessPiece.Color.WHITE;
                //provjera saha figure suprotne boje od boje figure koja je imala potez
                if(tablaSaha.isCheck(boja)==true){
                    System.out.println("CHECK!!!");}
            } catch (IllegalArgumentException a) {
                System.out.println("Ilegal move");

            }
        }while(true);


    }
}
