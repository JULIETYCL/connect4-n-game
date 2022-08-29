

public class Board {

    private boolean win;
    private boolean winner;
    private int player_turn;
    private char player;
    private String which_player;
    public char[][] board = new char[7][8];
    public int move;
    private int n;



    public Board(){

    }

    public void playGame(int n) {
        Player[] player = new Player[3];
        player[0] = new Computers("y");
        player[1] = new HuMan("r");
        player[2] = new Computers("g");

        win = false;
        winner = false;
        player_turn = 1;

            while (!winner) {
                try{
                move = -1;
                while (!validate(move)) {
                        move = player[player_turn].GetMove();
                        which_player = player[player_turn].GetPlayer();
                    }

                which_player = player[player_turn].GetPlayer();
                placeCounter(which_player, move);
                printBoard();
                isWinner(which_player, move, n);

                if (win) {
                    winner = true;

                } else {
                    player_turn = (player_turn + 1) % player.length;
                }

            }catch(Exception e){
                    System.out.println("No letters ! No tokens! ");
                    break;

                }
            }

        }
    // Record move in the board
    public void placeCounter(String which_player, int move) {
        boolean placed = false;
        player=which_player.charAt(0);
            for (int row = board.length - 2; row >= 0; row--) {
                if (!placed) {
                    if (board[row][move - 1] != 'y'&& board[row][move-1]!='g' && board[row][move-1]!='r') {
                        board[row][move - 1] =player;
                        System.out.println(which_player);
                        placed = true;
                    }
                }
            }
        }

    public void isWinner(String which_player,int move,int n) {
        if (2 < n && n < 7) {
            int counter = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == player) {
                    counter++;
                    if (counter >= n) {
                        System.out.println(which_player + " won the game!!");
                        win = true;
                    }
                } else {
                    counter = 0;
                }


            }
            counter = 0; // counting a new row, counter back to 0;

        }

        //vertical check
        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] == player) {
                    counter++;
                    if (counter >= n) {
                        System.out.println(which_player + " won the game!!");
                        win = true;
                    }
                } else {
                    counter = 0;
                }
            }
            counter = 0;
        }

        //downward diagonal
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    int i = 0;
                    while (i + row < board.length && i + column < board[row].length) {
                        if (board[row + i][column + i] == player) {
                            counter++;
                            if (counter >= n) {
                                System.out.println(which_player + " won the game!!");
                                win = true;
                            }
                        } else {
                            counter = 0;
                        }
                        i++;

                    }
                    counter = 0;
                }
            }

            //upward diagonal
            for (int row=0;row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    int i = 0;
                    while (row-i >= 0 && column + i < board[i].length) {
                        if (board[row-i][column+i] == player) {
                            counter++;
                            if (counter >= n) {
                                System.out.println(which_player + " won the game!!");
                                win = true;
                            }
                        } else {
                            counter = 0;
                        }
                        i++;
                    }
                    counter = 0;
                }
            }
        }



        else {
            System.out.println("Please enter n from 2 to 7");
            win=true;
        }
    }







// Add Exception check
    public boolean validate(int move) {
        try{
        if (move < 0 || move > board[0].length|| move==0) {
            return false;
        }

        if (board[0][move - 1] == 'y' || board[0][move - 1] == 'r'||board[0][move - 1] == 'g') {

            return false; }
        }
        catch(Exception e){
            System.out.println("Please enter valid numbers");
        }
        return true;
    }


    public void printBoard() {
        for (int row = 0; row < board.length - 1; row++) {
            for (int column = 0; column < board[row].length - 1; column++) {
                if (board[row][column] == 'r') {
                    System.out.print("| r ");
                } else if (board[row][column] == 'y') {
                    System.out.print("| y ");
                } else if(board[row][column] == 'g'){
                    System.out.print("| g ");
                }
                else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");

    }



}
