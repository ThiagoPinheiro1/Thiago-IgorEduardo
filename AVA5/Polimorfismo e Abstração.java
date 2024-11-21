import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Cadastro {
    protected final JFrame principal;

    public Cadastro(JFrame principal) {
        this.principal = principal;
    }

    public abstract void exibir();
}

class CadastroPessoas extends Cadastro {
    public CadastroPessoas(JFrame principal) {
        super(principal);
    }

    @Override
    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Pessoas", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Pessoas", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(new JComboBox<>(new String[]{"Masculino", "Feminino"}));

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}

class CadastroUsuarios extends Cadastro {
    public CadastroUsuarios(JFrame principal) {
        super(principal);
    }

    @Override
    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Usuários", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}

class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    public JPanel criar() {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}

class ConfiguracoesSistema {
    public static final String VERSAO_SISTEMA = "12.1.2024";
    public static final String NOME_USUARIO = "denys.silva";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm");
    public static final String DATA_ACESSO = DATE_FORMAT.format(new Date());
}

public class SistemaPessoa {
    public static void main(String[] args) {
        new SistemaPessoa().iniciarSistema();
    }

    public void iniciarSistema() {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(
            "Versão: " + ConfiguracoesSistema.VERSAO_SISTEMA +
            "    Usuário: " + ConfiguracoesSistema.NOME_USUARIO +
            "    Data de acesso: " + ConfiguracoesSistema.DATA_ACESSO
        );
        painelRodape.add(labelRodape);

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        itemMenuCadastroUsuarios.addActionListener(e -> new CadastroUsuarios(principal).exibir());
        itemMenuCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal).exibir());

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
