package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N12851 {

    static int[] visited= new int[100001];
    static int count;
    static int minTime = Integer.MAX_VALUE;

    public static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

       while(!queue.isEmpty()){
           int temp= queue.poll();

           // 현재 탐색 시간이 이미 최소 시간보다 크면 탐색 중단.
           if(minTime < visited[temp]){
               return;
           }

           for(int i= 0; i < 3; i++){
               int next = 0;
               if(i == 0){
                   next = temp-1;
               }
               if(i == 1){
                   next = temp+1;
               }
               if(i == 2){
                   next = temp*2;
               }

               if (next < 0 || next >= visited.length) {
                   continue;
               }

               if(next == end){
                   minTime= visited[temp];
                   count++;
               }

                // 방문하지 않은 점+
               if(visited[next]==0 || visited[next]==visited[temp]+1){
                   queue.add(next);
                   visited[next]= visited[temp]+1;
               }

           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K){
            bw.write(String.valueOf((N-K)));
            bw.newLine();
            bw.write(String.valueOf(1));

            bw.flush();
            bw.close();
            br.close();
            return;
        }
        bfs(N, K);

        bw.write(String.valueOf(minTime));
        bw.newLine();
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}
