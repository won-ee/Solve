import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] userStage = new int[N + 2];
        for (int stage : stages) {
            if (stage <= N) {
                userStage[stage]++;
            }
        }

        int totalPlayers = stages.length;
        List<StageFailure> failureList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureList.add(new StageFailure(i, 0));
            } else {
                double failRate = (double) userStage[i] / totalPlayers;
                failureList.add(new StageFailure(i, failRate));
                totalPlayers -= userStage[i];
            }
        }

        // 실패율 내림차순 정렬, 같으면 스테이지 번호 오름차순
        failureList.sort((a, b) -> {
            if (b.failRate == a.failRate) return a.stage - b.stage;
            return Double.compare(b.failRate, a.failRate);
        });

        // 결과 배열로 변환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failureList.get(i).stage;
        }

        return answer;
    }

    static class StageFailure {
        int stage;
        double failRate;

        StageFailure(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
}


// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 = stages 안의 갯수
// 스테이지에 도달한 플레이어 수 = 자기 이전 stages 안의 갯수 / 총인구수
// 실패율이 가장 높은순으로 정렬
// 실패율이 같으면 작은번호의 스테이지가 먼저오도록
// 스테이지에 도달한 유저가 없는경우 해당 스테이지의 실패율은 0으로