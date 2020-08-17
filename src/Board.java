

public class Board {

    private int[][] board;

    public Board() {
        board = new int[Constants.ROWS][Constants.COLS];
    }

    /**
     * Draw values of each cell on board
     */
    public void showBoard()
    {

        System.out.println("   1  2  3  4  5  6  7");
        for(int i =0; i<board.length;i++){
            System.out.printf("%d ", i+1);
            for (int j=0; j<board[i].length; j++){
                System.out.printf("|%d|",board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Sets target board cell with certain indicator
     * @param coordinates sets coordinates of target cell
     * @param color sets boolean value to choose what value (1 or 2) to set on a target cell
     */
    public boolean setToBoard(int[] coordinates, boolean color)
    {
        boolean isValidMove=false;
        int indicator = 0;

        //depends on player's color
        if (color) indicator = 1;
        else indicator = 2;

        int i = coordinates[0]-1;
        int j = coordinates[1]-1;

        if(board[i][j]==0 && i==Constants.ROWS-1){
            board[i][j] = indicator;
            isValidMove = true;
        }
        else if(board[i][j]==0 && (board[i+1][j]!=0)){
            board[i][j] = indicator;
            isValidMove = true;
        }
        return isValidMove;
    }

    /**
     * Check values of board to decide if there "four in a line" match
     * @return
     */
    public boolean checkWinner()
    {
        boolean isWinner = false;
        //1. Check if there are four in horizontal position
        //first if check by rows
        for (int y = 0; y< board.length; y++){
            //second if check by columns in y row
            for (int x =0; x < board[y].length-3;x++){
                if (board[y][x] !=0
                        && board[y][x] == board[y][x+1]
                        && board[y][x+1] == board[y][x+2]
                        && board[y][x+2] == board[y][x+3])
                    isWinner = true;
            }
        }

        //2. Check if there are four in vertical position
        //first if check by columns
        for (int x =0; x<board[0].length;x++){
            //second if check by row
            for (int y = 1; y< board.length-3; y++){
                if (board[y][x] !=0
                        && board[y][x] == board[y+1][x]
                        && board[y+1][x] == board[y+2][x]
                        && board[y+2][x] == board[y+3][x])
                    isWinner = true;
            }
        }
        //3. Check if there are four in right incline position
        //first if check by columns
        for (int y = 3; y< board.length-3; y++){
            //second if check by columns in y row
            for (int x =0; x< board[y].length-3;x++){
                if (board[y][x] !=0
                        && board[y][x] == board[y-1][x+1]
                        && board[y-1][x+1] == board[y-2][x+2]
                        && board[y-2][x+2] == board[y-3][x+3])
                    isWinner = true;
            }
        }

        //4. Check if there are four in left incline position
        //first if check by columns
        for (int y = 0; y< board.length-3; y++){
            //second if check by columns in y row
            for (int x =0; x< board[y].length-3;x++){
                if (board[y][x] !=0
                        && board[y][x] == board[y+1][x+1]
                        && board[y+1][x+1] == board[y+2][x+2]
                        && board[y+2][x+2] == board[y+3][x+3])
                    isWinner = true;
            }
        }
        if (isWinner)
        System.out.println("Winner was found");

        return isWinner;
    }

}
