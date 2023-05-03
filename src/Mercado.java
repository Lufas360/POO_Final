import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Mercado extends Mercearia implements Serializable{
    String tipo;
    double area;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if(tipo == 0){
            this.tipo = "Mini";
        }
        if(tipo == 1){
            this.tipo = "Super";
        }
        if(tipo == 2){
            this.tipo = "Hiper";
        }

    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double despesa(){
        return limpeza_anual;
    }

    @Override
    public double receita(){
        return area*faturacao;
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
        s.addElement(tipo+"mercado");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "mercado";}

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<>();
        List.add(String.valueOf(area));
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
