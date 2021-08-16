package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("A2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("A4")
        );
    }
    @Test
    void moveFalseDiagonal() {
        Pawn k = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("D3")
        );
    }
    @Test
    void moveFalseDiagona2() {
        Pawn k = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("F3")
        );
    }
    @Test
    void moveFalse() {
        Pawn k = new Pawn("E7", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> k.move("E5")
        );
    }
    @Test
    void movenBlack() {
        Pawn k = new Pawn("F7", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class,
                () -> k.move("C6")
        );
    }
    @Test
    void moveFalseDiagona3() {
        Pawn k = new Pawn("E7", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> k.move("D6")
        );
    }
    @Test
    void moveFalse2() {
        Pawn k = new Pawn("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("B5")
        );
    }
    @Test
    void moveFalseWhile() {
        Pawn k = new Pawn("C2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("C5")
        );
    }
    @Test
    void moveBack() {
        Pawn k = new Pawn("E3", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> k.move("E2")
        );
    }
    @Test
    void moveBackBlack() {
        Pawn k = new Pawn("F6", ChessPiece.Color.BLACK);
        assertThrows(IllegalChessMoveException.class,
                () -> k.move("F7")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("I2", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("I232", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Pawn k = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }
@Test
    void moveIllegal() {
        Pawn k = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C123")
        );
    }
    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Pawn k = new Pawn("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Pawn k = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }

}