class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        //빈병 a개 가져다주면 콜라 b개 주는 마트
        //갖고있는 빈병 n개  보유 중인 빈 병이 a개 미만이면, 콜라를 받을 수 없다.
        
        int bottle = 0;
        while(n >=a){
            answer += (n/a)*b;
            n = (n%a) + (n/a)*b;
        }
        

        return answer;
    }
}