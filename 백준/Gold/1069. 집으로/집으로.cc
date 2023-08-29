#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;
 
int main(){
    int X, Y, D, T;
    while(scanf("%d %d %d %d", &X, &Y, &D, &T) > 0){
        double dist = sqrt(X*X + Y*Y);
        // jump: 집의 방향으로만 점프하여 집을 지나치지 않을 수 있는 최대 횟수
        int jump = dist/D;
        // spare: jump번 집의 방향으로만 점프한 후 남은 집과의 거리
        double spare = dist - jump*D;
        // 첫 번째 후보: 점프하지 않고 끝까지 걸어가기
        double result = dist;
        // 두 번째 후보: jump번 점프한 후 걸어가기
        result = min(result, spare + jump*T);
        // 세 번째 후보: jump+1번 점프로 방향을 꺾어서 도착하기
        if(jump > 0) result = min(result, (jump+1)*T*1.0);
        else{
            // 네 번째 후보: 1번 점프한 후 역방향으로 걸어오기
            result = min(result, D-spare + T);
            // 다섯 번째 후보: 2번 점프로 도착하기
            if(dist < D) result = min(result, T*2.0);
        }
        printf("%.10lf\n", result);
    }
}