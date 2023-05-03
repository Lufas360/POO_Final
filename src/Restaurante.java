import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

abstract class Restaurante extends Restauracao implements Serializable{
    int dias_funcionamento;
    int mesas_interiores;

    public int getDias_funcionamento() {
        return dias_funcionamento;
    }

    public void setDias_funcionamento(int dias_funcionamento) {
        this.dias_funcionamento = dias_funcionamento;
    }

    public int getMesas_interiores() {
        return mesas_interiores;
    }

    public void setMesas_interiores(int mesas_interiores) {
        this.mesas_interiores = mesas_interiores;
    }

    @Override
    public DefaultListModel<String> listar(){return null;}
    @Override
    public String tipo(){return "";}
}
