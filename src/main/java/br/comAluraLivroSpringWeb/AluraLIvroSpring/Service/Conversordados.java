package br.comAluraLivroSpringWeb.AluraLIvroSpring.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversordados {
    ObjectMapper mapper = new ObjectMapper();

    public <T> T conversorDeJson(String json,Class<T> classe){
        try {
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
