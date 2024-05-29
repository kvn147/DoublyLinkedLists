import java.util.Scanner;

/**
 * This class constructs a DoublyLinkedList of Characters and tests out the
 * methods: add(index, value), add(value), remove(index), indexOf(value),
 * get(index)
 *
 */
public class DoublyLinkedListTester {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        DoublyLinkedList<Character> doubleList = new DoublyLinkedList<>();
        System.out.println(doubleList);

        String option = "";
        do {
            option = displayOptions(console);

            if (option.startsWith("ai")) {

                System.out.print("Add at what index? > ");
                int index = Integer.parseInt(console.nextLine());

                System.out.print("Add what? > ");
                char value = console.nextLine().charAt(0);

                doubleList.add(index, value);

            } else if (option.startsWith("a")) {

                System.out.print("Add What? > ");
                char value = console.nextLine().charAt(0);

                doubleList.add(value);

            } else if (option.startsWith("g")) {

                System.out.print("Get what index? > ");
                int index = Integer.parseInt(console.nextLine());

                char got = doubleList.get(index);
                System.out.println("--- Got " + got + " ---");

            } else if (option.startsWith("io")) {

                System.out.print("Index of what? > ");
                char value = console.nextLine().charAt(0);
                int index = doubleList.indexOf(value);

                if (index >= 0)
                    System.out.println("--- Found at index: " + index + " ---");
                else
                    System.out.println("--- Not found --- returned: " + index);

            } else if (option.startsWith("ri")) {

                System.out.print("Remove what index? > ");
                int index = Integer.parseInt(console.nextLine());

                char removed = doubleList.remove(index);
                System.out.println("--- Removed " + removed + " ---");

            }
            System.out.println(doubleList);

        } while (!option.startsWith("d"));

    }

    private static String displayOptions(Scanner console) {
        System.out.println("\nOptions: (a) add to the end (ai) add at index (io) indexOf a value");
        System.out.println("         (g) get by index  (ri) remove at index (d) done");
        System.out.print("Which option? > ");
        return console.nextLine().toLowerCase();
    }
}