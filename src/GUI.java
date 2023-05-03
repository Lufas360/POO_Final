import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/*
* @author Luis Henriques
* @version 1.0
* */

/*
* Classe main que gere o gui
*/
public class GUI implements ActionListener {
    int tracker;
    Empresas empresas = new Empresas();
    private JFrame principal = new JFrame();
    private JPanel panel_princ = new JPanel();
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JFrame frame_menu = new JFrame();
    private JPanel panel_menu = new JPanel();
    JButton button = new JButton("Nova empresa");
    JButton button_listar = new JButton("Listar empresas");
    JButton next_show = new JButton("próximo");
    JButton previous_show = new JButton("anterior");
    JButton frutaria = new JButton("Frutaria");
    JButton mercado = new JButton("Mercado");
    JButton cafe = new JButton("Café");
    JButton pastelaria = new JButton("Pastelaria");
    JButton locais = new JButton("Restaurante Local");
    JButton fastFood = new JButton("Restaurante Fast Food");
    private static JTextField nome = new JTextField();
    private static JTextField distrito = new JTextField();
    private static JTextField empregados = new JTextField();
    private static JTextField salario = new JTextField();
    private static JTextField clientes = new JTextField();
    private static JTextField cafes = new JTextField();
    private static JTextField faturacao = new JTextField();
    private static JTextField bolos = new JTextField();
    private static JTextField dias_funcionamento = new JTextField();
    private static JTextField mesas_interiores = new JTextField();
    private static JTextField mesas_esplanada = new JTextField();
    private static JTextField licensa_esplanada = new JTextField();
    private static JTextField driveThru = new JTextField();
    private static JTextField drive_medio = new JTextField();
    private static JTextField lat_graus = new JTextField();
    private static JTextField lat_min = new JTextField();
    private static JTextField lon_graus = new JTextField();
    private static JTextField lon_min = new JTextField();
    private static JTextField limpeza = new JTextField();
    private static JTextField produtos = new JTextField();


    String[] types = {"Mini", "Super", "Hiper"};
    private JComboBox tipos = new JComboBox(types);
    private static JTextField area = new JTextField();

    JButton Stats = new JButton("Informações");
    JButton Apagar = new JButton("Apagar");
    JButton Editar = new JButton("Editar");
    JButton cancel = new JButton("Cancelar");
    JButton button_fastfood = new JButton("Confirmar");
    JButton button_locais = new JButton("Confirmar");
    JButton button_pastelaria = new JButton("Confirmar");
    JButton button_cafe = new JButton("Confirmar");
    JButton button_frutaria = new JButton("Confirmar");
    JButton button_mercado = new JButton("Confirmar");

    JLabel Lnome = new JLabel("Nome");
    JLabel Ldistrito = new JLabel("Distrito");
    JLabel latitude = new JLabel("Latitude");
    JLabel longitude = new JLabel("Longitude");

    public GUI(){
        Stats.addActionListener(this);
        Editar.addActionListener(this);
        next_show.addActionListener(this);
        previous_show.addActionListener(this);
        button.addActionListener(this);
        button_listar.addActionListener(this);
        button_mercado.addActionListener(this);
        cancel.addActionListener(this);
        button_fastfood.addActionListener(this);
        button_locais.addActionListener(this);
        button_pastelaria.addActionListener(this);
        button_cafe.addActionListener(this);
        button_frutaria.addActionListener(this);
        frutaria.addActionListener(this);
        mercado.addActionListener(this);
        cafe.addActionListener(this);
        pastelaria.addActionListener(this);
        locais.addActionListener(this);
        fastFood.addActionListener(this);
        Apagar.addActionListener(this);
        System.out.print(carregarDados());
        empresas.sortLucroGeral();
        main_menu();

    }

    /*
    * metodo para criar o main menu
    * */

    public void main_menu(){
        principal.setTitle("Star Thrive");
        principal.setSize(500,200);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel_princ.setLayout(null);

        button.setBounds(150,20, 200,25);
        panel_princ.add(button);
        button_listar.setBounds(150, 50, 200,25);
        panel_princ.add(button_listar);
        Stats.setBounds(150, 80, 200,25);
        panel_princ.add(Stats);
        principal.add(panel_princ);
        principal.setVisible(true);

    }



/*
* Metodo para criar a pagina de criar empresa
* */
    private void standardInsertSetup(){
        frame.setTitle("Star Thrive");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        Lnome.setBounds(10,20,265,25);
        panel.add(Lnome);
        Ldistrito.setBounds(10,50,265,25);
        panel.add(Ldistrito);
        latitude.setBounds(10, 80, 100, 25);
        panel.add(latitude);
        longitude.setBounds(240, 80, 100, 25);
        panel.add(longitude);

        nome.setBounds(250,20,165,25);
        panel.add(nome);
        distrito.setBounds(250,50,165,25);
        panel.add(distrito);
        lat_graus.setBounds(95, 80, 45, 25);
        panel.add(lat_graus);
        lat_min.setBounds(150, 80, 45, 25);
        panel.add(lat_min);
        lon_graus.setBounds(315, 80, 45, 25);
        panel.add(lon_graus);
        lon_min.setBounds(370, 80, 45,25);
        panel.add(lon_min);
    }

