package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {

        var meuFilme = new Filme("O Poderoso Chefão", 1980);
        meuFilme.avalia(9);
        var outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        var lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // f1 esta referenciado o mesmo espaço que filmeDoPaulo
        Filme f1 = filmeDoPaulo;

        //Method Reference
        //lista.forEach(System.out::println);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                //var filme = (Filme) item;
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);
        //Ordenando
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        System.out.println("Lista de Títulos Ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        //Comprando com criterio de ordenacao
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
