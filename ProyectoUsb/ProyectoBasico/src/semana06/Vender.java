package semana06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vender extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JButton btnCerrar;
	private JButton btnVender;
	private JComboBox<?> comboBox;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender dialog = new Vender();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vender() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(51, 14, 62, 14);
		contentPane.add(lblCodigo);

		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "MT0", "MT1", "MT2", "MT3", "MT4" }));
		comboBox.setBounds(123, 11, 96, 20);
		contentPane.add(comboBox);

		JLabel lblPrecios = new JLabel("Precio(S/)");
		lblPrecios.setBounds(51, 39, 62, 14);
		contentPane.add(lblPrecios);

		textPrecio = new JTextField();
		textPrecio.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				
				if(Character.isLetter(c)){
					arg0.consume();
					Tienda.mensaje(textPrecio,"Ingrese Solo N\u00fameros");
					Tienda.focusSelectAll(textPrecio);
					
				}
			}
		});
		textPrecio.setBounds(123, 42, 96, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textCantidad = new JTextField();
		textCantidad.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(Character.isLetter(c)){
					arg0.consume();
					
					Tienda.mensaje(textCantidad,"Ingrese Solo N\u00fameros");
		              Tienda.focusSelectAll(textCantidad);
				}
			}
		});
		textCantidad.setBounds(123, 73, 96, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);

		JLabel lblctidad = new JLabel("Cantidad");
		lblctidad.setBounds(51, 76, 62, 14);
		contentPane.add(lblctidad);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(281, 11, 89, 36);
		contentPane.add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(281, 58, 89, 37);
		contentPane.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 414, 134);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		textPrecio.setText(Tienda.precio0 + "");

	}

	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedbtnVender(e);
		}
		if (e.getSource() == comboBox) {
			actionPerformedComboBox(e);
		}

	}

	public void actionPerformedComboBox(ActionEvent arg0) {
		 int cod = getMarca();

		switch (cod) {
		case 0:
			textPrecio.setText(Tienda.precio0 + "");
			Tienda.focusSelectAll(textCantidad);
			break;
		case 1:
			textPrecio.setText(Tienda.precio1 + "");
			Tienda.focusSelectAll(textCantidad);
			break;
		case 2:
			textPrecio.setText(Tienda.precio2 + "");
			Tienda.focusSelectAll(textCantidad);
			break;
		case 3:
			textPrecio.setText(Tienda.precio3 + "");
			Tienda.focusSelectAll(textCantidad);
			break;
		default:
			textPrecio.setText(Tienda.precio4 + "");
			Tienda.focusSelectAll(textCantidad);
		}
	}

	int totV;
	public void actionPerformedbtnVender(ActionEvent arg0) {
		double icom, ides, ipag;
		int can, mar;
		totV++;
		mar = getMarca();
		can = getctidad();
		icom = calcularimportecompra(mar,can);
		contAcum(mar, can , icom);
		ides = calculardescuento(can, icom);
		ipag = calcularpagar(icom, ides);
		mostrarresultados(icom, ides, ipag);
		clientePremiado();

	}

	int getctidad() {		
		return Integer.parseInt(textCantidad.getText());

	}
	
	int getMarca(){
		return comboBox.getSelectedIndex();
	}

	double calcularimportecompra(int m, int c) {
		switch (m) {
		case 0:
			return Tienda.precio0 * c;
		case 1:
			return Tienda.precio1 * c;
			
		case 2:
			return Tienda.precio2 * c;
			
		case 3:
			return Tienda.precio3 * c;
			
		default:
			return Tienda.precio4 * c;
		}
	}

	double calculardescuento(int c, double ic) {
		if (c < 4)
			return Tienda.porcentaje1 / 100 * ic;
		else if (c < 6)
			return Tienda.porcentaje2 / 100 * ic;
		else if (c < 9)
			return Tienda.porcentaje3 / 100 * ic;
		else
			return Tienda.porcentaje4 / 100 * ic;
	}

	void contAcum(int m, int c, double ic) {
		switch (m) {
		case 0:
			GenRepor.totMaV1 += c;
			GenRepor.totVen1++;
			GenRepor.icomAcu1 += ic;
			break;
		case 1:
			GenRepor.totMaV2 += c;
			GenRepor.totVen2++;
			GenRepor.icomAcu2 += ic;
			break;
		case 2:
			GenRepor.totMaV3 += c;
			GenRepor.totVen3++;
			GenRepor.icomAcu3 += ic;
			break;
		case 3:
			GenRepor.totMaV4 += c;
			GenRepor.totVen4++;
			GenRepor.icomAcu4 += ic;
			break;
		default:
			GenRepor.totMaV5 += c;
			GenRepor.totVen5++;
			GenRepor.icomAcu5 += ic;
		}
	}

	double calcularpagar(double ic, double id) {
		return ic - id;
	}

	void mostrarresultados(double ic, double id,double ip) {

		txtS.setText("  Su boleta:" + "\n\n");
		Tienda.Imprimir(txtS, "Importe Compra      :	" + ic);
		Tienda.Imprimir(txtS, "Importe Descuento :	" + id);
		Tienda.Imprimir(txtS, "Importe Pagar          :	" + ip);
		Tienda.Imprimir(txtS, "Obsequio                  :	" + Tienda.obsequio);
		Tienda.Imprimir(txtS, "Premio Sorpresa     :	" + Tienda.premioSorpresa);

	}

	void clientePremiado() {
		if (totV == Tienda.numeroClientePremiado) {
			Tienda.mensaje(this, "FELICIDADES ERES EL GANADOR");
		}

	}

}
