public class TestMyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("Size : " + stack.getSize());
        System.out.println("Add 23");
        stack.push(23);
        System.out.println("Add 56");
        stack.push(56);
        System.out.println("Add 82");
        stack.push(82);

        System.out.println("Peek : " + stack.peek());

        System.out.println("Pop : " + stack.pop());
        System.out.println("Search 56 : " + stack.search(56));
        System.out.println("Size : " + stack.getSize());
        System.out.println("Pop : " + stack.pop());
        System.out.println("Pop : " + stack.pop());
        System.out.println("Size : " + stack.getSize());


    }
}
