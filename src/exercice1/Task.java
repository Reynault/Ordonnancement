package exercice1;

public class Task {
    private int id;
    private int p;
    private int d;
    private int w;
    private double ratio;

    public Task(int id, int p, int d, int w) {
        this.id = id;
        this.p = p;
        this.d = d;
        this.w = w;
        computeRatio();
    }

    public int getId() {
        return id;
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

    public void setD(int d) {
        this.d = d;
        computeRatio();
    }

    public void setW(int w) {
        this.w = w;
        computeRatio();
    }

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
