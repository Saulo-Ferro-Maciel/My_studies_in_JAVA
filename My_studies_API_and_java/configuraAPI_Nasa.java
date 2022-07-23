import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class configuraAPI_Nasa {
    public List <conteudo> extrair_Conteudos (String json){
        var parser = new JsonParser();
        List<Map<String, String>> ItemList = parser.parse(json);

        List<conteudo> itens = new ArrayList<>();

        for (Map<String,String> Itens : ItemList){
            String title = Itens.get("title");
            String url_Image = Itens.get("url");
            var conteudo =  new conteudo(title, url_Image);

            itens.add(conteudo);
        }
        return itens;
    }
}
