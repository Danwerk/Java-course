package reflection.tester;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private List<String> result = new ArrayList<>();

    public void runTests(List<String> testClassNames) {

        for (String testClassName : testClassNames) {

            Class<?> clazz = null;
            try {
                clazz = Class.forName(testClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
            Object instance = null;
            try {
                instance = clazz.getDeclaredConstructor().newInstance();

            } catch (InstantiationException e) {
                throw new RuntimeException(e);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);

            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);

            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);

            }

            for (Method method : clazz.getDeclaredMethods()) {
                MyTest myTest = method.getAnnotation(MyTest.class);
                if (myTest == null) {
                    continue;
                }


                Class<? extends Throwable> expected = myTest.expected();


                try {
                    method.invoke(instance);
                    if (expected.getSimpleName().equals("None")) {
                        result.add(method.getName() + "() - OK");
                    } else {
                        result.add(method.getName() + "() - FAILED");
                    }


                } catch (Exception e) {
                    Class<? extends Throwable> throwableCause = e.getCause().getClass();
                    if (throwableCause == expected) {
                        result.add(method.getName() + "() - OK");
                    } else if (expected.isAssignableFrom(throwableCause)) {
                        result.add(method.getName() + "() - OK");
                    } else {
                        result.add(method.getName() + "() - FAILED");
                    }
                }

            }
        }
    }

    public String getResult() {
        return String.join(",", result);
    }

}
