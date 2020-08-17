import java.util.*;

public class Node
{
   Board board;
   int score;
   ArrayList<Node> branch;
   
   public Node()
   {
       branch = new ArrayList<Node>();
       score = 0;
   }

   public Board getBoard()
   {
       return board;
   }

   public int getScore()
   {
       return score;
   }
  
   public ArrayList<Node> getBranch()
   {
       return branch;
   }

   public void setBoard(Board b)
   {
       board = b;
   }

   public void setScore(int s)
   {
       score = s;
   }

   public void setBranch(Node n)
   {
       branch.add(n);
   }

}

