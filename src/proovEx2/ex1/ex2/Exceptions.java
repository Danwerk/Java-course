package proovEx2.ex1.ex2;

public class Exceptions {

    private FileReader fileReader;

    public Exceptions(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String main() throws MyException3 {
        String result = "";// delete this
        result = this.sub();
        return result;
        // call this.sub() and return result. Should not use fileReader directly.
    }

    public String sub() throws MyException3 {
        String result;
        try {
            result = this.readData();
        } catch (MyException2 e) {
            throw new MyException3(e);
        }
        return result;

        // call this.readData() and return result. Should not use fileReader directly.
    }

    public String readData() throws MyException2 {
        String result;
        try {
            result = fileReader.readFile();
        } catch (Throwable e) {
            throw new MyException2(e);
        }
        return result;
        // call fileReader.readFile() and return result.
    }
}