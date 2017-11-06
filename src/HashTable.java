public class HashTable {

    private int size;
    private Item[] table;

    private int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = (127 * hash + key.charAt(i)) % size;

        }
        return hash;
    }

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }

    public void print() {
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " " + table[i].getKey());
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
