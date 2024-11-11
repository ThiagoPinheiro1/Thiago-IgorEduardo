import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe principal para o sistema
public class SistemaPessoa extends JPanel {

    public static void main(String args[]) {
        SistemaPessoa sistema = new SistemaPessoa();
        sistema.iniciar();
    }

    // Método que inicializa o sistema e configura o JFrame principal
    private void iniciar() {
        JFrame principal = criarJanelaPrincipal();
        
        // Adiciona componentes (menuPrincipal, areaTrabalho e painelRodape) no frame principal.
        principal.getContentPane().add(BorderLayout.NORTH, criarMenuPrincipal());
        principal.getContentPane().add(BorderLayout.CENTER, criarAreaTrabalho());
        principal.getContentPane().add(BorderLayout.SOUTH, criarRodape());

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }

    //Cria o frame principal
    private JFrame criarJanelaPrincipal() {
        JFrame frame = new JFrame("Sistema Pessoa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        return frame;
    }

    //Cria o menu principal
    private JMenuBar criarMenuPrincipal() {
        JMenuBar menuPrincipal = new JMenuBar();
       
        //Cria e adiciona as opções horizontais do menu principal
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
       
        // Cria a opção de "Sair" no menu principal
        JMenu menuSair = new JMenu("Sair");
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            // Evento de ação clique na opção Sair
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });
        
        // Adiciona o menu "Sair" à barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);
       
        //Cria os itens verticais de opções do menu
        // Opções verticais do menuCadastro
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);
        
        // Opções verticais do menuVisualizacao
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        return menuPrincipal;
    }

    // Text Area at the Center
    private JTextArea criarAreaTrabalho() {
        return new JTextArea();
    }

    //Cria painel e label do rodapé
    private JPanel criarRodape() {
        JPanel painelRodape = new JPanel(); // the panel is not visible in output
        JLabel labelRodape = new JLabel(obterTextoRodape());
        painelRodape.add(labelRodape); // Components Added using Flow Layout
        return painelRodape;
    }

    // Método que gera o texto do rodapé
    private String obterTextoRodape() {
        // Constante e varárias para informações do rodapé
        final String versaoSistema = "12.1.2024";
        String nomeUsuario = "denys.silva";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());
        return "Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso;
    }
}
