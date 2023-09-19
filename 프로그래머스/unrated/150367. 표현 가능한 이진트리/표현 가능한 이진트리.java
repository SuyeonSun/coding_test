import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int tc=0; tc<numbers.length; tc++) {
            ArrayList<Integer> binList = new ArrayList<>();
            int[] resultBin;
            
            // 1. 이진수로 변환하기
            long num = numbers[tc];
            while(num > 0) {
                binList.add((int)(num % 2));
                num /= 2;
            }
            
            // 2. 이진트리의 개수에 맞도록 0을 앞에 붙이기
            int curLen = binList.size();
            
            // curLen 출력
            System.out.println("curLen: " + curLen);
            
            int resultLen = (int)Math.pow(2, 1) - 1;
            while(curLen > resultLen) {
                resultLen += 1;
                resultLen *= 2;
                resultLen -= 1;
            }
            System.out.println("resultLen: " + resultLen);
            
            int appendCnt = resultLen - curLen;
            for(int i=0; i<appendCnt; i++) {
                binList.add(0);
            }
            
            resultBin = new int[binList.size()];
            for(int i=binList.size()-1; i>=0; i--) {
                resultBin[binList.size()-1-i] = binList.get(i); 
            }
            
            int height = (int)(Math.log(resultLen+1) / Math.log(2));
            
            // 3. 가능한지 탐색

            int startIdx = resultLen / 2;
            
            if(resultBin[startIdx] == 0) {
                list.add(0);
            }
            else {
                if(find(resultBin, startIdx, height)) {
                    list.add(1);
                }
                else {
                    list.add(0);
                }
            }
            
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static boolean find(int[] arr, int startIdx, int height) {
        if(height <= 2) {
            if(arr[startIdx] == 1) {
                return true;
            }
            
            else if(arr[startIdx] == 0 && arr[startIdx-1] == 0 && arr[startIdx+1] == 0) {
                return true;
            }
            else {
                return false;
            }
        }        
        
        int gap = (int)Math.pow(2, height-2);
        
        if(arr[startIdx] == 0 && (arr[startIdx-gap] == 1 || arr[startIdx+gap] == 1)) {
            return false;
        }

        
        if(!find(arr, startIdx-gap, height-1)) return false;
        if(!find(arr, startIdx+gap, height-1)) return false;
        
        return true;
    }
}