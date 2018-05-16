import java.util.Scanner;
class Test{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String file;
        System.out.println("ficheiro:");
        file = stdin.next() + ".csv";
        Data info = Data.getData(file);
        Object[][] table = info.getTable();
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(table[i][j]);
                if(table[i][j] instanceof Double){
                    System.out.println("--> Double");
                }
                else if(table[i][j] instanceof String){
                    System.out.println("--> String");
                }
            }
            System.out.println();
        }
    }
}