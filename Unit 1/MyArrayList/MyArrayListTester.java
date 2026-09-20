import java.util.ArrayList;

public class MyArrayListTester {
    public static void main(String[] args) {
        ArrayList<String> actual = new ArrayList<String>(5);
        System.out.println(actual);
        MyArrayList<String> test = new MyArrayList<String>(5);
        try {
            for (int i = 0; i < 6; i++) {
                test.add(Integer.toString(i));
            }
        } catch(Exception e) {
            System.out.println(test);
            System.out.println(e);
        }
        for (int i = 6; i < 7; i++) {
            test.add(Integer.toString(i));
            System.out.println(test);
        }
        // System.out.println(test.get(-1));
        System.out.println(test.remove(1));
        System.out.println(test);
        System.out.println(test.remove(1));
        System.out.println(test);
        System.out.println(test.remove(3));
        System.out.println(test);
        try {
            test.remove(4);
        } catch(Exception e) {
            System.out.println(test);
            System.out.println(e);
        }
        test.remove("0");
        System.out.println(test);
        test.add(0, "0");
        System.out.println(test);
        test.add(3, "5");
        System.out.println(test);
        test.add(4, "7");
        System.out.println(test);
        Dog testDog = new Dog("Doggo");
        System.out.println("kai's dog: " + testDog);
    }
}
