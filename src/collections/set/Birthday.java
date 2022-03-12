package collections.set;

import org.junit.Test;

import java.util.*;


public class Birthday {

    // pick random day in a loop
    // find how many iterations till first collision (got the same number)
    @Test
    public void runCode() {
        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < 1000; i++) {
            list.add(findFirstCollision());
        }
        for (Integer integer : list) {
            total += integer;
        }
        System.out.println(total / list.size());


    }

    private int findFirstCollision() {
        Random r = new Random();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 365; i++) {
            int randomDayOfYear = r.nextInt(365);
            if (set.contains(randomDayOfYear)) {
                return i;
            } else {
                set.add(randomDayOfYear);
            }

        }
        throw new IllegalStateException("whoops something went wrong");
    }

}