    /*Metodo para criar a pagina de criar Restaurante fast food*/
    public void InsertFastfood(){
        standardInsertSetup();
        JLabel Lempregados = new JLabel("Numero de empregados");
        JLabel Lsalario = new JLabel("Salario medio anual");
        JLabel Lclientes = new JLabel("Media clientes diarios");
        JLabel Ldias_funcionamento = new JLabel("Media de dias de funcionamento");
        JLabel Lmesas_interiores = new JLabel("Numero de mesas interiores");
        JLabel Lfaturacao_diaria = new JLabel("Media de faturação diaria por mesa");
        JLabel LdriveThru = new JLabel("DriveThru's por dia");
        JLabel Ldrive_medio = new JLabel("Media de faturacao por DriveThru");

        Lempregados.setBounds(10,110,265,25);
        panel.add(Lempregados);
        Lsalario.setBounds(10,140,265,25);
        panel.add(Lsalario);
        Lclientes.setBounds(10,170,265,25);
        panel.add(Lclientes);
        Ldias_funcionamento.setBounds(10,200,265,25);
        panel.add(Ldias_funcionamento);
        Lmesas_interiores.setBounds(10,230,265,25);
        panel.add(Lmesas_interiores);
        Lfaturacao_diaria.setBounds(10,260,265,25);
        panel.add(Lfaturacao_diaria);
        LdriveThru.setBounds(10,290,265,25);
        panel.add(LdriveThru);
        Ldrive_medio.setBounds(10, 320,265, 25);
        panel.add(Ldrive_medio);

        empregados.setBounds(250,110,165,25);
        panel.add(empregados);
        salario.setBounds(250,140,165,25);
        panel.add(salario);
        clientes.setBounds(250,170,165,25);
        panel.add(clientes);
        dias_funcionamento.setBounds(250,200,165,25);
        panel.add(dias_funcionamento);
        mesas_interiores.setBounds(250,230,165,25);
        panel.add(mesas_interiores);
        faturacao.setBounds(250,260,165,25);
        panel.add(faturacao);
        driveThru.setBounds(250,290,165,25);
        panel.add(driveThru);
        drive_medio.setBounds(250,320,165,25);
        panel.add(drive_medio);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_fastfood.setBounds(10, 350, 165, 25);
        panel.add(button_fastfood);
        frame.add(panel);
        frame.setVisible(true);
    }

