import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

abstract class Empresa implements Serializable {
    String nome;
    String distrito;
    Coordenadas coordenadas;

    double faturacao;

    public double getFaturacao() {
        return faturacao;
    }

    public void setFaturacao(double faturacao) {
        this.faturacao = faturacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }


    public double despesa(){return 0;}
    public String tipo(){return "";}
    public double receita(){return 0;}
    public String lucro(){return "";}
    public DefaultListModel<String> listar(){return null;}

    abstract public ArrayList<String> getInfo();
    abstract public int getClientes();
}
