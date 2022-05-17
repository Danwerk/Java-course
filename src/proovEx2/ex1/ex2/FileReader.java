package proovEx2.ex1.ex2;

public class FileReader {

    private String data;
    private Throwable throwable;

    public FileReader(Throwable throwable) {
        this.throwable = throwable;
    }

    public FileReader(Throwable throwable, String data) {
        this.data = data;
        this.throwable = throwable;
    }

    public String readFile() throws Throwable {
        if (throwable != null) {
            throw throwable;
        }

        return data;
    }

}
