package gol;

public class Game {

    // x -> row, y -> column
    // {{f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f,f}, {...}, total 15 rows}

    private boolean[][] board = new boolean[15][20];


    public void markAlive(int x, int y) {
        board[x][y] = true;
    }


    public boolean isAlive(int x, int y) {
        return board[x][y];
    }


    public void toggle(int x, int y) {
        if (board[x][y]) {
            board[x][y] = false;
        } else if (!board[x][y]) {
            board[x][y] = true;
        }
    }



    private boolean isInTheGrid(int x, int y) {
        return x >= 0 && y >= 0 && y < 20 && x < board.length;
    }



    public Integer getNeighbourCount(int x, int y) {
        int aliveNeighboursCount = 0;

        int[][] cellsToCheck = {
                {x - 1, y - 1},
                {x - 1, y},
                {x - 1, y + 1},
                {x, y + 1},
                {x + 1, y + 1},
                {x + 1, y},
                {x + 1, y - 1},
                {x, y - 1},
        };

        for (int[] i : cellsToCheck) {

            int xToCheck = i[0];
            int yToCheck = i[1];

            if (isInTheGrid(xToCheck, yToCheck) && isAlive(xToCheck, yToCheck)) {
                aliveNeighboursCount++;
            }

        }

        return aliveNeighboursCount;
    }



    public void nextFrame() {
        boolean[][] updatedBoard = new boolean[15][20];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {

                if (nextState(board[x][y], getNeighbourCount(x, y))) {
                    updatedBoard[x][y] = true;
                }
            }

        }
        board = updatedBoard;


    }


    public void clear() {
        throw new RuntimeException("not implemented yet");
    }



    public boolean nextState(boolean isLiving, int neighborCount) {
        if (isLiving && (neighborCount < 2 || neighborCount > 3)) {
            return false;
        }
        else if (isLiving && (neighborCount == 2 || neighborCount == 3)) {
            return true;
        }
        else if (!isLiving && neighborCount == 3) {
            return true;
        }
        return false;
    }
}
