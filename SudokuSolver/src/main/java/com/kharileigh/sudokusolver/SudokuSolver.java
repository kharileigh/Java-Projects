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

    public static void main(String[] args) {
        
       // Game Board Layout - 2 Dimensional Integer Array (numbers taken from a sudoko game generator)
       int[][] board = {
           {7, 0 , 2, 0, 5, 0, 6, 0, 0},
           {0, 0, 0, 0, 0, 3, 0, 0, 0},
           {1, 0, 0, 0, 0, 9, 5, 0, 0},
           {8, 0, 0, 0, 0, 0, 0, 9, 0},
           {0, 4, 3, 0, 0, 0, 7, 5, 0},
           {0, 9, 0, 0, 0, 0, 0, 0, 8},
           {0, 0, 9, 7, 0, 0, 0, 0, 5},
           {0, 0, 0, 2, 0, 0, 0, 0, 0},
           {0, 0, 7, 0, 4, 0, 2, 0, 3}
       };
    }
}
