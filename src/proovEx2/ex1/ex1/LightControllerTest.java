package proovEx2.ex1.ex1;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class LightControllerTest {

    @Test
    public void controllerHasStringRepresentation() {
        LightController controller = new LightController();

        List.of(new LightOff(), new LightOff(),
                new LightOn(), new LightOff(),
                new LightOff()).forEach(controller::addLight);

        assertThat(controller.asString(), is("XXOXX"));
    }

    @Test
    public void canTurnLightsOn() {
        LightController controller = getSampleLightController();

        controller.turnOn(4);

        assertThat(controller.asString(), is("XXXXO"));
    }

    @Test
    public void canToggleLights() {
        LightController controller = getSampleLightController();

        controller.toggle(1);

        assertThat(controller.asString(), is("XOXXX"));

        controller.toggle(1);

        assertThat(controller.asString(), is("XXXXX"));
    }

    private LightController getSampleLightController() {
        LightController controller = new LightController();

        List.of(new LightOff(), new LightOff(),
                new LightOff(), new LightOff(),
                new LightOff()).forEach(controller::addLight);

        return controller;
    }

    @Test
    public void usesOnlyAllowedFields() {
        Field[] fields = LightController.class.getDeclaredFields();

        assertThat(fields.length, is(1));

        assertThat(fields[0].getGenericType().getTypeName(),
                is("java.util.List<eksam.ex1.Light>"));
    }

    @Test
    public void noClassTests() {
        String source = List.of(LightController.class, Light.class, LightOn.class, LightOff.class)
                .stream().map(c -> "src/" + c.getName().replaceAll("\\.", "/") + ".java")
                .map(fn -> readSourceFile(Paths.get(fn)))
                .map(contents -> contents.replaceAll("\\s", ""))
                .collect(Collectors.joining());

        assertThat(source, not(containsString("instanceof")));
        assertThat(source, not(containsString(".getClass(")));
        assertThat(source, not(containsString(".class")));
    }

    private String readSourceFile(Path path) {
        try {
            return Files.lines(path).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