    /*Metodo para criar a pagina de criar Restaurante Local*/
    public void InsertLocal(){
        standardInsertSetup();
        JLabel Lempregados = new JLabel("Numero de empregados");
        JLabel Lsalario = new JLabel("Salario medio anual");
        JLabel Lclientes = new JLabel("Media clientes diarios");
        JLabel Ldias_funcionamento = new JLabel("Media de dias de funcionamento");
        JLabel Lmesas_interiores = new JLabel("Numero de mesas interiores");
        JLabel Lfaturacao_diaria = new JLabel("Media de faturação diaria por mesa");
        JLabel Lesplanada = new JLabel("Numero de mesas na esplanada");
        JLabel Llicensa = new JLabel("Valor licensa anual de esplanada");

        Lempregados.setBounds(10,110,265,25);
        panel.add(Lempregados);
        Lsalario.setBounds(10,140,265,25);
        panel.add(Lsalario);
        Lclientes.setBounds(10,170,265,25);
        panel.add(Lclientes);
        Ldias_funcionamento.setBounds(10,200,265,25);
        panel.add(Ldias_funcionamento);
        Lmesas_interiores.setBounds(10,230,265,25);
        panel.add(Lmesas_interiores);
        Lfaturacao_diaria.setBounds(10,260,265,25);
        panel.add(Lfaturacao_diaria);
        Lesplanada.setBounds(10,290,265,25);
        panel.add(Lesplanada);
        Llicensa.setBounds(10, 320,265, 25);
        panel.add(Llicensa);

        empregados.setBounds(250,110,165,25);
        panel.add(empregados);
        salario.setBounds(250,140,165,25);
        panel.add(salario);
        clientes.setBounds(250,170,165,25);
        panel.add(clientes);
        dias_funcionamento.setBounds(250,200,165,25);
        panel.add(dias_funcionamento);
        mesas_interiores.setBounds(250,230,165,25);
        panel.add(mesas_interiores);
        faturacao.setBounds(250,260,165,25);
        panel.add(faturacao);
        mesas_esplanada.setBounds(250,290,165,25);
        panel.add(mesas_esplanada);
        licensa_esplanada.setBounds(250,320,165,25);
        panel.add(licensa_esplanada);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_locais.setBounds(10, 350, 165, 25);
        panel.add(button_locais);
        frame.add(panel);
        frame.setVisible(true);
    }
    /*Metodo para criar a pagina de criar Pastelaria*/
    public void InsertPastelaria(){
        standardInsertSetup();
        JLabel Lempregados = new JLabel("Numero de empregados");
        JLabel Lsalario = new JLabel("Salario medio anual");
        JLabel Lclientes = new JLabel("Media clientes diarios");
        JLabel Lbolos = new JLabel("Media de bolos vendidos por dia");
        JLabel Lfaturacao_diaria = new JLabel("Média de faturação anual por bolo vendido");

        Lempregados.setBounds(10,110,265,25);
        panel.add(Lempregados);
        Lsalario.setBounds(10,140,265,25);
        panel.add(Lsalario);
        Lclientes.setBounds(10,170,265,25);
        panel.add(Lclientes);
        Lfaturacao_diaria.setBounds(10,200,265,25);
        panel.add(Lfaturacao_diaria);
        Lbolos.setBounds(10,230,265,25);
        panel.add(Lbolos);

        empregados.setBounds(250,110,165,25);
        panel.add(empregados);
        salario.setBounds(250,140,165,25);
        panel.add(salario);
        clientes.setBounds(250,170,165,25);
        panel.add(clientes);
        bolos.setBounds(250,200,165,25);
        panel.add(bolos);
        faturacao.setBounds(250,230,165,25);
        panel.add(faturacao);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_pastelaria.setBounds(10, 350, 165, 25);
        panel.add(button_pastelaria);
        frame.add(panel);
        frame.setVisible(true);
    }
    /*Metodo para criar a pagina de criar Café*/
    public void InsertCafe(){
        standardInsertSetup();
        JLabel Lempregados = new JLabel("Numero de empregados");
        JLabel Lsalario = new JLabel("Salario medio anual");
        JLabel Lclientes = new JLabel("Media clientes diarios");
        JLabel LCafe = new JLabel("Media de cafes vendidos por dia");
        JLabel Lfaturacao_diaria = new JLabel("Média faturação anual por café vendido");

        Lempregados.setBounds(10,110,265,25);
        panel.add(Lempregados);
        Lsalario.setBounds(10,140,265,25);
        panel.add(Lsalario);
        Lclientes.setBounds(10,170,265,25);
        panel.add(Lclientes);
        Lfaturacao_diaria.setBounds(10,200,265,25);
        panel.add(Lfaturacao_diaria);
        LCafe.setBounds(10,230,265,25);
        panel.add(LCafe);

        empregados.setBounds(250,110,165,25);
        panel.add(empregados);
        salario.setBounds(250,140,165,25);
        panel.add(salario);
        clientes.setBounds(250,170,165,25);
        panel.add(clientes);
        cafes.setBounds(250,200,165,25);
        panel.add(cafes);
        faturacao.setBounds(250,230,165,25);
        panel.add(faturacao);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_cafe.setBounds(10, 350, 165, 25);
        panel.add(button_cafe);
        frame.add(panel);
        frame.setVisible(true);
    }
    /*Metodo para criar a pagina de criar frutaria*/
    public void InsertFrutaria(){
        standardInsertSetup();
        JLabel Llimpeza = new JLabel("Custo anual de limpeza");
        JLabel Lprodutos = new JLabel("Numero de produtos");
        JLabel Lfaturacao = new JLabel("Média faturação anual/produto");

        Lprodutos.setBounds(10,110,265,25);
        panel.add(Lprodutos);
        Lfaturacao.setBounds(10,140,265,25);
        panel.add(Lfaturacao);
        Llimpeza.setBounds(10,170,265,25);
        panel.add(Llimpeza);

        produtos.setBounds(250,110,165,25);
        panel.add(produtos);
        faturacao.setBounds(250,140,165,25);
        panel.add(faturacao);
        limpeza.setBounds(250,170,165,25);
        panel.add(limpeza);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_frutaria.setBounds(10, 350, 165, 25);
        panel.add(button_frutaria);
        frame.add(panel);
        frame.setVisible(true);
    }
    /*Metodo para criar a pagina de criar mercado*/
    public void InsertMercado(){
        standardInsertSetup();
        JLabel Llimpeza = new JLabel("Custo anual de limpeza");
        JLabel Ltipo = new JLabel("Tipo de mercado");
        JLabel Lfaturacao = new JLabel("Média faturação anual/metro quadrado");
        JLabel Larea = new JLabel("Area dos corredores do mercado");

        Larea.setBounds(10,110,265,25);
        panel.add(Larea);
        Lfaturacao.setBounds(10,140,265,25);
        panel.add(Lfaturacao);
        Llimpeza.setBounds(10,170,265,25);
        panel.add(Llimpeza);
        Ltipo.setBounds(10, 200, 265, 25);
        panel.add(Ltipo);

        area.setBounds(250,110,165,25);
        panel.add(area);
        faturacao.setBounds(250,140,165,25);
        panel.add(faturacao);
        limpeza.setBounds(250,170,165,25);
        panel.add(limpeza);
        tipos.setBounds(250,200,165,25);
        panel.add(tipos);

        cancel.setBounds(250, 350, 165, 25);
        panel.add(cancel);
        button_mercado.setBounds(10, 350, 165, 25);
        panel.add(button_mercado);
        frame.add(panel);
        frame.setVisible(true);
    }



