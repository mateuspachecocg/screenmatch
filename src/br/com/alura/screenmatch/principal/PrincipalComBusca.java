package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        var busca = "";
        List<Titulo> titulos = new ArrayList<>();

        var gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            var endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=6585022c";

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                var jsonRepresentation = response.body();

                TituloOmdb meuTituloOmdb = gson.fromJson(jsonRepresentation, TituloOmdb.class);
                titulos.add(new Titulo(meuTituloOmdb));

            } catch (IllegalArgumentException e) {
                System.out.println("Erro no argumetno do Request Http");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            }
        }

        FileWriter escrita = new FileWriter(("filmes.json"));
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou corretamente!!!");

    }
}
