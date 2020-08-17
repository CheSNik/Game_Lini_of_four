public class Computer implements IPlayer{

    /**
     * stores name of player
     */
    private String _name;
    /**
     * stores int 1 or 2 to differ player's tokens on the board
     */
    private boolean _color;

    public Computer(String name, boolean color) {
        _name = name;
        _color = color;
    }

    /**
     * Sets indicator what player will set in board cell
     * @param color sets value to _color property
     */
    public void init (Boolean color){
        _color = color;
    }

    /**
     * Retrieve data from _name property
     * @return
     */
    public String name(){
        return _name;
    }

    /**
     * Retrieve indicator what player will set in board cell
     * @return boolean value of _color property
     */
    public boolean getColor(){
        return _color;
    }


    public int[] move(){
        int[] a ={1};
        return a;
    }
}
