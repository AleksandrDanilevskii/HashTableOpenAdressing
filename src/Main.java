import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int size=0;
        try {
            size = HashTable.inputSize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashTable hashTable = new HashTable(size);

        try {
            hashTable.selectMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}