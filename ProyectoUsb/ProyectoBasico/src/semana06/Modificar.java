package semana06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Modificar extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAlto;
	private JLabel lblAncho;
	private JLabel lblFondo;
	private JButton btnCerrar;
	private JTextField textModelo;
	private JTextField textPrecio;
	private JTextField textAlto;
	private JTextField textAncho;
	private JTextField textFondo;
	private JComboBox<?> cboCodigo;
	private JButton btnGrabar_1;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Modificar() {
		/**
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(100, 100,
		 * 450, 300); contentPane = new JPanel(); contentPane.setBorder(new
		 * EmptyBorder(5, 5, 5, 5)); setContentPane(contentPane);
		 * contentPane.setLayout(null);
		 **/
		//setModal(true);
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

		textPrecio = new JTextField();
		textPrecio.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (Character.isLetter(c)) {

					e.consume();

					Tienda.mensaje(textPrecio, "Ingresa Solo Numeros");
					Tienda.focusSelectAll(textPrecio);

				}else if( Character.isWhitespace(c)){
					Tienda.mensaje(textFondo, "Cuidado con espacios en blanco");
					Tienda.focusSelectAll(textPrecio);
				}
			}
		});
		textPrecio.setBounds(187, 99, 160, 20);
		getContentPane().add(textPrecio);
		textPrecio.setColumns(10);

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

					Tienda.mensaje(textAncho, "Ingresa Solo Numeros");
					Tienda.focusSelectAll(textAncho);

				}else if( Character.isWhitespace(c)){
					Tienda.mensaje(textFondo, "Cuidado con espacios en blanco");
					Tienda.focusSelectAll(textAncho);
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

					Tienda.mensaje(textAlto, "Ingresa Solo Numeros");
					Tienda.focusSelectAll(textAlto);

				}else if( Character.isWhitespace(c)){
					Tienda.mensaje(textFondo, "Cuidado con espacios en blanco");
					Tienda.focusSelectAll(textAlto);
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

					Tienda.mensaje(textFondo, "Ingresa Solo Numeros");
					Tienda.focusSelectAll(textFondo);
				} else if( Character.isWhitespace(c)){
					Tienda.mensaje(textFondo, "Cuidado con espacios en blanco");
					Tienda.focusSelectAll(textFondo);
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
		switch (cod) {
		case 0:
			Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo0, 
					Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0);
			/**
			textModelo.setText(Tienda.modelo0);
			textPrecio.setText(Tienda.precio0 +"");
			textAncho.setText(Tienda.ancho0 +"");
			textAlto.setText(Tienda.alto0 +"");
			textFondo.setText(Tienda.fondo0 +"");**/
			break;
		case 1:	
			
		Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo1,
					Tienda.precio1, Tienda.ancho1, Tienda.alto1, Tienda.fondo1);
			
		/**
			textModelo.setText(Tienda.modelo1);
			textPrecio.setText(Tienda.precio1 +"");
			textAncho.setText(Tienda.ancho1 +"");
			textAlto.setText(Tienda.alto1 +"");
			textFondo.setText(Tienda.fondo1 +"");**/
			break;
		case 2:
			Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo2,
					Tienda.precio2, Tienda.ancho2, Tienda.alto2, Tienda.fondo2);
			/**	
			textModelo.setText(Tienda.modelo2);
			textPrecio.setText(Tienda.precio2 +"");
			textAncho.setText(Tienda.ancho2 +"");
			textAlto.setText(Tienda.alto2 +"");
			textFondo.setText(Tienda.fondo2 +"");**/
			break;
		case 3:
			Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo3,
					Tienda.precio3, Tienda.ancho3, Tienda.alto3, Tienda.fondo3);
			/**
			textModelo.setText(Tienda.modelo3);
			textPrecio.setText(Tienda.precio3 +"");
			textAncho.setText(Tienda.ancho3 +"");
			textAlto.setText(Tienda.alto3 +"");
			textFondo.setText(Tienda.fondo3 +"");**/
			break;
		default:
			Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo4,
					Tienda.precio4, Tienda.ancho4, Tienda.alto4, Tienda.fondo4);
			/**
			textModelo.setText(Tienda.modelo4);
			textPrecio.setText(Tienda.precio4 +"");
			textAncho.setText(Tienda.ancho4 +"");
			textAlto.setText(Tienda.alto4 +"");
			textFondo.setText(Tienda.fondo4 +"");**/
		}

	}
	
	
	
	public void actionPerformedbtnGrabar_1(ActionEvent e) {
		try{
		getModificaciones();
		//Variable para validación de texto
		String mods = textModelo.getText();
		
		if(mods.isEmpty() || mods.length() < 1){
			Tienda.mensaje(textModelo, "Porfavor ingrese algún modelo");
			Tienda.focusSelectAll(textModelo);
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
			Tienda.precio0 = Tienda.getDouble(textPrecio);
			Tienda.ancho0 = Tienda.getDouble(textAncho);
			Tienda.alto0 = Tienda.getDouble(textAlto);
			Tienda.fondo0 = Tienda.getDouble(textFondo);
			break;
		case 1:
			Tienda.modelo1 = textModelo.getText();
			Tienda.precio1 = Tienda.getDouble(textPrecio);
			Tienda.ancho1 = Tienda.getDouble(textAncho);
			Tienda.alto1 = Tienda.getDouble(textAlto);
			Tienda.fondo1 = Tienda.getDouble(textFondo);
			break;

		case 2:
			Tienda.modelo2 = textModelo.getText();
			Tienda.precio2 = Tienda.getDouble(textPrecio);
			Tienda.ancho2 = Tienda.getDouble(textAncho);
			Tienda.alto2 = Tienda.getDouble(textAlto);
			Tienda.fondo2 = Tienda.getDouble(textFondo);
			break;
		case 3:
			Tienda.modelo3 = textModelo.getText();
			Tienda.precio3 = Tienda.getDouble(textPrecio);
			Tienda.ancho3 = Tienda.getDouble(textAncho);
			Tienda.alto3 = Tienda.getDouble(textAlto);
			Tienda.fondo3 = Tienda.getDouble(textFondo);
			break;
		default:
			Tienda.modelo4 = textModelo.getText();
			Tienda.precio4 = Tienda.getDouble(textPrecio);
			Tienda.ancho4 = Tienda.getDouble(textAncho);
			Tienda.alto4 = Tienda.getDouble(textAlto);
			Tienda.fondo4 = Tienda.getDouble(textFondo);
		}
		
	}

	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public void mostrarDatosPorDefecto(){
		Tienda.SetDatos(textModelo, textPrecio, textAncho, textAlto, textFondo, Tienda.modelo0,
				Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0);
		/**
		textModelo.setText(Tienda.modelo0);
		textPrecio.setText(Tienda.precio0 +"");
		textAncho.setText(Tienda.ancho0 +"");
		textAlto.setText(Tienda.alto0 +"");
		textFondo.setText(Tienda.fondo0 +"");		**/
	}	
	
	
	
}