    /*Metodo para criar a pagina para escolher tipo de empresa para criar*/
    public void menu_criar_empresa(){
        frame_menu.setTitle("Star Thrive");
        frame_menu.setSize(500,500);
        frame_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame_menu.setSize(500,400);
        panel_menu.setLayout(null);

        frutaria.setBounds(10,20,200,25);
        panel_menu.add(frutaria);
        mercado.setBounds(250, 20,200, 25);
        panel_menu.add(mercado);
        cafe.setBounds(10, 50, 200, 25);
        panel_menu.add(cafe);
        pastelaria.setBounds(250, 50, 200,25);
        panel_menu.add(pastelaria);
        locais.setBounds(10, 80, 200,25);
        panel_menu.add(locais);
        fastFood.setBounds(250, 80,200,25);
        panel_menu.add(fastFood);

        frame_menu.add(panel_menu);
        frame_menu.setVisible(true);
    }

    //

    //Cria ficheiro.dat e guarda o objeto empresas
    public String guardarDados(){
        File ficheiro = new File("src/data/StarThrive.dat");
        try{
            FileOutputStream fos = new FileOutputStream(ficheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresas);
            oos.close();
            return "As alterações foram guardadas com sucesso.\n";
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            return "Não foi possivel guardar as alterações, ocurreu um erro a criar o ficheiro\n";
        }catch (IOException ex){
            return "Não foi possivel guardar as alterações, ocurreu um erro durante a escrita do ficheiro\n";
        }
    }

    public String carregarDados(){
        File ficheiro = new File("src/data/StarThrive.dat");
        if(!ficheiro.exists()){
            return carregarTXT();}
        else{
            return (carregarObjetos(ficheiro));}
    }

