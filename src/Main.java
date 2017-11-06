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

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter what insert");
                    hashTable.insert(scan.next());
                    break;
                case 2:
                    System.out.println("Enter what remove");
                    hashTable.remove(scan.next());
                    break;
            }
            hashTable.print();

            System.out.println("Type c to continue or s to stop");
            ch = scan.next().charAt(0);
        } while (ch == 'c');
    }
}
