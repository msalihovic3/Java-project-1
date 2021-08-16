package ba.unsa.etf.rpr;
import static java.lang.Math.abs;
public class Board implements Cloneable{
    private ChessPiece[][] tabla ;

    Board(){


        tabla=new ChessPiece[8][8];

     tabla[0][0]=new Rook("A1", ChessPiece.Color.WHITE);
     tabla[0][7]=new Rook("H1", ChessPiece.Color.WHITE);
     tabla[7][0]=new Rook("A8", ChessPiece.Color.BLACK);
     tabla[7][7]=new Rook("H8", ChessPiece.Color.BLACK);
     tabla[0][1]=new Knight("B1",ChessPiece.Color.WHITE);
     tabla[0][6]=new Knight("G1",ChessPiece.Color.WHITE);
     tabla[7][1]=new Knight("B8",ChessPiece.Color.BLACK);
     tabla[7][6]=new Knight("G8",ChessPiece.Color.BLACK);
     tabla[0][2]=new Bishop("C1",ChessPiece.Color.WHITE);
     tabla[0][5]=new Bishop("F1",ChessPiece.Color.WHITE);
     tabla[7][2]=new Bishop("C8",ChessPiece.Color.BLACK);
     tabla[7][5]=new Bishop("F8",ChessPiece.Color.BLACK);
     tabla[0][3]=new Queen("D1",ChessPiece.Color.WHITE);
     tabla[0][4]=new King("E1",ChessPiece.Color.WHITE);
     tabla[7][3]=new Queen("D8",ChessPiece.Color.BLACK);
     tabla[7][4]=new King("E8",ChessPiece.Color.BLACK);
        char a='A';
     for(int i=0; i<8; i++){
         tabla[1][i]=new Pawn(Character.toString(a)+"2", ChessPiece.Color.WHITE);
         tabla[6][i]=new Pawn(Character.toString(a)+"7", ChessPiece.Color.BLACK);
         a++;
     }

    }

