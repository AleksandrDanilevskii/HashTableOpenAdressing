//элемент таблицы
class Item{
    private String key; //ключ-строка
    Item next;

    public Item(String key) {
        this.key = key;
        next = null;
    }

    public String getKey() {
        return key;
    }
}

