package exceptions.basic;

public class TryCatchSample {
    public String readDataFrom(Resource resource) {
        resource.open();
        String data;
        try {
            data = resource.read();
        } catch (Exception e) {
            resource.close();
            return "someDefaultValue";
        }
        resource.close();
        return data;
    }

    public static void main(String[] args) {
        Resource resource = new Resource().setData("stuff");

        String data = new TryCatchSample().readDataFrom(resource);
        System.out.println(data);
    }
}
