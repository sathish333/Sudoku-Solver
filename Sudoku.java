import java.io.*;
import java.util.*;
class Sudoku
{
	public static void main(String[] args) throws IOException{

		int board[][]=new int[9][9]; 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line[];
		for(int i=0;i<9;i++)
		{
			line=br.readLine().split(" ");
			for(int j=0;j<9;j++)
				board[i][j]=Integer.parseInt(line[j]);

		}
		solve(board);
		printSolution(board);
	}

	public static boolean solve(int board[][])
	{
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				if(board[row][col]==0)
				{
					//try 1 through 9 
					for(int k=1;k<=9;k++)
					{
						if(isValid(board,row,col,k))
						{
							board[row][col]=k;
							if(solve(board))//return true if it's solution else go back and replace with 0
								return true;
							else
								board[row][col]=0;	

						}
					}
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isValid(int board[][],int row,int col,int k)
	{
		for(int i=0;i<9;i++)
		{
			if(board[row][i]==k)//check if there is any repetition in row
				return false;
			if(board[i][col]==k)////check if there is any repetition in column
				return false;
			if(board[3*(row/3)+i/3][3*(col/3)+i%3]==k)//check if there is any repetition in 3*3 block
				return false;
		}
		return true;
	}
	public static void printSolution(int board[][])
	{
		System.out.println("solution is");
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				System.out.print(board[row][col]+" ");
			}
			System.out.println();
		}
	}
}