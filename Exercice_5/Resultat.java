public class Resultat {
    private int score;

    public Resultat() { this.score = 0; }
    public Resultat(int score) { this.score = score; }

    public int getScore() { return score; }
    public void setScore(int score) {
        if (score >= 0) this.score = score;
    }

    public void afficher() {
        System.out.println("Score : " + score);
    }

    @Override
    public String toString() {
        return "Score : " + score;
    }
}