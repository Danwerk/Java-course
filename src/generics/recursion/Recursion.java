package generics.recursion;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion {

    public List<String> getParts(Path path) {
        List<String> files = new ArrayList<>();
        Path runner = path;
        while (runner != null) {
            System.out.println(runner.getFileName());
            files.add(String.valueOf(runner.getFileName()));
            runner = runner.getParent();
        }

        Collections.reverse(files);
        return files;
    }

    public List<String> getParts2(Path path) {
        if (path.getParent() != null) {
            getParts2(path.getParent());
        }
        System.out.println(path.getFileName());
        return null;

    }

    public List<String> getParts3(Path path, List<String> parts) {
        if (path.getParent() != null) {
            getParts3(path.getParent(), parts);
        }
        parts.add(path.getFileName().toString());
        return parts;
    }

    public List<String> getParts4(Path path) {
        List<String> elements = new ArrayList<>();
        return getParts3(path, elements);
    }
}
