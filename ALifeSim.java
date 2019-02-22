package artificialLife;

import java.io.PrintWriter;

public class ALifeSim {


  public static void main(String[] args) throws Exception {

    int iterate;
    int coop;
    int def;
    int part;

    PrintWriter pen = new PrintWriter(System.err, true);

    if (args.length != 4) { 
      pen.println("Incorrect number of parameters");
      System.exit(4);
    }
    iterate = Integer.parseInt(args[0]);
    coop = Integer.parseInt(args[1]);
    def = Integer.parseInt(args[2]);
    part = Integer.parseInt(args[3]);

    Pair<String, Integer> c = new Pair<String, Integer>("Cooperator", coop);
    Pair<String, Integer> d = new Pair<String, Integer>("Defector", def);
    Pair<String, Integer> p = new Pair<String, Integer>("PartialCooperator", part);

    @SuppressWarnings("unchecked")
    Pair<String, Integer>[] array = (Pair<String,Integer>[]) (new Pair[] {c, d, p});


   // try {
      Population pop = new Population(array);
      for (int i = 0; i < iterate; i++) {
        pop.update();
      }
      array = pop.getPopulationCounts();
      pen.println("After " + iterate + " ticks:");
      pen.println("Cooperators = " + array[0].getRight());
      pen.println("Defectors = " + array[1].getRight());
      pen.println("PartialCooperators = " + array[2].getRight());
    
      pen.println("Mean Cooperation Probability = " + pop.calculateCooperationMean());
    
  //  } catch (Exception e) {
   //   throw new IllegalArgumentException();
   // }
    
  }
}
