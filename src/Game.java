import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    private Gameboard board;
    public Game(int size, int numMines) {
//        Game: Den här klassen kontrollerar spelets logik. Den håller koll på spelets status (pågående, vunnet, förlorat),
//        startar ett nytt spel, och kanske även kontrollerar spelarens interaktioner.
        this.board=new Gameboard( size,numMines);
    }


    public boolean GameOver(Tile tile) {
        if (tile.isMine() && tile.isRevealed()) {
            return true;
        }
        return false;
    }


    public void openTile(){
        System.out.println("Which tile do you want to choose? Choose which row and column e.g (24)");
        String input=scan.nextLine();
        int row = Character.getNumericValue(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        board.revealTile(row, column);


    }
    public void play(){
        boolean gameOver= false;
        do {
            board.displayBoard();
            this.openTile();

            if (isGameLost()){
                board.showAllTiles();
                System.out.println("Game Over!");
                gameOver = true;
            }

        }while(!gameOver);
    }
    public boolean isGameLost() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                Tile tile = board.getTile(row,column);
                if(tile.isMine()&&tile.isRevealed())
                    return true;
                }
            }
            return false;
        }
    public boolean isGameWon(){
      //  for(int row=0;)
        return false;
    }

    }


