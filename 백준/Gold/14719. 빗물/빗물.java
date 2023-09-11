import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    
	    int H = Integer.parseInt(st.nextToken());
	    int W = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(in.readLine());
	    int[] height = new int[W];
	    for (int i = 0; i < W; i++) {
	    	height[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 고인 빗물 합
	    int rain = 0;
	    
	    // 각 인덱스에 해당하는 빗물 구하기
	    for (int i = 1; i < W-1; i++) { // 첫번째와 마지막 인덱스는 빗물이 고일 수 없다.
	    	int leftHeight= 0 ;
	    	int rightHeight = 0;
	    	
	    	// 현재 인덱스 기준 왼쪽 최고 높이 찾기
	    	for (int j = 0; j < i; j++) {
	    		leftHeight = Math.max(height[j], leftHeight);
	    	}
	    	
	    	// 현재 인덱스 기준 오른쪽 최고 높이 찾기
	    	for (int j = i+1; j < W; j++) {
	    		rightHeight = Math.max(height[j], rightHeight);
	    	}
	    	
	    	// 조건1: 빗물이 고이기 위해선 현재 인덱스의 높이가 왼쪽, 오른쪽 최고 높이보다 낮아야 한다.
	    	// 조건2: 빗물은 왼쪽, 오른쪽 중 최소 높이만큼 찬다.
	    	if (height[i] < leftHeight && height[i] < rightHeight) {
	    		rain += Math.min(leftHeight, rightHeight) - height[i];
	    	}
	    }
	    
	    System.out.println(rain);
	}

}