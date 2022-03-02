package inheritance.stack;

import java.util.Stack;

public class LoggingStack extends Stack<Integer> {
    @Override
    public Integer push(Integer item) {
        System.out.println("pushed item: " + item);
        return super.push(item);
    }

    @Override
    public Integer pop() {
        Integer pop = super.pop();
        System.out.println("popped item: " + pop);
        return pop;
    }

    public void pushAll(Integer ... numbers) {
        for (Integer number : numbers) {
            push(number);
        }
    }
}
