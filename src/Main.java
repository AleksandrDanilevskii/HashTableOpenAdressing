import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size: ");
        HashTable hashTable = new HashTable(scan.nextInt());

        char ch;
        do {
            System.out.println("Hash Table Operations:");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. clear");
            System.out.println("4. size");
            System.out.println("5. check empty");
            System.out.println("6. contains");

            ch = scan.next().charAt(0);
        } while (ch == 'c');
    }
}
