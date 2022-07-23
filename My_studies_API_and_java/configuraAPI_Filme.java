import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class configuraAPI_Filme {
    public String frase;
    public List <conteudo> extrair_Conteudos (String json){
        var parser = new JsonParser();
        List<Map<String, String>> ItemList = parser.parse(json);

        List<conteudo> itens = new ArrayList<>();

        for (Map<String,String> Itens : ItemList){
          String 
          title = Itens.get("title"),
          url_Image = Itens.get("image"),

          title2 = String.format("Name: %s\n", Itens.get("title")), 
          image = String.format("Image_Poster: %s\n", Itens.get("url")), 
          imDbRating = String.format("Rating: %s", Itens.get("imDbRating")),

          ANSI_YELLOW = "\u001B[33m",
          ANSI_RESET = "\u001B[0m",
          ANSI_BLUE = "\u001B[34m",
          ANSI_CYAN = "\u001B[36m",
          
          star_emoji;
          
          var conteudo =  new conteudo(title, url_Image);
          Float i;

          System.out.println(ANSI_YELLOW+title2+ANSI_RESET+
            ANSI_BLUE+image+ANSI_RESET+
            ANSI_CYAN+imDbRating+ANSI_RESET);
          
          i = Float.parseFloat(Itens.get("imDbRating"));

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
            }else if (i >= 10){
              star_emoji = "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n";
              System.out.println(star_emoji);
              frase = "FILME FOD**";
            } 
          }

          itens.add(conteudo);
        }
        return itens;
    }
}
