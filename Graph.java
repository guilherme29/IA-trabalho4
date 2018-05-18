
class Graph{
    //public static Node root;
    /*
    public static void main(String[] args){
        Graph alfa = new Graph();
        root = new ValueDouble(1.0,2.0);
    }
    */

    Graph(Object[][] table, boolean[] rowList, boolean[] colList){
        //rowList dá as linhas que ainda estão a ser usadas
        //colList dá as colunas que ainda estão a ser usadas
        //true = a ser usado, false = já não pode ser usado

        //ver se a tabela é pura aqui.
        boolean isPure = true;
        Object value;

        for(int i=0;i<table.length;i++){
            if(rowList[i] == false){
                continue; //ignora linhas da tabela inúteis.
            }

        }

    }
}