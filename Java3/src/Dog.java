public class Dog {
    private String _name;
    private int _size;

    public Dog(String name, int size) {
        _name = name;
        _size = size;
    }

    private int getSize() {
        return _size;
    }

    private void setName(String newName) {
        _name = newName;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Bruno", 12);
        System.out.println("Size of dog:" + dog.getSize());
        dog.setName("Brina");
    }
}
