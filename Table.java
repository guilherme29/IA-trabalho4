import java.util.Vector;
import java.util.HashSet;

class Table{
    private static Object[][] table;

    Table(Object[][] table){
        this.table = table;
    }

    public static double calculateEntropy(Vector<Integer> indexList, int col,
                                       HashSet<Object> values){
        double result = 0;
        Object[] valueList = new Object[values.size()];//o HashSet num vetor.
        int[] quantity = new int[values.size()];//quantidade de cada elem do hashset
        int i = 0;
        for(Object value : values){
            valueList[i] = value;
            i++;
        }
        for(Integer nline : indexList){
            for(int j=0;j<table.length;j++){
                if(j == nline){ //para a linha da tabela dada pelo indíce
                    for(int k=0;k<valueList.length;k++){
                        if(table[col][nline].equals(valueList[k])){
                            quantity[k]++;
                        }
                    }
                }
            }
        }
        for(i=0;i<quantity.length;i++){
            System.out.print(quantity[i] + " ");
            System.out.println(valueList[i]);
        }

        return 0;
    }
}