package ProducerAndConsumerProblem;

public class Msg {
    int id;
    String msg;

    public Msg(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"Msg\":{"
                + "\"id\":"
                + id
                + ",\"msg\":\""
                + msg + '\"'
                + "}}";
    }
}
