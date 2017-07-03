package semana06;

import java.awt.EventQueue;
import java.awt.GridLayout;
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

public class ConfgOptima extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCantidadOptimaDe = new JLabel("Cantidad optima de maletas vendidas");
		contentPane.add(lblCantidadOptimaDe);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		textCantOpt = new JTextField();
		textCantOpt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if( Character.isLetter(c)){
					Tienda.mensaje(textCantOpt, "Ingrese solo n\u00fameros enteros");
					Tienda.focusSelectAll(textCantOpt);
					
			}/*else if( Character.isWhitespace(c)){
					JOptionPane.showMessageDialog(textCantOpt, "Cuidado con espacios en blanco");
					textCantOpt.requestFocus();
				}*/
			}
		});
		contentPane.add(textCantOpt);
		textCantOpt.setColumns(10);
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
			Tienda.focusSelectAll(textCantOpt);
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
