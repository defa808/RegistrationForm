package ua.kpi;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class Model {

    private int numGuess;
    private int prevNum;
    private int nextNum;

    public int getNextNum() {
        return nextNum;
    }

    public int getPrevNum() {
        return prevNum;
    }

    public void setNextNum(int nextNum) {
        this.nextNum = nextNum;
    }

    public void setPrevNum(int prevNum) {
        this.prevNum = prevNum;
    }

    public int getNumGuess() {
        return numGuess;
    }

    public void setNumGuess(int numGuess) {
        this.numGuess = numGuess;
    }
}
