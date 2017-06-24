package semana06;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiaologoConsultar extends JDialog implements ActionListener {
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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiaologoConsultar dialog = new DiaologoConsultar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DiaologoConsultar() {
		setModal(true);
		setResizable(false);
		setTitle("Consultar Libro");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		lblCdigo = new JLabel("Codigo");
		lblCdigo.setBounds(80, 30, 50, 14);
		getContentPane().add(lblCdigo);

		lblModelo = new JLabel("Modelo ");
		lblModelo.setBounds(80, 71, 56, 14);
		getContentPane().add(lblModelo);

		lblPrecio = new JLabel("Precio  ");
		lblPrecio.setBounds(80, 102, 56, 14);
		getContentPane().add(lblPrecio);
		
		lblAlto= new JLabel("Alto    ");
		lblAlto.setBounds(80, 195, 56, 14);
		getContentPane().add(lblAlto);
		
		lblAncho= new JLabel("Ancho  ");
		lblAncho.setBounds(80, 133, 56, 14);
		getContentPane().add(lblAncho);
		
		lblFondo= new JLabel("Fondo  ");
		lblFondo.setBounds(80, 164, 56, 14);
		getContentPane().add(lblFondo);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(132, 221, 175, 23);
		getContentPane().add(btnCerrar);

		textprecio = new JTextField();
		textprecio.setEditable(false);
		textprecio.setBounds(181, 99, 160, 20);
		getContentPane().add(textprecio);
		textprecio.setColumns(10);

		textModelo = new JTextField();
		textModelo.setEditable(false);
		textModelo.setBounds(181, 68, 160, 20);
		getContentPane().add(textModelo);
		textModelo.setColumns(10);

		cboCodigo = new JComboBox();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] { "MT0", "MT1", "MT2", "MT3", "MT4" }));
		cboCodigo.setBounds(214, 27, 89, 20);
		getContentPane().add(cboCodigo);

		textAncho = new JTextField();
		textAncho.setEditable(false);
		textAncho.setBounds(181, 130, 160, 20);
		getContentPane().add(textAncho);
		textAncho.setColumns(10);
		
		textAlto = new JTextField();
		textAlto.setEditable(false);
		textAlto.setBounds(181, 192, 160, 20);
		getContentPane().add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setEditable(false);
		textFondo.setBounds(181, 161, 160, 20);
		getContentPane().add(textFondo);
		textFondo.setColumns(10);
		
		mostrarDatosPorDefecto();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboCodigo) {
			actionPerformedComboBox(arg0);
		}
	}

	protected void actionPerformedComboBox(ActionEvent arg0) {
		int cod = cboCodigo.getSelectedIndex();
		if (cod == 0) {
			textModelo.setText(Tienda.modelo0);
			textprecio.setText(Tienda.precio0 +"");
			textAncho.setText(Tienda.ancho0 +"");
			textAlto.setText(Tienda.alto0 +"");
			textFondo.setText(Tienda.fondo0 +"");
		    
		} else if (cod == 1) {
			
			textModelo.setText(Tienda.modelo1);
			textprecio.setText(Tienda.precio1 +"");
			textAncho.setText(Tienda.ancho1 +"");
			textAlto.setText(Tienda.alto1 +"");
			textFondo.setText(Tienda.fondo1 +"");
		} else if (cod == 2) {
			textModelo.setText(Tienda.modelo2);
			textprecio.setText(Tienda.precio2 +"");
			textAncho.setText(Tienda.ancho2 +"");
			textAlto.setText(Tienda.alto2 +"");
			textFondo.setText(Tienda.fondo2 +"");
		}
		
		else if (cod == 3) {
			textModelo.setText(Tienda.modelo3);
			textprecio.setText(Tienda.precio3 +"");
			textAncho.setText(Tienda.ancho3 +"");
			textAlto.setText(Tienda.alto3 +"");
			textFondo.setText(Tienda.fondo3 +"");
		}else {
			textModelo.setText(Tienda.modelo4);
			textprecio.setText(Tienda.precio4 +"");
			textAncho.setText(Tienda.ancho4 +"");
			textAlto.setText(Tienda.alto4 +"");
			textFondo.setText(Tienda.fondo4 +"");
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
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
