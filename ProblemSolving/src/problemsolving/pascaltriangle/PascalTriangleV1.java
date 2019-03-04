package problemsolving.pascaltriangle;

import java.util.*;

public class PascalTriangleV1 {

    public static void buildTriangle(int level) {
        if (level > 0) {
            System.out.println("1");

            if (level > 1)
                System.out.println("1 1");

            buildTriangle(3, level, Arrays.asList(1, 1));
        } else {
            System.err.println("Can't create triangle, specify a correct level, please.");
        }
    }

    private static void buildTriangle(int currentLevel, int desiredLevel, List<Integer> leaves) {
        if (currentLevel <= desiredLevel) {
            LinkedList<Integer> newLeaves = new LinkedList<>();
            newLeaves.addFirst(1);
            System.out.print("1 ");

            for (int i = 0; i < leaves.size() - 1; i++) {
                newLeaves.add(leaves.get(i) + leaves.get(i + 1));
                System.out.print(newLeaves.getLast() + " ");
            }

            newLeaves.addLast(1);
            System.out.println("1");

            buildTriangle(currentLevel + 1, desiredLevel, newLeaves);
        }
    }

    public static void main(String[] args) {
        buildTriangle(7);
        buildTriangle(0);
        buildTriangle(-1);
        buildTriangle(1);
        buildTriangle(2);
    }

}
