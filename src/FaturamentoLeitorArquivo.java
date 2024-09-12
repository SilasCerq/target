import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaturamentoLeitorArquivo {

    private String arquivo;

    public FaturamentoLeitorArquivo(String arquivo){
        this.arquivo = arquivo;
    }

    public Map<Integer, Double> lerFaturamentoMensal() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String, Object>> faturamentoList = objectMapper.readValue(
                new File(arquivo),
                new TypeReference<List<Map<String, Object>>>() {}
        );
        Map<Integer, Double> faturamentoMap = new HashMap<>();
        for (Map<String, Object> item : faturamentoList) {
            Integer dia = ((Number) item.get("dia")).intValue();
            Double valor = ((Number) item.get("valor")).doubleValue();
            faturamentoMap.put(dia, valor);
        }
        return faturamentoMap;
    }



}
