class NodeDouble extends Node{
    private int value1;
    private int value2;

    public NodeDouble(int value1, int value2) {
        this.value1 = value1;
        this.value2 = (value1 + value2)/2;
    }
}