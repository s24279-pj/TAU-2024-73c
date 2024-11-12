package org.pjatk.ea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    public void setup() {
        gameBoard = new GameBoard(5, 5);
    }

    @Test
    public void testInitialPositionsAreOnTheEdgeAndNotAdjacent() {
        int startX = gameBoard.getStartX();
        int startY = gameBoard.getStartY();
        int stopX = gameBoard.getStopX();
        int stopY = gameBoard.getStopY();

        assertTrue(isOnEdge(startX, startY));
        assertTrue(isOnEdge(stopX, stopY));
        assertFalse(gameBoard.isAdjacent(startX, startY, stopX, stopY));
    }

    private boolean isOnEdge(int x, int y) {
        return x == 0 || x == gameBoard.getRows() - 1 || y == 0 || y == gameBoard.getCols() - 1;
    }

    @Test
    public void testMoveOutOfBounds() {
        assertFalse(gameBoard.moveLeft(0, 0));
        assertFalse(gameBoard.moveUp(0, 0));
        assertFalse(gameBoard.moveRight(4, 4));
        assertFalse(gameBoard.moveDown(4, 4));
    }

    @Test
    public void testObstacleBlocksMovement() {
        int x = gameBoard.getStartX();
        int y = gameBoard.getStartY();

        if (y + 1 < gameBoard.getCols()) {
            gameBoard.getBoard()[x][y + 1] = 'X';
            assertFalse(gameBoard.moveRight(x, y));
        }
    }


    @Test
    public void testFreePathAllowsMovement() {
        int x = gameBoard.getStartX();
        int y = gameBoard.getStartY();

        if (y + 1 < gameBoard.getCols()) {
            gameBoard.getBoard()[x][y + 1] = '.';
            assertTrue(gameBoard.moveRight(x, y));
        }
    }

    @Test
    public void testStartAndStopPositionsAreOnEdges() {
        int startX = gameBoard.getStartX();
        int startY = gameBoard.getStartY();
        int stopX = gameBoard.getStopX();
        int stopY = gameBoard.getStopY();
        assertTrue(isOnEdge(startX, startY));
        assertTrue(isOnEdge(stopX, stopY));
    }

    @Test
    public void testStartAndStopPositionsAreDistinctAndNotAdjacent() {
        int startX = gameBoard.getStartX();
        int startY = gameBoard.getStartY();
        int stopX = gameBoard.getStopX();
        int stopY = gameBoard.getStopY();
        assertFalse(startX == stopX && startY == stopY);
        assertFalse(gameBoard.isAdjacent(startX, startY, stopX, stopY));
    }

    @Test
    public void testObstacleBlocksMovementInAllDirections() {
        int x = 2, y = 2;
        gameBoard.getBoard()[x][y] = 'A';
        gameBoard.getBoard()[x - 1][y] = 'X';
        gameBoard.getBoard()[x + 1][y] = 'X';
        gameBoard.getBoard()[x][y - 1] = 'X';
        gameBoard.getBoard()[x][y + 1] = 'X';
        assertFalse(gameBoard.moveUp(x, y));
        assertFalse(gameBoard.moveDown(x, y));
        assertFalse(gameBoard.moveLeft(x, y));
        assertFalse(gameBoard.moveRight(x, y));
    }

    @Test
    public void testMovementOutsideBoardBoundsIsBlocked() {
        assertFalse(gameBoard.moveUp(0, 0));
        assertFalse(gameBoard.moveLeft(0, 0));
        assertFalse(gameBoard.moveDown(gameBoard.getRows() - 1, gameBoard.getCols() - 1));
        assertFalse(gameBoard.moveRight(gameBoard.getRows() - 1, gameBoard.getCols() - 1));
    }

    @Test
    public void testBoardSetup() {
        char[][] board = gameBoard.getBoard();
        int startCount = 0, stopCount = 0, obstacleCount = 0;
        for (int i = 0; i < gameBoard.getRows(); i++) {
            for (int j = 0; j < gameBoard.getCols(); j++) {
                if (board[i][j] == 'A') startCount++;
                if (board[i][j] == 'B') stopCount++;
                if (board[i][j] == 'X') obstacleCount++;
            }
        }
        assertEquals(1, startCount);
        assertEquals(1, stopCount);
        assertTrue(obstacleCount > 0);
    }

    @Test
    public void testMovementToEmptySpace() {
        int x = 1, y = 1;
        gameBoard.getBoard()[x][y] = 'A';
        gameBoard.getBoard()[x - 1][y] = '.';
        gameBoard.getBoard()[x + 1][y] = '.';
        gameBoard.getBoard()[x][y - 1] = '.';
        gameBoard.getBoard()[x][y + 1] = '.';
        assertTrue(gameBoard.moveUp(x, y));
        assertTrue(gameBoard.moveDown(x, y));
        assertTrue(gameBoard.moveLeft(x, y));
        assertTrue(gameBoard.moveRight(x, y));
    }
}
