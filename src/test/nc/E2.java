package test.nc;

import java.util.HashMap;
import java.util.Map;

public class E2 {
    public int solution(Tree T) {
        return search(T, new HashMap<>());
    }

    private int search(Tree t, Map<Integer, Integer> history) {

        // null 이라면 현재까지 지나온 패스 기록이 distinct 한 값의 총 수이기 때문에
        // history 크기를 return
        if (t == null) {
            return history.size();
        }

        // 지나온 패스 기록
        history.put(t.x, history.getOrDefault(t.x, 0) + 1);

        // 과거 패스를 기반으로 좌우 노드에서 최대 값을 얻어 냄
        int max = Math.max(this.search(t.r, history), this.search(t.l, history));

        // 현재 패스 삭제
        if (history.get(t.x) == 1) {
            history.remove(t.x);
        } else {
            history.put(t.x, history.get(t.x) - 1);
        }

        return max;
    }
}
