package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {


    @Test
    void moveDiagonal() {
        Bishop k = new Bishop("E1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("D2")
        );
    }
    @Test
    void moveFalse1() {
        Bishop k = new Bishop("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("B5")
        );
    }
    @Test
    void moveBack() {
        Bishop k = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E2")
        );
    }
    @Test
    void move1() {
        Bishop k = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E6")
        );
    }
    @Test
    void move2() {
        Bishop k = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("A3")
        );
    }
    @Test
    void move3() {
        Bishop k = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("F3")
        );
    }


    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Bishop k = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Bishop k = new Bishop("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Bishop k = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}