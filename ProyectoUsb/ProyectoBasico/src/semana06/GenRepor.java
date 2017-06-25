package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarReportes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes frame = new GenerarReportes();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenerarReportes() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerarReporte = new JLabel("Generar Reporte");
		lblGenerarReporte.setBounds(10, 19, 104, 14);
		contentPane.add(lblGenerarReporte);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ventas por maleta", "Maletas con venta optima ", "Maletas con precios menores al precio promedio", "Maletas con precios mayores al precio promedio", "Precios menor, mayor y promedio"}));
		comboBox.setBounds(124, 16, 174, 20);
		contentPane.add(comboBox);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(321, 11, 89, 31);
		contentPane.add(btnCerrar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 53, 414, 197);
		contentPane.add(textPane);
	}
	
	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar){
			actionPerformedbtnCerrar(e);
		}
		
	}

}
