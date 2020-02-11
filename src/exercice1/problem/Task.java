package exercice1.problem;

/**
 * a task of the problem
 */
public final  class Task {
    private final int id;   // an id to identify the task
    private final int p;    // a time to do
    private final int d;    // a deadline before being late
    private final int w;    // a weight
    private double ratio;   // the ratio : d / w

    /**
     * a task is represented by:
     * @param id an identifier
     * @param p a time to do
     * @param d a deadline
     * @param w and a weight
     */
    public Task(int id, int p, int d, int w) {
        this.id = id;
        this.p = p;
        this.d = d;
        this.w = w;
        computeRatio(); // ratio is computing when created
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

    public int getId() {
        return id;
    }

    /**
     *
     */
    private void computeRatio() {
        this.ratio = (double)d / (double)w;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", p=" + p +
                ", d=" + d +
                ", w=" + w +
                ", ratio=" + ratio +
                '}';
    }
}
