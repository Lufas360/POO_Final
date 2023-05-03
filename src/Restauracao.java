import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

abstract class Restauracao extends Empresa implements Serializable{
    int empregados;
    double salario;
    int clientes;

    public int getEmpregados() {
        return empregados;
    }

    public void setEmpregados(int empregados) {
        this.empregados = empregados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getClientes() {
        return clientes;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    @Override
    public DefaultListModel<String> listar(){return null;}
    @Override
    public String tipo(){return "";}
}
