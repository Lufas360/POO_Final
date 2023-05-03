import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Frutaria extends Mercearia implements Serializable{
    int produtos;
    int faturacao_anual_produto;

    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public int getFaturacao_anual_produto() {
        return faturacao_anual_produto;
    }

    public void setFaturacao_anual_produto(int faturacao_anual_produto) {
        this.faturacao_anual_produto = faturacao_anual_produto;
    }

    @Override
    public double despesa(){
        return limpeza_anual;
    }

    @Override
    public double receita(){
        return produtos*faturacao;
    }

    @Override
    public String lucro(){
        if(receita()- despesa()> 0){
            return ("Tem lucro de " +(receita()- despesa()));
        }
        else{
            return ("Prejuiso de "+(receita()- despesa()));
        }
    }

    @Override
    public DefaultListModel<String> listar(){
        DefaultListModel<String> s = new DefaultListModel<>();
        s.addElement("Frutaria");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "frutaria";}

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<String>();
        List.add(String.valueOf(produtos));
        List.add(String.valueOf(limpeza_anual));
        List.add(String.valueOf(faturacao));
        List.add(nome);
        List.add(distrito);
        List.add(String.valueOf(coordenadas.getGraus_latitude()));
        List.add(String.valueOf(coordenadas.getMinutos_latitude()));
        List.add(String.valueOf(coordenadas.getGraus_longitude()));
        List.add(String.valueOf(coordenadas.getMinutos_longitude()));
        return List;
    }
}
