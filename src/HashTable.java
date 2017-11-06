
public class HashTable {
    private int size;
    private Item[] table;
    private int counte;

    private int hash(String key) {
        System.out.println(size);
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
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
        if(counte<size) {
            Item item = new Item(key);
            int hash = hash(key);
            while (table[hash] != null) {
                hash++;
                hash %= size;
            }
            table[hash] = item;
            counte++;
        }
        else{
            rehash();
            insert(key);
        }
    }

    public void rehash() {
        this.size = 2*table.length;
        Item[] newElements = new Item[this.size];
        Item[] old = table;
        table = newElements;
        counte =0;
        for (Item node : old){
                insert(node.getKey());
        }

    }

    public void remove(String val){
        int h = hash(val);
        for(int i=h; i<size; i++){
            String str = table[i].getKey();
            if (str.equals(val)){
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

    public void search(String val) {
        int h = hash(val);
        for(int i=h; i<size; i++) {
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
        System.out.println("Size = "+size);
    }
}
