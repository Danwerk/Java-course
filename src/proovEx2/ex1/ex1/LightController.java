package proovEx2.ex1.ex1;

import java.util.ArrayList;
import java.util.List;

public class LightController {

    private List<Light> lights = new ArrayList<>();

    public void addLight(Object light) {
        lights.add((Light) light);

    }


    public String asString() {
        String result = "";
        for (Light light : lights) {
            result += light.asString();
        }
        return result;
    }

    public void turnOn(int index) {
        lights.set(index, new LightOn());
    }

    public void toggle(int index) {
        if (lights.get(index).asString() == "X") {

            lights.set(index, new LightOn());
        } else {
            lights.set(index, new LightOff());
        }
    }
}

