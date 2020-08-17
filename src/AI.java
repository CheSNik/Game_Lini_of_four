///**
// * Write a description of class AI here.
// *
// * @author (your name)
// * @version (a version number or a date)
// */
//
//import java.util.ArrayList;
//import java.lang.Math;
//
//public class AI
//{
//    private Node root;
//    int depth;
//
//    public AI(int [][]board, int d, int p)
//    {
//        depth = d;
//
//        root = new Node(board, -1, -1, p);
//    }
//
//    public int myScore(int [][] board, int move)
//    {
//        // YOU NEED TO IMPLEMENT
//
//        return ((int)(Math.random()*1000) + 1);
//    }
//
//    public boolean isValidMove(int [][] board, int move)
//    {
//        if (board[1][move] == 0)
//        {
//            return (true);
//        }
//        else
//        {
//            return (false);
//        }
//    }
//
//    public void spanTree(Node c_node, ArrayList<Node> list)
//    {
//        int [][] t_board = new int[Constants.ROWS+1][Constants.COLS];
//        int player;
//
//        for (int i = 0; i < Constants.COLS; i++)
//        {
//            if (isValidMove(c_node.getBoard(), i))
//            {
//                copyBoard(c_node.getBoard(), t_board);
//                if (c_node.getPlayer() == Constants.PLAYER1)
//                {
//                    player = Constants.PLAYER2;
//                }
//                else
//                {
//                    player = Constants.PLAYER1;
//                }
//
//                makeMove(t_board, i, player);
//                int score = myScore(t_board, i);
//                Node n_node = new Node(t_board, score, i, player);
//                c_node.getNext().set(i, n_node);
//                list.add(n_node);
//            }
//        }
//    }
//
//    private void copyBoard(int [][] a_from, int [][] a_to)
//    {
//        for (int i = 0; i < Constants.ROWS+1; i++)
//        {
//            for (int j = 0; j < Constants.COLS; j++)
//            {
//                a_to[i][j] = a_from[i][j];
//            }
//        }
//    }
//
//    private void makeMove(int [][] board, int move, int player)
//    {
//
//        for (int i = Constants.ROWS; i >= 1; i--)
//        {
//            if (board[i][move] == 0)
//            {
//                board[i][move] = player;
//                break;
//            }
//        }
//    }
//
//    public int AImove()
//    {
//        ArrayList<Node> list1 = new ArrayList<Node>();
//        ArrayList<Node> list2 = new ArrayList<Node>();
//
//        spanTree(root, list2);
//
//        for (int c_d = 1; c_d < depth; c_d++)
//        {
//            cloneList(list1, list2);
//            list2.clear();
//
//            for (int j = 0; j < list1.size(); j++)
//            {
//                if (list1.get(j) != null)
//                {
//                    spanTree(list1.get(j), list2);
//                }
//            }
//
//            list1.clear();
//
//        }
//
//        // call minimax to get move
//        int [] result = new int[2];
//        result = minimax(root, depth, true);
//
//        return (result[1]);
//    }
//
//    private void cloneList(ArrayList<Node> list_to, ArrayList<Node> list_from)
//    {
//        for (int i = 0; i < list_from.size(); i++)
//        {
//            list_to.add(list_from.get(i));
//        }
//    }
//
//    private int [] minimax(Node c_node, int depth, boolean maxPlayer)
//    {
//        int [] result = new int [2];
//        int bestScore=0;
//        int bestIndex=0;
//
//        if((depth==0) || c_node.isNextNull())
//        {
//            result[0] = c_node.getScore();
//            result[1] = c_node.getMove();
//            return (result);
//        }
//        else
//        {
//            if(maxPlayer)
//            {
//                bestScore=-1000;
//                bestIndex=0;
//                for(int i=0;i<c_node.getNext().size();i++)
//                {
//                    int[] temp=new int[2];
//                    temp[0] = -1000;
//                    temp[1] = 0;
//                    if (c_node.getNext().get(i) != null)
//                    {
//                        temp=minimax(c_node.getNext().get(i),depth-1,false);
//                    }
//                    if(bestScore<temp[0])
//                    {
//                        bestScore=temp[0];
//                        bestIndex=temp[1];
//                    }
//                }
//
//            }
//            else
//            {
//                bestScore=1000;
//                bestIndex=0;
//                for(int i=0;i<c_node.getNext().size();i++)
//                {
//                    int[] temp=new int[2];
//                    temp[0] = 1000;
//                    temp[1] = 0;
//                    if (c_node.getNext().get(i) != null)
//                    {
//                        temp=minimax(c_node.getNext().get(i),depth-1,true);
//                    }
//                    if(bestScore>temp[0])
//                    {
//                        bestScore=temp[0];
//                        bestIndex=temp[1];
//                    }
//                }
//
//            }
//        }
//        result[0]=bestScore;
//        result[1]=bestIndex;
//        return (result);
//    }
//
//}
