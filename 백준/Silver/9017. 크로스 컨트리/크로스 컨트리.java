import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 한 팀 : 6명
        // 팀 점수: 상위 네명의 점수 합
        // 우승: 가장 낮은 점수 얻는 팀
        // if 여섯 명의 주자가 참가하지 못한 팀은 점수 계산에서 제외
        // if 동점의 경우에는 다섯 번째 주자의 점수가 낮은 팀이 우승

        // T 테스트 케이스 수
        // 데이터의 수
        // 데이터

        // 입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[2][N+1];
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 1; i < N+1; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
                if (hashMap.get(arr[0][i]) == null) {
                    hashMap.put(arr[0][i], 1);
                } else {
                    int cnt = hashMap.get(arr[0][i]);
                    hashMap.put(arr[0][i], cnt+1);
                }
            }

            // hashMap : 6이하인 팀 확인
            int score = 1;
            for (int i = 1; i < N+1; i++) {
                if (hashMap.get(arr[0][i]) < 6) {
                    arr[1][i] = -1;
                } else {
                    arr[1][i] = score;
                    score++;
                }
            }

            HashMap<Integer, Integer> result = new HashMap<>();
            for (Integer key: hashMap.keySet()) {
                if (hashMap.get(key) < 6) continue;
                int total = 0;
                int idx = 1;
                for (int i = 1; i < N+1; i++) {
                    if (idx > 4) break;
                    if (arr[0][i] == key) {
                        total += arr[1][i];
                        idx++;
                    }
                }
                result.put(key, total);
            }

            // 가장 작은 수 찾기 return 팀 번호
            // 같은 점수라면 5번째 낮은 팀
            int min = Integer.MAX_VALUE;
            for (Integer key : result.keySet()) {
                if (result.get(key) < min) {
                    min = result.get(key);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (Integer key : result.keySet()) {
                if (result.get(key) == min) {
                    list.add(key);
                }
            }

            if (list.size() == 1) {
                System.out.println(list.get(0));
            } else {
                // list에 들어있는 key의 5번째 값 구하기
                int fifthTeamScore = Integer.MAX_VALUE;
                int fifthTeam = 0;
                for (int i = 0; i < list.size(); i++) {
                    int key = list.get(i);
                    int idx = 1;
                    for (int j = 1; j < N+1; j++) {
                        if (arr[0][j] == key) {
                            if (idx == 5) {
                                // score은 arr[1][j]
                                if (arr[1][j] < fifthTeamScore) {
                                    fifthTeamScore = arr[1][j];
                                    fifthTeam = key;
                                }
                            }
                            idx++;
                        }
                    }
                }
                System.out.println(fifthTeam);
            }
        }
    }
}