import java.io.IOException;
import java.util.Scanner;

public class HashTable {
    private int size;
    private Item[] table;
    private int counte;

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % size;
        }
        return hash;
    }

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }

    public void print() {
        System.out.println("HashTable output:");
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(i + " " + table[i].getKey());
                flag = false;
            }
        }
        if (flag)
            System.out.println("HashTable is empty.");
    }

    public void insert(String key) {
        if (size == 0) {
            size++;
        }
        if (counte < size) {
            Item item = new Item(key);
            int hash = hash(key);
            while (table[hash] != null) {
                hash++;
                hash %= size;
            }
            table[hash] = item;
            counte++;
        } else {
            rehash();
            insert(key);
        }
    }

    public void rehash() {
        this.size = 2 * table.length;
        Item[] newElements = new Item[this.size];
        Item[] old = table;
        table = newElements;
        counte = 0;
        for (Item node : old) {
            insert(node.getKey());
        }

    }

    public void remove(String val) {
        int h = hash(val);
        for (int i = h; i < size; i++) {
            String str = table[i].getKey();
            if (str.equals(val)) {
                table[i] = null;
                counte--;
                break;
            }
        }
    }

    public void makeEmpty() {
        int l = table.length;
        table = new Item[l];
    }

    public void isEmpty() {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("HashTable is empty.");
        else
            System.out.println("HashTable is not empty.");
    }

    public void search(String val) {
        int h = hash(val);
        for (int i = h; i < size; i++) {
            String str = table[i].getKey();
            if (str.equals(val)) {
                System.out.println("Element in.");
                break;
            }
            System.out.println("Element not found");
            return;
        }
    }

    public void size() {
        System.out.println("Size = " + size);
    }

    public static int inputSize() throws IOException {
        int size;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter size: ");
            size = scan.nextInt();

            if(size <= 0){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("You entered a non-positive number! Re-enter: ");
                    return inputSize();
                }
            }
        }
        catch (Exception e) {
            System.out.println("You have entered invalid characters! Re-enter: ");
            return inputSize();
        }
        return size;
    }

    public void selectMenu() throws IOException {
        Scanner scan = new Scanner(System.in);
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

            choice = inputCase();

            if (choice != 0) {
                switch (choice) {
                    case 1:
                        System.out.print("Enter what insert: ");
                        insert(scan.next());
                        break;
                    case 2:
                        System.out.print("Enter what remove: ");
                        remove(scan.next());
                        break;
                    case 3:
                        makeEmpty();
                        break;
                    case 4:
                        isEmpty();
                        break;
                    case 5:
                        System.out.print("Enter what find: ");
                        search(scan.next());
                        break;
                    case 6:
                        print();
                    case 7:
                        size();
                }
            }
        } while (choice != 0);
    }


    public int inputCase() {
        Scanner scan = new Scanner(System.in);
        int choice;
        try {
            choice = scan.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("You have entered invalid characters! Re-enter:");
            return inputCase();
        } catch (Exception e) {
            System.out.println("You entered non-positive numbers! Re-enter:");
            return inputCase();
        }
        return choice;
    }
}

