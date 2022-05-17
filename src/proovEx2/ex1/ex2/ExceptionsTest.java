package proovEx2.ex1.ex2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class ExceptionsTest {


    @Test(expected = MyException2.class)
    public void methodReadDataThrowsCorrectExceptions() throws Throwable {
        var exceptionThatFileReaderThrows = new RuntimeException();

        new Exceptions(new FileReader(exceptionThatFileReaderThrows)).readData();
    }

    @Test
    public void methodReadDataCanReadDataFromFileReader() throws Throwable {
        var randomData = String.valueOf(System.currentTimeMillis());
        var dataRead = new Exceptions(new FileReader(null, randomData)).readData();

        assertThat(dataRead, is(randomData));
    }

    @Test
    public void subThrowsExceptionWithCorrectRootCause() {
        var exceptionThatFileReaderThrows = new IllegalStateException();

        try {
            new Exceptions(new FileReader(exceptionThatFileReaderThrows)).sub();
        } catch (Exception e) {
            assertThat(getRootCause(e), sameInstance(exceptionThatFileReaderThrows));
            return;
        }

        fail();
    }

    @Test
    public void mainCanReadDataOriginatedFromFileReader() throws Throwable {
        var randomData = String.valueOf(System.currentTimeMillis());
        var dataRead = new Exceptions(new FileReader(null, randomData)).main();

        assertThat(dataRead, is(randomData));
    }


    @Test(expected = MyException3.class)
    public void mainThrowsCorrectException() throws Throwable {
        var exceptionThatFileReaderThrows = new IllegalArgumentException();

        new Exceptions(new FileReader(exceptionThatFileReaderThrows)).main();
    }

    @Test
    public void mainThrowsExceptionWithCorrectRootCause() {
        var exceptionThatFileReaderThrows = new IllegalArgumentException();

        try {
            new Exceptions(new FileReader(exceptionThatFileReaderThrows)).main();
        } catch (Throwable e) {
            assertThat(getRootCause(e), sameInstance(exceptionThatFileReaderThrows));
            return;
        }

        fail();
    }

    private Throwable getRootCause(Throwable t) {
        while (t.getCause() != null) {
            t = t.getCause();
        }

        return t;
    }
}
