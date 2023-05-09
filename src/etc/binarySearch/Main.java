package etc.binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < array.length; i++) {
            binarySearch(array, i);
        }

        binarySearch(array, -1);
    }

    private static int binarySearch(int[] array, int num) {
        System.out.printf("search:%d\n", num);
        int left = 0;
        int right = array.length;

        int index;
        while (left < right) {
            index = (left + right) / 2;
            System.out.printf("left:%d, right:%d\n", left, right);
            System.out.printf("index:%d, element:%d\n", index, array[index]);
            if (array[index] == num) {
                System.out.printf("exists:%d\n\n", index);
                return index;
            }
            if (array[index] < num) left = index;
            else right = index;
        }
        System.out.print("not exists\n\n");
        return -1;
    }
}
