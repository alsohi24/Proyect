package semana06;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class DialogoListar extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private static JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;

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
					DialogoListar dialog = new DialogoListar();
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
	public DialogoListar() {
		setTitle("Listar");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 212);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);

		btnListar = new JButton("Listar");
		btnListar.setBounds(59, 234, 133, 26);
		getContentPane().add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(263, 234, 133, 26);
		getContentPane().add(btnCerrar);
		btnCerrar.addActionListener(this);
		btnListar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		} 
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public void actionPerformedBtnListar(ActionEvent e) {
		Lista();
	}
	
	void Lista(){
		txtS.setText("     "+"Listado de Maletas" + "\n\n");
		
		Tienda.imprimirListas(txtS, Tienda.codigo0, Tienda.modelo0, Tienda.precio0,
				Tienda.ancho0, Tienda.alto0, Tienda.fondo0);
		Tienda.imprimirListas(txtS, Tienda.codigo1, Tienda.modelo1, Tienda.precio1,
				Tienda.ancho1, Tienda.alto1, Tienda.fondo1);
		Tienda.imprimirListas(txtS, Tienda.codigo2, Tienda.modelo2, Tienda.precio2,
				Tienda.ancho2, Tienda.alto2, Tienda.fondo2);
		Tienda.imprimirListas(txtS, Tienda.codigo3, Tienda.modelo3, Tienda.precio3,
				Tienda.ancho3, Tienda.alto3, Tienda.fondo3);
		Tienda.imprimirListas(txtS, Tienda.codigo4, Tienda.modelo4, Tienda.precio4,
				Tienda.ancho4, Tienda.alto4, Tienda.fondo4);
		/**
		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo0);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo0);
		Tienda.Imprimir(txtS,"Precio :" + Tienda.precio0);
		Tienda.Imprimir(txtS,"Ancho :" + Tienda.ancho0);
		Tienda.Imprimir(txtS,"Alto :"+ Tienda.alto0 );
		Tienda.Imprimir(txtS,"Fondo :"+ Tienda.fondo0 + "\n");

		Tienda.Imprimir(txtS,"Codigo :" + Tienda.codigo1);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo1);
		Tienda.Imprimir(txtS,"Precio :" + Tienda.precio1);
		Tienda.Imprimir(txtS,"Ancho :" + Tienda.ancho1);
		Tienda.Imprimir(txtS,"Alto :"+ Tienda.alto1);
		Tienda.Imprimir(txtS,"Fondo :"+ Tienda.fondo1 + "\n");

		Tienda.Imprimir(txtS,"Codigo :" + Tienda.codigo2);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo2);
		Tienda.Imprimir(txtS,"Precio :" + Tienda.precio2);
		Tienda.Imprimir(txtS,"Ancho :" + Tienda.ancho2);
		Tienda.Imprimir(txtS,"Alto :"+ Tienda.alto2);
		Tienda.Imprimir(txtS,"Fondo :"+ Tienda.fondo2 + "\n");
		
		Tienda.Imprimir(txtS,"Codigo :" + Tienda.codigo3);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo3);
		Tienda.Imprimir(txtS,"Precio :" + Tienda.precio3);
		Tienda.Imprimir(txtS,"Ancho :" + Tienda.ancho3);
		Tienda.Imprimir(txtS,"Alto :"+ Tienda.alto3);
		Tienda.Imprimir(txtS,"Fondo :"+ Tienda.fondo3 +"\n");
		
		Tienda.Imprimir(txtS,"Codigo :" + Tienda.codigo4);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo4);
		Tienda.Imprimir(txtS,"Precio :" + Tienda.precio4);
		Tienda.Imprimir(txtS,"Ancho :" + Tienda.ancho4);
		Tienda.Imprimir(txtS,"Alto :"+ Tienda.alto4);
		Tienda.Imprimir(txtS,"Fondo :"+ Tienda.fondo4 +"\n"); **/
	}
}
