class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++) {
            // Arrays.fill() wont work since it takes same value and fills in every box
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // create set of values for rows
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                Character val = board[r][c];
                if('.' == val) continue;
                if(!rows[r].add(val)) return false;
                if(!cols[c].add(val)) return false;
                // find proper box index
                int boxIdx = 3 * (r/3) + c/3; // getBoxInd(r,c)
                if(!boxes[boxIdx].add(val)) return false;
            }
        }
        return true;
    }

    /*
    lets find a match for box index
    j / 3 gives 0, 1, 2 always
    so lets find i. if you draw box,
    0 1 2 (i>=0 && <=2) (0 + j/3)
    3 4 5 (i>=3 && <=5) (3 + j/3)
    6 7 8 (i>=6 && <=8) (6 + j/3)

    then box index 
        = multiple of 3 + j/3
        = 3 * (i/3) + j/3
    */
    private int getBoxInd(int i, int j) {
        if(i<=2) {
            if(j<=2) return 0;
            if(j<=5) return 1;
            if(j<=8) return 2;
        }
        if(i>=3 && i<=5) {
            if(j<=2) return 3;
            if(j<=5) return 4;
            if(j<=8) return 5;
        }
        if(i>=6 && i<=8) {
            if(j<=2) return 6;
            if(j<=5) return 7;
            if(j<=8) return 8;
        }
        return -1;
    }
}
