package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modificar extends JDialog implements ActionListener {

	private JLabel lblCdigo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAlto;
	private JLabel lblAncho;
	private JLabel lblFondo;
	private JButton btnCerrar;
	private JTextField textModelo;
	private JTextField textprecio;
	private JTextField textAlto;
	private JTextField textAncho;
	private JTextField textFondo;
	private JComboBox cboCodigo;
	private JButton btnGrabar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar dialog = new Modificar();
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
	public Modificar() {
		/**
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(100, 100,
		 * 450, 300); contentPane = new JPanel(); contentPane.setBorder(new
		 * EmptyBorder(5, 5, 5, 5)); setContentPane(contentPane);
		 * contentPane.setLayout(null);
		 **/
		setModal(true);
		setResizable(false);
		setTitle("Modificar ");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		lblCdigo = new JLabel("Codigo");
		lblCdigo.setBounds(82, 30, 46, 14);
		getContentPane().add(lblCdigo);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(82, 71, 66, 14);
		getContentPane().add(lblModelo);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(82, 102, 66, 14);
		getContentPane().add(lblPrecio);

		lblAlto = new JLabel("Alto(cm)");
		lblAlto.setBounds(82, 168, 66, 14);
		getContentPane().add(lblAlto);

		lblAncho = new JLabel("Ancho(cm)");
		lblAncho.setBounds(82, 133, 66, 14);
		getContentPane().add(lblAncho);

		lblFondo = new JLabel("Fondo(cm)");
		lblFondo.setBounds(82, 201, 66, 14);
		getContentPane().add(lblFondo);

		cboCodigo = new JComboBox();
		cboCodigo.setBounds(229, 27, 66, 20);
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] { "MT0", "MT1", "MT2", "MT3", "MT4" }));
		getContentPane().add(cboCodigo);

		textprecio = new JTextField();
		textprecio.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {

					e.consume();

					JOptionPane.showMessageDialog(textprecio, "Ingresa Solo Numeros");

				}else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textFondo, "Cuidado con espacios en blanco");
				}
			}
		});
		textprecio.setBounds(187, 99, 160, 20);
		getContentPane().add(textprecio);
		textprecio.setColumns(10);

		textModelo = new JTextField();
		textModelo.setBounds(187, 68, 160, 20);
		getContentPane().add(textModelo);
		textModelo.setColumns(10);

		textAncho = new JTextField();
		textAncho.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {

					e.consume();

					JOptionPane.showMessageDialog(textAncho, "Ingresa Solo Numeros");

				}else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textFondo, "Cuidado con espacios en blanco");
				}
			}
		});
		textAncho.setBounds(187, 130, 160, 20);
		getContentPane().add(textAncho);
		textAncho.setColumns(10);

		textAlto = new JTextField();
		textAlto.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {

					e.consume();

					JOptionPane.showMessageDialog(textAlto, "Ingresa Solo Numeros");

				}else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textFondo, "Cuidado con espacios en blanco");
				}
			}
		});
		textAlto.setBounds(187, 165, 160, 20);
		getContentPane().add(textAlto);
		textAlto.setColumns(10);

		textFondo = new JTextField();
		textFondo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {

					e.consume();

					JOptionPane.showMessageDialog(textFondo, "Ingresa Solo Numeros");

				} else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textFondo, "Cuidado con espacios en blanco");
				}
			}
		});
		textFondo.setBounds(187, 198, 160, 20);
		getContentPane().add(textFondo);
		textFondo.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(283, 237, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);

		btnGrabar_1 = new JButton("Grabar");
		btnGrabar_1.setBounds(73, 237, 89, 23);
		btnGrabar_1.addActionListener(this);
		getContentPane().add(btnGrabar_1);
		
		mostrarDatosPorDefecto();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(e);
		}
		if (e.getSource() == btnGrabar_1) {
			actionPerformedbtnGrabar_1(e);
		}
		if (e.getSource() == cboCodigo) {
			actionPerformedComboBox(e);
		}

	}

	private void actionPerformedComboBox(ActionEvent e) {
		int cod = cboCodigo.getSelectedIndex();
		if (cod == 0) {
			textModelo.setText(Tienda.modelo0);
			textprecio.setText(Tienda.precio0 + "");
			textAncho.setText(Tienda.ancho0 + "");
			textAlto.setText(Tienda.alto0 + "");
			textFondo.setText(Tienda.fondo0 + "");

		} else if (cod == 1) {

			textModelo.setText(Tienda.modelo1);
			textprecio.setText(Tienda.precio1 + "");
			textAncho.setText(Tienda.ancho1 + "");
			textAlto.setText(Tienda.alto1 + "");
			textFondo.setText(Tienda.fondo1 + "");
		} else if (cod == 2) {
			textModelo.setText(Tienda.modelo2);
			textprecio.setText(Tienda.precio2 + " ");
			textAncho.setText(Tienda.ancho2 + " ");
			textAlto.setText(Tienda.alto2 + " ");
			textFondo.setText(Tienda.fondo2 + " ");
		}

		else if (cod == 3) {
			textModelo.setText(Tienda.modelo3);
			textprecio.setText(Tienda.precio3 + "");
			textAncho.setText(Tienda.ancho3 + "");
			textAlto.setText(Tienda.alto3 + "");
			textFondo.setText(Tienda.fondo3 + "");
		} else {
			textModelo.setText(Tienda.modelo4);
			textprecio.setText(Tienda.precio4 + "");
			textAncho.setText(Tienda.ancho4 + "");
			textAlto.setText(Tienda.alto4 + "");
			textFondo.setText(Tienda.fondo4 + "");
		}

	}
	
	
	
	public void actionPerformedbtnGrabar_1(ActionEvent e) {
		try{
		getModificaciones();
		//Variable para validación de texto
		String mods = textModelo.getText();
		
		if(mods.isEmpty() || mods.length() < 1){
			Tienda.mensaje(textModelo, "Porfavor ingrese algún modelo");
			textModelo.requestFocus();
			textModelo.selectAll();
		}
		
		}catch (Exception o){
			Tienda.mensaje(this,"Esas cantidades deben ser n\u00fameros enteros");
			
		}
	
	}

	private void getModificaciones() {
		int cod = cboCodigo.getSelectedIndex();	
		switch (cod) {
		case 0:
			Tienda.modelo0 = textModelo.getText();
			Tienda.precio0 = Double.parseDouble(textprecio.getText());
			Tienda.ancho0 = Double.parseDouble(textAncho.getText());
			Tienda.alto0 = Double.parseDouble(textAlto.getText());
			Tienda.fondo0 = Double.parseDouble(textFondo.getText());
			break;
		case 1:
			Tienda.modelo1 = textModelo.getText();
			Tienda.precio1 = Double.parseDouble(textprecio.getText());
			Tienda.ancho1 = Double.parseDouble(textAncho.getText());
			Tienda.alto1 = Double.parseDouble(textAlto.getText());
			Tienda.fondo1 = Double.parseDouble(textFondo.getText());
			break;

		case 2:
			Tienda.modelo2 = textModelo.getText();
			Tienda.precio2 = Double.parseDouble(textprecio.getText());
			Tienda.ancho2 = Double.parseDouble(textAncho.getText());
			Tienda.alto2 = Double.parseDouble(textAlto.getText());
			Tienda.fondo2 = Double.parseDouble(textFondo.getText());

		case 3:
			Tienda.modelo3 = textModelo.getText();
			Tienda.precio3 = Double.parseDouble(textprecio.getText());
			Tienda.ancho3 = Double.parseDouble(textAncho.getText());
			Tienda.alto3 = Double.parseDouble(textAlto.getText());
			Tienda.fondo3 = Double.parseDouble(textFondo.getText());

		default:
			Tienda.modelo4 = textModelo.getText();
			Tienda.precio4 = Double.parseDouble(textprecio.getText());
			Tienda.ancho4 = Double.parseDouble(textAncho.getText());
			Tienda.alto4 = Double.parseDouble(textAlto.getText());
			Tienda.fondo4 = Double.parseDouble(textFondo.getText());
		}
		
	}

	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public void mostrarDatosPorDefecto(){
		textModelo.setText(Tienda.modelo0);
		textprecio.setText(Tienda.precio0 +"");
		textAncho.setText(Tienda.ancho0 +"");
		textAlto.setText(Tienda.alto0 +"");
		textFondo.setText(Tienda.fondo0 +"");		
	}	
	
	
	
}
