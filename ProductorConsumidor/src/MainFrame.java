/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tana
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
  private JTextArea textArea;
  private JLabel statusLabel;
  private JButton clearButton;
  private JMenuBar menuBar;
  private JMenu gestionarDOM, gestionarSAX, gestionarStAX, validacion, jaxb;
  private JMenuItem crearDOM, mostrarDOM, anadirNodoDOM, crearSAX, mostrarSAX, eventosSAX;
  private JMenuItem crearStAX, mostrarStAX, cursorStAX, eventosStAX;
  private JMenuItem xsd, dtd;
  
  public MainFrame() {
    // Configuración de la ventana
    setTitle("Interfaz Gráfica");
    setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // JTextArea con JScrollPane
    textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    add(scrollPane, BorderLayout.CENTER);

    // JLabel para mostrar mensajes de estado
    statusLabel = new JLabel("Bienvenido");
    add(statusLabel, BorderLayout.SOUTH);

    // JButton para limpiar JTextArea
    clearButton = new JButton("Limpiar");
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.setText("");
        statusLabel.setText("Texto limpio");
      }
    });
  }
}