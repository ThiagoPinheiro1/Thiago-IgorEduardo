import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        setTitle("Sistema de Pessoa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        JMenuItem itemUsuarios = new JMenuItem("Usuários");
        JMenuItem itemPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemUsuarios);
        menuCadastro.add(itemPessoas);

        JMenuItem itemListaUsuarios = new JMenuItem("Lista de usuário");
        JMenuItem itemListaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);

        JMenuItem itemSair = new JMenuItem("Sair");
        menuSair.add(itemSair);

        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);

        JPanel rodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: 12.1.2024    Usuário: denys.silva    Data de acesso: 20/09/2024 10:58");
        rodape.add(labelRodape);

        itemUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroUsuarios();
            }
        });

        itemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setJMenuBar(menuBar);
        add(rodape, BorderLayout.SOUTH);
    }

    private void abrirCadastroUsuarios() {
        JFrame cadastroFrame = new JFrame("Cadastro de Usuários");
        cadastroFrame.setSize(500, 400);
        cadastroFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.add(new JLabel("Usuário:"));
        JTextField txtUsuario = new JTextField();
        panel.add(txtUsuario);

        panel.add(new JLabel("Senha:"));
        JPasswordField txtSenha = new JPasswordField();
        panel.add(txtSenha);

        panel.add(new JLabel("Email:"));
        JTextField txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Ativo:"));
        JCheckBox chkAtivo = new JCheckBox();
        panel.add(chkAtivo);

        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSair = new JButton("Sair");

        ActionListener botaoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cadastroFrame, "Botão clicado! " + ((JButton) e.getSource()).getText());
            }
        };

        btnIncluir.addActionListener(botaoListener);
        btnAlterar.addActionListener(botaoListener);
        btnExcluir.addActionListener(botaoListener);
        btnConsultar.addActionListener(botaoListener);
        btnCancelar.addActionListener(botaoListener);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnIncluir);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnSair);

        cadastroFrame.add(new JLabel("Cadastro de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        cadastroFrame.add(panel, BorderLayout.CENTER);
        cadastroFrame.add(buttonPanel, BorderLayout.SOUTH);
        cadastroFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaPessoa().setVisible(true);
            }
        });
    }
}
