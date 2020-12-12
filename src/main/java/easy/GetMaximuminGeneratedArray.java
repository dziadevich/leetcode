package easy;

public class GetMaximuminGeneratedArray {
    public static void main(String[] args) {
        System.out.println(GetMaximuminGeneratedArray.getMaximumGenerated(7));
    }

    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int max = 1;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1];
                max = Math.max(max, array[i]);
            }
        }
        return max;
    }
}
