/**
 *
 * @author kharileigh
 * SUDOKU SOLVER TUTORIAL by YouTuber Coding With Jon
 * 
 * What is Sudoku?
 * 9 by 9 grid of numbers, split out into nine 3 by 3 squares
 * Must fill out the grid with numbers between 1 and 9 
 * 
 * Rules of the Game :
 * Each row, each column and each 3 by 3 square must contain all numbers between 1 through 9
 * Can't have the same number twice in any given row, column of 3 by 3 square
 * 
 */

package com.kharileigh.sudokusolver;

public class SudokuSolver {
    
    // Global Constant - represents grid size, set to 9 to be used frequently in algorithm
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        
        
       // Game Board Layout - 2 Dimensional Integer Array (numbers taken from a sudoko game generator)
       // int [row][column]
       int[][] board = {
           
           {0, 1, 0, 0, 4, 6, 2, 7, 9},
           {0, 0, 7, 1, 8, 3, 0, 5, 4},
           {0, 0, 0, 9, 7, 0, 0, 3, 1},
           {7, 5, 0, 0, 0, 4, 1, 0, 6},
           {0, 0, 0, 0, 0, 8, 0, 0, 0},
           {0, 0, 0, 2, 1, 0, 7, 0, 0},
           {0, 7, 6, 0, 5, 0, 0, 1, 0},
           {5, 0, 3, 0, 0, 0, 4, 6, 7},
           {0, 8, 1, 0, 3, 0, 9, 0, 5}
           
       };
       
       
       // Print Initial Game Board
       printBoard(board);
       
       /** Calls Recursive Method
           true - solved board successfully
           false - initial board entered was not a valid board
        */
       if (solveBoard(board)) {
           
           System.out.println("\n Solved successfully! \n ");
        
       } else {
       
           System.out.println("\n Unsolvable board :( \n");
       }
       
       // Print Solved Board
       printBoard(board);
       
    }
    
    
    
    
    /** HELPER METHODS
    used to see if number already exists in the Row, Column  or 3 by 3 Grid (Boolean to return true if it exists)
    ----------------------------------------------------------------------------------------------------------------
    -- ROW & COLUMN --
    For Loop [BASE CASE] :
    * starts at index 0, continues iterating as long as its less than constant GRID_SIZE
    * 
    If Statement [WORK TOWARDS BASE CASE] : 
    * if board holds the number being checked in row that was passed in at the current column of i, return true - EXIT PROGRAM
    * else false - recursively call until checked all numbers and number is not found
    **/
    
    
    
    /** ROW
    ----------------------------------------------------------------------------------------------------------------
    Parameters : 
    * board itself [row - passed in][column - currently being iterated through]
    * number being checked in Row
    * row number itself (0-8 as dealing with array indexes)
    **/
    private static boolean isNumberInRow(int[][] board, int number, int row) {
        
        for (int i = 0; i < GRID_SIZE; i++) {
            
            if (board[row][i] == number) {
            
                return true;
            }
        }
        return false;
        
    }
    
    
    /** COLUMN
    ----------------------------------------------------------------------------------------------------------------
     Parameters : 
     * board itself [row - currently being iterated through][column - passed in]
     * number being checked in Column
     * column number itself (0-8 as dealing with array indexes)
     */
    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        
        for (int i = 0; i < GRID_SIZE; i++) {
            
            if (board[i][column] == number) {
            
                return true;
            }
        }
        return false;
        
    }
    
    
    /** 3 by 3 GRID
    ----------------------------------------------------------------------------------------------------------------
     Parameters :
     * board itself [][]
     * number being checked in Grid
     * row & column itself - to get exact coordinates of the number that was passed in
     
     Variables :
     * localGridRow & localGridColumn = formula to get any Grid on Board, divides given number by 3 then returns remainder
     
     For Loop [BASE CASE] :
     * loops through 3 by 3 Grid both rows & columns
     
     If Statement [WORK TOWARDS BASE CASE] :
     * check if number at row i & column j during each iteration
     */
    private static boolean isNumberInGrid(int[][] board, int number, int row, int column) {
        
        int localGridRow = row - row % 3;
        int localGridColumn = column - column % 3;
        
        for (int i = localGridRow; i < localGridRow + 3; i++) {
            
            for (int j = localGridColumn; j < localGridColumn + 3; j++) {
            
                if (board[i][j] == number) {
                
                    return true;
                }
            }
        }
        return false;
    }
  
    
    /** CHECKS ALL - ROW, COLUMN & 3 by 3 GRID
    ----------------------------------------------------------------------------------------------------------------
     * one method that calls all 3 previous methods to see if a certain placement is valid
     * FALSE - it is a valid placement of a number, meaning number is not currently in a row, column or grid
     
     Parameters :
     * board itself 
     * number passed in
     * row & column - coordinates being passed in
     */
    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInGrid(board, number, row, column);
    
    }
    
    
    /** RECURSIVE / BACKTRACKING METHOD TO MAKE SUDOKU GAME WORK
    ----------------------------------------------------------------------------------------------------------------
     For Loop 
     * traverse board row by row
     
     If Statement
     * if doesn't have a number in it, check if number between 1-9 is valid to enter here
     * if valid, number is entered and process will start over recursively
     * continues until entire grid is filled with a valid moves
     
     RECURSIVE CALL : looping through whole grid to find place where number is not populated yet
     BACKTRACKING [move to get closer to base case]: if completes loop and number is not valid, backtrack to previous number and keep trying other numbers to get closer to solving the board
     BASE CASE : 
     */
    private static boolean solveBoard(int[][] board) {
    
        for (int row = 0; row < GRID_SIZE; row++) {
        
            for (int column = 0; column < GRID_SIZE; column++) {
            
                // if current coordinates are empty, try a number & check if its a valid placement using previous method
                // iteration starts at 1, ends at 9
                if (board[row][column] == 0) {
                
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                    
                        if (isValidPlacement(board, numberToTry, row, column)) {
                        
                            board[row][column] = numberToTry;
                            
                            // RECURSIVE CALL
                            if (solveBoard(board)) {
                                
                                // if recursive call succeeds, rest of board will be filled out successfully
                                return true;
                                
                            // BACKTRACKING : 
                            // if current recurive call returns false, clear out numberToTry, set as empty for next recurive call 
                            } else {
                            
                                board[row][column] = 0;
                            
                            }
                        }
                    }
                    // means could not solve board successfully
                    return false;
                }
            }
        }
        // solved board successfully
        return true;
    }
    
    
    
    /** PRINTS BOARD
    ----------------------------------------------------------------------------------------------------------------
     */
    private static void printBoard(int[][] board) {
    
        for (int row = 0; row < GRID_SIZE; row++) {
            
            // FOR EVERY 3RD ROW, EXCEPT TOP ONE - INSERT LINE
            if(row % 3 == 0 && row != 0) {
            
                System.out.println("---------------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                
                // FOR EVERY 3RD COLUMN, EXCEPT TOP ONE - INSERT LINE
                if(column % 3 == 0 && column != 0) {

                    System.out.print(" | ");
                }
                // PRINTS OUT NUMBERS IN CURRENT ROW & COLUMN
                System.out.print(board[row][column]);
            }
            // prints each row on a new line
            System.out.println();
        }
    }
    
}
