package oo.hide;

public class Fibonacci {
    private int nextNum = 1;
    private int currentNum = 0;

    public int nextValue() {
        int result = currentNum;
        currentNum = nextNum;
        nextNum = nextNum + result;   //n-1 ja n-2le väärtustatakse uued väärtused, st. n-1 muutub sum-ks ja n-2 muutub n1-ks.
        return result;

    }

}


// fibonacci formula fib(n) = fib(n - 1) + fib(n - 2) arvu n väärtus on kahe eelmise arvu summa.
