
package tictactoe;

import java.util.Scanner;

//NAME: Ahmad Abraham
/* This program allows the user to play TicTacToe. 
Enter the number of the cell you wish to place your token. 
The token alternates between 'X' and 'O' after each turn.
*/

public class TicTacToe {
  
    public static void main(String[] args) {  
        //call method to create and print board
         char[][] board = createBoard();
         printBoard(board);
         
         //declared variables
         char token = 'X';
         int k = 1;
         boolean won = false;
         int cellNum = 0;
         
         //loop for each turn
         do {  
        
         board = placeToken(board, token, cellNum); 
         
         printBoard(board);
         
         if (k > 4) {
         won = checkWon(board);
         
         }
         
         if(token == 'X') {
          token = 'O';   
         }
         else if (token == 'O') {
         token = 'X';
         }
         
         k++;
         
         } while (k < 10 && won == false);
         
         
         //output if win or tie
         if(won == true && token == 'O') {
             System.out.println("X Won!");
         }
         if(won == true && token == 'X') {
             System.out.println("O Won!");
         }
         if (won == false) {
             System.out.println("Draw!");
         }
       
   
       
       
       
       
       
             
       
                
        } // end main
    
    //METHODS
    
    //create the board
    public static char[][] createBoard() {
     int row, col;
     
     char[][] board = new char[17][17];
     
       for (row = 0; row < 17; row++) {
          for (col = 0; col < 17; col++) {
           board[row][col] = ' ';
          }
       }
       
       //first horizontal line
       for (col = 0; col < 17; col++) {
           board[5][col] = '-';
       }
       
       //second horizontal line
       for (col = 0; col < 17; col++) {
           board[11][col] = '-';      
       }
       
       //first vertical line
       for (row = 0; row < 17; row++) {
           board[row][5] = '|';      
       }
       
       //second vertical line
       for (row = 0; row < 17; row++) {
           board[row][11] = '|';      
       }
       
       
       //numbers to place
       board[2][2] = '1';
       board[2][8] = '2';
       board[2][14] = '3';
       
       board[8][2] = '4';
       board[8][8] = '5';
       board[8][14] = '6';
       
       board[14][2] = '7';
       board[14][8] = '8';
       board[14][14] = '9';
     return board;
}
    
    //print the board
    public static void printBoard(char[][] board) {
    for ( int row = 0; row < 17; row++) {
       for ( int col = 0; col < 17; col++) {
           System.out.print(board[row][col]);
       }
           System.out.println();
       }
    }
    
    //place the token
    public static char[][] placeToken(char[][]board, char token, int cellNum) {
   Scanner scnr = new Scanner(System.in);
    System.out.println("Enter number of cell to place token: ");
    cellNum = scnr.nextInt();
    
    switch(cellNum) {
       case 1:
       board[2][2] = token;
       break;
       case 2:
       board[2][8] = token;
       break;
       case 3:
       board[2][14] = token;
       break;
       case 4:
       board[8][2] = token;
       break;
       case 5:
       board[8][8] = token;
       break;
       case 6:
       board[8][14] = token;
       break;
       case 7:
       board[14][2] = token;
       break;
       case 8:
       board[14][8] = token;
       break;
       case 9:
       board[14][14] = token;
       break;
       default:
           break;
    }
    return board;
  }
    

  //check if user won
  public static boolean checkWon(char[][]board) {
     boolean won = false;
    //horizontal win
    if (board[2][2] == board[2][8] && board[2][8] == board[2][14]) {
    won = true;
  }
    if (board[8][2] == board[8][8] && board[8][8] == board[8][14]) {
    won = true;
  }
    if (board[14][2] == board[14][8] && board[14][8] == board[14][14]) {
    won = true;
  }
    //vertical win
    if (board[2][2] == board[8][2] && board[8][2] == board[14][2]) {
    won = true;
  }
    if (board[2][8] == board[8][8] && board[8][8] == board[14][8]) {
    won = true;
  }
    if (board[2][14] == board[8][14] && board[8][14] == board[14][14]) {
    won = true;
  }
    // diagonal win
    if (board[2][2] == board[8][8] && board[8][8] == board[14][14]) {
    won = true;
  }
    if (board[2][14] == board[8][8] && board[8][8] == board[14][2]) {
    won = true;
  }
    return won;
}
     
    
    } // end class
    

