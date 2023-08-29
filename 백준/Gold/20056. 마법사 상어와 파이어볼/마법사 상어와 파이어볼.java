import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[][] dir = {
			{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
			{1, 0}, {1, -1}, {0, -1}, {-1, -1}
	};
	
	static class Fire{
		int r, c, m, d, s;
		
		Fire(int r, int c, int m, int s, int d){
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
		void moveFire() {
			r = (r+dir[d][0]*(s%N)+N)%N;
			c = (c+dir[d][1]*(s%N)+N)%N;
		}
	}
	
	static int N, M, K;
	static LinkedList<Fire> ball = new LinkedList<>();
	static ArrayList<Fire>[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N][N];
		int total = 0;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			ball.offer(new Fire(r,c,m,s,d));
			total += m;
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int k = 0; k<K; k++) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					map[i][j].clear();
				}
			}
			
			for (Fire f : ball) {
				f.moveFire();
				map[f.r][f.c].add(f);
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					ArrayList<Fire> temp = map[i][j];
					int size = temp.size();
					if(temp.size()<=1) continue;
					int m = 0, s = 0, d;
					int ocnt = 0, ecnt = 0;
					for (Fire fire : temp) {
						m+=fire.m;
						s+=fire.s;
						if(fire.d%2 == 0) ecnt++;
						else ocnt++;
						ball.remove(fire);
					}
					total -= m;
					m /= 5;
					s /= size;
					if(ocnt == 0 || ecnt == 0) d = 0;
					else d = 1;
					if(m <= 0) continue;
					for(int f = 0; f<4; f++) {
						ball.offer(new Fire(i, j, m, s, d+f*2));
					}
					total += 4*m;
				}
			}
		}
		
		System.out.println(total);
		
	}

}