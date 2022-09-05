package com.br.diogenes.pelando.resources;

import com.br.diogenes.pelando.model.Promocao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParse {
    private Document document;
    private Promocao promo = new Promocao();
    public HtmlParse (Document document, Promocao promo){
        this.document = document;
        this.promo = promo;
    }
    public HtmlParse (){
    }

    public Promocao promocao  (String args){
        try{
            Promocao promo = new Promocao();
            Document document = Jsoup.connect(args).get();
            HtmlParse parse = new HtmlParse(document, promo);
            promo = parse.getPromotion(args);
            return promo;
        }catch(IOException e) {
            e.printStackTrace();

        }
        return null;
    }
    private Promocao getPromotion(String url){
        Elements titulo = document.select("Pdpstyled__ProductName-sc-dq3ox2-34 kDVnxM");
        Elements preco = document.select("_dltm33");
        Elements imagem = document.select("_2awk4px");
        Elements descricao = document.select("_a2g8ep");
        promo.setImagem(imagem.attr("src"));
        promo.setTitulo(titulo.text());
        promo.setPreco(Double.valueOf(preco.text()));
        promo.setDescricao(descricao.text());
        promo.setUrl(url);
        return promo;
    }
}
