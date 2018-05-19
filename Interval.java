
class Interval{
    private double value1;
    private double value2;
    private boolean isLast;//o último intervalo é [a,b] e não [a,b[ como os outros, daí a necessidade de apontar isso

    public Interval(double value1, double value2, boolean isLast) {
        this.value1 = value1;
        this.value2 = value2;
        this.isLast = isLast;
    }

    public isInside(double value){ //para ver se está dentro do intervalo
        if(value >= value1 && value < value2) return true;
        else if(value == value2 && isLast) return true;
        else return false;
    }
}