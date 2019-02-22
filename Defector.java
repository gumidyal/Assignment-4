package artificialLife;

public class Defector extends Organism {

  public Defector() {
    this.type = "Defector";
    this.energy =0;
  }
  
  public double getCooperationProbability() {
    return 0;
  }
  public boolean cooperates() {
    return false;
  }
}