    public String carregarTXT(){
        File fileTXT = new File("src/data/StarThrive.txt");
        try (FileReader fr = new FileReader(fileTXT);
             BufferedReader br = new BufferedReader(fr)){
            String linha = br.readLine();
                while (linha != null){
                    String[] dados = linha.split("/");
                    switch (dados[0]){
                        case "cafe": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newCafe(Integer.parseInt(dados[5]),Double.parseDouble(dados[6]),Integer.parseInt(dados[7]),Double.parseDouble(dados[8]),Integer.parseInt(dados[9]),dados[10],dados[11],c);
                            break;
                        }
                        case "frutaria": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newFrutaria(Integer.parseInt(dados[5]),Double.parseDouble(dados[6]),Double.parseDouble(dados[7]),dados[8],dados[9],c);
                            break;
                        }
                        case"mercado": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newMercado(Integer.parseInt(dados[5]),Integer.parseInt(dados[6]),Double.parseDouble(dados[7]),Double.parseDouble(dados[8]),dados[9],dados[10],c);
                            break;
                        }
                        case "fastfood": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newFastfood(Integer.parseInt(dados[5]), Double.parseDouble(dados[6]), Integer.parseInt(dados[7]), Integer.parseInt(dados[8]), Double.parseDouble(dados[9]),Integer.parseInt(dados[10]),Double.parseDouble(dados[11]),Integer.parseInt(dados[12]),dados[13],dados[14],c);
                            break;
                        }
                        case "local": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newLocal(Integer.parseInt(dados[5]), Double.parseDouble(dados[6]), Integer.parseInt(dados[7]), Integer.parseInt(dados[8]), Double.parseDouble(dados[9]),Integer.parseInt(dados[10]),Double.parseDouble(dados[11]),Integer.parseInt(dados[12]),dados[13],dados[14],c);
                            break;
                        }
                        case "pastelaria": {
                            Coordenadas c = new Coordenadas();
                            c.Coordenadas(Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),Integer.parseInt(dados[3]),Integer.parseInt(dados[4]));
                            empresas.newPastelaria(Integer.parseInt(dados[5]), Double.parseDouble(dados[6]), Integer.parseInt(dados[7]), Double.parseDouble(dados[8]),Integer.parseInt(dados[9]),dados[10],dados[11],c);
                            break;
                        }
                    }
                    linha = br.readLine();
                }
                return "";
            } catch (FileNotFoundException e) {
                return "Erro a abrir ficheiro.";
            } catch (IOException e) {
                return "Erro a ler ficheiro.";
            }
    }

    //Lê o ficheiro de objetos
    public String carregarObjetos(File ficheiro){
        try{
            FileInputStream fis = new FileInputStream(ficheiro);
            ObjectInputStream ois = new ObjectInputStream(fis);
            empresas = ((Empresas)ois.readObject());
            ois.close();
            return "O ficheiro foi carregado com sucesso.\n";
        }catch (FileNotFoundException ex){
            return "Não foi possivel carregar as alterações, ocurreu um erro a abrir o ficheiro\n";
        }catch (IOException ex){
            ex.printStackTrace();
            return "Não foi possivel carregar as alterações, ocurreu um erro durante a leitura do ficheiro\n";
        }
        catch (ClassNotFoundException ex){
            return "Erro a converter objeto\n";
        }
    }


    public static void main(String[] args) {
        new GUI();

    }
