class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] ChkRow = new HashSet[9];
        Set<Character>[] ChkCol = new HashSet[9];
        Set<Character>[] ChkBox = new HashSet[9];
        int boxIndex;

        for(int i=0;i<9;i++){
            ChkRow[i] = new HashSet<>();
            ChkCol[i] = new HashSet<>();
            ChkBox[i] = new HashSet<>();
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boxIndex = (i/3)*3 + (j/3);
                if(board[i][j] != '.'){
                    if(!ChkRow[i].add(board[i][j]) || !ChkCol[j].add(board[i][j]) || !ChkBox[boxIndex].add(board[i][j])){
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
