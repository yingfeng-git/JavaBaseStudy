package ClassicCase.Tree;

public class Info {
    boolean isBalance;
    int height;

    public Info(int height) {
        this.height = height;
    }

    public Info(boolean isBalance, int height) {
        this.isBalance = isBalance;
        this.height = height;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"isBalance\":")
                .append(isBalance);
        sb.append(",\"height\":")
                .append(height);
        sb.append('}');
        return sb.toString();
    }
}
