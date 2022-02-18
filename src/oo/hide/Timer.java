package oo.hide;

public class Timer {
    private long start = System.currentTimeMillis();

    public String getPassedTime() {
        double timeDifference = System.currentTimeMillis() - start;
        return String.format("%s sek", timeDifference / 1000);
    }

}
