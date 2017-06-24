package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Vender extends JDialog implements ActionListener{
	private JPanel contentPane;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JButton btnCerrar; 
	private JButton btnVender;
	private JComboBox comboBox;
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
		textPrecio.setBounds(123, 42, 96, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(123, 73, 96, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(51, 76, 62, 14);
		contentPane.add(lblCantidad);
		
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
		cod = comboBox.getSelectedIndex();
		
		if (cod == 0) {
			textPrecio.setText(Tienda.precio0 + "");
		} else if (cod == 1) {
			textPrecio.setText(Tienda.precio1 + "");
		} else if (cod == 2) {
			textPrecio.setText(Tienda.precio2 + "");
		} else if (cod == 3) {
			textPrecio.setText(Tienda.precio3 + "");
		} else {
			textPrecio.setText(Tienda.precio4 + "");
		}
	}

	double icom, ides, ipag;
	int can, cod;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	public void actionPerformedbtnVender(ActionEvent arg0) {
		

		ingresardatos();
		calcularimportecompra();
		calculardescuento();
		calcularpagar();
		mostrarresultados();

	}

	void ingresardatos() {

		cod = comboBox.getSelectedIndex();
		can = Integer.parseInt(textCantidad.getText());

	}

	void calcularimportecompra() {
		switch (cod) {
		case 0:
			icom = Tienda.precio0 * can;
			break;
		case 1:
			icom = Tienda.precio1 * can;
			break;
		case 2:
			icom = Tienda.precio2 * can;
			break;
		case 3:
			icom = Tienda.precio3 * can;
			break;
		default:
			icom = Tienda.precio4 * can;
		}
	}

	void calculardescuento() {
		if (can < 4)
			ides = Tienda.porcentaje1 / 100 * icom;
		else if (can < 6)
			ides = Tienda.porcentaje2 / 100 * icom;
		else if (can < 9)
			ides = Tienda.porcentaje3 / 100 * icom;
		else
			ides = Tienda.porcentaje4 / 100 * icom;
	}

	void calcularpagar() {
		ipag = icom - ides;
	}

	void mostrarresultados() {

		txtS.setText("  Su boleta:" + "\n\n");
		Tienda.Imprimir(txtS, "Importe Compra      :	" + icom);
		Tienda.Imprimir(txtS, "Importe Descuento :	" + ides);
		Tienda.Imprimir(txtS, "Importe Pagar          :	" + ipag);
		Tienda.Imprimir(txtS, "Importe Compra      :	" + icom);
		Tienda.Imprimir(txtS, "Obsequio                  :	" + Tienda.obsequio);
		Tienda.Imprimir(txtS, "Premio Sorpresa     :	" + Tienda.premioSorpresa);

	}
}