    private void diagonalnoLijevoGore(int i,int j,int i_novo) throws IllegalChessMoveException {
        for(int p=1; p<i-i_novo; p++){
            if (tabla[i-p][j-p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }

    private void dijagonalnoLijevoDole(int i, int j,int i_novo) throws IllegalChessMoveException {
        for(int p=1; p<i_novo-i; p++){
            if (tabla[i+p][j-p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }
    private void dijagonalnoDesnoGore(int i, int j,int i_novo) throws IllegalChessMoveException {
        for(int p=1; p<i-i_novo; p++){
            if (tabla[i-p][j+p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }
    private void dijagonalnoDesnoDole(int i,int j,int i_novo) throws IllegalChessMoveException {
        for(int p=1; p<i_novo-i; p++){
            if (tabla[i+p][j+p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }
    private void vertikalnoGore(int i, int j,int k) throws IllegalChessMoveException {
        for (int p =k+1; p < i; p++) {
            if (tabla[p][j] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }

    }
    private void vertikalnoDole(int i,int j,int k) throws IllegalChessMoveException {
        for (int p =i+1; p < k; p++) {
            if (tabla[p][j] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }

    private void horizontalnoLijevo(int i,int j,int k) throws IllegalChessMoveException {
        for (int p =k+1; p < j; p++) {
            if (tabla[i][p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }

    private void horizontalnoDesno(int i, int j, int k) throws IllegalChessMoveException {
        for (int p =j+1; p <k ; p++) {
            if (tabla[i][p] != null) {
                throw new IllegalChessMoveException("Ne moze preskakati ");
            }
        }
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException, CloneNotSupportedException {
        boolean provjera=true;
        position=position.toUpperCase();
        int i=0,j = 0;
        //trazimo figuru za koju je potez legalan
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if(tabla[i][j]!=null) {
                    if (tabla[i][j].getClass() == type && tabla[i][j].getColor() == color) {
                        try {

                            //provjeravamo da li ima figura na putu od stare do nove pozicije  A1 ->A4
                            if(tabla[i][j].getClass() == Knight.class){
                                Knight kopija=(Knight) tabla[i][j].clone();
                                kopija.move(position);
                            }
                            else if(tabla[i][j].getClass() == King.class){
                                King kopija=(King) tabla[i][j].clone();
                                kopija.move(position);
                            }
                            else if (tabla[i][j].getClass() == Rook.class) {
                                Rook kopija=(Rook) tabla[i][j].clone();
                                kopija.move(position);

                                if (position.charAt(0) == tabla[i][j].getPosition().charAt(0)) {
                                    if (position.charAt(1) < tabla[i][j].getPosition().charAt(1)) {

                                        vertikalnoGore(i,j,position.charAt(1) - '0'-1);

                                    } else if (position.charAt(1) > tabla[i][j].getPosition().charAt(1)) {


                                        vertikalnoDole(i, j, position.charAt(1) - '0' - 1);
                                    }
                                }
                                else if (position.charAt(1) == tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoLijevo(i, j, position.charAt(0) - 'A');

                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoDesno(i, j, position.charAt(0) - 'A');
                                    }
                                }
                            } else if (tabla[i][j].getClass() == Bishop.class) {
                                Bishop kopija=(Bishop) tabla[i][j].clone();
                                kopija.move(position);

                                if (position.charAt(1) < tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        diagonalnoLijevoGore(i,j,position.charAt(1)-'0'-1);

                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoGore(i,j,position.charAt(1)-'0'-1);

                                    }
                                } else if (position.charAt(1) > tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoLijevoDole(i,j,position.charAt(1)-'0'-1);


                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoDole(i,j,position.charAt(1)-'0'-1);
                                    }
                                }
                            } else if (tabla[i][j].getClass() == Queen.class) {
                                //ukoliko je nova pozicija iznas i ispod stare

                                Queen kopija = (Queen) tabla[i][j].clone();
                                kopija.move(position);

                                if (position.charAt(0) == tabla[i][j].getPosition().charAt(0)) {
                                    if (position.charAt(1) < tabla[i][j].getPosition().charAt(1)) {

                                        vertikalnoGore(i,j,position.charAt(1) - '0'-1);

                                    } else if (position.charAt(1) > tabla[i][j].getPosition().charAt(1)) {


                                        vertikalnoDole(i, j, position.charAt(1) - '0' - 1);
                                    }
                                }
                                else if (position.charAt(1) == tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoLijevo(i, j, position.charAt(0) - 'A');

                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoDesno(i, j, position.charAt(0) - 'A');
                                    }
                                }
                                else if (position.charAt(1) < tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        diagonalnoLijevoGore(i,j,position.charAt(1)-'0'-1);

                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoGore(i,j,position.charAt(1)-'0'-1);

                                    }
                                } else if (position.charAt(1) > tabla[i][j].getPosition().charAt(1)) {
                                    if (position.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoLijevoDole(i,j,position.charAt(1)-'0'-1);


                                    } else if (position.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoDole(i,j,position.charAt(1)-'0'-1);
                                    }
                                }

                            } else if (tabla[i][j].getClass() == Pawn.class){
                                Pawn kopija= (Pawn) tabla[i][j].clone();
                                kopija.move(position);
                                //vertikalno ako je prazna pozicija ne moze se pomjeriti
                                if(tabla[i][j].getPosition().charAt(0)!=position.charAt(0) && tabla[position.charAt(1) - '0' - 1][position.charAt(0) - 'A' ]==null ){
                                    throw new IllegalChessMoveException("ilegalno");
                                }


                            }

                            //ako je pronadjena figura i ako je  na novoj poziciji je figura iste boje
                            if (tabla[position.charAt(1) - '0' - 1][position.charAt(0) - 'A' ] != null && tabla[i][j].getColor() ==
                                    tabla[position.charAt(1) - '0' - 1][position.charAt(0) - 'A' ].getColor()) {
                                throw new IllegalChessMoveException("Figura iste boje");
                            } else {

                                //ako je pronadjena figura i na novoj poziciji je figura druge boje ili nema figure
                                tabla[i][j].move(position);
                                tabla[position.charAt(1) - '0'-1][position.charAt(0) - 'A'] = tabla[i][j];
                                tabla[i][j] = null;

                            }
                            provjera = false;
                            break;
                        } catch (IllegalChessMoveException poruka) {
                        }
                    }
                }
            }
        }

        //u slucaju da nije pronadjen ni jedna figura za koju je pozet legalan zaca izuzetak
        if(provjera) throw new IllegalChessMoveException("nema figure");



    }
    void move(String oldPosition, String newPosition) throws IllegalChessMoveException, CloneNotSupportedException {

        oldPosition=oldPosition.toUpperCase();
        newPosition=newPosition.toUpperCase();
        if(tabla[oldPosition.charAt(1)-'0'-1][oldPosition.charAt(0)-'A']!=null){
            this.move(tabla[oldPosition.charAt(1)-'0'-1][oldPosition.charAt(0)-'A'].getClass(),tabla[oldPosition.charAt(1)-'0'-1][oldPosition.charAt(0)-'A'].getColor(),newPosition);
        }else{
            throw new IllegalArgumentException("nema figure");
        }

    }


    private String dajPozicijuKralja(ChessPiece.Color boja) {

        //trazimo poziciju kralja
        String pozicija="";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabla[i][j] != null)
                    if (tabla[i][j].getColor().equals(boja) && tabla[i][j].getClass() == King.class) {
                         pozicija=tabla[i][j].getPosition();
                        return pozicija;
                    }
            }
        }
        return pozicija;
    }

    boolean isCheck(ChessPiece.Color boja) {


     //trazimo poziciju kralja

        String p_kralja=dajPozicijuKralja(boja);

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(tabla[i][j]!=null) {
                    if (tabla[i][j].getColor() != boja) {
                        try {

                            if (tabla[i][j] instanceof Rook) {

                                Rook novi = (Rook) tabla[i][j].clone();
                                novi.move(p_kralja);
                                if (p_kralja.charAt(0) == tabla[i][j].getPosition().charAt(0)) {
                                    if (p_kralja.charAt(1) < tabla[i][j].getPosition().charAt(1)) {

                                        vertikalnoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    } else if (p_kralja.charAt(1) > tabla[i][j].getPosition().charAt(1)) {


                                        vertikalnoDole(i, j, p_kralja.charAt(1) - '0' - 1);
                                    }
                                } else if (p_kralja.charAt(1) == tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoLijevo(i, j, p_kralja.charAt(0) - 'A');

                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoDesno(i, j, p_kralja.charAt(0) - 'A');
                                    }
                                }


                            } else if (tabla[i][j] instanceof Queen) {

                                Queen novi = (Queen) tabla[i][j].clone();

                                novi.move(p_kralja);
                                if (p_kralja.charAt(0) == tabla[i][j].getPosition().charAt(0)) {
                                    if (p_kralja.charAt(1) < tabla[i][j].getPosition().charAt(1)) {

                                        vertikalnoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    } else if (p_kralja.charAt(1) > tabla[i][j].getPosition().charAt(1)) {


                                        vertikalnoDole(i, j, p_kralja.charAt(1) - '0' - 1);
                                    }
                                } else if (p_kralja.charAt(1) == tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoLijevo(i, j, p_kralja.charAt(0) - 'A');

                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        horizontalnoDesno(i, j, p_kralja.charAt(0) - 'A');
                                    }
                                } else if (p_kralja.charAt(1) < tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        diagonalnoLijevoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    }
                                } else if (p_kralja.charAt(1) > tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoLijevoDole(i, j, p_kralja.charAt(1) - '0' - 1);


                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoDole(i, j, p_kralja.charAt(1) - '0' - 1);
                                    }
                                }


                            } else if (tabla[i][j] instanceof Knight) {

                                Knight novi = (Knight) tabla[i][j].clone();
                                novi.move(p_kralja);


                            } else if (tabla[i][j] instanceof Bishop) {


                                Bishop novi = (Bishop) tabla[i][j].clone();
                                novi.move(p_kralja);
                                if (p_kralja.charAt(1) < tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        diagonalnoLijevoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoGore(i, j, p_kralja.charAt(1) - '0' - 1);

                                    }
                                } else if (p_kralja.charAt(1) > tabla[i][j].getPosition().charAt(1)) {
                                    if (p_kralja.charAt(0) < tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoLijevoDole(i, j, p_kralja.charAt(1) - '0' - 1);


                                    } else if (p_kralja.charAt(0) > tabla[i][j].getPosition().charAt(0)) {

                                        dijagonalnoDesnoDole(i, j, p_kralja.charAt(1) - '0' - 1);
                                    }
                                }


                            } else if (tabla[i][j] instanceof Pawn) {
                                Pawn novi = (Pawn) tabla[i][j].clone();
                                novi.move(p_kralja);
                                //vertikalno ako je prazna pozicija ne moze se pomjeriti
                                if (tabla[i][j].getPosition().charAt(0) != p_kralja.charAt(0) && tabla[p_kralja.charAt(1) - '0' - 1][p_kralja.charAt(0) - 'A'] == null) {
                                    throw new IllegalChessMoveException("ilegalno");
                                }


                            } else if (tabla[i][j] instanceof King) {
                                King novi = (King) tabla[i][j].clone();
                                novi.move(p_kralja);


                            }
                            if (tabla[p_kralja.charAt(1) - '0' - 1][p_kralja.charAt(0) - 'A'] != null && tabla[i][j].getColor() ==
                                    tabla[p_kralja.charAt(1) - '0' - 1][p_kralja.charAt(0) - 'A'].getColor()) {
                                throw new IllegalChessMoveException("Figura iste boje");
                            }
                            return true;

                        } catch (IllegalChessMoveException e) {

                        } catch (CloneNotSupportedException e) {

                        }
                    }
                }
            }
        }
      return false;
    }

}
