import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        setTitle("Sistema de Pessoa");
        setSize(500, 400);
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
        JLabel labelRodape = new JLabel("Rodapé do Sistema de Pessoa");
        rodape.add(labelRodape);

        itemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setJMenuBar(menuBar);
        add(rodape, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaPessoa().setVisible(true);
            }
        });
    }
}

