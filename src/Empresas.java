import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Classe com a lista de empresas*/
public class Empresas implements Serializable{

    ArrayList<Empresa> emp = new ArrayList<>();
    ArrayList<Empresa> mercearias = new ArrayList<>();
    ArrayList<Empresa> restauracao = new ArrayList<>();

    public ArrayList<Empresa> getMercearias() {
        return mercearias;
    }

    public ArrayList<Empresa> getRestauracao() {
        return restauracao;
    }

    public ArrayList<Empresa> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Empresa> emp) {
        this.emp = emp;
    }
    /*Metodo que cria uma instancia da classe  restaurante fastfood e adiciona à lista*/

    public void newFastfood(int drive, double drive_medio, int dias_funcionamento, int mesas, double faturacao, int empregados, double salario, int clientes, String nome, String distrito, Coordenadas c){
    Fastfood f = new Fastfood();
    f.setDrive_thru(drive);
    f.setDrive_medio(drive_medio);
    f.setDias_funcionamento(dias_funcionamento);
    f.setMesas_interiores(mesas);
    f.setFaturacao(faturacao);
    f.setEmpregados(empregados);
    f.setSalario(salario);
    f.setClientes(clientes);
    f.setNome(nome);
    f.setDistrito(distrito);
    f.setCoordenadas(c);
    emp.add(f);
}

/*Metodo que cria uma instancia da classe restaurante local e adiciona à lista*/
    public void newLocal(int esplanada,double licenca, int dias_funcionamento, int mesas, double faturacao, int empregados, double salario, int clientes, String nome, String distrito, Coordenadas c){
        Locais l = new Locais();
        l.setMesas_esplanada(esplanada);
        l.setLicensa_mesa_ano(licenca);
        l.setDias_funcionamento(dias_funcionamento);
        l.setMesas_interiores(mesas);
        l.setFaturacao(faturacao);
        l.setEmpregados(empregados);
        l.setSalario(salario);
        l.setClientes(clientes);
        l.setNome(nome);
        l.setDistrito(distrito);
        l.setCoordenadas(c);
        emp.add(l);
    }

    /*Metodo que cria uma instancia da classe pastelaria e adiciona à lista*/
    public void newPastelaria( int bolos , double faturacao, int empregados, double salario, int clientes, String nome, String distrito, Coordenadas c){
        Pastelaria f = new Pastelaria();
        f.setBolos_dia(bolos);
        f.setFaturacao(faturacao);
        f.setEmpregados(empregados);
        f.setSalario(salario);
        f.setClientes(clientes);
        f.setNome(nome);
        f.setDistrito(distrito);
        f.setCoordenadas(c);
        emp.add(f);
    }

    /*Metodo que cria uma instancia da classe café e adiciona à lista*/
    public void newCafe( int cafe , double faturacao, int empregados, double salario, int clientes, String nome, String distrito, Coordenadas c){
        Cafe f = new Cafe();
        f.setCafes_dia(cafe);
        f.setFaturacao(faturacao);
        f.setEmpregados(empregados);
        f.setSalario(salario);
        f.setClientes(clientes);
        f.setNome(nome);
        f.setDistrito(distrito);
        f.setCoordenadas(c);
        emp.add(f);
    }

    /*Metodo que cria uma instancia da classe frutaria e adiciona à lista*/
    public void newFrutaria( int produtos , double limpeza,double faturacao, String nome, String distrito, Coordenadas c){
        Frutaria f = new Frutaria();
        f.setProdutos(produtos);
        f.setFaturacao(faturacao);
        f.setLimpeza_anual(limpeza);
        f.setNome(nome);
        f.setDistrito(distrito);
        f.setCoordenadas(c);
        emp.add(f);
    }


    /*Metodo que cria uma instancia da classe mercado e adiciona à lista*/
    public void newMercado( double area , int tipo, double limpeza,double faturacao, String nome, String distrito, Coordenadas c){
        Mercado f = new Mercado();
        f.setArea(area);
        f.setTipo(tipo);
        f.setFaturacao(faturacao);
        f.setLimpeza_anual(limpeza);
        f.setNome(nome);
        f.setDistrito(distrito);
        f.setCoordenadas(c);
        emp.add(f);
    }

    public void listasSeparadas(){
        ArrayList<Empresa> rest = new ArrayList<>();
        ArrayList<Empresa> merc = new ArrayList<>();
        for(int i = 0; i< emp.size(); i++){
            if(emp.get(i).tipo() == "frutaria" || emp.get(i).tipo() == "mercado"){
                merc.add(emp.get(i));
            }
            if(emp.get(i).tipo() == "cafe" || emp.get(i).tipo() == "pastelaria" || emp.get(i).tipo() == "fastfood" || emp.get(i).tipo() == "locais"){
                rest.add(emp.get(i));
            }
        }
        mercearias = merc;
        restauracao = rest;
    }

    public void sortLucroGeral(){
        Collections.sort(emp, new Comparator<Empresa>()
            {
                public int compare(Empresa e1, Empresa e2)
                {
                    return Double.compare((e2.receita()- e2.despesa()), (e1.receita()-e1.despesa()));
                }
            });
    }

    public void sortReceita(){
        Collections.sort(restauracao, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare(e2.receita(), e1.receita());
            }
        });
        Collections.sort(mercearias, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare(e2.receita(), e1.receita());
            }
        });
    }

    public void sortDespesa(){
        Collections.sort(restauracao, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare(e2.despesa(), e1.despesa());
            }
        });
        Collections.sort(mercearias, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare(e2.despesa(), e1.despesa());
            }
        });
    }

    public void sortLucro(){
        Collections.sort(restauracao, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare((e2.receita()- e2.despesa()), (e1.receita()-e1.despesa()));
            }
        });
        Collections.sort(mercearias, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare((e2.receita()- e2.despesa()), (e1.receita()-e1.despesa()));
            }
        });
    }

    public void sortCLientes(){
        Collections.sort(restauracao, new Comparator<Empresa>()
        {
            public int compare(Empresa e1, Empresa e2)
            {
                return Double.compare(e2.getClientes(), e1.getClientes());
            }
        });
    }
}
