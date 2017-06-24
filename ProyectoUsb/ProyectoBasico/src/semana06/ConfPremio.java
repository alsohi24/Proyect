package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfPremio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textNumeroCliente;
	private JTextField textPremioSorpresa;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfPremio dialog = new ConfPremio();
					dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfPremio() {
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroDeCliente = new JLabel("Numero de cliente");
		lblNumeroDeCliente.setBounds(83, 48, 121, 14);
		contentPane.add(lblNumeroDeCliente);

		JLabel lblPremioSorpresa = new JLabel("Premio sorpresa");
		lblPremioSorpresa.setBounds(83, 83, 100, 14);
		contentPane.add(lblPremioSorpresa);

		textNumeroCliente = new JTextField();
		textNumeroCliente.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				
				if(Character.isLetter(c)){
					JOptionPane.showMessageDialog(textNumeroCliente, "Solo se aceptan n\u00fameros enteros");
					textNumeroCliente.requestFocus();
					textNumeroCliente.selectAll();
				}
				
			}
		});
		textNumeroCliente.setBounds(231, 45, 122, 20);
		contentPane.add(textNumeroCliente);
		textNumeroCliente.setColumns(10);

		textPremioSorpresa = new JTextField();
		textPremioSorpresa.setBounds(231, 80, 122, 20);
		contentPane.add(textPremioSorpresa);
		textPremioSorpresa.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(102, 127, 89, 23);
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(248, 127, 89, 23);
		contentPane.add(btnCancelar);
		
		SalidaDeDatos();
	}


	public void actionPerformedbtnCancelar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedbtnCancelar(e);
		}if (e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
	}
	
	int num;
	String sor;
			
	
	public void actionPerformedbtnAceptar(ActionEvent arg0) {
		try{
		getNuevosValores();
			if(num < 0){
				Tienda.mensaje(this, "Debe ingresar un n\u00famero entero");
				textNumeroCliente.requestFocus();
				textNumeroCliente.selectAll();
			}else if(sor.isEmpty() || sor.length() < 1){
				//Tienda.mensaje(this, "Por favor ingrese alg\u00fan premio");
				actualizarDatos();
				Tienda.premioSorpresa = "No hay premio";
			}	
		}
		catch(Exception u){
			Tienda.mensaje(this, "Por favor ingrese correctamente los datos");
		}
	}
	
	public void SalidaDeDatos() {
		textNumeroCliente.setText(Tienda.numeroClientePremiado + "");
		textPremioSorpresa.setText(Tienda.premioSorpresa);
	}
	

	public void getNuevosValores() {		
		num = Integer.parseInt(textNumeroCliente.getText());
		sor  = textPremioSorpresa.getText();
	}
	
	public void actualizarDatos(){
		Tienda.numeroClientePremiado = Integer.parseInt(textNumeroCliente.getText());
		Tienda.premioSorpresa =  textPremioSorpresa.getText();
	}
}
