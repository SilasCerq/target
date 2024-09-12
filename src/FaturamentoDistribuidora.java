import java.util.HashMap;
import java.util.Map;

public class FaturamentoDistribuidora {

    public FaturamentoDistribuidora(){

    }

    private double faturamentoTotal(Map<String, Double> map){
        double totalFaturamento = map.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return totalFaturamento;
    }

    public Map<String, Double> percentualEstado(Map<String, Double> map) {
        double total = faturamentoTotal(map);
        HashMap<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / total) * 100;
            result.put(estado, percentual);
        }
        return result;
    }



}
