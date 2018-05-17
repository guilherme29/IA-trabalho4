import java.util.HashSet;

abstract class Value{
    HashSet<Attribute> sons;

    Value(){
        this.sons = new HashSet<Attribute>();
    }
}