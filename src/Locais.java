import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Locais extends Restaurante implements Serializable{
    int mesas_esplanada;
    double licensa_mesa_ano;

    public int getMesas_esplanada() {
        return mesas_esplanada;
    }

    public void setMesas_esplanada(int mesas_esplanada) {
        this.mesas_esplanada = mesas_esplanada;
    }

    public double getLicensa_mesa_ano() {
        return licensa_mesa_ano;
    }

    public void setLicensa_mesa_ano(double licensa_mesa_ano) {
        this.licensa_mesa_ano = licensa_mesa_ano;
    }

    @Override
    public double despesa(){
        return empregados*salario+ mesas_esplanada*licensa_mesa_ano;
    }

    @Override
    public double receita(){
        return (mesas_esplanada+mesas_interiores)*faturacao*dias_funcionamento;
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
        s.addElement("Restaurante Local");
        s.addElement("Nome: " + nome);
        s.addElement("Distrito: "+distrito);
        s.addElement("Clientes diarios: " + clientes);
        s.addElement("Despesa: "+ despesa()+"$");
        s.addElement("Receita: "+ receita() +"$");
        s.addElement(lucro()+"$");

        return (s);
    }
    @Override
    public String tipo(){return "locais";}

    public ArrayList<String> getInfo(){
        ArrayList<String> List= new ArrayList<String>();
        List.add(String.valueOf(mesas_esplanada));
        List.add(String.valueOf(licensa_mesa_ano));
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
