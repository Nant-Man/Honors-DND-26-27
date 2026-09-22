public class SinglyLinkedListTester {
    public static void main(String[] args) {
        String[] values = {"a", "b", "c", "d", "e"};
        SinglyLinkedList<String> test = new SinglyLinkedList<String>(values);
        // constructor seems to be working b/c everything else

        // test toString
        System.out.println(test);

        // test size pt 1
        System.out.println(test.size());

        // test add
        test.add("f");
        test.add("g");
        System.out.println(test);

        // test size pt 2
        System.out.println(test.size());

        // test contains
        System.out.println("contains exist: " + test.contains("a"));
        System.out.println("contains DNE: " + test.contains("1"));

        // test indexOf
        System.out.println("indexOf exists: " + test.indexOf("c"));
        System.out.println("indexOf DNE: " + test.indexOf("1"));

        // test get
        for (int i = 0; i < 7; i++) {
            System.out.println(test.get(i));
        }
        try {
            System.out.println(test.get(7));
        } catch(Exception e) {
            System.out.println("worked: can't get invalid index");
        }
        try {
            System.out.println(test.get(-1));
        } catch(Exception e) {
            System.out.println("worked: can't get invalid index");
        }

        // test remove object
        System.out.println("removed: " + test.remove("c"));

        // test remove object: head
        System.out.println("removed object head: " + test.remove("a"));

        // test remove object: tail
        System.out.println("removed object tail: " + test.remove("g"));

        test = new SinglyLinkedList<String>(values);
        // test remove index
        System.out.println("removed index 1: " + test.remove(1));

        // test remove index head
        System.out.println("removed index 0/head: " + test.remove(0));

        // test remove index tail
        System.out.println("removed index nodeCount-1/tail: " + test.remove(test.size() - 1));
        System.out.println(test);

        // test default constructor
        SinglyLinkedList<String> emptyList = new SinglyLinkedList<String>();
        System.out.println(emptyList.getHead());
        System.out.println(emptyList.getTail());
        System.out.println(emptyList.size());

        // test isEmpty and add to empty - something went wrong - fixed (empty having null tail/head)
        System.out.println(emptyList.isEmpty());
        emptyList.add("not empty now");
        System.out.println(emptyList.size());
        emptyList.remove(0);

        // test set
        test = new SinglyLinkedList<String>(values);
        for (int i = 0; i < values.length; i++) {
            test.set(i, Integer.toString(i));
        }
        System.out.println(test);

        // test add at index
        test.add(1, "0.5");
        System.out.println(test);
        test.add(0, "-1");
        System.out.println(test);
        test.add(6, "3.5");
        System.out.println(test);

    }
}
