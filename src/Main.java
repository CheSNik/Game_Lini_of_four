
public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        IPlayer player1 = new Human("Sergei");
        player1.init(false);
        IPlayer player2 = new Human("John");
        player1.init(true);

        GameReferee gameReferee = new GameReferee(player1, player2,board);
        gameReferee.startTheGame();
    }
}
