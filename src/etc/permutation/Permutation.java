package etc.permutation;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
//        int[] array = {1, 2, 3};

        int[][] result = permutate(array, 3);

        Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("result : " + result.length + "EA");
    }
    public static int[][] permutate(int[] array, int r) {
        return dfs(array, 0, r, new int[0][r]);
    }

    private static int[][] dfs(int[] array, int depth, int r, int[][] result) {
        if (depth == r) {
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = Arrays.copyOfRange(array, 0, depth);
            return result;
        }

        for (int i = depth; i < array.length; i++) {
            swap(array, depth, i);

            result = dfs(array, depth + 1, r, result);

            swap(array, depth, i);
        }

        return result;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
