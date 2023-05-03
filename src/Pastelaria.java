import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Pastelaria extends Restauracao implements Serializable{
    int bolos_dia;


    public int getBolos_dia() {
        return bolos_dia;
    }

    public void setBolos_dia(int bolos_dia) {
        this.bolos_dia = bolos_dia;
    }

    @Override
    public double despesa(){
        return empregados*salario;
    }

    @Override
    public double receita(){
        return bolos_dia*faturacao;
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
        s.addElement("Pastelaria");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Clientes diarios: " + clientes);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "pastelaria";}

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<String>();
        List.add(String.valueOf(bolos_dia));
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
