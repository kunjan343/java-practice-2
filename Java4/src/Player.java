public class Player {
    private String name;
    private double score;
    private double level;
    private double health;

    public Player(String name, double score, double level, double health) {
        this.name = name;
        this.score = score;
        this.level = level;
        this.health = health;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void updateScore(double score) {
        this.score += score;
    }

    public void levelUp() {
        this.level += 1;
    }

    public void hitHealth() {
        this.health -= (this.health * 0.055);
    }

    public void printInfo() {
        System.out.println(this.name + ", " + this.score + ", " + this.level + ", " + this.health);
    }
}
