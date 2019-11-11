package model;

import exceptions.WrongInputException;

import java.util.ArrayList;
import java.util.List;

public class ListOfStats {
    List<Stat> stats = new ArrayList<Stat>();


   //EFFECTS: Adds a string into the arraylist
    public Stat addStat(String str) throws WrongInputException {
        //Stat s = new Stat();
        Stat s = new Stat(str);

        stats.add(s);
        return s;
    }

    //REQUIRES: A list of strings
    //EFFECTS: prints out each element in the list
    public void printStats(){
        for (Stat s : stats)
       System.out.println(s.toString());
    }

    //REQUIRES: an ArrayList
    //EFFECTS: gives the size of the list
    public Integer size(){
       return stats.size();
    }

    //EFFECTS: gets the element in a list corresponding to the number
    public Stat get(int num){
        return stats.get(num);
    }
}
