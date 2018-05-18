import java.util.HashSet;

abstract class Node{
    private String attribute;
    HashSet<Node> sons;

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}