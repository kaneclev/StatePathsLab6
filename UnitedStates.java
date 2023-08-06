import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UnitedStates {
    private ArrayList<State> states;

    public UnitedStates() {
        // 50 states + DC
        states = new ArrayList<>(51);

        // load in code file and fill up the states ArrayList
        loadCodesFile();
        loadNeighborsFile();
    }

    private void loadNeighborsFile(){
        Scanner neighbors;

        try {
            // Create a scanner object from a file
            neighbors = new Scanner(new File("contiguous-usa.txt"));
            // NOTE: if we wanted to create a Scanner from user input:
            // new Scanner(System.in);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find the adjacent states files");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        // Loop over all of the lines in the file
        while(neighbors.hasNextLine()) {
            String line = neighbors.nextLine();
            String[] values = line.split(" ");

            /*
             * values[0] is one state code (e.g., PA)
             * values[1] is another state code (e.g., NY)
             *
             * TODO Add code to add these neighbor pairs
             *
             * (1) Find the state in states ArrayList that has the code
             * values[0]
             * (2) Add a neighbor to that state
             *     - values[1]
             *     - look up the state object for values[1]
             *
             * Do this in the opposite direction as well.
             */

        }

        return;
    }

    /**
     * Return the State object from the states ArrayList that
     * has the correct two-letter code.
     * preconditions: code must exist in the states array
     *
     * @param code Two-letter abbreviation for a state
     * @return the State from the states ArrayList that is associated
     * with the code provided
     */
    private State findState(String code) {
        for (State s : states) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }
    // find the state using an iterator (just another way of doing it)
    private State findState2(String code) {
        // get the iterator from the AL
        Iterator<State> i = states.iterator();
        while(i.hasNext()) {
            State s = i.next();
            if (s.getCode().equals(code)) {
                return s;

            }
        }
        return null;
    }


    /**
     * load in the information stored in codes.csv
     * create each state and add it to the states ArrayList
     */

    private State findState3(String code) {
        // now we are finding the state using a new method
        int idx = states.indexOf(new State(code, code));
        // above, we are using a bogus state object to search
        // the "equals" method in the State class only looks at the first parameter; the second
        // parameter doesn't really matter in this situatio
        return states.get(idx);
    }
    private void loadCodesFile() {
        // scanner can be used to read a file
        Scanner codes;

        try {
            // opened the file for reading with the scanner
            codes = new Scanner(new File("codes.csv"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not find the codes file");
            e.printStackTrace();
            System.exit(1);
            return; // this line should never be reached
        }

        // if we get here, we have successfully opened the file

        // TODO loop through all lines of the file to add states

        return;
    }

    public void printStates() {
        // TODO Print out each state and all its neighbors
    }
}
