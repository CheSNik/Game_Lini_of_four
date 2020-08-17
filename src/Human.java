import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human implements IPlayer{
    /**
     * stores name of player
     */
    private String _name;
    private final JFrame frame = new JFrame();
    /**
     * stores scanner object
     */
    private Scanner in;
    /**
     * stores int 1 or 2 to differ player's tokens on the board
     */
    private boolean _color;

    /**
     * Sets name of the Player
     * @param name sets value to a _name property
     */
    public Human(String name) {
        _name = name;
    }

    /**
     * Retrieve data from _name property
     * @return
     */
    public String name(){
       return _name;
    }

    /**
     * Calls dialog box to prompt user enter coordinates of target board cell
     * @return coordinates of target board cell to put token in
     */
    public int[] move (){
        /**
         * stores String input
         */
        String input;
        /**
         * stores parsed input integers
         */
        int row =0, col=0;
        /**
         * stores input target coordinates of Players token
         */
        int[] result = {0,0};
        /**
         * flag for while loop
         */
        boolean instantiated = false;

        //loop for users input
        while (!instantiated){
            input = JOptionPane.showInputDialog(frame,
                    "What position you would like to drop token (Row Column)?",
                    0);
            /**
             * stores input destination of token
             */
            in = new Scanner(input);

            //open read integers from input
            if (in.hasNextInt())
            {
                try{
                    row = in.nextInt();
                    col = in.nextInt();
                }
                catch (NoSuchElementException ex){
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid number",
                            "The Game: \"4 in a line",
                            JOptionPane.PLAIN_MESSAGE);
                }
                //check that input not exceed max possible values
                if(row>0 && col>0 && row <= Constants.ROWS && col<=Constants.COLS) {
                    result[0] = row;
                    result[1] = col;
                    instantiated = true;
                }
                else{
                    JOptionPane.showMessageDialog(frame,
                            "Please enter number not exceed than rows/columns",
                            "The Game: \"4 in a line",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,
                        "Please enter valid number",
                        "The Game: \"4 in a line",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }

        return result;
    }

    /**
     * Sets indicator what player will set in board cell
     * @param color sets value to _color property
     */
    public void init (Boolean color){
        _color = color;
    }

    /**
     * Retrieve indicator what player will set in board cell
     * @return boolean value of _color property
     */
    public boolean getColor(){
        return _color;
    }

    //todo implement inform()
//    void inform (int i);

}
