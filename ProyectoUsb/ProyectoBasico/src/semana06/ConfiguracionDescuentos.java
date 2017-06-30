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
import javax.swing.border.EmptyBorder;

public class ConfiguracionDescuentos extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDesc1;
	private JTextField textDesc2;
	private JTextField textDesc3;
	private JTextField textDesc4;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguracionDescuentos dialog = new ConfiguracionDescuentos();
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
	public ConfiguracionDescuentos() {
		setTitle("Configuraci\u00F3n de Descuentos");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("1 a 3 maletas");
		lblNewLabel.setBounds(28, 50, 100, 14);
		contentPane.add(lblNewLabel);

		textDesc1 = new JTextField();
		textDesc1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					JOptionPane.showMessageDialog(textDesc1, "Solo debe ingresar n\u00fameros enteros");
					textDesc1.requestFocus();
					textDesc1.selectAll();
				}
			}
		});
		textDesc1.setBounds(138, 47, 94, 20);
		contentPane.add(textDesc1);
		textDesc1.setColumns(10);

		JLabel lblA = new JLabel("4 a 5 maletas");
		lblA.setBounds(28, 89, 100, 14);
		contentPane.add(lblA);

		textDesc2 = new JTextField();
		textDesc2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					JOptionPane.showMessageDialog(textDesc2, "Solo debe ingresar n\u00fameros enteros");
					textDesc2.requestFocus();
					textDesc2.selectAll();
				}
			}
		});
		textDesc2.setBounds(138, 86, 94, 20);
		contentPane.add(textDesc2);
		textDesc2.setColumns(10);

		textDesc3 = new JTextField();
		textDesc3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)){
					JOptionPane.showMessageDialog(textDesc3, "Solo debe ingresar n\u00fameros enteros");
					textDesc3.requestFocus();
					textDesc3.selectAll();
				}
			}
		});
		textDesc3.setBounds(138, 125, 94, 20);
		contentPane.add(textDesc3);
		textDesc3.setColumns(10);

		textDesc4 = new JTextField();
		textDesc4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)){
					JOptionPane.showMessageDialog(textDesc4, "Solo debe ingresar n\u00fameros enteros");
					textDesc4.requestFocus();
					textDesc4.selectAll();
				}
			}
		});
		textDesc4.setBounds(138, 164, 94, 20);
		contentPane.add(textDesc4);
		textDesc4.setColumns(10);

		JLabel lblA_1 = new JLabel("6 a 8 maletas");
		lblA_1.setBounds(28, 128, 100, 14);
		contentPane.add(lblA_1);

		JLabel lblMasDe = new JLabel("Mas de 8 maletas");
		lblMasDe.setBounds(20, 167, 108, 14);
		contentPane.add(lblMasDe);

		JLabel label = new JLabel("%");
		label.setBounds(242, 53, 32, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("%");
		label_1.setBounds(242, 92, 32, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("%");
		label_2.setBounds(242, 131, 32, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("%");
		label_3.setBounds(242, 170, 32, 14);
		contentPane.add(label_3);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(296, 73, 89, 30);
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(296, 135, 89, 30);
		contentPane.add(btnCancelar);
		
		setPorcentajesDeDescuentos();
	}

	public void actionPerformedbtnCancelar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedbtnCancelar(e);
		} if (e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
	}
	
	
	double p1, p2, p3, p4;
	public void actionPerformedbtnAceptar(ActionEvent arg0) {
		try{
			
		getPorDeDesc(); 
		validarPorDesc();
				
		}
		catch (Exception a){
			Tienda.mensaje(this , "Por favor solo ingrese n\u00fameros enteros");
		}
	}

	public void getPorDeDesc() {
		p1 = Tienda.porcentaje1 = Tienda.getDouble(textDesc1);
		p2 = Tienda.porcentaje2 = Tienda.getDouble(textDesc2);
		p3 = Tienda.porcentaje3 = Tienda.getDouble(textDesc3);
		p4 = Tienda.porcentaje4 = Tienda.getDouble(textDesc4);
		
	}

	public void setPorcentajesDeDescuentos(){ 
		textDesc1.setText(Tienda.porcentaje1 + "");
		textDesc2.setText(Tienda.porcentaje2 + "");
		textDesc3.setText(Tienda.porcentaje3 + "");
		textDesc4.setText(Tienda.porcentaje4 + "");
		
	}
	
	public void validarPorDesc(){
		if(p1 > 100||p2 > 100||p3 > 100||p4 > 100){
			Tienda.mensaje(this, "Los descuentos deben ser menores al 100%");
			this.requestFocus();
			//this.selectAll();
		}
		/**if(p1 > 100){
			Tienda.mensaje(this, "Los descuentos deben ser menores al 100%");
			textDesc1.requestFocus();
			textDesc1.selectAll();
		} if(p2 > 100){
			Tienda.mensaje(this, "Los descuentos deben ser menores al 100%");
			textDesc2.requestFocus();
			textDesc2.selectAll();
		}	if(p3 > 100){
			Tienda.mensaje(this, "Los descuentos deben ser menores al 100%");
			textDesc3.requestFocus();
			textDesc3.selectAll();
		} if(p4 > 100){
			Tienda.mensaje(this, "Los descuentos deben ser menores al 100%");
			textDesc4.requestFocus();
			textDesc4.selectAll();
		}**/
	}
}
