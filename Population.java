package artificialLife;


import java.util.ArrayList;
import java.util.Random;

public class Population {
  ArrayList<Organism> organism = new ArrayList<Organism>();

  public Population(Pair<String, Integer>[] counts) throws Exception {

    for (int i = 0; i < counts.length; i++) {
      if(counts[i].getLeft().contentEquals("Cooperator")) {
        for (int j = 0; j < counts[i].getRight(); j++) {
          Organism org = new Cooperator();
          this.organism.add(org);
        }
      }
      else if(counts[i].getLeft().contentEquals("Defector")) {
        for (int j = 0; j < counts[i].getRight(); j++) {
          Organism org = new Defector();
          this.organism.add(org);
        }
      }
      else if(counts[i].getLeft().contentEquals("PartialCooperator")) {
        for (int j = 0; j < counts[i].getRight(); j++) {
          Organism org = new PartialCooperator();
          this.organism.add(org);
        }
      }
      else {
        throw new IllegalArgumentException();
      }
    } // for
  }


  public void update() {
    Random r = new Random(1);
    for (int i = 0; i < organism.size(); i++) {
      Organism o = organism.get(i);
      o.update();
      organism.set(i, o);
     
      if (o.cooperates()) {
        o.decrementEnergy();
        int group = (organism.size() / 8);
        for (int j = 0; j < 8; j++) {
          int q = r.nextInt(group);
          Organism random = organism.get(q + group * j);
          random.incrementEnergy();
          organism.set(q + group * j, random);
        }
      }
      if (o.getEnergy() >= 10) {
        int n = r.nextInt(organism.size());
        organism.set(n, o.reproduce());
      }
    }
  }


  public double calculateCooperationMean() {
    double total = 0;
    for (int i = 0; i < organism.size(); i++) {

      total += organism.get(i).getCooperationProbability();
    }
    return (total / organism.size());
  }

  public Pair<String, Integer>[] getPopulationCounts() {
    int totalC = 0;
    int totalP = 0;
    int totalD = 0;

    for (int i = 0; i < organism.size(); i++) {
      if (organism.get(i).getType().equals("Cooperator")) {
        totalC++;
      } else if (organism.get(i).getType().equals("Defector")) {
        totalD++;
      } else if (organism.get(i).getType().equals("PartialCooperator")) {
        totalP++;
      }


    }

    @SuppressWarnings("unchecked")
    Pair<String, Integer>[] p = (Pair<String, Integer>[]) (new Pair[3]);
    p[0] = new Pair<String, Integer>("Cooperator", totalC);
    p[1] = new Pair<String, Integer>("Defector", totalD);
    p[2] = new Pair<String, Integer>("PartialCooperator", totalP);

    return p;

  }

}
