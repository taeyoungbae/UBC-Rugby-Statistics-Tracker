package model;

public class Stat {
    String s;
    String i;

    // MODIFIES: this
    // this is a setter
   public Stat (String s){
        this.s = s;
    }

    //REQUIRES: a string
    //EFFECTS: this method enables the printing of a string list
    @Override
    public String toString(){
      return s.toString();
    }

}
