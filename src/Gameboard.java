public class Gameboard {

//    initializeBoard(): Denna metod kan användas för att skapa brädet och placera ut minor på slumpmässiga platser.
//    displayBoard(): Denna metod kan användas för att visa brädet för spelaren.
//    Kanske visa okända rutor som frågetecken, flaggade rutor som flaggor, etc.


    private static Tile[][] board;
    private int size;
    private int numMines;

    public Gameboard(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.board = new Tile[size][size];
        initializeBoard();
        }

        private void initializeBoard() {
            // Fill the board with empty tiles
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    board[row][col] = new Tile(false);
                }
            }
        }
            public void displayBoard() {
                System.out.println("  | 0 1 2 3 4 5 6 7 8");
                System.out.println("--|-------------------");
                for (int row = 0; row < size; row++) {
                    System.out.print(row + " | ");
                    for (int col = 0; col < size; col++) {
                        Tile tile = board[row][col];
                        if (tile.isRevealed()) {
                            if (tile.isMine()) {
                                System.out.print("X ");
                            }  else {
//                                 Display the count of adjacent mines
//                                int adjacentMines = countAdjacentMines(row, col);
//                                System.out.print(adjacentMines + " ");
                            }
                        } else {
                            System.out.print(". ");
                        }
                    }
                    System.out.println();
                }
            }

    public void revealTile(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size && !board[row][col].isRevealed()) {
            board[row][col].reveal();
        }
    }
    public int countAdjacentMines(int row, int col) {

        int count = 0;
        


        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Hoppa över den aktuella rutan
                if (i == 0 && j == 0) {
                    continue;
                }

                int adjacentRow = row + i;
                int adjacentCol = col + j;

                // Kontrollera om den närliggande rutan är inom brädet
                if (isWithinBoard(adjacentRow, adjacentCol)) {
                    Tile adjacentTile = board[adjacentRow][adjacentCol];
                    if (adjacentTile.isMine()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isWithinBoard(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
    }

