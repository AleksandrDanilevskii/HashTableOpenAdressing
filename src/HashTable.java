public class HashTable {

    private int size;
    private Item[] table;

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }
}
