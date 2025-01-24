package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1697 {
    static int[] visited = new int[100001];

    static int bfs(int subinLocation, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subinLocation);
        visited[subinLocation] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            // 동작이 3개이므로
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = temp - 1;
                } else if (i == 1) {
                    next = temp + 1;
                } else {
                    next = 2 * temp;
                }

                if (next == K) {
                    return visited[temp];
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write("0\n");
        } else {
            bw.write(bfs(N, K) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}