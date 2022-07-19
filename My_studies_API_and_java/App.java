import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
      // Variables:
      var hello = "\nHello Java\nWorking for the first time with API in java\n";
      
      String url = "https://api.mocki.io/v2/549a5d8b";
      URI site = URI.create(url);
      var client = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(site).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      String body = response.body();

      // Extraindo só dados que interessam (titulo, poster, classificação)
      var parser = new JsonParser();
      List<Map<String, String>> MovieList = parser.parse(body);
      
      // Exibindo dados:
      for (Map<String,String> movie : MovieList){
          String title = String.format("Name: %s", movie.get("title")), 
          image = String.format("Image_Poster: %s", movie.get("image")), 
          imDbRating = String.format("Rating: %s", movie.get("imDbRating")),
          ANSI_YELLOW = "\u001B[33m",
          ANSI_RESET = "\u001B[0m",
          ANSI_BLUE = "\u001B[34m",
          ANSI_CYAN = "\u001B[36m"; 
          
          System.out.println(ANSI_YELLOW+title+ANSI_RESET);
          System.out.println(ANSI_BLUE+image+ANSI_RESET);
          System.out.println(ANSI_CYAN+imDbRating+ANSI_RESET);
          System.out.println();
        }

        System.out.println(hello); 

    }
}
 