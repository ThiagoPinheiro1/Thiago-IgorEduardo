import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {

    private JTextField usuarioField;
    private JPasswordField senhaField;
    private final String USUARIO_CORRETO = "denys.silva";
    private final String SENHA_CORRETA = "Teste@2024";

    public AcessoAplicativo() {
        setTitle("Acesso ao aplicativo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        panel.add(new JLabel("Usuário:"));
        usuarioField = new JTextField();
        panel.add(usuarioField);

        panel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        panel.add(senhaField);
       
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnConfirmar = new JButton("Confirmar");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnConfirmar);
    
        add(panel, BorderLayout.CENTER);
       
