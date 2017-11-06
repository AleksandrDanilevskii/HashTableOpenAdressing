import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int size = HashTable.inputSize();

        HashTable hashTable = new HashTable(size);

        //try {
            hashTable.selectMenu();
        /*} catch (NullPointerException e){
            System.out.println("Item not found!");
            hashTable.selectMenu();
        }*/

    }

}
