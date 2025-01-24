package bfs_dfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DFS {
    static BufferedWriter bw;

    // DFS 메소드
    public static void dfs(String [] vertex, int[][] edge, int start, boolean[] visit) throws IOException {
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        visit[start] = true;
        bw.write(String.valueOf(vertex[start]));
        bw.flush();

        for (int next= 0; next<vertex.length; next++) {
            if (edge[start][next] != 0 && !visit[next]) {
                dfs(vertex, edge, next, visit);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] vertex = {"A", "B", "C", "D", "E"};
        boolean[]visited= new boolean[vertex.length];
        for(int i = 0; i<= vertex.length-1 ; i++){
            visited[i]= false;
        }
        int[][] edge = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };
        dfs(vertex, edge, 0, visited);

    }
}
