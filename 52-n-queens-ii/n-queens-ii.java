class Solution {
    public int totalNQueens(int n) {
        return help(n, 0, 0, 0, 0);
    }

    int help(int n, int r, int column, int posDig, int negDig){
        if(r == n) return 1;
        int ans = 0;
        for(int c = 0; c < n; c++){
            int colMask = 1<<c;
            int posMask = 1<<(r - c);
            int negMask = 1<<(r + c);
            if((colMask & column) == 0 && (posMask & posDig) == 0 && (negMask & negDig) == 0){
                column ^= colMask;
                posDig ^= posMask;
                negDig ^= negMask;
                ans += help(n, r+1, column, posDig, negDig);
                column ^= colMask;
                posDig ^= posMask;
                negDig ^= negMask;
            }
        }
        return ans;
    }
}