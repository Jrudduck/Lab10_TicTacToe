import java.util.Scanner;

public class Main {
    private static String[][] board = new String[3][3];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean wantPlay;
        boolean playerOneMove = false;
        boolean playerTwoMove = false;
        String playerOne = "X";
        String playerTwo = "O";
        boolean game = false;
        boolean play;

        play = InputHelper.getYNConfirm(scan, "Would you like to play tic-tac-toe? [y/n]");

        if (play = true) {
            wantPlay = true;
        } else {
            wantPlay = false;
            System.exit(0);
        }

        do{
            clearBoard();
            displayBoard();
            do {
               do {
                   int row = InputHelper.getRangedInt(scan, "Player one, please choose which row[0-2]:", 2, 0);

                   int col = InputHelper.getRangedInt(scan, "Player one, please choose which column[0-2]:", 2, 0);
                   if (isValidMove(row, col)){
                    board[row][col] = playerOne;
                    displayBoard();
                       playerOneMove = true;
                       playerTwoMove = false;
                   } else {
                       System.out.println("Not a valid move, please try again");
                   }
               } while(!playerOneMove);
                if (isWin(playerOne)){
                    System.out.println("Player one wins!");
                    game = true;
                    play = InputHelper.getYNConfirm(scan, "Would you like to play tic-tac-toe? [y/n]");
                    if (play = true) {
                        wantPlay = true;
                        game = false;
                        clearBoard();
                    } else {
                        wantPlay = false;
                        System.exit(0);
                    }

                }
                do {
                    int row = InputHelper.getRangedInt(scan, "Player two, please choose which row[0-2]:", 2, 0);

                    int col = InputHelper.getRangedInt(scan, "Player two, please choose which column[0-2]:", 2, 0);
                    if (isValidMove(row, col)){
                        board[row][col] = playerTwo;
                        displayBoard();
                        playerTwoMove = true;
                        playerOneMove = false;
                    } else {
                        System.out.println("Not a valid move, please try again");
                    }
                } while(!playerTwoMove);
                if (isWin(playerTwo)){
                    System.out.println("Player two wins!");
                    game = true;
                    play = InputHelper.getYNConfirm(scan, "Would you like to play tic-tac-toe? [y/n]");
                    if (play = true) {
                        wantPlay = true;
                        game = false;
                        clearBoard();
                    } else {
                        wantPlay = false;
                        System.exit(0);
                    }
                }
                if (isTie()){
                    System.out.println("The game is a tie!");
                    game = true;
                    play = InputHelper.getYNConfirm(scan, "Would you like to play tic-tac-toe? [y/n]");
                    if (play = true) {
                        wantPlay = true;
                        game = false;
                        clearBoard();
                    } else {
                        wantPlay = false;
                        System.exit(0);
                    }
                }
            }while (!game);
        }while (!wantPlay);
    }

    private static void clearBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "-";
            }
        }
    }

    private static void displayBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (board [row][col].equalsIgnoreCase("-")){
            return true;
        } else {
            return false;
        }
    }

    private static boolean isWin(String player) {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }else {
            return false;
        }
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i <= 2; i++){
            if (board [0][i].equals(player) && board [1][i].equals(player) && board [2][i].equals(player)){
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i <= 2; i++){
            if (board [i][0].equals(player) && board [i][1].equals(player) && board [i][2].equals(player)){
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board [0][0].equals(player) && board [1][1].equals(player) && board [2][2].equals(player) || board [0][2].equals(player) && board [1][1].equals(player) && board [2][0].equals(player) ){
                return true;
            }else{
        return false;
        }
    }

    private static boolean isTie () {
        boolean full = true;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c].equalsIgnoreCase("-")){
                    full = false;
                }
            }
        }
        if(full && !isWin("O") || full && !isWin("x")){
            return  true;
        } else {
            return false;
        }
    }
}