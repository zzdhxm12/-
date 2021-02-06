import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20057 {
	static int[] dx = {-1,0,1,0}; // 좌하우상
	static int[] dy = {0,1,0,-1};
	static int[] p = {5,10,10,2,7,7,2,1,1};
	static int[][] px = {{-3,-2,-2,-1,-1,-1,-1,0,0,-2},{0,-1,1,-2,-1,1,2,-1,1,0},{3,2,2,1,1,1,1,0,0,2},{0,1,-1,2,1,-1,-2,1,-1,0}};
	static int[][] py = {{0,-1,1,-2,-1,1,2,-1,1,0},{3,2,2,1,1,1,1,0,0,2},{0,-1,1,-2,-1,1,2,-1,1,0},{-3,-2,-2,-1,-1,-1,-1,0,0,-2}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int len = 1;
		int cnt = 0;
		int dir = 0;
		int result = 0;
		// 시작 정점
		int nx = N/2 + 1;
		int ny = N/2 + 1;
		loop : while(true) {
			if(cnt == 2) {
				cnt = 0;
				len++;
			}
			
			for(int k=0;k<len;k++) {
				if(nx == 1 && ny == 1) break loop;
				int out = 0;
				for(int d=0;d<9;d++) {
					int per = (int) (map[ny+dy[dir]][nx+dx[dir]] * 0.01 * p[d]);
					out += per;
					if(nx + px[dir][d] > N || nx + px[dir][d] <= 0 || ny + py[dir][d] > N || ny + py[dir][d] <= 0) {
						result += per;
					} else {
						map[ny + py[dir][d]][nx + px[dir][d]] += per;
					}
				}
				int alpha = map[ny+dy[dir]][nx+dx[dir]] - out;
				if(nx + px[dir][9] > N || nx + px[dir][9] <= 0 || ny + py[dir][9] > N || ny + py[dir][9] <= 0) {
					result += alpha;
				} else {
					map[ny + py[dir][9]][nx + px[dir][9]] += alpha;
				}
				map[ny+dy[dir]][nx+dx[dir]] = 0;
				nx += dx[dir];
				ny += dy[dir];
			}
			
			dir++;
			if(dir == 4) dir = 0;
			cnt++;
		}
		System.out.println(result);
	}

}
