import java.util.Vector;
import java.util.HashSet;
import java.lang.Math;

class Table{
    private static Object[][] table;

    Table(Object[][] table){
        this.table = table;
    }


    //se entropia = 0 conjunto é puro
    //senão deve-se escolher o menor possível ( o mais afastado do 0)
    public static double calculateEntropy(Vector<Integer> indexList, int col,
                                       HashSet<Object> values){
        Object[] valueList = new Object[values.size()];//o HashSet num vetor.
        int[] quantity = new int[values.size()];//quantidade de cada elem do hashset
        int i = 0;
        for(Object value : values){
            valueList[i] = value;
            i++;
        }
        //cálculo das quantidades de cada elemento para um vetor com as quantidades de cada
        //elemento do hashset dado
        i = 0;
        for(Object value : valueList){
            for(int k=0;k<table.length;k++){
                if(table[k][col].equals(value)){
                    quantity[i]++;
                }
            }
            i++;
        }
        //Entropy(Decision) = – p(Yes)*log2p(Yes) – p(No)*log2p(No) -p(OutraCoisa)*log2p(OutraCoisa) ..
        double result = 0;
        for(i=0;i<quantity.length;i++){
            result += -1*quantity[i]*Math.log(quantity[i])/Math.log(2);
        }
        return result;
    }

    public void print(){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}