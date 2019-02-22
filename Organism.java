package artificialLife;


public class Organism {
  int energy;
  public String type;
  
  public Organism() {
    this.energy = 0;
  }

  public void update() {
    this.energy += 1;
  }
  
  public int getEnergy() {
    return this.energy;
  }
  
  public void incrementEnergy() {
    this.energy++;
  }
  
  public void decrementEnergy() {
    this.energy--;
  }
  
  public String getType() {
    return this.type;
  }
  
  
  public Organism reproduce() {
    Organism offspring = new Organism();
    offspring.energy =0;
    offspring.type = this.type;
    return offspring;
  }
  
  public double getCooperationProbability() {
    if(this.type.equals("Cooperator")){
      return 1;
    }
    else if(this.type.equals("PartialCooperator")){
      return .5;
    }
    if(this.type.equals("Defector")){
      return 0;
    }
    else {
      return 0;
    }
  }
  
  public boolean cooperates() {
    if (this.energy == 1) {
      return true;
    }
    else if (this.energy == 0) {
      return false;
    }
    else {
      return true;
    }
  }
  
  
  
  
  
}
