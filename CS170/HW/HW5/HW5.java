//Joseph Barbati - jdbarba
//Section 004
//Worked by myself, consulted class notes on selection sort
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class HW5 {
    //You will see some hard code, I though this was safe because this code is
    //used for sudoku which is always a 9x9 board
    /**
     * Builds a 2D array from a file containing a 9x9 grid of ints
     * @param grid 2D array to be filled with numbers file
     * @param fileName name of file to be scanned (CLA)
     */
    public static void boardFromFile(int[][] grid, String fileName)
    throws IOException {
        File sudokuFile = new File(fileName);
        Scanner readFile = new Scanner(sudokuFile);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                grid[i][j] = readFile.nextInt();
            }
        }
    }
    /**
     * Clones array and sorts the rows in ascending order
     * @param grid is the 2D array that represents the sudoku board
     * @param row is the row to be sorted
     * @return returns the sorted row after cloning it
     */
    //helper method
    public static int[] selectionSortRow(int[][] grid, int row) {
        //the followng loop system clones the selected row of grid array
        row -= 1;
        int[] sortThis = new int[9];
        for(int i = 0; i < grid[row].length; i++) {
            sortThis[i] = grid[row][i];
        }
        //the following code selection sorts the array
        for (int i = 0; i < sortThis.length - 1; i++) {
            int position = i;
            for (int j = i + 1; j < sortThis.length; j++) {
                if (sortThis[j] < sortThis[position]) {
                    position = j;
                }
            }
            int temp = sortThis[i];
            sortThis[i] = sortThis[position];
            sortThis[position]= temp;
        }
        return sortThis;
    }
    /**
     * Checks row to see if it is a valid row by the rules of sudoku
     * @param grid a 2D array representing the sudoku board
     * @param row integer that represents the row number to be checked
     * @return returns true of the specified row is valid, false otherwise
     */
    public static boolean isValidRow(int[][] grid, int row) {
        int[] tempArray = selectionSortRow(grid, row);
        for(int i = 0; i < tempArray.length - 1; i++) {
            if(tempArray[i] == tempArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /**
     * sorts the selected column by selection sorting
     * @param grid the 2D array that is the sudoku board
     * @param col the selected column to be sorted
     * @return returns a clone 1D array of the selected column
     */
    public static int[] selectionSortCol(int[][] grid, int col) {
        //the following code clones the col specified into an array
        col -= 1;
        int[] sortThis = new int[9];
        for(int i = 0; i < 9; i++) {
            sortThis[i] = grid[i][col];
        }
        //the following code bubble sorts the columns of the array
        //the folling code doesn't sort properly, find a way to fix this, should
        //be easy, similar to regular array sorting (non 2D)
        for (int i = 0; i < 9; i++) {
            int position = i;
            for (int j = i + 1; j < 9; j++) {
                if (sortThis[j] < sortThis[position]) {
                    position = j;
                }
            }
            int temp = sortThis[i];
            sortThis[i] = sortThis[position];
            sortThis[position]= temp;
        }
        return sortThis;
    }
    /**
     * Checks to see if the column is a valid column based on the rules of sudoku
     * @param grid 2D array of the sudoku board
     * @param column selected column to be checked
     * @return returns true if the column follows the rules of sudoku, false
     * otherwise
     */
    public static boolean isValidColumn(int[][] grid, int column) {
        int[] tempArray = selectionSortCol(grid, column);
        for(int i = 0; i < tempArray.length - 1; i++) {
            if(tempArray[i] == tempArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /**
     * puts each subboard into a 1D array and sorts array by selection sort
     * @param grid 2D array representing the sudoku board
     * @param subNumber number of subboard to be placed in 1D array
     * @return return the 1D array with the elements from the selected subboard
     */
    public static int[] selectionSortSub(int[][] grid, int subNumber) {
        //building array to be sorted
        int[] sortThis = new int[9];
        int i = 0;
        int k = 0;
        if (subNumber == 1) {
            i = 0;
            k = 0;
        } else if (subNumber == 2) {
            i = 0;
            k = 3;
        } else if (subNumber == 3) {
            i = 0;
            k = 6;
        } else if (subNumber == 4) {
            i = 3;
            k = 0;
        } else if (subNumber == 5) {
            i = 3;
            k = 3;
        } else if (subNumber == 6) {
            i = 3;
            k = 6;
        } else if (subNumber == 7) {
            i = 6;
            k = 0;
        } else if (subNumber == 8) {
            i = 6;
            k = 3;
        } else if (subNumber == 9) {
            i = 6;
            k = 6;
        }
        for(int x = i; x < i + 3; x++) {
            for(int j = k; j < k + 3; j++) {
                if (subNumber == 1 || subNumber == 4 || subNumber == 7) {
                    if (sortThis[2] == 0) {
                        sortThis[j] = grid[x][j];
                    } else if (sortThis[5] == 0) {
                        sortThis[j + 3] = grid[x][j];
                    } else if (sortThis[8] == 0) {
                        sortThis[j + 6] = grid[x][j];
                    }
                } else if (subNumber == 2 || subNumber == 5 || subNumber == 8) {
                    if (sortThis[2] == 0) {
                        sortThis[j - 3] = grid[x][j];
                    } else if (sortThis[5] == 0) {
                        sortThis[j] = grid[x][j];
                    } else if (sortThis[8] == 0) {
                        sortThis[j + 3] = grid[x][j];
                    }
                } else if (subNumber == 3 || subNumber == 6 || subNumber == 9) {
                    if (sortThis[2] == 0) {
                        sortThis[j - 6] = grid[x][j];
                    } else if (sortThis[5] == 0) {
                        sortThis[j - 3] = grid[x][j];
                    } else if (sortThis[8] == 0) {
                        sortThis[j] = grid[x][j];
                    }
                }
            }
        }
        //sorting array after building it
        //use x instead of i in outside loop because it's already defined above
        for (int x = 0; x < 9; x++) {
            int position = x;
            for (int j = x + 1; j < 9; j++) {
                if (sortThis[j] < sortThis[position]) {
                    position = j;
                }
            }
            int temp = sortThis[x];
            sortThis[x] = sortThis[position];
            sortThis[position]= temp;
        }
        return sortThis;
    }
    /**
     * Checks to see if the selected subboard is valid based on rules of sudoku
     * @param grid 2D array of the sudoku baord
     * @param subboard selected subboard to be checked
     * @return returns true if subboard is valid, false otherwise
     */
    public static boolean isValidSubboard(int[][] grid, int subboard) {
        int[] tempArray = selectionSortSub(grid, subboard);
        for(int i = 0; i < tempArray.length - 1; i++) {
            if (tempArray[i] == tempArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method checks to see if the entire board is valid
     * @param grid is the 2D array of the sudoku board
     * @return returns true if the board is valid, false otherwise
     */
    public static boolean isValidBoard(int[][] grid) {
        boolean valid = false;
        for(int i = 1; i <= 9; i++) {
            if (isValidRow(grid, i)) {
                valid = true;
            } else {
                valid = false;
//                System.out.print("Row " + i + " is invalid! ");
                break;
            }
            if(isValidColumn(grid, i)) {
                valid = true;
            } else {
                valid = false;
//                System.out.print("Column " + i + " is invalid! ");
                break;
            }
            if(isValidSubboard(grid, i)) {
                valid = true;
            } else {
                valid = false;
//                System.out.print("Subboard " + i + " is invalid! ");
                break;
            }
        }
        return valid;
    }
    
    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args.length > 1) {
            System.out.println("Usage: java HW5 fileName(or path to file)");
        } else {
            int[][] sudokuArray = new int[9][9];
            boardFromFile(sudokuArray, args[0]);
            for(int i = 0; i < sudokuArray.length; i++) {
                for(int j = 0; j < sudokuArray[i].length; j++) {
                    System.out.print(sudokuArray[i][j] + " ");
                }
                System.out.println();
            }
            System.out.print("Is the board a valid board? ");
            System.out.println(isValidBoard(sudokuArray));

        }
    }
}