package task;

/**
 * Une tâche d'un problème
 */
public final  class Task {
    private final int id;   // un Id qui identifie la tâche
    private final int p;    // un temps de réalisation
    private final int d;    // une deadline
    private final int w;    // un poids
    private double ratio;   // le ratio : d / w

    /**
     * Une tâche est représentée par:
     * @param id un identifieur
     * @param p un temps de réalisation
     * @param d une deadline
     * @param w un poids
     */
    public Task(int id, int p, int d, int w) {
        this.id = id;
        this.p = p;
        this.d = d;
        this.w = w;
        computeRatio(); // calcul du ratio
    }

    /**
     * Méthode de calcul du ratio
     */
    private void computeRatio() {
        this.ratio = (double)d / (double)w;
    }

    public int getP() {
        return p;
    }

    public int getD() {
        return d;
    }

    public int getW() {
        return w;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "task.Task{" +
                "id=" + id +
                ", p=" + p +
                ", d=" + d +
                ", w=" + w +
                ", ratio=" + ratio +
                '}';
    }

    public int getId() {
        return id;
    }
}
