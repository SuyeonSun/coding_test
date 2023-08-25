import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;
		
		Shark(int r, int c, int s, int d, int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			if(this.r < o.r) {
				return this.r-o.r;
			}
			else if(this.r == o.r) {
				return this.c-o.c;
			}
			else return this.r-o.r;
		}
		
		boolean winShark(Shark o) {
			return this.z > o.z;
		}
		
		void moveShark() {
			int move = s;
			while(move-- > 0) {
				int nr = r+direction[d][0];
				int nc = c+direction[d][1];
				if(!isPossible(nr, nc)) {
					d = 3-d;
					r = r+direction[d][0];
					c = c+direction[d][1];
				}
				else {
					r = nr;
					c = nc;
				}
//				System.out.print("sharkmove");
//				System.out.println(r+" "+c);
			}
		}
	}
	
	static boolean isPossible(int r, int c) {
		if(r <= 0 || r > R || c<= 0 || c > C) return false;
		return true;
	}
	
	static int R, C, S;
	static ArrayList<ArrayList<ArrayList<Shark>>> sea;
	static int[][] direction = {
			{-1, 0}, {0, -1}, {0, 1}, {1, 0} 
	};
	static ArrayList<Shark> shark;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		shark = new ArrayList<>();
		for(int i = 0; i<S; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			switch(d) {
			case 1:
				d = 0;
				s = s%(2*R-2);
				break;
			case 2:
				d = 3;
				s = s%(2*R-2);
				break;
			case 3:
				d = 2;
				s = s%(2*C-2);
				break;
			case 4:
				d = 1;
				s = s%(2*C-2);
				break;
			}
			shark.add(new Shark(r,c,s,d,z));
		}
		
		int total = 0;
		sea = new ArrayList<>();
		for(int c = 1; c<=C; c++) {
			int getcha = -1;
			for(int j = 0; j<shark.size(); j++) {
				if(shark.get(j).c == c) {
					if(getcha == -1) {
						getcha = j;
					}
					else {
						getcha = shark.get(getcha).r < shark.get(j).r? getcha:j; 
					}
				}
			}
			
			if(getcha != -1) {
				total += shark.remove(getcha).z;
			}
			
//			System.out.println("잡았다");
			
			sea.clear();
			
			for(int i = 0; i<=R; i++) {
				sea.add(new ArrayList<>());
				for(int j = 0; j<=C; j++) {
					sea.get(i).add(new ArrayList<>());
				}
			}
			
			for(int i = 0; i<shark.size(); i++) {
				shark.get(i).moveShark();
//				System.out.println(shark.get(i).r +" "+ shark.get(i).c);
				sea.get(shark.get(i).r).get(shark.get(i).c).add(shark.get(i));
			}
//			System.out.println("C= " + c);
			
//			System.out.println("움직였다");
			for(int i = 1; i<=R; i++) {
				for(int j = 1; j<=C; j++) {
					ArrayList<Shark> temp = sea.get(i).get(j);
					if(temp.size() <= 1) continue;
					Shark strong = temp.get(0);
					for(int idx = 1; idx <temp.size(); idx++) {
						Shark t = temp.get(idx);
						if(t.z > strong.z) {
							shark.remove(strong);
							strong = t;
						}
						else {
							shark.remove(t);
						}
					}
				}
			}
//			for (int i = 0; i<shark.size(); i++) {
//				System.out.println(shark.get(i).r+ " " +shark.get(i).c);
//			}
//			System.out.println();
		}
		System.out.println(total);
	}

}