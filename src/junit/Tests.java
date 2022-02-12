package junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@SuppressWarnings("PMD")
public class Tests {

    @Test
    public void equalityExamples() {
//        assertTrue(1==1);
//        Integer x2 = 128;
//        Integer y2 = 128;
//        assertTrue(x2.equals(y2));
//        String a = "a";
//        assertTrue("abc".equals(a + "bc"));
    }

    @Test
    public void assertThatAndAssertEqualsExample() {
        assertEquals(1 + 2, 3);
        assertThat(3, is(3));
        assertThat(1 + 2, is(not(1)));

        assertThat(new int[]{1, 2, 3}, is(new int[]{1, 2, 3}));
//        assertThat(new int[] {1, 2, 3}, is (new int[] {1, 2}));
    }

    @Test
    public void findsSpecialNumbers() {
        assertTrue(Code.isSpecial(0));
        assertTrue(Code.isSpecial(1)); //true
        assertTrue(Code.isSpecial(2)); //true
        assertTrue(Code.isSpecial(3)); //true
        assertFalse(Code.isSpecial(4)); //false

        assertTrue(Code.isSpecial(11)); // true
        assertFalse(Code.isSpecial(15)); //false

        assertTrue(Code.isSpecial(36)); //true
        assertFalse(Code.isSpecial(37)); //false
    }

    @Test
    public void findsLongestStreak() {
        assertThat(Code.longestStreak(""), is(0));
        assertThat(Code.longestStreak(null), is(0));
        assertThat(Code.longestStreak("aabbb"), is(3));
        assertThat(Code.longestStreak("aaabb"), is(3));
        assertThat(Code.longestStreak("ababbbbcbbbbb"), is(5));
    }

    @Test
    public void findsModeFromCharactersInString() {

        assertThat(Code.mode(null), is(nullValue()));
        assertThat(Code.mode(""), is(nullValue()));
        assertThat(Code.mode("abcb"), is('b'));
        assertThat(Code.mode("cbbc"), is('c'));
        // other test cases for mode() method
    }

    @Test
    public void countsCharactersInString() {
        assertThat(Code.getCharacterCount("", 'a'), is(0));
        assertThat(Code.getCharacterCount("aaabc", 'a'), is(3));
    }

    @Test
    public void removesDuplicates() {
        assertThat(Code.removeDuplicates(arrayOf(1, 1)), is(arrayOf(1)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 1, 3, 2)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 3)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(100, 0, 3, 100, 0, 4, 562, 4)),
                is(arrayOf(100, 0, 3, 4, 562)));

        assertThat(Code.removeDuplicates(arrayOf(1,2,3,2,5,5,2,1,7,8,4,4,33)), is(arrayOf(1,2,3,5,7,8,4,33)));
    }

    @Test
    public void sumsIgnoringDuplicates() {
        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 1)), is(1));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 1, 3, 2)), is(6));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 3)), is(6));
    }

    private int[] arrayOf(int... numbers) {
        return numbers;
    }

}
