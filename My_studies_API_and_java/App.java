import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;;

public class App {
    public static void main(String[] args) throws Exception {
      // Variables:
      var hello = "\nHello Java\nWorking for the first time with API in java\n";
      var cliente = new clientURL();
      var Sticker = new sticker();
      var Configura_Api_Filme = new configuraAPI_Filme();
      var Configura_API_Nasa = new configuraAPI_Nasa();
      
      /*"https://api.mocki.io/v2/549a5d8b" "https://api.mocki.io/v2/549a5d8b/NASA-APOD"*/ 

      String url;
      int resposta;
      Scanner entrada = new Scanner(System.in);

      System.out.println("\nWhich API do you want to use? NASA or Movies?\n    Type it:\n     1 for NASA\n     2 for MOVIES");
      resposta = entrada.nextInt();

      if (resposta == 1){
        url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";

        var json = cliente.conecta(url);
        List<conteudo> conteudos =  Configura_API_Nasa.extrair_Conteudos(json);

        for (int a = 0; a < conteudos.size(); a ++){

          conteudo dados = conteudos.get(a);

          InputStream inputURL = new URL(dados.getUrl_Image()).openStream();
          String nomeArquivo = dados.getTitle(),
          extensaoArquivo = "png",
          frase = "IMERSÃO JAVA\nALURA";

          Sticker.criando(inputURL, nomeArquivo, extensaoArquivo, frase);

        }
      } else{
        url = "https://api.mocki.io/v2/549a5d8b";

        var json = cliente.conecta(url);
        List<conteudo> conteudos =  Configura_Api_Filme.extrair_Conteudos(json);

        for (int a = 0; a < conteudos.size(); a ++){

          conteudo dados = conteudos.get(a);

          InputStream inputURL = new URL(dados.getUrl_Image()).openStream();
          String nomeArquivo = dados.getTitle(),
          extensaoArquivo = "png",
          frase = Configura_Api_Filme.frase;

          Sticker.criando(inputURL, nomeArquivo, extensaoArquivo, frase);

        }
      } 
      System.out.println(hello);
    }
}
 