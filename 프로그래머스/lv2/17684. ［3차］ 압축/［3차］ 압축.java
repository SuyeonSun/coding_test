import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> al = new ArrayList<>();
        String w ="";
        String c="";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1;i<=26;i++){
            String temp = (char)('A'+(i-1))+"";
            map.put(temp, i);
        }
        
        for(int i=0;i<msg.length();){
            w = msg.charAt(i)+"";
            
            for(int j=i+1;j<msg.length();j++){
                w+=msg.charAt(j);
                if(!map.containsKey(w)){
                    c = msg.substring(j,j+1);
                    w = w.substring(0,w.length()-1);
                    break;
                }
                
            }
            i+=w.length();
            al.add(map.get(w));
            if(c.length()>0){
                String s = w+c;
                map.put(s,map.size()+1);
            }
        }
        answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}