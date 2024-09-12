public class InverterString {

    public InverterString(){}


    public String inverterString(String palavra){
        int i = 0;
        int j = palavra.length() -1;
        char[] result = palavra.toCharArray();
        while(i <= j){
            char aux = result[j];
            result[j] = result[i];
            result[i] = aux;
            i++;
            j--;
        }
        return new String(result);
    }


}
