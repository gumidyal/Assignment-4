package artificialLife;

public class Cooperator extends Organism {

  public Cooperator() {
    this.type = "Cooperator";
    this.energy = 0;
  }

  public double getCooperationProbability() {
    return 1;
  }
  public boolean cooperates() {
    return true;
  }
}
