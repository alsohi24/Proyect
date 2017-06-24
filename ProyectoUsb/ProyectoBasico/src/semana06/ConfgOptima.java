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
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfgOptima extends JDialog implements ActionListener {
	private JTextField textCantOpt;
	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfgOptima dialog = new ConfgOptima();
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
	public ConfgOptima() {
		setTitle("Configurar cantidad \u00F3ptima de maletas vendidas");
		setModal(true);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidadOptimaDe = new JLabel("Cantidad optima de maletas vendidas");
		lblCantidadOptimaDe.setBounds(61, 41, 239, 24);
		contentPane.add(lblCantidadOptimaDe);
		
		textCantOpt = new JTextField();
		textCantOpt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if( Character.isLetter(c)){
					JOptionPane.showMessageDialog(textCantOpt, "Ingrese solo n\u00fameros enteros");
					textCantOpt.requestFocus();
					textCantOpt.selectAll();
					
			}/*else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textCantOpt, "Cuidado con espacios en blanco");
					textCantOpt.requestFocus();
				}*/
			}
		});
		textCantOpt.setBounds(102, 76, 86, 20);
		contentPane.add(textCantOpt);
		textCantOpt.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(310, 25, 89, 35);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(310, 82, 89, 35);
		contentPane.add(btnCancelar);

		setCantOpt();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	int num;
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try{
		getNewCantOpt();
			if(num < 0){
				Tienda.mensaje(this, "Por favor ingrese alg\u00fan entero v\u00e1lido");
			}else{
				getNewCantOpt();
			}
		} catch(Exception o){
			JOptionPane.showMessageDialog(textCantOpt, "Por favor ingrese alg\u00fan n\u00famero entero válido");
				//	+ "\n");
				//	+ "Cuidado con los espacios en blanco");
			textCantOpt.requestFocus();
			textCantOpt.selectAll();
		}
	}
	
	void setCantOpt(){
		textCantOpt.setText(Tienda.cantidadOptima + "");
	}
	
	void getNewCantOpt(){
		num = Tienda.cantidadOptima = Integer.parseInt(textCantOpt.getText());
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
