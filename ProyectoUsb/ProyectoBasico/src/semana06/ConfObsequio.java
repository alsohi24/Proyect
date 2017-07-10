package semana06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ConfObsequio extends JDialog implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantidadMaletas;
	private JTextField txtObsequio;
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
					ConfObsequio dialog = new ConfObsequio();
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
	public ConfObsequio() {
		setResizable(false);
		setBounds(100, 100, 500, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidadMinimaDe = new JLabel("Cantidad minima de maletas adquiridas");
		lblCantidadMinimaDe.setBounds(29, 38, 225, 14);
		contentPane.add(lblCantidadMinimaDe);
		
		JLabel lblObsequio = new JLabel("Obsequio");
		lblObsequio.setBounds(29, 70, 55, 14);
		contentPane.add(lblObsequio);
		
		txtCantidadMaletas = new JTextField();
		txtCantidadMaletas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				  char c= arg0.getKeyChar(); 
		             
			         
		          if(Character.isLetter(c)) { 
		               
		              arg0.consume(); 
		               
		              Tienda.mensaje(txtCantidadMaletas,"Ingrese Solo N\u00fameros");
		              Tienda.focusSelectAll(txtCantidadMaletas);
		               
		          } else if( Character.isWhitespace(c)){
		        	  Tienda.mensaje(txtCantidadMaletas,"Cuidado con los espacios en blanco");
		        	  txtCantidadMaletas.selectAll();
		          }
		         
			}
		});
		txtCantidadMaletas.setBounds(264, 35, 86, 20);
		contentPane.add(txtCantidadMaletas);
		txtCantidadMaletas.setColumns(10);
		
		txtObsequio = new JTextField();
		txtObsequio.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				char c=arg0.getKeyChar(); 
	             
		         
		          if(Character.isDigit(c)) { 
		               
		              arg0.consume(); 
		               
		              Tienda.mensaje(txtObsequio, "Ingresa Solo Letras");
		              Tienda.focusSelectAll(txtObsequio);
		               
		          } 
			}
		});
		txtObsequio.setBounds(264, 67, 86, 20);
		contentPane.add(txtObsequio);
		txtObsequio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(360, 34, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(360, 66, 89, 23);
		contentPane.add(btnCancelar);
		
		//Valores dados
		mostrarCantidadMinActual();
		mostrarObsequio();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedbtnCancelar(e);
		} 
		if (e.getSource() == btnAceptar) {
			actionPerformedbtnAceptar(e);
		}
	}
	
		public void actionPerformedbtnCancelar(ActionEvent e) {
			dispose();
		}
		
		//Variables para la validacion de datos
				
		public void actionPerformedbtnAceptar(ActionEvent e) {
			int can;
			String obs;
			try{
			can = getCantidad();
			obs = newObsequio();
			if(can < 0){
				Tienda.mensaje(this, "N\u00famero incorrecto");
				Tienda.focusSelectAll(txtCantidadMaletas);
			}else if(obs.isEmpty() || obs.length() < 1 ){
				Tienda.mensaje(this, "Te falto espeificar alg\u00fan obsequio");
				Tienda.focusSelectAll(txtObsequio);
			}
				else{
			
			getCantidadMinima();
			getObsequio();
			}
			}catch (Exception o){
				Tienda.mensaje(this,"Por favor ingrese los datos solicitados");
				Tienda.focusSelectAll(txtObsequio);				
			}
			
			
		}
		
	public void mostrarCantidadMinActual(){  
		txtCantidadMaletas.setText(Tienda.cantidadMinima + "");
	}
	
	public void mostrarObsequio(){  
		txtObsequio.setText(Tienda.obsequio);
	}
	
	public void getCantidadMinima(){
		Tienda.cantidadMinima  = Integer.parseInt(txtCantidadMaletas.getText());
	}
	
	public void getObsequio(){
		Tienda.obsequio  = txtObsequio.getText();
	}
	
	//Valores de las varibles para la validacion de datos
	int getCantidad(){
		return Integer.parseInt(txtCantidadMaletas.getText());
		
	}
	
	String newObsequio(){
		return txtObsequio.getText();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
