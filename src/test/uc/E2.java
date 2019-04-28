package test.uc;

public class E2 {

    public boolean solution(int[][] lands, int[][] wells, int[] point) {
        Rect rectPoint = makeRect(point);

        for (int[] land : lands) {
            if (makeRect(land).isIntersect(rectPoint)) {
                return false;
            }
        }

        boolean result = false;

        for (int[] well : wells) {
            if (makeRect(well).isIntersect(rectPoint)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static Rect makeRect(int[] arr) {
        return new Rect(arr[0], arr[3], arr[2], arr[1]);
    }

    static class Rect {
        int left, top, right, bottom;

        public Rect(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public boolean isIntersect(Rect other) {
            return this.left < other.right && this.right > other.left && this.top > other.bottom && this.bottom < other.top;
        }
    }
}
