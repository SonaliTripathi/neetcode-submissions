class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int c=0;c<cols;c++){
            dfs(0,c,pac,heights);
            dfs(rows-1,c,atl,heights);
        }
        for(int r=0;r<rows;r++){
            dfs(r,0,pac,heights);
            dfs(r,cols-1,atl,heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

        public void dfs(int r, int c, boolean[][] oceans,
        int[][] heights){
             oceans[r][c]=true;
            for(int[] dir : directions){
                int nr= r+dir[0], nc=c+dir[1];
                if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length 
                && !oceans[nr][nc] && heights[nr][nc]>=heights[r][c]){
                    dfs(nr,nc,oceans,heights);
                }
            }
            
        }
    }

