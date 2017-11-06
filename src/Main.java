import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size: ");
        HashTable hashTable = new HashTable(scan.nextInt());

        char ch;
        do {
            System.out.println("HashTable Operations:");
            System.out.println("1. Insert ");
            System.out.println("2. Remove");
            System.out.println("3. Make it empty:");
            System.out.println("4. Size");
            System.out.println("5. Check empty");
            System.out.println("6. Contains");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter what insert: ");
                    hashTable.insert(scan.next());
                    break;
                case 2:
                    System.out.print("Enter what remove: ");
                    hashTable.remove(scan.next());
                    break;
                case 3:
                    hashTable.makeEmpty();
                    break;
            }
            hashTable.print();

            System.out.println("Type c to continue or s to stop");
            ch = scan.next().charAt(0);
        } while (ch == 'c');
    }
}
