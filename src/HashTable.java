public class HashTable {

    private int size;
    private Item[] table;

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }

    public void insert(String key)
    {
        if(size==0){size++;}
        Item item = new Item(key);
        int hash = hash(key);
        while(table[hash] != null)
        {
            hash++;
            hash %= size;
        }
        table[hash] = item;
    }
}
