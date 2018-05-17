import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import java.io.*; //para ter ficheiros.


class Data {
    //tabela com os valores da árvore
    private static Vector<String[]> table;
    private static Object[][] formattedTable;
    //para cada posição do vetor fará corresponder os atributos possíveis
    private static ArrayList<HashSet<String>> attributes;
    private static Data data = null;
    private static String[] attributeNames;

    public static Data getData(String file){//Data é um Singleton, apenas uma instância de cada vez.
        if(data == null){
            data = new Data(file);
            return data;
        }
        else return data;
    }

    private Data(String file){
        clearData();
        setData(file);
        setFormattedData();
    }

    public Object[][] getTable(){ //para ter a tabela formatada com os dados
        return formattedTable;
    }

    public String[] getAttributeNames(){ //para ter uma lista de nomes dos Atributos
        return attributeNames;
    }

    private static void setData(String file){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            if(br.ready()){//a primeira linha é lixo
                attributes = new ArrayList<>();
                String[] firstLine = br.readLine().split(",");//isto é a primeira linha que é lixo
                setAttributeNames(firstLine);
                int size = firstLine.length - 1;
                for(int i=0;i<size;i++){
                    attributes.add(new HashSet<String>());
                }
            }
            table = new Vector<>();
            while(br.ready()){//agora a data mesmo
                String[] line2 = br.readLine().split(",");//linha ainda com a ID, é preciso tirar
                String[] line = new String[line2.length-1];
                for(int i=0;i<line.length;i++){
                    line[i]=line2[i+1];
                }
                table.add(line);//adicionamos a linha à tabela
                for(int i=0;i<attributes.size();i++){//adicionamos ao HashSet da col o novo elem
                    if(!attributes.get(i).contains(line[i])){
                        attributes.get(i).add(line[i]);
                    }
                }
            }

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if(br !=null){
                try{
                    br.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private static void setAttributeNames(String[] firstLine){
        attributeNames = new String[firstLine.length-1];
        for(int i=0;i<attributeNames.length;i++){
            attributeNames[i] = firstLine[i+1];
        }
    }

    private static void clearData() { //limpa informação que já lá estava
        if (table != null){
            if (!table.isEmpty()) {
                table.clear();
            }
        }
        if(formattedTable != null){
            formattedTable = null;
        }
        if(attributes != null){
            attributes = null;
        }
    }

    private static void setFormattedData(){
        formattedTable = new Object[table.size()][table.elementAt(0).length];
        for(int i=0;i<attributes.size();i++){
            boolean isNumeric = true;
            for(String test : attributes.get(i)){
                try {
                    Double.parseDouble(test);

                } catch (NumberFormatException e) { //se um valor não poder ser número nenhum nessa coluna pode
                    isNumeric = false;
                    break;
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
            if(isNumeric){
                for(int j=0;j<table.size();j++){
                    formattedTable[j][i] = Double.parseDouble(table.elementAt(j)[i]); //copia como Double
                }
            }
            else{
                for(int j=0;j<table.size();j++){
                    formattedTable[j][i] = table.elementAt(j)[i]; //copia a String
                }
            }
        }
    }

}