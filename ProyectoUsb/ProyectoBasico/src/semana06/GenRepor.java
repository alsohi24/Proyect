package semana06;

import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class GenRepor extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCerrar;
	private JComboBox<?> comboBox;
	private JScrollPane scrollPane;
	private JTextArea txtS;

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
					GenRepor dialog = new GenRepor();
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
	public GenRepor() {
		setBackground(Color.GRAY);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGenerarReporte = new JLabel("Generar Reporte");
		lblGenerarReporte.setBounds(108, 0, 104, 20);
		contentPane.add(lblGenerarReporte);

		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ventas por maleta", "Maletas con venta optima ", "Maletas con precios menores al precio promedio", "Maletas con precios mayores al precio promedio", "Precio menor, mayor y promedio"}));
		comboBox.setBounds(10, 27, 301, 20);
		contentPane.add(comboBox);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(321, 11, 89, 36);
		contentPane.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 414, 192);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformedbtnCerrar(ActionEvent e) {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedbtnCerrar(e);
		}
		if (e.getSource() == comboBox) {
			actionPerformedcomboBox(e);
		}

	}

	public static int totVen1, totVen2, totVen3, totVen4, totVen5, totMaV1, totMaV2, totMaV3, totMaV4, totMaV5;
	public static double icomAcu1, icomAcu2, icomAcu3, icomAcu4, icomAcu5,
						icomGen,

						promP,
						promAn,
						promAl,
						promFon;
	int totM;

	public void actionPerformedcomboBox(ActionEvent e) {
		int cod = comboBox.getSelectedIndex();
		actualizarPromedios();
		switch (cod) {
		case 0:
			totalDeVentas();
			break;
		case 1:
			malVenOp();
			break;
		case 2:			
			menAlpromP();
			break;
		case 3:
			mayAlpromP();
			break;
		default:
			promPMaxMin();
		}
	}
	
	void totalDeVentas() {
		txtS.setText("     " + "Reporte totalde las ventas" + "\n\n");
		
		Tienda.imprimirVentas(txtS, Tienda.codigo0, Tienda.modelo0, totVen1, totMaV1, icomAcu1);
		Tienda.imprimirVentas(txtS, Tienda.codigo1, Tienda.modelo1, totVen2, totMaV2, icomAcu2);
		Tienda.imprimirVentas(txtS, Tienda.codigo2, Tienda.modelo2, totVen3, totMaV3, icomAcu3);
		Tienda.imprimirVentas(txtS, Tienda.codigo3, Tienda.modelo3, totVen4, totMaV4, icomAcu4);
		Tienda.imprimirVentas(txtS, Tienda.codigo4, Tienda.modelo4, totVen5, totMaV5, icomAcu5);
		
		//Aqui se reutilizo la clase ya que cumplian una funcion muy parecida
		icomGen = Tienda.promediosG(icomAcu1, icomAcu2, icomAcu3, icomAcu4, icomAcu5)*5;
		
		Tienda.Imprimir(txtS, "Importe total acumulado general :  " + icomGen);
		
		
		/**
		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo0);
		Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo0);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totVen1);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totMaV1);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu1 + "\n");

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo1);
		Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo1);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totVen2);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totMaV2);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu2 + "\n");

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo2);
		Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo2);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totVen3);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totMaV3);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu3 + "\n");

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo3);
		Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo3);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totVen4);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totMaV4);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu4 + "\n");

		Tienda.Imprimir(txtS, "Codigo :" + Tienda.codigo4);
		Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo4);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totVen5);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totMaV5);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + icomAcu5 + "\n");  **/
	}

	void malVenOp() {
		txtS.setText("     " + "Reporte de Ventas Optimas" + "\n\n");
		Tienda.VentaOptima(txtS, totMaV1, Tienda.cantidadOptima, Tienda.codigo0, Tienda.modelo0);
		Tienda.VentaOptima(txtS, totMaV2, Tienda.cantidadOptima, Tienda.codigo1, Tienda.modelo1);
		Tienda.VentaOptima(txtS, totMaV3, Tienda.cantidadOptima, Tienda.codigo2, Tienda.modelo2);
		Tienda.VentaOptima(txtS, totMaV4, Tienda.cantidadOptima, Tienda.codigo3, Tienda.modelo3);
	}



	void mayAlpromP() {
		int conMal = 0;
		txtS.setText("     " + "Precios mayores al promedio" + "\n\n");		
		conMal = Tienda.mayorAlProm(txtS, promP, Tienda.modelo0, Tienda.precio0, conMal);
		conMal = Tienda.mayorAlProm(txtS, promP, Tienda.modelo1, Tienda.precio1, conMal);
		conMal = Tienda.mayorAlProm(txtS, promP, Tienda.modelo2, Tienda.precio2, conMal);
		conMal = Tienda.mayorAlProm(txtS, promP, Tienda.modelo3, Tienda.precio3, conMal);
		conMal = Tienda.mayorAlProm(txtS, promP, Tienda.modelo4, Tienda.precio4, conMal);
	/**
		if (promP < Tienda.precio0) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo0);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio0 + "\n");
		}
		if (promP < Tienda.precio1) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo1);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio1 + "\n");
		}
		if (promP < Tienda.precio2) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo2);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio2 + "\n");
		}
		if (promP < Tienda.precio3) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo3);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio3 + "\n");
		}
		if (promP < Tienda.precio4) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo4);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio4 + "\n");
		}  **/
		Tienda.Imprimir(txtS, "promPedio :" + promP);
		Tienda.Imprimir(txtS, "Numero de maletas : " + conMal);
	}

	void menAlpromP() {
		int conMal = 0; 
		txtS.setText("     " + "Precios menores al promedio" + "\n\n");
		conMal = Tienda.menorAlProm(txtS, promP, Tienda.modelo0, Tienda.precio0, conMal);
		conMal = Tienda.menorAlProm(txtS, promP, Tienda.modelo1, Tienda.precio1, conMal);
		conMal = Tienda.menorAlProm(txtS, promP, Tienda.modelo2, Tienda.precio2, conMal);
		conMal = Tienda.menorAlProm(txtS, promP, Tienda.modelo3, Tienda.precio3, conMal);
		conMal = Tienda.menorAlProm(txtS, promP, Tienda.modelo4, Tienda.precio4, conMal);
		/**
		if (promP > Tienda.precio0) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo0);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio0 + "\n");
		}
		if (promP > Tienda.precio1) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo1);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio1 + "\n");
		}
		if (promP > Tienda.precio2) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo2);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio2 + "\n");
		}
		if (promP > Tienda.precio3) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo3);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio3 + "\n");
		}
		if (promP > Tienda.precio4) {
			Tienda.Imprimir(txtS, "Modelo :" + Tienda.modelo4);
			Tienda.Imprimir(txtS, "Precio :" + Tienda.precio4 + "\n");
		}**/
		
		Tienda.Imprimir(txtS, "Promedio : " + promP);
		Tienda.Imprimir(txtS, "Numero de maletas : " + conMal);
	}

	void promPMaxMin() {

		// Formula UNO
		double 	preMay = 0, preMen = 2147483647,
				anMay = 0, anMen = 2147483647,
				alMay = 0, alMen = 2147483647,
				fonMay = 0, fonMen = 2147483647;
		/**
		  if(preMay < Tienda.precio0 && promP <Tienda.precio0){ preMay =
		  Tienda.precio0; }if(preMen > Tienda.precio0 && promP >
		  Tienda.precio0){ preMen = Tienda.precio0; }if(/**preMay <
		  Tienda.precio1 && promP <Tienda.precio1){ preMay = Tienda.precio1;
		  }if(preMen > Tienda.precio1 && promP > Tienda.precio1){ preMen =
		  Tienda.precio1; }if(preMay < Tienda.precio2 && promP
		  <Tienda.precio2){ preMay = Tienda.precio2; }if(preMen >
		  Tienda.precio2 && promP > Tienda.precio2){ preMen = Tienda.precio2;
		  }if(preMay < Tienda.precio3 && promP <Tienda.precio3){ preMay =
		  Tienda.precio3; }if(preMen > Tienda.precio3 && promP >
		  Tienda.precio3){ preMen = Tienda.precio3; }if(preMay <
		  Tienda.precio4 && promP <Tienda.precio4){ preMay = Tienda.precio4;
		  }if(preMen > Tienda.precio4 && promP > Tienda.precio4){ preMen =
		  Tienda.precio4; }
		 **/
		
		//Numero menor
		preMen = Tienda.numMenor(preMen, Tienda.precio0, Tienda.precio1, Tienda.precio2, Tienda.precio3, Tienda.precio4);
		anMen = Tienda.numMenor(anMen, Tienda.ancho0, Tienda.ancho1, Tienda.ancho2, Tienda.ancho3, Tienda.ancho4);
		alMen = Tienda.numMenor(alMen, Tienda.alto0, Tienda.alto1, Tienda.alto2, Tienda.alto3, Tienda.alto4);
		fonMen = Tienda.numMenor(fonMen, Tienda.fondo0, Tienda.fondo1, Tienda.fondo2, Tienda.fondo3, Tienda.fondo4);
		
		// Formula DOS
		/**
		if (preMen > Tienda.precio0) {
			preMen = Tienda.precio0;
		}
		if (preMen > Tienda.precio1) {
			preMen = Tienda.precio1;

		}
		if (preMen > Tienda.precio2) {
			preMen = Tienda.precio2;
		}
		if (preMen > Tienda.precio3) {
			preMen = Tienda.precio3;
		}if (preMen > Tienda.precio4) {
			preMen = Tienda.precio4;
		}
		
		
		if (anMen > Tienda.ancho0) {
			anMen = Tienda.ancho0;
		}
		if (anMen > Tienda.ancho1) {
			anMen = Tienda.ancho1;
		}
		if (anMen > Tienda.ancho2) {
			anMen = Tienda.ancho2;
		}
		if (anMen > Tienda.ancho3) {
			anMen = Tienda.ancho3;
		}if (anMen > Tienda.ancho4) {
			anMen = Tienda.ancho4;
		}
		
		
		if (alMen > Tienda.alto0 ) {
			alMen = Tienda.alto0;
		}
		if (alMen > Tienda.alto1 ) {
			alMen = Tienda.alto1;
		}if (alMen > Tienda.alto2 ) {
			alMen = Tienda.alto2;
		}if (alMen > Tienda.alto3 ) {
			alMen = Tienda.alto3;
		}if (alMen > Tienda.alto4 ) {
			alMen = Tienda.alto4;
		}
		
		
		if (fonMen > Tienda.fondo0) {
			fonMen = Tienda.fondo0;
		}
		if (fonMen > Tienda.fondo1) {
			fonMen = Tienda.fondo1;
		}
		if (fonMen > Tienda.fondo2) {
			fonMen = Tienda.fondo2;
		}
		if (fonMen > Tienda.fondo3) {
			fonMen = Tienda.fondo3;
		}
		if (fonMen > Tienda.fondo4) {
			fonMen = Tienda.fondo4;
		}
		**/
		//Numero mayor
		//double ;
		preMay = Tienda.numMayor(preMay, Tienda.precio0, Tienda.precio1, Tienda.precio2, Tienda.precio3, Tienda.precio4);
		anMay = Tienda.numMayor(anMay, Tienda.ancho0, Tienda.ancho1, Tienda.ancho2, Tienda.ancho3, Tienda.ancho4);
		alMay = Tienda.numMayor(alMay, Tienda.alto0, Tienda.alto1, Tienda.alto2, Tienda.alto3, Tienda.alto4);
		fonMay = Tienda.numMayor(fonMay, Tienda.fondo0, Tienda.fondo1, Tienda.fondo2, Tienda.fondo3, Tienda.fondo4);

		/**
		if (preMay < Tienda.precio0) {
			preMay = Tienda.precio0;
		}if (preMay < Tienda.precio1) {
			preMay = Tienda.precio1;
		}if (preMay < Tienda.precio2) {
			preMay = Tienda.precio2;
		}if (preMay < Tienda.precio3) {
			preMay = Tienda.precio3;
		}if (preMay < Tienda.precio4) {
			preMay = Tienda.precio4;
		}
		
		if (anMay < Tienda.ancho0) {
			anMay = Tienda.ancho0;
		}if (anMay < Tienda.ancho1) {
			anMay = Tienda.ancho1;
		}if (anMay < Tienda.ancho2) {
			anMay = Tienda.ancho2;
		}if (anMay < Tienda.ancho3) {
			anMay = Tienda.ancho3;
		}if (preMay < Tienda.ancho4) {
			anMay = Tienda.ancho4;
		}
		
		if (alMay < Tienda.alto0) {
			alMay = Tienda.alto0;
		}if (alMay < Tienda.alto1) {
			alMay = Tienda.alto1;
		}if (alMay < Tienda.alto2) {
			alMay = Tienda.alto2;
		}if (alMay < Tienda.alto3) {
			alMay = Tienda.alto3;
		}if (alMay < Tienda.alto4) {
			alMay = Tienda.alto4;
		}
		
		 
		 if (fonMay < Tienda.fondo0) {
				fonMay = Tienda.fondo0;
			}if (fonMay < Tienda.fondo1) {
				fonMay = Tienda.fondo1;
			}if (fonMay < Tienda.fondo2) {
				fonMay = Tienda.fondo2;
			}if (fonMay < Tienda.fondo3) {
				fonMay = Tienda.fondo3;
			}if (fonMay < Tienda.fondo4) {
				fonMay = Tienda.fondo4;
			}									@-v-@  **/
		
		txtS.setText("     " + "Promedios, maximos y  minimos" + "\n\n");
		
		Tienda.SetMayMen(txtS, "Precio", preMay, preMen, promP);
		Tienda.SetMayMen(txtS, "Ancho", anMay, anMen, promAn);
		Tienda.SetMayMen(txtS, "Alto", alMay, alMen, promAl);
		Tienda.SetMayMen(txtS, "Fondo", fonMay, fonMen, promFon);
		
		/** 
		Tienda.Imprimir(txtS, "Precio mayor:  " + preMay);
		Tienda.Imprimir(txtS, "Precio menor:  " + preMen);
		Tienda.Imprimir(txtS, "Promedio del preicio : " + promP + "\n");
		
		Tienda.Imprimir(txtS, "Ancho mayor:  " + anMay);
		Tienda.Imprimir(txtS, "Ancho menor:  " + anMen);
		Tienda.Imprimir(txtS, "Promedio del Ancho : " + promAn + "\n");
		
		Tienda.Imprimir(txtS, "Alto mayor:  " + alMay);
		Tienda.Imprimir(txtS, "Alto menor:  " + alMen);
		Tienda.Imprimir(txtS, "Promedio del Alto : " + promAl + "\n");
		
		Tienda.Imprimir(txtS, "Fondo mayor:  " + fonMay);
		Tienda.Imprimir(txtS, "Fondo menor:  " + fonMen);
		Tienda.Imprimir(txtS, "Promedio del Fondo : " + promFon + "\n");**/
	}
	
	void actualizarPromedios(){
		promP = Tienda.promediosG(Tienda.precio0, Tienda.precio1, Tienda.precio2, Tienda.precio3, Tienda.precio4);
		promAn = Tienda.promediosG(Tienda.ancho0, Tienda.ancho1, Tienda.ancho2, Tienda.ancho3, Tienda.ancho4);
		promAl = Tienda.promediosG(Tienda.alto0, Tienda.alto1, Tienda.alto2, Tienda.alto3, Tienda.alto4);
		promFon = Tienda.promediosG(Tienda.fondo0, Tienda.fondo1, Tienda.fondo2, Tienda.fondo3, Tienda.fondo4);
	}
}
