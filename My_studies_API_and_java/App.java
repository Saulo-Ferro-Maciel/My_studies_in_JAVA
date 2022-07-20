import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
      var Sticker = new sticker();
      
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

        InputStream inputURL = new URL(movie.get("image")).openStream();
        String nomeArquivo = movie.get("title"),
        extensaoArquivo = "png",
        frase = null;

        String title = String.format("Name: %s\n", movie.get("title")), 
        image = String.format("Image_Poster: %s\n", movie.get("image")), 
        imDbRating = String.format("Rating: %s", movie.get("imDbRating")),
        ANSI_YELLOW = "\u001B[33m",
        ANSI_RESET = "\u001B[0m",
        ANSI_BLUE = "\u001B[34m",
        ANSI_CYAN = "\u001B[36m",
        star_emoji = null;
        
        System.out.println(ANSI_YELLOW+title+ANSI_RESET+
          ANSI_BLUE+image+ANSI_RESET+
          ANSI_CYAN+imDbRating+ANSI_RESET);
        
        float i = 0;
        i = Float.parseFloat(movie.get("imDbRating"));
        
        if (i == 8 || 9 > i){
          star_emoji = "⭐⭐⭐⭐⭐⭐⭐⭐\n";
          System.out.println(star_emoji);
          frase = "FILME BOM";
        } else if (i == 9 || 10 > i){
          star_emoji = "⭐⭐⭐⭐⭐⭐⭐⭐⭐\n";
          System.out.println(star_emoji);
          frase = "FILME TOP";
        } else{
          if (i == 5 || 6 > i){
            star_emoji = "⭐⭐⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME LEGAL";
          } else if (1==i||2 > i){
            star_emoji = "⭐\n";
            System.out.println(star_emoji);
            frase = "FILME RUIM";
          }else if (2==1||3 > i){
            star_emoji = "⭐⭐\n";
            System.out.println(star_emoji);
            frase = "POUCO RUIM";
          }else if (3==i||4 > i){
            star_emoji = "⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME MELHORZIN";
          }else if (4==i||5 > i){
            star_emoji = "⭐⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME LEGALZINHO";
          }else if (6 == i || 7 > i){
            star_emoji = "⭐⭐⭐⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME LEGALZINHO";
          }else if (7 == i || 8 > i){
            star_emoji = "⭐⭐⭐⭐⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME LEGALZINHO";
          }
          if (i >= 10){
            star_emoji = "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n";
            System.out.println(star_emoji);
            frase = "FILME FOD**";
          } 
        }
        Sticker.criando(inputURL, nomeArquivo, extensaoArquivo, frase);
        star_emoji = null;
      }
      System.out.println(hello); 
    }
}
 