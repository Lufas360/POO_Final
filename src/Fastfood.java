import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Fastfood extends Restaurante implements Serializable{
    int drive_thru;
    double drive_medio;

    public double getDrive_medio() {
        return drive_medio;
    }

    public void setDrive_medio(double drive_medio) {
        this.drive_medio = drive_medio;
    }

    public int getDrive_thru() {
        return drive_thru;
    }

    public void setDrive_thru(int drive_thru) {
        this.drive_thru = drive_thru;
    }

    @Override
    public double despesa(){
        return empregados*salario;
    }

    @Override
    public double receita(){
        return (mesas_interiores*faturacao+drive_thru*drive_medio)*dias_funcionamento;
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
        s.addElement("Restaurante FastFood");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Clientes diarios: " + clientes);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "fastfood";}

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<String>();
        List.add(String.valueOf(drive_thru));
        List.add(String.valueOf(drive_medio));
        List.add(String.valueOf(dias_funcionamento));
        List.add(String.valueOf(mesas_interiores));
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
