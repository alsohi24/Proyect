package semana06;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tienda extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnAyuda;
	private JMenu mnVentas;
	private JMenu Configuraciones;
	private JMenuItem mntmSalir;
	private JMenuItem mntmListar;
	private JMenuItem mntmAcerca;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmVerder;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarLaCantidad;
	private JMenuItem mntmConfigurarPremioSorpresa;
	
	
	
	//Datos del primer modelo 
	public static String codigo0 = "MT0";
	public static String modelo0 = "Aviator";
	public static double precio0 = 124.9;
	public static double ancho0 = 63.5;
	public static double alto0 = 30.9;
	public static double fondo0 = 29.2;

	//Datos del segundo modelo
	public static String codigo1 = "MT1";
	public static String modelo1 = "Century";
	public static double precio1 = 174.9;
	public static double ancho1 = 75.0;
	public static double alto1 = 28.5;
	public static double fondo1 = 30.0;
	
	//Datos del tercer modelo
	public static String codigo2 = "MT2";
	public static String modelo2 = "Benneton";
	public static double precio2 = 159.9;
	public static double ancho2 = 65.2;
	public static double alto2 = 31.2;
	public static double fondo2 = 29.4;
	
	//Datos del cuarto modelo
	public static String codigo3 = "MT3";
	public static String modelo3 = "Lucas";
	public static double precio3 = 99.9;
	public static double ancho3 = 45.0;
	public static double alto3 = 70.0;
	public static double fondo3 = 25.0;
	
	//Datos del quinto modelo
	public static String codigo4 = "MT4";
	public static String modelo4 = "Samsonite";
	public static double precio4 = 84.9;
	public static double ancho4 = 50.2;
	public static double alto4 = 60.4;
	public static double fondo4 = 25.0;
	
	//Conf. Obsequio
	//Cantidad minima
	public static int cantidadMinima = 10;
	// Obsequio
	public static String obsequio = "USB";
	
	// Porcentajes de descuento
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	
	// Cantidad Ã³ptima de maletas vendidas
	public static int cantidadOptima = 50;
	
	// Número de cliente que recibe el premio sorpresa
	public static int numeroClientePremiado = 5;
	// Premio sorpresa
	public static String premioSorpresa = "Una agenda";


		


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar ");
		mntmModificar.addActionListener(this); 
		mnMantenimiento.add(mntmModificar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVerder = new JMenuItem("Vender");
		mntmVerder.addActionListener(this);
		mnVentas.add(mntmVerder);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		Configuraciones = new JMenu("Configuracion");
		menuBar.add(Configuraciones);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		Configuraciones.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequio");
		mntmConfigurarObsequios.addActionListener(this);
		Configuraciones.add(mntmConfigurarObsequios);
		
		mntmConfigurarLaCantidad = new JMenuItem("Configurar la cantidad optima de maletas vendidas");
		mntmConfigurarLaCantidad.addActionListener(this);
		Configuraciones.add(mntmConfigurarLaCantidad);
		
		mntmConfigurarPremioSorpresa = new JMenuItem("Configurar premio sorpresa");
		mntmConfigurarPremioSorpresa.addActionListener(this);
		Configuraciones.add(mntmConfigurarPremioSorpresa);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcerca = new JMenuItem("Acerca de Tienda");
		mntmAcerca.addActionListener(this);
		mnAyuda.add(mntmAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmAcerca) {
			actionPerformedMntmAcerca(arg0);
		}
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		if(arg0.getSource() == mntmModificar){
			actionPerformedmntmModificar(arg0);
		}
		if(arg0.getSource() == mntmVerder){
			actionPerformedmntmVerder(arg0);
		}
		if(arg0.getSource() == mntmGenerarReportes){
			actionPerformedmntmGenerarReportes(arg0);
		}
		if(arg0.getSource() == mntmConfigurarDescuentos){
			actionPerformedmntmConfigurarDescuentos(arg0);
		}
		if(arg0.getSource() == mntmConfigurarObsequios){
			actionPerformedmntmConfigurarObsequios(arg0);
		}
		if(arg0.getSource() == mntmConfigurarLaCantidad){
			actionPerformedmntmConfigurarLaCantidad(arg0);
		}
		if(arg0.getSource() == mntmConfigurarPremioSorpresa){
			actionPerformedmntmConfigurarPremioSorpresa(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		
	}

	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	
	
	
	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		// Declarar el nombre de la caja de diï¿½logo
		DiaologoConsultar d;
		// Crear la caja de dialogo
		d = new DiaologoConsultar();
		// Centrar la cja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja
		d.setVisible(true);

	}

	protected void actionPerformedMntmListar(ActionEvent arg0) {
		// Declarar el nombre de la caja de dialogo
		DialogoListar d;
		// Crear la caja de dialogo
		d = new DialogoListar();
		// Centrar la cja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja
		d.setVisible(true);

	}

	protected void actionPerformedMntmAcerca(ActionEvent arg0) {
		// Declarar el nombre de la caja de dialogo
		DialogoAcercaDeTienda d;
		// Crear la caja de dialogo
		d = new DialogoAcercaDeTienda();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja
		d.setVisible(true);

		
	}
	
	protected void actionPerformedmntmVerder(ActionEvent arg0){
		//Declarar el name de la ventana de ventas
		Vender d;
		//Crear la ventana de vantas
		d = new Vender();
		//Centrar la ventana
		d.setLocationRelativeTo(this);
		//Hacer visible
		d.setVisible(true);
		
	}
	
	public void actionPerformedmntmModificar(ActionEvent arg0) {
		//Declarar el name de la ventana de ventas
		Modificar d;
		//Crear la ventana de vantas
		d = new Modificar();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);
	}
	
	public void actionPerformedmntmGenerarReportes(ActionEvent e) {
		//Declarar el name de la ventana 
		GenRepor d;
		//Crear la ventana de vantas
		d = new GenRepor();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);
		
	}
	
	public void actionPerformedmntmConfigurarDescuentos(ActionEvent arg0) {
		//Declarar el name de la ventana 
		ConfiguracionDescuentos d;
		//Crear la ventana de vantas
		d = new ConfiguracionDescuentos();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);	
	}
	
	public void actionPerformedmntmConfigurarObsequios(ActionEvent e) {
		//Declarar el name de la ventana 
		ConfObsequio d;
		//Crear la ventana de vantas
		d = new ConfObsequio();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);	
	}
	
	public void actionPerformedmntmConfigurarLaCantidad(ActionEvent e) {
		//Declarar el name de la ventana 
		ConfgOptima d;
		//Crear la ventana de vantas
		d = new ConfgOptima();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);	
	}
	
	public void actionPerformedmntmConfigurarPremioSorpresa(ActionEvent e) {
		//Declarar el name de la ventana 
		ConfPremio d;
		//Crear la ventana de vantas
		d = new ConfPremio();
		//Centrar la ventana
	
		//Hacer visible
		d.setVisible(true);	
	}
	
	public static void mensaje(Component clazz, String mensaje){
		JOptionPane.showMessageDialog(clazz,mensaje);
	}
	
	public static void Imprimir( JTextArea txtS, String cad){
		txtS.append("       "+ cad + "\n");
	}
	/**
	public static void limiteCifras(int MiTxt){
		if(MiTxt.getText().length()==10){
			e.consume();
		}
	}*/
	
	public static double getDouble(JTextField text){
		return Double.parseDouble(text.getText());
	}
	
	public static void focusSelectAll( JTextField text){
		text.selectAll();
		text.requestFocus();
	}
	public static Double numMayor(double may, double TVar0, double TVar01, double TVar02, double TVar03, double TVar04){
		 
		if (may < TVar0) {
			 may = TVar0;
		}if (may < TVar01) {
			 may = TVar01;
		}if (may < TVar02) {
			 may = TVar02;
		}if (may < TVar03) {
			 may = TVar03;
		}if (may < TVar04) {
			 may = TVar04;
		}
		return may;
	}
	
	public static Double numMenor(double men, double TVar0, double TVar1, double TVar2, double TVar3, double TVar4){
		 
		if (men > TVar0) {
			men = TVar0;
		}if (men > TVar1) {
			men = TVar1;
		}if (men > TVar2) {
			men = TVar2;
		}if (men > TVar3) {
			men = TVar3;
		}if (men >TVar4) {
			men = TVar4;
		}
		return men;
	}
	
	public static void imprimirVentas(JTextArea txtS, String cod, String mod, double totV, double totM, double ic ){
		Tienda.Imprimir(txtS, "Codigo :" + cod);
		Tienda.Imprimir(txtS, "Modelo :" + mod);
		Tienda.Imprimir(txtS, "Cantidad total de ventas  :" + totV);
		Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas :" + totM);
		Tienda.Imprimir(txtS, "Importe total acumulado :" + ic + "\n");
	}
	
	public static void VentaOptima( JTextArea txtS, int totV, int CanOp, int totMaV, String Tcodigo, String Tmodelo ){
		if (totV > CanOp) {
			Tienda.Imprimir(txtS, "Codigo  :" + Tcodigo);
			Tienda.Imprimir(txtS, "Modelo  :" + Tmodelo);
			Tienda.Imprimir(txtS, "Cantidad total de maletas vendidas  : " + totMaV + "x \n");
		}
	}
	
	public static int menorAlProm(JTextArea txtS, double prom,String mod, double pre, int con){
		if (prom > pre) {
			Tienda.Imprimir(txtS, "Modelo :" + mod);
			Tienda.Imprimir(txtS, "Precio :" + pre + "\n");
			con++;
		}return con;
	}
	
	public static int mayorAlProm(JTextArea txtS, double prom,String mod, double pre, int con){
		
		if (prom < pre) {
			Tienda.Imprimir(txtS, "Modelo :" + mod);
			Tienda.Imprimir(txtS, "Precio :" + pre + "\n");	
			con++;
		}return con;
	}
	
	public static void SetMayMen(JTextArea txtS, String String, double Vmay, double Vmen, double prom){
		Tienda.Imprimir(txtS, String +" mayor:  "  + Vmay);
		Tienda.Imprimir(txtS, String +" menor:  "  + Vmen);
		Tienda.Imprimir(txtS, "Promedio del "+ String + ":  " + prom + "\n");
	}
	
		public static void imprimirListas(JTextArea txtS, String cod, String mod, double pre, double an, double al, double fon){
		Tienda.Imprimir(txtS, "Codigo :" + cod);
		Tienda.Imprimir(txtS,"Modelo :" + mod);
		Tienda.Imprimir(txtS,"Precio :" + pre);
		Tienda.Imprimir(txtS,"Ancho :" + an);
		Tienda.Imprimir(txtS,"Alto :"+ al);
		Tienda.Imprimir(txtS,"Fondo :"+ fon + "\n");
	}
	
	public static void SetDatos(JTextField textModelo, JTextField textPrecio,
			JTextField textAncho, JTextField textAlto, JTextField textFondo, String mod,
			double pre, double an, double al, double fon){
		
			textModelo.setText(mod);
			textPrecio.setText(pre +"");
			textAncho.setText(an +"");
			textAlto.setText(al +"");
			textFondo.setText(fon +"");
	}
}
