
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        // n == grid.length == grid[i].length
        // n == 2^x, 0 <= x <= 6
        return dfs(grid, 0, 0, n);
    }

    private Node dfs(int [][] grid, int xBegin, int yBegin, int length) {
        if (checkGrid(grid, xBegin, yBegin, length, 1)) return new Node(true, true);
        if (checkGrid(grid, xBegin, yBegin, length, 0)) return new Node(false, true);
        int nxtLength = length >> 1;
        Node topLeft = dfs(grid, xBegin, yBegin, nxtLength);
        Node topRight = dfs(grid, xBegin, yBegin + (nxtLength), nxtLength);
        Node bottomLeft = dfs(grid, xBegin + (nxtLength), yBegin, nxtLength);
        Node bottomRight = dfs(grid, xBegin + (nxtLength), yBegin + (nxtLength), nxtLength);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean checkGrid(int [][] grid, int xBegin, int yBegin, int length, int target) {
        for (int i = xBegin; i < xBegin + length; i++) {
            for (int j = yBegin; j < yBegin + length; j++) {
                if (grid[i][j] != target) return false;
            }
        }
        return true;
    }
}