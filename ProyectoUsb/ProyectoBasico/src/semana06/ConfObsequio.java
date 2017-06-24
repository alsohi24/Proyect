package semana06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConfObsequio extends JDialog implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JTextField txtCantidadMaletas;
	private JTextField txtObsequio;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setModal(true);
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
		               
		              JOptionPane.showMessageDialog(txtCantidadMaletas,"Ingrese Solo N\u00fameros");
		              txtCantidadMaletas.requestFocus();
		              txtCantidadMaletas.selectAll();
		               
		          } else if( Character.isWhitespace(c)){
		        	  JOptionPane.showMessageDialog(txtCantidadMaletas,"Cuidado con los espacios en blanco");
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
		               
		              JOptionPane.showMessageDialog(txtObsequio, "Ingresa Solo Letras"); 
		               
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
		int can;
		String obs;
		
		public void actionPerformedbtnAceptar(ActionEvent e) {
			
			try{
			ingresarDatos();
			if(can < 0){
				Tienda.mensaje(this, "N\u00famero incorrecto");
				txtCantidadMaletas.requestFocus();
				txtCantidadMaletas.selectAll();
			}else if(obs.isEmpty() || obs.length() < 1 ){
				Tienda.mensaje(this, "Te falto espeificar alg\u00fan obsequio");
			}
				else{
			
			getCantidadMinima();
			getObsequio();
			}
			}catch (Exception o){
				Tienda.mensaje(this,"Por favor ingrese los datos solicitados");
				txtCantidadMaletas.requestFocus();
				txtCantidadMaletas.selectAll();				
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
	void ingresarDatos(){
		can = Integer.parseInt(txtCantidadMaletas.getText());
		obs = txtObsequio.getText();
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
