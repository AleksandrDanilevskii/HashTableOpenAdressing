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
        System.out.println("HashTable output:");
        boolean flag = true;
        for(int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(i + " " + table[i].getKey());
                flag = false;
            }
        }
        if(flag)
            System.out.println("HashTable is empty.");
    }

    public void insert(String key) {
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

    public void remove(String val){
        int h = hash(val);
        for(int i=h; i<size; i++){
            String str = table[i].getKey();
            if (str.equals(val)){
                table[i] = null;
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
        for(int i = 0; i < size; i++) {
            if (table[i] != null) {
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("HashTable is empty.");
        else
            System.out.println("HashTable is not empty.");
    }
}
