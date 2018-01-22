class numberOfIslands200 {
    
    class UnionFind{
        private int[] parent, size;
        
        public UnionFind(int n){
            
            parent = new int[n];
            size = new int[n];
            
            for (int i = 0; i < n; i++)
                parent[i] = i;

        }
        
        public int root(int i){
            while(i != parent[i]){
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            
            return i;
        }
        
        public void union(int p, int q){
            int proot = root(p);
            int qroot = root(q);
            
            if (proot == qroot)
                return;
            if (size[proot] > size[qroot]){
                parent[qroot] = proot;
                size[proot] += size[qroot];
            }
            else{
                parent[proot] = qroot;
                size[qroot] += size[proot];
            }
            
            
        }
        
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        UnionFind myUF = new UnionFind(row*col);
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i < row - 1){
                    if(j < col - 1){
                        // check right
                        if (grid[i][j] == '1' && grid[i][j+1] == '1')
                            myUF.union(i*col+j, i*col+j+1);
                        // check below 
                        if (grid[i][j] == '1' && grid[i+1][j] == '1')
                            myUF.union(i*col+j, (i+1)*col+j);
                    }
                    else{
                        // check below
                        if (grid[i][j] == '1' && grid[i+1][j] == '1')
                            myUF.union(i*col+j, (i+1)*col+j);
                    }
                }
                else{
                    if(j < col - 1){
                        // check right
                        if (grid[i][j] == '1' && grid[i][j+1] == '1')
                            myUF.union(i*col+j, i*col+j+1);
                    }   
                }        
            }
        }
        
        int[] count = new int[row*col];
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '1')
                    count[myUF.root(i*col+j)] ++;
            }
        }
        
        int total = 0;
        for (int i = 0; i < row*col; i++)
            if (count[i] > 0)
                total ++;
        return total;
        
    }
}