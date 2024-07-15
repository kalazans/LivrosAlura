package br.comAluraLivroSpringWeb.AluraLIvroSpring.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApi {

    public String consumoApi(String url){
        HttpClient c = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> rep = c.send(req, HttpResponse.BodyHandlers.ofString());
            return rep.body().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
