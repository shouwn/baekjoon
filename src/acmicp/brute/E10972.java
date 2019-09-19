package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10972 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            solution(arr);

            String result = Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(result);
        } catch (RuntimeException e) {
            System.out.println(-1);
        }
    }

    private static void solution(int[] arr) {
        int rear = arr.length - 1;

        for (; rear >= 1; rear--) {
            if (arr[rear] > arr[rear - 1]) {
                break;
            }
        }

        if (rear == 0) {
            throw new RuntimeException();
        }

        for (int i = arr.length - 1; i >= rear; i--) {
            if (arr[rear - 1] < arr[i]) {
                swap(arr, rear - 1, i);
                break;
            }
        }

        Arrays.sort(arr, rear, arr.length);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
