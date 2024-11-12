package org.pjatk.ea;

import java.util.Random;

public class GameBoard {
    private final char[][] board;
    private final int rows;
    private final int cols;
    private int startX, startY;
    private int stopX, stopY;

    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '.';
            }
        }

        Random random = new Random();
        placeStartAndStop(random);

        placeObstacles(random);
    }

    private void placeStartAndStop(Random random) {
        do {
            startX = random.nextInt(rows);
            startY = (startX == 0 || startX == rows - 1) ? random.nextInt(cols) : (random.nextBoolean() ? 0 : cols - 1);
            stopX = random.nextInt(rows);
            stopY = (stopX == 0 || stopX == rows - 1) ? random.nextInt(cols) : (random.nextBoolean() ? 0 : cols - 1);
        } while ((startX == stopX && startY == stopY) || isAdjacent(startX, startY, stopX, stopY));

        board[startX][startY] = 'A';
        board[stopX][stopY] = 'B';
    }

    public boolean isAdjacent(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) == 1;
    }

    private void placeObstacles(Random random) {
        int obstacles = (rows * cols) / 4;
        for (int i = 0; i < obstacles; i++) {
            int x, y;
            do {
                x = random.nextInt(rows);
                y = random.nextInt(cols);
            } while (board[x][y] != '.');
            board[x][y] = 'X';
        }
    }

    public boolean canMove(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] != 'X';
    }

    public boolean moveUp(int x, int y) {
        return canMove(x - 1, y);
    }

    public boolean moveDown(int x, int y) {
        return canMove(x + 1, y);
    }

    public boolean moveLeft(int x, int y) {
        return canMove(x, y - 1);
    }

    public boolean moveRight(int x, int y) {
        return canMove(x, y + 1);
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getStopX() {
        return stopX;
    }

    public int getStopY() {
        return stopY;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



}
