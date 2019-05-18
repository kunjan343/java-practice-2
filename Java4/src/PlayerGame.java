public class PlayerGame {
    public static void main(String[] args) {
        Player p1 = new Player("Rom", 45.6, 6, 78);
        Player p2 = new Player("Jack", 63.2, 8, 35);

        p1.levelUp();
        System.out.println("P1: Level up");
        p1.printInfo();

        p2.updateScore(3);
        System.out.println("P2: Set new score");
        p2.printInfo();

        p1.hitHealth();
        System.out.println("P1: Hit health");
        p1.printInfo();

        p2.levelUp();
        System.out.println("P2: Level up");
        p2.printInfo();

        System.out.println("Final Score");
        p1.printInfo();
        p2.printInfo();
    }
}
