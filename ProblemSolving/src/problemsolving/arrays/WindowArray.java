package problemsolving.arrays;

public class WindowArray {

    public static int[] findLargerNumbersInWindow(int[] numbers, int k) {
        if (numbers.length <= k) {
            return new int[] {};
        }

        int[] largerNumbers = new int[numbers.length - k + 1];
        int largerNumber = Integer.MIN_VALUE;
        int largerNumberPosition = 0;
        int secondLargerNumber = Integer.MIN_VALUE;
        int secondLargerNumberPosition = 0;
        boolean discardLargerNumber = false;

        for (int i = 0; i < numbers.length; i++) {
            if (largerNumber <= numbers[i]) {
                largerNumber = numbers[i];
                largerNumberPosition = i;

                if (discardLargerNumber) {
                    discardLargerNumber = false;
                }
            }

            if (i >= k - 1) {
                if (discardLargerNumber) {
                    largerNumber = secondLargerNumber;
                    largerNumberPosition = secondLargerNumberPosition;
                    secondLargerNumber = Integer.MIN_VALUE;
                    secondLargerNumberPosition = 0;

                    largerNumbers[i - k + 1] = largerNumber;
                    discardLargerNumber = false;
                } else {
                    largerNumbers[i - k + 1] = largerNumber;
                }

                if (largerNumberPosition == (i - k + 1)) {
                    discardLargerNumber = true;
                    System.out.println("The edge: " + i + " = " + largerNumberPosition);
                }

                if (numbers[i] < largerNumber &&
                    numbers[i] > secondLargerNumber &&
                    i > largerNumberPosition) {
                    secondLargerNumber = numbers[i];
                    secondLargerNumberPosition = i;
                    System.out.println("The next candidate: " + i + " " + secondLargerNumber);
                }
            } else {
                if (numbers[i] < largerNumber &&
                    numbers[i] > secondLargerNumber &&
                    i > largerNumberPosition) {
                    secondLargerNumber = numbers[i];
                    secondLargerNumberPosition = i;
                    System.out.println("The next candidate: " + i + " " + secondLargerNumber);
                }
            }
        }

        return largerNumbers;
    }

    public static int[] findLargerNumbersInWindow2(int[] numbers, final int k) {
        int[] largerNumbersInWindows = new int[numbers.length - k + 1];
        int largerNumberInWindow;

        for (int i = 0; i < (numbers.length - k + 1); i++) {
            largerNumberInWindow = numbers[i];

            for (int j = (i + 1); j < (i + k); j++) {
                if (largerNumberInWindow <= numbers[j]) {
                    largerNumberInWindow = numbers[j];
                }
            }

            largerNumbersInWindows[i] = largerNumberInWindow;
        }

        return largerNumbersInWindows;
    }

    public static void main(String[] args) {
        int[] result1 = findLargerNumbersInWindow2(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        int[] result2 = findLargerNumbersInWindow2(new int[] { 3, 1, -1, -3, 5, 3, 6, 7 }, 3);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        int[] result3 = findLargerNumbersInWindow2(new int[] { 3, 1, -1, -3, -5, 3, 6, 7 }, 3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        int[] result4 = findLargerNumbersInWindow2(new int[] { 3, 1, -1, -3, -5, -1, -6, 0 }, 4);
        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        int[] result5 = findLargerNumbersInWindow2(new int[] { 3, 1, -1, -3, -5, -1, -6, 0 }, 3);
        for (int i = 0; i < result5.length; i++) {
            System.out.print(result5[i] + " ");
        }
    }

}
