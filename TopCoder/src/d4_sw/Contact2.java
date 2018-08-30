package d4_sw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Contact2 {
 
    static int map[][];
    static int CONNECT = 1;
    static boolean visited[];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            map = new int[101][101];
            visited = new boolean[101];
            Queue<Integer> q = new LinkedList<>();
            int len = sc.nextInt();
            int start = sc.nextInt();
            q.add(start);
            for (int i = 0; i < len / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                map[from][to] = CONNECT;
            }
            Queue<Integer> sub = null;
            while (!q.isEmpty()) {
                int qsize = q.size();
                sub = new LinkedList<>();
                // Level queue
                for (int i = 0; i < qsize; i++) {
                    int cur = q.poll();
                    sub.add(cur);
                    visited[cur] = true;
                    for (int j = 0; j < 100; j++) {
                        if (map[cur][j] != 0 && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
                if (!q.isEmpty()) {
                    sub.clear();
                } else {
                    break;
                }
            }
            int ret = 0;
            int length = sub.size();
            while (!sub.isEmpty()) {
                int tmp = sub.poll();
                if (ret < tmp) {
                    ret = tmp;
                }
            }
            System.out.println("#" + t + " " + ret);
        }
    }
}