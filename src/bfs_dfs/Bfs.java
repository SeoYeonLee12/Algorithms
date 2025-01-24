package bfs_dfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    static BufferedWriter bw;

    public static void main(String[] args) {

    }

    public static void BFS(int[] vtx, List<List<Integer>> adjList, int start) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int vtxLen = vtx.length;

        // 방문여부를 체크하는 배열 → false로 초기화
        boolean visted[] = new boolean[vtxLen];
        for(int i = 0; i < visted.length; i++){
            visted[i] = false;
        }

        // 방문을 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 시작 정점을 삽입하고, 해당 정점을 true로 변경
        queue.offer(start);
        visted[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            bw.write(vtx[current] + " "); // 현재 노드 출력

            // 현재 노드의 인접 리스트를 가져옴
            for(int neighbor : adjList.get(current)){
                if(!visted[neighbor]){
                    queue.offer(neighbor);
                    visted[neighbor] = true;
                }

            }
        }

    }



}
