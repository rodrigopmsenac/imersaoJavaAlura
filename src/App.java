import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        /*        
        Ola mundo

        System.out.println("Hello, World!");
        */

        //Criar conexão http e buscar dados da API

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
        String corpo_api = resposta.body();
        //System.out.println(corpo_api);
        
        //Extrair dados desejado (top filmes: Titulo, Poster-Capa, Classificação-Ranking)
        retornoList retornar_lista = new retornoList();
        List<Map<String, String>> listaDeFilmes = retornar_lista.parser(corpo_api);
        /*Tras o tamanho da fila 
        System.out.println(listaDeFilmes.size());*/
        /*Tras o marco zero da fila
        System.out.println(listaDeFilmes.get(0));*/

        //Extrair dados desejado (top filmes: Titulo, Poster-Capa, Classificação-Ranking)
        //titulo completo
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Titulo");
            System.out.println(filme.get("fullTitle"));
            System.out.println();
            System.out.println("Capa");
            System.out.println(filme.get("image"));
            System.out.println();
            System.out.println("Ranking");
            System.out.println(filme.get("imDbRating"));
            System.out.println();                   
        }

        //Exibir e manipular dados



    }
}
