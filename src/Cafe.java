import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Cafe extends Restauracao implements Serializable{
    int cafes_dia;

    public int getCafes_dia() {
        return cafes_dia;
    }

    public void setCafes_dia(int cafes_dia) {
        this.cafes_dia = cafes_dia;
    }

    @Override
    public double despesa(){
        return empregados*salario;
    }

    @Override
    public double receita(){
        return cafes_dia*faturacao;
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
        s.addElement("Café");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Clientes diarios: " + clientes);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "cafe";};

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<>();
        List.add(String.valueOf(cafes_dia));
        List.add(String.valueOf(faturacao));
        List.add(String.valueOf(empregados));
        List.add(String.valueOf(salario));
        List.add(String.valueOf(clientes));
        List.add(nome);
        List.add(distrito);
        List.add(String.valueOf(coordenadas.getGraus_latitude()));
        List.add(String.valueOf(coordenadas.getMinutos_latitude()));
        List.add(String.valueOf(coordenadas.getGraus_longitude()));
        List.add(String.valueOf(coordenadas.getMinutos_longitude()));
        return List;
    }
}
