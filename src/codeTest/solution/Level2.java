package codeTest.solution;

import java.util.Arrays;

public class Level2 {
    // [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
    public int puzzle(int[] diffs, int[] times, long limit) {
        // 현재퍼즐의 난이도 diff
        // 현재 퍼즐의 소요시간 time_cur
        // 이전 퍼즐의 소요시간 time_prev
        // 숙련도 level
        int answer = 0;
        
        boolean isAnswer = false;
        int[] diffClone = Arrays.copyOf(diffs, diffs.length);
//        Arrays.sort(diffClone);
        Arrays.parallelSort(diffClone);
        
        int level = diffClone[0];
        while(!isAnswer) {
            
            long time_limit = limit;
            
            for(int j=0; j<diffs.length; j++) {
                int diff = diffs[j];
                int time_cur = times[j];
                int time_prev = j != 0 ? times[j-1] : 0;
                
                time_limit -= (time_cur * 1.0);
                if(diff > level) {
                    int wrongCnt = diff - level;
                    time_limit -= ((time_cur + time_prev) * wrongCnt * 1.0);
                }
                
                if(time_limit < 0.0) {
                    break;
                }
            }
            
            if(time_limit >= 0.0) {
                answer = level;
                isAnswer = true;
                break;
            }
            level++;
        }
        return answer;
    }
}
