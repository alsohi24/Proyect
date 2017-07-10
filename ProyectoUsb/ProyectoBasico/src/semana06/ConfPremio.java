package semana06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class ConfPremio extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumeroCliente;
	private JTextField textPremioSorpresa;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfPremio dialog = new ConfPremio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		setTitle("Configuraci\u00F3n del premio sorpresa");
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNumeroDeCliente = new JLabel("Numero de cliente");
		contentPane.add(lblNumeroDeCliente);

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
		contentPane.add(textNumeroCliente);
		textNumeroCliente.setColumns(10);
		
				JLabel lblPremioSorpresa = new JLabel("Premio sorpresa");
				contentPane.add(lblPremioSorpresa);

		textPremioSorpresa = new JTextField();
		contentPane.add(textPremioSorpresa);
		textPremioSorpresa.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnCancelar, btnAceptar, lblPremioSorpresa, textNumeroCliente, contentPane, textPremioSorpresa, lblNumeroDeCliente}));
		
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
	
	
			
	
	public void actionPerformedbtnAceptar(ActionEvent arg0) {
		int num;
		String sor;
		try{
			num = getNumCliente();
			sor = getPremio();
			actualizarDatos(num, sor);
			if(num < 0){
				Tienda.mensaje(this, "Debe ingresar un n\u00famero entero");
				Tienda.focusSelectAll(textNumeroCliente);
			}else if(sor.isEmpty() || sor.length() < 1){
				//Tienda.mensaje(this, "Por favor ingrese alg\u00fan premio");			
				actualizarDatos(num, "No hay premio");
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
	
	public void actualizarDatos(int n, String s){
		Tienda.numeroClientePremiado = n;
		Tienda.premioSorpresa =  s;
	}
	
	public int getNumCliente() {		
		return Integer.parseInt(textNumeroCliente.getText());	
	}
	 
	public String getPremio(){
		return textPremioSorpresa.getText();
	}
	
	
}
