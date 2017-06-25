package semana06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GenRepor extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCerrar;
	private JComboBox comboBox; 
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenRepor frame = new GenRepor();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenRepor() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerarReporte = new JLabel("Generar Reporte");
		lblGenerarReporte.setBounds(10, 19, 104, 14);
		contentPane.add(lblGenerarReporte);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ventas por maleta", "Maletas con venta optima ", "Maletas con precios menores al precio promedio", "Maletas con precios mayores al precio promedio", "Precios menor, mayor y promedio"}));
		comboBox.setBounds(124, 16, 174, 20);
		contentPane.add(comboBox);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(321, 11, 89, 31);
		contentPane.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 414, 192);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	
	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar){
			actionPerformedbtnCerrar(e);
		}if(e.getSource() == comboBox){
			actionPerformedcomboBox(e);
		}
		
	}
	
	public static int 	totVen1, totVen2, totVen3, totVen4, totVen5,
						totMaV1, totMaV2, totMaV3, totMaV4, totMaV5;
	public static double icomAcu1, icomAcu2, icomAcu3, icomAcu4, icomAcu5,
																	prom;

	int totM;
	
	public void actionPerformedcomboBox(ActionEvent e) {
		int cod = comboBox.getSelectedIndex();
		
		switch(cod){
		case 0 : 
			totalDeVentas();
			break;
			
		case 1 :	
			 malVenOp();
		default:
			mayAlProm();
		}
	}
	
	void malVenOp(){
		txtS.setText("     "+"Reporte de Ventas Optimas" + "\n\n");
		if(totVen1 >= Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo0);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo0);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV1 + "x \n");
		}/**if(totVen1 == Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo0);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo0);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV1 + "n \n");
		}**/
		if(totVen2 >= Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo1);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo1);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV2 + "\n");
		}if(totVen3 >= Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo2);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo2);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV3 + "\n");
		}if(totVen4 >= Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo3);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo3);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV4 + "\n");
		}if(totVen5 >= Tienda.cantidadOptima){
			Tienda.Imprimir(txtS, "Codigo  :" + Tienda.codigo4);
			Tienda.Imprimir(txtS,"Modelo  :" + Tienda.modelo4);
			Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas  : " + totMaV5 + "\n");
		}else{
			Tienda.Imprimir(txtS, "Funciona");
		}
	}
	
	void totalDeVentas(){
		txtS.setText("     "+"Reporte totalde las ventas" + "\n\n");
		
		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo0);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo0);
		Tienda.Imprimir(txtS,"Cantidad total de ventas  :" + totVen1);
		Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas :" + totMaV1);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu1 + "\n");
		
		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo1);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo1);
		Tienda.Imprimir(txtS,"Cantidad total de ventas  :" + totVen2);
		Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas :" + totMaV2);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu2 + "\n");	

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo2);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo2);
		Tienda.Imprimir(txtS,"Cantidad total de ventas  :" + totVen3);
		Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas :" + totMaV3);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu3 + "\n");

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo3);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo3);
		Tienda.Imprimir(txtS,"Cantidad total de ventas  :" + totVen4);
		Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas :" + totMaV4);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu4 + "\n");
		
		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo4);
		Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo4);
		Tienda.Imprimir(txtS,"Cantidad total de ventas  :" + totVen5);
		Tienda.Imprimir(txtS,"Cantidad total de maletas vendidas :" + totMaV5);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu5 + "\n");
	}
	
	void mayAlProm(){
		prom = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 +Tienda.precio3
				+ Tienda.precio4)/5;
		txtS.setText("     "+"Precios mayores al promedio" + "\n\n");
		if(prom < Tienda.precio0){
			Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo0);
			Tienda.Imprimir(txtS,"Precio :" + Tienda.precio0+ "\n");			
		}if(prom < Tienda.precio1){
			Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo1);
			Tienda.Imprimir(txtS,"Precio :" + Tienda.precio1+ "\n");			
		}if(prom < Tienda.precio2){
			Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo2);
			Tienda.Imprimir(txtS,"Precio :" + Tienda.precio2+ "\n");			
		}if(prom < Tienda.precio3){
			Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo3);
			Tienda.Imprimir(txtS,"Precio :" + Tienda.precio3+ "\n");			
		}if(prom < Tienda.precio4){
			Tienda.Imprimir(txtS,"Modelo :" + Tienda.modelo4);
			Tienda.Imprimir(txtS,"Precio :" + Tienda.precio4+ "\n");			
		}
	}
}
