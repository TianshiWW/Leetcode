
//dfs

class Solution {
     
    int[] coorX = {-1,0,0,1};
    int[] coorY = {0,1,-1,0};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid); 
                }
            }
        }
        return count;
    }
    
    private void dfs(int x, int y, char[][] grid) {
        
        if (!isValid(x,y,grid)) {
            return;
        }
        grid[x][y] = '0';
        
        for(int i = 0; i < 4; i++) {
            int nextX = x + coorX[i];
            int nextY = y + coorY[i];
            dfs(nextX,nextY,grid); 
            
        }
        return;
        

//         grid[x][y] = '0';
        
//         for(int i = 0; i < 4; i++) {
//             int nextX = x + coorX[i];
//             int nextY = y + coorY[i];
//             if(isValid(nextX,nextY,grid)) {
//                  dfs(nextX,nextY,grid);    
//             } 
//         }
//         return;
    }
    
    private boolean isValid(int x, int y, char[][] grid) {
        if (x>= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '0') {
            return true;
        }
        return false; 
    }
}



// bfs
class Solution {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }        
    int[] coorX = {-1,0,0,1};
    int[] coorY = {0,1,-1,0};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 0) {
           return 0; 
        }
        int count = 0;  
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Queue<Point> q = new LinkedList<>();
                    count++;
                    Point p = new Point(i,j);
                    q.offer(p);
                    while (!q.isEmpty()) {
                        Point curr = q.poll();
                        grid[curr.x][curr.y] = '0';
                        for(int k = 0; k < 4; k++) {
                            int nextX = curr.x + coorX[k];
                            int nextY = curr.y + coorY[k];
                            if (!isValid(nextX,nextY,grid)) {
                                continue;
                            }
                            if(grid[nextX][nextY] == '1') {
                                grid[nextX][nextY] = '0';
                                q.add(new Point(nextX,nextY));
                            }
                        }
                    }
                }
            }
        } 
        return count;
    }
    
    private boolean isValid(int x, int y, char[][] grid) {
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '0') {
            return true;
        }
        return false;
    }
}