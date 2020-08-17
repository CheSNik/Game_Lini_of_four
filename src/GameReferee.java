import javax.swing.*;

public class GameReferee {

    private IPlayer _player1;
    private IPlayer _player2;
    private Board _board;
    private int deltaTime;
    private int timeNow;
    private int timeStart;
    private final JFrame frame = new JFrame();


    public GameReferee(IPlayer player1, IPlayer player2, Board board) {
        _player1 = player1;
        _player2 = player2;
        _board = board;
        timeStart = (int)System.currentTimeMillis();
    }

    public void startTheGame(){
        IPlayer player=null;
        //set 1 move to player 1
        int turn = 1;
        System.out.println("Game four in line");
        _board.showBoard();

        while(!_board.checkWinner()){
            if(turn>0)
                player = _player1;
            else
                player = _player2;
            //pass the coordinates of target place of token to a board
            System.out.println("It is turn of "+player.name());
            JOptionPane.showMessageDialog(frame,
                    "It is turn of "+player.name(),
                    "The Game: \"4 in a line",
                    JOptionPane.PLAIN_MESSAGE);
            while(!_board.setToBoard(player.move(), player.getColor())){
                System.out.println("Invalid target position. Try again");
                JOptionPane.showMessageDialog(frame,
                        "Invalid target position. Try again",
                        "The Game: \"4 in a line",
                        JOptionPane.PLAIN_MESSAGE);
            }
            turn*=-1;
            _board.showBoard();
        }

        System.exit(0);
    }

    private void timeControl(){
//todo implement 18 sec control of making move
    }
}
