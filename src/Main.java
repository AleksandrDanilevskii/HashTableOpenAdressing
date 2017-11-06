import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size: ");
        HashTable hashTable = new HashTable(scan.nextInt());

        int choice;
        do {
            System.out.println("HashTable Operations:");
            System.out.println("1. Insert;");
            System.out.println("2. Remove;");
            System.out.println("3. Make it empty;");
            System.out.println("4. Check empty;");
            System.out.println("5. Search;");
            System.out.println("6. Print;");
            System.out.println("7. Size;");
            System.out.println("0. Stop.");

            choice = scan.nextInt();
            if (choice!=0) {
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
                    case 4:
                        hashTable.isEmpty();
                        break;
                    case 5:
                        System.out.print("Enter what find: ");
                        hashTable.search(scan.next());
                        break;
                    case 6:
                        hashTable.print();
                    case 7:
                        hashTable.size();
                }

            }
        }while(choice!=0);
    }
}
