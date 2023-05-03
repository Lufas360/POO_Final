import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

abstract class Mercearia extends Empresa implements Serializable{
    double limpeza_anual;

    public double getLimpeza_anual() {
        return limpeza_anual;
    }

    public int getClientes() {
        return 0;
    }

    public void setLimpeza_anual(double limpeza_anual) {
        this.limpeza_anual = limpeza_anual;
    }

    @Override
    public DefaultListModel<String> listar(){return null;}

    @Override
    public String tipo(){return "";}
}
