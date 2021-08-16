package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void moveDiagonal() {
        Rook k = new Rook("E1", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> k.move("D2")
        );
    }
    @Test
    void moveDiagonal1() {
        Rook k = new Rook("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("F5")
        );
    }
    @Test
    void moveBack() {
        Rook k = new Rook("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E2")
        );
    }
    @Test
    void move1() {
        Rook k = new Rook("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E4")
        );
    }
    @Test
    void move2() {
        Rook k = new Rook("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("G3")
        );
    }
    @Test
    void move3() {
        Rook k = new Rook("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Rook k = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Rook k = new Rook("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Rook k = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}