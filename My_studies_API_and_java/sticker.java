import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;

public class sticker {
    void criando(InputStream inputURL,String nomeArquivo,String extensaoArquivo,String frase) throws IOException{
        //InputStream inputURL = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_3.jpg").openStream();
        BufferedImage imageOriginal = ImageIO.read(inputURL); // Ler Imagem
        int largura = imageOriginal.getWidth(); // Manipula largura
        int altura = imageOriginal.getHeight(); // Manipula altura

        int novaAltura = altura+200; // atribui um aumento na altura (Y) da imagem
        int novaLargura = largura; // atribui um aumento na largura (X) da imagem

        BufferedImage novaImagem = new BufferedImage(novaLargura,novaAltura,BufferedImage.TRANSLUCENT); // Gera nova imagem
        Graphics2D grafico_novaImagem = (Graphics2D) novaImagem.getGraphics(); // Nova imagem é estabelecida para desenho
        grafico_novaImagem.drawImage(imageOriginal, 0, 0, null); // Desenha imagem nova na antiga - atualiza a antiga.

        Font font = new Font(Font.SANS_SERIF, Font.BOLD,72);
        float d = novaLargura/4.5f;
        grafico_novaImagem.setFont(font);
        grafico_novaImagem.setColor(Color.YELLOW);
        grafico_novaImagem.drawString(frase, d, novaAltura -100);

        String nome_Arquivo = String.format("bin/%s.%s", nomeArquivo,extensaoArquivo);

        ImageIO.write(novaImagem, extensaoArquivo, new File(nome_Arquivo)); // Saida da imagem
    }
}
