import java.util.Arrays;

public class Database {
    private String[] table;

    public Database(int size) {
        this.table = new String[size];
    }

    public void add(int index, String value) {
        if (index < 1 || index > this.table.length) {
            System.out.println("Please enter valid table position. Value ignored");
            return;
        }
        this.table[index - 1] = value;
    }

    public void print() {
        System.out.println(Arrays.toString(this.table));
    }

    public void sort() {
        Arrays.sort(this.table);
    }

    public void find(String value) {
        for (int index = 0; index < this.table.length; index++) {
            if (this.table[index].equals(value)) {
                System.out.println("Entry found");
                return;
            }
        }
        System.out.println("Not found");
    }
}