/*Metodo para criar pagina para listar empresas*/
    public void menu_listar_empresas(int contador) {
        frame_menu.setTitle("Lista empresas");
        frame_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        next_show.setBounds(120, 350, 100, 25);
        previous_show.setBounds(10,350,100,25 );
        Apagar.setBounds(10, 385, 100, 25);
        Editar.setBounds(120, 385, 100, 25);
        panel_menu.add(Editar);
        panel_menu.add(Apagar);
        panel_menu.add(next_show);
        panel_menu.add(previous_show);


        frame_menu.setSize(500, 500);
        panel_menu.setLayout(null);

        //System.out.print(contador+ " ");
        if(empresas.getEmp().size() > contador){
            JList list = new JList<String>(empresas.getEmp().get(contador).listar());
            list.setBounds(10, 20, 400, 300);
            panel_menu.add(list);
        }
        cancel.setBounds(250, 350, 165, 25);
        panel_menu.add(cancel);

        frame_menu.add(panel_menu);
        frame_menu.setVisible(true);

    }


    public void menu_listar_estatistica() {
        frame_menu.setTitle("Estatisticas");
        frame_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_menu.setSize(1000, 550);
        panel_menu.setLayout(null);

        empresas.listasSeparadas();

        empresas.sortReceita();
        JLabel receitas_merc = new JLabel("Mercearias com maior e menor receita");
        JList max_receita_merc = new JList<String>(empresas.getMercearias().get(0).listar());
        JList min_receita_merc = new JList<String>(empresas.getMercearias().get(empresas.getMercearias().size()-1).listar());
        max_receita_merc.setBounds(10, 20, 170, 120);
        min_receita_merc.setBounds(160, 20, 170, 120);
        receitas_merc.setBounds(10, 140, 250, 25);
        panel_menu.add(min_receita_merc);
        panel_menu.add(max_receita_merc);
        panel_menu.add(receitas_merc);
        JLabel receitas_rest = new JLabel("Restauração com maior e menor receita");
        JList max_receita_rest = new JList<String>(empresas.getRestauracao().get(0).listar());
        JList min_receita_rest = new JList<String>(empresas.getRestauracao().get(empresas.getRestauracao().size()-1).listar());
        max_receita_rest.setBounds(10, 175, 170, 135);
        min_receita_rest.setBounds(160, 175, 170, 135);
        receitas_rest.setBounds(10, 310, 250, 25);
        panel_menu.add(min_receita_rest);
        panel_menu.add(max_receita_rest);
        panel_menu.add(receitas_rest);

        empresas.sortDespesa();
        JLabel despesas_merc = new JLabel("Mercearias com maior e menor despesa");
        JList max_despesa_merc = new JList<String>(empresas.getMercearias().get(0).listar());
        JList min_despesa_merc = new JList<String>(empresas.getMercearias().get(empresas.getMercearias().size()-1).listar());
        max_despesa_merc.setBounds(340, 20, 170, 120);
        min_despesa_merc.setBounds(490, 20, 170, 120);
        despesas_merc.setBounds(340, 140, 250, 25);
        panel_menu.add(min_despesa_merc);
        panel_menu.add(max_despesa_merc);
        panel_menu.add(despesas_merc);
        JLabel despesas_rest = new JLabel("Restauração com maior e menor despesa");
        JList max_despesa_rest = new JList<String>(empresas.getRestauracao().get(0).listar());
        JList min_despesa_rest = new JList<String>(empresas.getRestauracao().get(empresas.getRestauracao().size()-1).listar());
        max_despesa_rest.setBounds(340, 175, 170, 135);
        min_despesa_rest.setBounds(490, 175, 170, 135);
        despesas_rest.setBounds(340, 310, 250, 25);
        panel_menu.add(min_despesa_rest);
        panel_menu.add(max_despesa_rest);
        panel_menu.add(despesas_rest);

        empresas.sortLucro();
        JLabel lucro_merc = new JLabel("Mercearias com maior e menor lucro");
        JList max_lucro_merc = new JList<String>(empresas.getMercearias().get(0).listar());
        JList min_lucro_merc = new JList<String>(empresas.getMercearias().get(empresas.getMercearias().size()-1).listar());
        max_lucro_merc.setBounds(670, 20, 170, 120);
        min_lucro_merc.setBounds(820, 20, 170, 120);
        lucro_merc.setBounds(670, 140, 250, 25);
        panel_menu.add(min_lucro_merc);
        panel_menu.add(max_lucro_merc);
        panel_menu.add(lucro_merc);
        JLabel lucro_rest = new JLabel("Restauração com maior e menor lucro");
        JList max_lucro_rest = new JList<String>(empresas.getRestauracao().get(0).listar());
        JList min_lucro_rest = new JList<String>(empresas.getRestauracao().get(empresas.getMercearias().size()-1).listar());
        max_lucro_rest.setBounds(670, 175, 170, 135);
        min_lucro_rest.setBounds(820, 175, 170, 135);
        lucro_rest.setBounds(670, 310, 250, 25);
        panel_menu.add(min_lucro_rest);
        panel_menu.add(max_lucro_rest);
        panel_menu.add(lucro_rest);

        empresas.sortCLientes();
        JLabel clientes_rest = new JLabel("Restauração com maior capacidade de clientes");
        JList max_clientes_rest = new JList<String>(empresas.getRestauracao().get(0).listar());
        JList min_clientes_rest = new JList<String>(empresas.getRestauracao().get(1).listar());
        max_clientes_rest.setBounds(10, 345, 170, 135);
        min_clientes_rest.setBounds(160, 345, 170, 135);
        clientes_rest.setBounds(10, 480, 300, 25);
        panel_menu.add(min_clientes_rest);
        panel_menu.add(max_clientes_rest);
        panel_menu.add(clientes_rest);

        cancel.setBounds(350, 480, 165, 25);
        panel_menu.add(cancel);

        frame_menu.add(panel_menu);
        frame_menu.setVisible(true);
    }

    /*Metodo para dar reset aos text fields e panels*/
    private void clearTextfields(){
        nome.setText("");
        distrito.setText("");
        lat_graus.setText("");
        lat_min.setText("");
        lon_graus.setText("");
        lon_min.setText("");
        empregados.setText("");
        salario.setText("");
        clientes.setText("");
        cafes.setText("");
        faturacao.setText("");
        bolos.setText("");
        dias_funcionamento.setText("");
        mesas_interiores.setText("");
        mesas_esplanada.setText("");
        licensa_esplanada.setText("");
        driveThru.setText("");
        drive_medio.setText("");
        produtos.setText("");
        area.setText("");
        limpeza.setText("");
        frame.getContentPane().removeAll();
        panel.removeAll();
        panel.repaint();
        panel_princ.removeAll();
        panel_princ.repaint();
        panel_menu.removeAll();
        panel_menu.repaint();
    }


    public void editarCafe(ArrayList<String> list){
        cafes.setText(list.get(0));
        faturacao.setText(list.get(1));
        empregados.setText(list.get(2));
        salario.setText(list.get(3));
        clientes.setText(list.get(4));
        nome.setText(list.get(5));
        distrito.setText(list.get(6));
        lat_graus.setText(list.get(7));
        lat_min.setText(list.get(8));
        lon_graus.setText(list.get(9));
        lon_min.setText(list.get(10));
        InsertCafe();
    }

    public void editarPastelaria(ArrayList<String> list){
        bolos.setText(list.get(0));
        faturacao.setText(list.get(1));
        empregados.setText(list.get(2));
        salario.setText(list.get(3));
        clientes.setText(list.get(4));
        nome.setText(list.get(5));
        distrito.setText(list.get(6));
        lat_graus.setText(list.get(7));
        lat_min.setText(list.get(8));
        lon_graus.setText(list.get(9));
        lon_min.setText(list.get(10));
        InsertPastelaria();
    }

    public void editarMercado(ArrayList<String> list){
        area.setText(list.get(0));
        limpeza.setText(list.get(1));
        faturacao.setText(list.get(2));
        nome.setText(list.get(3));
        distrito.setText(list.get(4));
        lat_graus.setText(list.get(5));
        lat_min.setText(list.get(6));
        lon_graus.setText(list.get(7));
        lon_min.setText(list.get(8));
        InsertMercado();
    }

    public void editarFrutaria(ArrayList<String> list){
        produtos.setText(list.get(0));
        limpeza.setText(list.get(1));
        faturacao.setText(list.get(2));
        nome.setText(list.get(3));
        distrito.setText(list.get(4));
        lat_graus.setText(list.get(5));
        lat_min.setText(list.get(6));
        lon_graus.setText(list.get(7));
        lon_min.setText(list.get(8));
        InsertFrutaria();
    }

    public void editarFastfood(ArrayList<String> list){
        driveThru.setText(list.get(0));
        drive_medio.setText(list.get(1));
        dias_funcionamento.setText(list.get(2));
        mesas_interiores.setText(list.get(3));
        faturacao.setText(list.get(4));
        empregados.setText(list.get(5));
        salario.setText(list.get(6));
        clientes.setText(list.get(7));
        nome.setText(list.get(8));
        distrito.setText(list.get(9));
        lat_graus.setText(list.get(10));
        lat_min.setText(list.get(11));
        lon_graus.setText(list.get(12));
        lon_min.setText(list.get(13));
        InsertFastfood();
    }

    public void editarLocal(ArrayList<String> list){
        mesas_esplanada.setText(list.get(0));
        licensa_esplanada.setText(list.get(1));
        dias_funcionamento.setText(list.get(2));
        mesas_interiores.setText(list.get(3));
        faturacao.setText(list.get(4));
        empregados.setText(list.get(5));
        salario.setText(list.get(6));
        clientes.setText(list.get(7));
        nome.setText(list.get(8));
        distrito.setText(list.get(9));
        lat_graus.setText(list.get(10));
        lat_min.setText(list.get(11));
        lon_graus.setText(list.get(12));
        lon_min.setText(list.get(13));
        InsertLocal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            clearTextfields();
            principal.setVisible(false);
            menu_criar_empresa();
        }
        if(e.getSource() == button_listar) {
            clearTextfields();
            try{
                tracker = 0;
                principal.setVisible(false);
                menu_listar_empresas(tracker);
            }
            catch (IndexOutOfBoundsException e1){
                System.out.print("Index out of bounds\n");
            }

        }

        if(e.getSource() == Stats) {
            clearTextfields();
            principal.setVisible(false);
            menu_listar_estatistica();
        }

        if(e.getSource()== Apagar){
            empresas.getEmp().remove(tracker);
            if(tracker>0){tracker--;}
            menu_listar_empresas(tracker);
        }

        if(e.getSource() == Editar){
            switch (empresas.getEmp().get(tracker).tipo()){
                case "cafe": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarCafe(list);
                    break;
                }
                case "mercado": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarMercado(list);
                    break;
                }
                case "pastelaria": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarPastelaria(list);
                    break;
                }
                case "frutaria": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarFrutaria(list);
                    break;
                }
                case "fastfood": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarFastfood(list);
                    break;
                }
                case "locais": {
                    ArrayList<String> list = empresas.getEmp().get(tracker).getInfo();
                    empresas.getEmp().remove(tracker);
                    editarLocal(list);
                    break;
                }
            }
        }

        if(e.getSource()== next_show){
            if(tracker<empresas.getEmp().size()-1){
                tracker ++;
                clearTextfields();
                menu_listar_empresas(tracker);
            }
        }
        if(e.getSource()== previous_show){
            if(tracker>0){
                tracker -=1;
                clearTextfields();
                menu_listar_empresas(tracker);
            }
        }

        if(e.getSource()== fastFood){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertFastfood();
        }
        if(e.getSource() == locais){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertLocal();
        }
        if(e.getSource() == pastelaria){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertPastelaria();
        }
        if(e.getSource() == cafe){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertCafe();
        }
        if(e.getSource() == frutaria){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertFrutaria();
        }
        if(e.getSource() == mercado){
            clearTextfields();
            frame_menu.setVisible(false);
            InsertMercado();
        }
        if(e.getSource() == cancel){
            frame.setVisible(false);
            frame_menu.setVisible(false);
            clearTextfields();
            main_menu();
        }
        if(e.getSource() == button_fastfood) {
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                int n_empregados = Integer.parseInt(empregados.getText().trim());
                double n_salario = Double.parseDouble(salario.getText().trim());
                int n_clientes = Integer.parseInt(clientes.getText().trim());
                double n_faturacao = Double.parseDouble(faturacao.getText().trim());
                int n_dias = Integer.parseInt(dias_funcionamento.getText().trim());
                int n_mesas = Integer.parseInt(mesas_interiores.getText().trim());
                int n_drive = Integer.parseInt(driveThru.getText().trim());
                double n_drive_medio = Double.parseDouble(drive_medio.getText().trim());
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText().trim()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText().trim()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText().trim()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText().trim()));

                empresas.newFastfood(n_drive,n_drive_medio, n_dias, n_mesas, n_faturacao, n_empregados, n_salario, n_clientes, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }
        if(e.getSource() == button_locais){
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                int n_empregados = Integer.parseInt(empregados.getText().trim());
                double n_salario = Double.parseDouble(salario.getText().trim());
                int n_clientes = Integer.parseInt(clientes.getText().trim());
                double n_faturacao = Double.parseDouble(faturacao.getText().trim());
                int n_dias = Integer.parseInt(dias_funcionamento.getText().trim());
                int n_mesas = Integer.parseInt(mesas_interiores.getText().trim());
                int n_esplanada = Integer.parseInt(mesas_esplanada.getText().trim());
                double n_licensa = Double.parseDouble(licensa_esplanada.getText().trim());
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText().trim()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText().trim()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText().trim()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText().trim()));

                empresas.newLocal(n_esplanada,n_licensa, n_dias, n_mesas, n_faturacao, n_empregados, n_salario, n_clientes, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }
        if(e.getSource() == button_pastelaria){
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                int n_empregados = Integer.parseInt(empregados.getText().trim());
                double n_salario = Double.parseDouble(salario.getText().trim());
                int n_clientes = Integer.parseInt(clientes.getText().trim());
                double n_faturacao = Double.parseDouble(faturacao.getText().trim());
                int n_bolos = Integer.parseInt(bolos.getText().trim());
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText().trim()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText().trim()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText().trim()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText().trim()));

                empresas.newPastelaria(n_bolos, n_faturacao, n_empregados, n_salario, n_clientes, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }
        if(e.getSource() == button_cafe){
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                int n_empregados = Integer.parseInt(empregados.getText().trim());
                double n_salario = Double.parseDouble(salario.getText().trim());
                int n_clientes = Integer.parseInt(clientes.getText().trim());
                double n_faturacao = Double.parseDouble(faturacao.getText().trim());
                int n_cafe = Integer.parseInt(cafes.getText().trim());
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText().trim()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText().trim()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText().trim()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText().trim()));

                empresas.newCafe(n_cafe, n_faturacao, n_empregados, n_salario, n_clientes, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }
        if(e.getSource() == button_frutaria){
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                int n_produtos = Integer.parseInt(produtos.getText().trim());
                double n_faturacao = Double.parseDouble(faturacao.getText().trim());
                double n_limpeza = Double.parseDouble(limpeza.getText().trim());
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText().trim()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText().trim()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText().trim()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText().trim()));

                empresas.newFrutaria(n_produtos,n_limpeza, n_faturacao, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }
        if(e.getSource() == button_mercado){
            String nomeText = nome.getText();
            String distritoText = distrito.getText();
            try {
                Coordenadas c = new Coordenadas();
                double n_area = Double.parseDouble(area.getText());
                double n_faturacao = Double.parseDouble(faturacao.getText());
                double n_limpeza = Double.parseDouble(limpeza.getText());
                int n_tipo = tipos.getSelectedIndex();
                c.setGraus_latitude(Integer.parseInt(lat_graus.getText()));
                c.setMinutos_latitude(Integer.parseInt(lat_min.getText()));
                c.setGraus_longitude(Integer.parseInt(lon_graus.getText()));
                c.setMinutos_longitude(Integer.parseInt(lon_min.getText()));

                empresas.newMercado(n_area,n_tipo,n_limpeza, n_faturacao, nomeText, distritoText, c);
                guardarDados();
                frame.setVisible(false);
                clearTextfields();
                main_menu();

            } catch (NumberFormatException e1) {
                System.out.println("Erro a converter inteiro");
            }
        }

    }
}