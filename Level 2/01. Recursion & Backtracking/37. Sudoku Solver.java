class Solution {
    
    public boolean isSudokuValid(char[][] board, int row, int col, char ch){
        // row element
        for(int j=0; j<9; j++){
            if(board[row][j] == ch){
                return false;
            }
        }
        
        // column element
        for(int i=0; i<9; i++){
            if(board[i][col] == ch){
                return false;
            }
        }
        
        int crow = (row / 3) * 3;
        int ccol = (col / 3) * 3;
        
        // submatrix element
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i + crow][j + ccol] == ch){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean solveSudoku(char[][] board, int row, int col){
        if(row == 9) return true; 
        // positive base case -> all boxes are filled
        
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;
        
        if(board[row][col] != '.'){
            // already filled
            boolean res = solveSudoku(board, nextRow, nextCol);
            if(res == true) return true;
            
        } else {
            
            // empty fill -> explore all valid options
            for(int i=1; i<=9; i++){
                if(isSudokuValid(board, row, col, (char)(i + '0')) == true){
                    board[row][col] = (char)(i + '0');
                    boolean res = solveSudoku(board, nextRow, nextCol);
                    if(res == true) return true;
                    
                    board[row][col] = '.';
                }
            }
            
        }
        
        return false; // sudoku is not solvable
    }
    
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }
}
