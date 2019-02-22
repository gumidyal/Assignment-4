package artificialLife;

import java.util.Random;

public class PartialCooperator extends Organism{

  public PartialCooperator() {
    this.type = "PartialCooperator";
    this.energy =0;
  }
  
  public double getCooperationProbability() {
    return .5;
  }
  public boolean cooperates() {
    Random r = new Random();
    boolean b = r.nextBoolean();
    return b;
    
  }
}
