import java.util.HashMap;

public class FaturamentoMensal {

    public FaturamentoMensal(){

    }

    public double menorValor(HashMap<Integer, Double> map){

        double atualMenorValor = Double.POSITIVE_INFINITY;
        for(double val : map.values()){
            if(val > 0) {
                atualMenorValor = Math.min(atualMenorValor, val);
            }
        }
        return atualMenorValor;
    }

    public double maiorValor(HashMap<Integer, Double> map){

        double atualMaiorValor = -1;
        for(double val : map.values()){
            atualMaiorValor = Math.max(atualMaiorValor, val);
        }
        return atualMaiorValor;
    }

    public Integer mediaValor(HashMap<Integer, Double> map){
        double media = map.values().stream()
                .filter(valor -> valor > 0)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        int valoresAcimaDaMedia = (int) map.values().stream()
                .filter(valor -> valor > media)
                .count();

        return valoresAcimaDaMedia;
    }

}
