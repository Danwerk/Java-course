package reflection.tester;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private List<String> result = new ArrayList<>();

    public void runTests(List<String> testClassNames) throws Exception {
        for (String testClassName : testClassNames) {

            Class<?> clazz = Class.forName(testClassName);
//            System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
            Object instance = clazz.getDeclaredConstructor().newInstance();

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


//                    System.out.println("ok method" + method.getName());

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
        System.out.println(result);
    }

    public String getResult() {
        return String.join(",", result);
    }


}


//
//
//
//
//
//
//
//
//
//
//
//    if (expected != null) {
//            try {
//
//            method.invoke(instance);
//
//            } catch (Exception e) {
//
//
//            Class<? extends Throwable> throwableCause = e.getCause().getClass();
//
//        if (expected == throwableCause) {
//        result.add(method.getName() + "() - OK");
//
//        } else if (expected.isAssignableFrom(IllegalStateException.class)) {
//        result.add(method.getName() + "() - OK");
//        } else {
//        result.add(method.getName() + "() - FAILED");
//        }
//
//        }
//
//
////                    Class<? extends Throwable> expected = cause.getClass();
////                    if (IllegalStateException.class.isAssignableFrom(expected)) {
////                        result.add(method.getName() + "() - OK");
////                    } else {
////                        result.add(method.getName() + "() - FAILED");
////                    }
//        } else {
//        try {
//        method.invoke(instance);
//        result.add(method.getName() + "() - OK");
//        } catch (Exception e) {
//        result.add(method.getName() + "() - FAILED");
//
//        }
//
//        }
//
//        }
//        }
//        System.out.println(result);
//        }
