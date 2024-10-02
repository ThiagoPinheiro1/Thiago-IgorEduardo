
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class CardapioClient {

    public static void main(String[] args) {
        JFrame frame = new JFrame("PitDog Cardápio");
        JTextArea textArea = new JTextArea(20, 50);
        JButton button = new JButton("Consultar Cardápio");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (Socket socket = new Socket("localhost", 12345); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out.println("Pedido de cardápio");
                    String response = in.readLine();
                    textArea.setText(response);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.getContentPane().add(new JScrollPane(textArea), "Center");
        frame.getContentPane().add(button, "South");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
