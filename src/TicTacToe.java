
/**
 * @(#)TicTacToe.java
 *
 * TicTacToe application
 *
 * @author 
 * @version 1.00 2015/5/11
 */
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class TicTacToe {
    static String  Turn = "Now is your turn. Please choose number.";
    static char[][] grid = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    static ArrayList<Integer> x_choice = new ArrayList<Integer>();
    static ArrayList<Integer> y_choice = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    static int  input_err = 0;
 
 public static  void main(String[] args){ 
           // Solicit for a valid input value 
	       System.out.println(Turn);
	       while (true){
	    	     print_curren_grid();
    	         int input = get_input();
    	         if (!x_choice.contains(input)&& !y_choice.contains(input)&& 
    	        		 input>0 && input<10){
    	        	 y_choice.add(input);
    	        	 update_grid(input,0);
    	        	 if(jadge_who_win('O')==1)
    	      	     {
    	      		   print_curren_grid();
    	      		   break;
    	      	     }
    	        	 
    	        	 computer_choice();
                     if(jadge_who_win('X')==1)
    	      	     {
    	      		   print_curren_grid();
    	      		   break;
    	      	     }
                     if(x_choice.size()+y_choice.size()==9)
              	     {
              		   System.out.println("The Game End up in the tie\n");
              		   break;
              	     }
                     System.out.println(Turn);
    	         }
    	         else
    	        	 System.out.println("Your input is not valid. Please choose a grid "
    	        	 		+ "from 1-9 that has not been chosen yet");
	       }
    	   

    	   System.out.println("Game Over!");
}
      
 
 private static void print_curren_grid(){
  for(int i=0;i<3;i++){
   for(int j=0;j<3;j++){
    System.out.print(grid[i][j]);
   }
   System.out.print('\n');
  }
 }
 
 
 private static void update_grid(int in,int computer){
  
  int i = (in-1)/3;
  int j = in-i*3-1;
 
         if (computer==1)
          grid[i][j]='X';
         else
          grid[i][j]='O';
 }
 
 private static int jadge_who_win(char ch){
   if((grid[0][0]==ch)&&(grid[0][1]==ch)&&(grid[0][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }    
   }
   if((grid[1][0]==ch)&&(grid[1][1]==ch)&&(grid[1][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }     
   }
   if((grid[2][0]==ch)&&(grid[2][1]==ch)&&(grid[2][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }     
   }
   
   if((grid[0][0]==ch)&&(grid[1][0]==ch)&&(grid[2][0]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }     
   }
   if((grid[0][1]==ch)&&(grid[1][1]==ch)&&(grid[2][1]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }    
   }
   if((grid[0][2]==ch)&&(grid[1][2]==ch)&&(grid[2][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }
   }
   
   if((grid[0][0]==ch)&&(grid[1][1]==ch)&&(grid[2][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    
    }
   }
   
   if((grid[2][0]==ch)&&(grid[1][1]==ch)&&(grid[0][2]==ch))
   {
    if(ch=='X')
    {
     System.out.print("Coputer win!\n");
     return 1;
    }
    else
    {
     System.out.print("You win!\n");
     return 1;
    }
   }
  return 0;
 }
 
 private static int get_input(){
  return sc.nextInt();
 }
 
 private static int computer_choice(){
	 Random rm = new Random();
	 while(true){
		 int choose = rm.nextInt(9)+1;
		 if(!x_choice.contains(choose)&& !y_choice.contains(choose)){
			 update_grid(choose,1);
			 return choose;
		 }
	 }
 }
 
}
