package generics.connection;

import java.util.List;

public class ConnectionFinder {

    private String[][] connects;

//    [[a,b], []]

    public void addAll(List<Connection> connections) {
        throw new RuntimeException("not implemented yet");
    }

    public void add(Connection connection) {
        for (String[] connect : connects) {
            for (String s : connect) {
            if (s.equals(connection.getFrom())) {

            }
            }
        }
        System.out.println(connection.getFrom());
    }

    public boolean hasConnection(String a, String b) {
        throw new RuntimeException("not implemented yet");
    }

    public List<String> findConnection(String a, String b) {
        throw new RuntimeException("not implemented yet");
    }
}



//{a -> b
// b -> c
//