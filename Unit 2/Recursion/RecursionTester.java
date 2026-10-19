public class RecursionTester {
    public static void main(String[] args) {

        String[] values = {"a", "b", "c", "d"};
        SinglyLinkedList<String> testList = new SinglyLinkedList<String>(values);
        Recursion.printListInReverse(testList.getHead());
        System.out.println();

        String[][] testGrid = {
            {"vaccinated", "vulnerable", "vulnerable"},
            {"infected", "vulnerable", "vaccinated"},
            {"infected", "vaccinated", "vulnerable"}
        };
        Recursion.infect(testGrid, 1, 1);
        for (int r = 0; r < testGrid.length; r++) {
            System.out.print("[");
            for (int c = 0; c < testGrid[0].length; c++) {
                System.out.print(testGrid[r][c]);
                if (c != testGrid[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
        for (int i = 1; i < 8; i++) {
            System.out.println(i + ": " + Recursion.countNonConsecutiveSubsets(i));
        }

        int[] unsorted = {1, 5, 3, 7, 9, 8, 6, 2, 0, 4};
        Recursion.mergeSort(unsorted);
        System.out.print("[");
        for (int c = 0; c < unsorted.length; c++) {
            System.out.print(unsorted[c]);
            if (c != unsorted.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        unsorted = new int[100];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * 1000);
        }
        Recursion.mergeSort(unsorted);
        System.out.print("[");
        for (int c = 0; c < unsorted.length; c++) {
            System.out.print(unsorted[c]);
            if (c != unsorted.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // subsets
        Recursion.printSubsets("abcd");

        // permutations
        Recursion.printPermutations("abcde");

        // hanoi: confirmed what was printed by checking manually with erasers of different sizes on desk
        Recursion.solveHanoi(1);
        System.out.println();
        Recursion.solveHanoi(2);
        System.out.println();
        Recursion.solveHanoi(3);
        System.out.println();
        Recursion.solveHanoi(4);

        // scav hunt
        int[] times = {3, 7, 9};
        int[] points = {10, 15, 10};
        System.out.println(Recursion.scavHunt(times, points));
        times = new int[] {1, 2, 3};
        points = new int[] {5, 10, 15};
        System.out.println(Recursion.scavHunt(times, points));

    }
}
