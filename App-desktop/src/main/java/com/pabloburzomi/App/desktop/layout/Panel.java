package com.pabloburzomi.App.desktop.layout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.domain.Paseador;
import com.pabloburzomi.domain.Paseo;
import com.pabloburzomi.services.DueñoServices;
import com.pabloburzomi.services.MascotaServices;
import com.pabloburzomi.services.PaseadorServices;
import com.pabloburzomi.services.PaseoServices;
import com.pabloburzomi.services.impl.DueñoServicesImpl;
import com.pabloburzomi.services.impl.MascotaServicesImpl;
import com.pabloburzomi.services.impl.PaseadorServicesImpl;
import com.pabloburzomi.services.impl.PaseoServicesImpl;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;

public class Panel extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtBuscarCliente;
	private JTextField txtAfiliadoEncontrado;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Panel() {

		setTitle("Carga de Nuevos Paseos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 814);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre y Apellido");
		lblNewLabel.setBounds(50, 70, 119, 20);
		contentPane.add(lblNewLabel);

		txtBuscarCliente = new JTextField();
		txtBuscarCliente.setBounds(161, 70, 265, 20);
		contentPane.add(txtBuscarCliente);
		txtBuscarCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mascotas Relacionadas");
		lblNewLabel_1.setBounds(50, 165, 165, 14);
		contentPane.add(lblNewLabel_1);

		JComboBox <Object>cmbMascota = new JComboBox<>();
		cmbMascota.setBounds(50, 203, 251, 22);
		contentPane.add(cmbMascota);

		JButton btnAltaCliente = new JButton("Alta Cliente");
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AltaCliente nuevoCliente = new AltaCliente();
				nuevoCliente.setLocationRelativeTo(null);
				nuevoCliente.setVisible(true);
			

			}
		});

		btnAltaCliente.setBounds(588, 69, 129, 23);
		contentPane.add(btnAltaCliente);

		JButton btnAltaMascota = new JButton("Alta Mascota");
		btnAltaMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AltaMascota nuevaMascota = new AltaMascota();
				nuevaMascota.setLocationRelativeTo(null);
				nuevaMascota.setVisible(true);
				
				
			}
		});
		btnAltaMascota.setBounds(311, 203, 182, 23);
		contentPane.add(btnAltaMascota);

		txtAfiliadoEncontrado = new JTextField();
		txtAfiliadoEncontrado.setEditable(false);
		txtAfiliadoEncontrado.setBounds(50, 114, 667, 34);
		contentPane.add(txtAfiliadoEncontrado);
		txtAfiliadoEncontrado.setColumns(10);

		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cmbMascota.removeAllItems();

				DueñoServices buscarCliente = new DueñoServicesImpl();

				String nombreCliente = txtBuscarCliente.getText();

				Dueño cliente;
				
				try {
					cliente = buscarCliente.getDueñoByName(nombreCliente);
					if (cliente != null) {
						
						txtAfiliadoEncontrado.setText("Nombre: " + cliente.getNombre() + "    Domicilio: "
								+ cliente.getDomicilio() + "    Telefono: " + cliente.getTelefono());
						
					}
					
					else {
						
						txtAfiliadoEncontrado.setText("No se encontro al cliente");
					}
					MascotaServices buscarMascotas = new MascotaServicesImpl();
					
					List<Mascota> listaMascotas = new ArrayList<>();
					
					listaMascotas = buscarMascotas.getMascotaById(cliente);
					
					listaMascotas.forEach(System.out::println);
					
					
					listaMascotas.stream().map(x -> x.getNombre()).forEach(cmbMascota::addItem);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}


				
					


			}
		});

		btnBuscarCliente.setBounds(458, 69, 119, 23);
		contentPane.add(btnBuscarCliente);

		JLabel lblNewLabel_2 = new JLabel("Horario de Retiro");
		lblNewLabel_2.setBounds(50, 294, 103, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Paseadores Disponibles");
		lblNewLabel_3.setBounds(34, 456, 165, 20);
		contentPane.add(lblNewLabel_3);

		JComboBox <Object> cmbPaseadores = new JComboBox<>();
		cmbPaseadores.setBounds(209, 455, 217, 22);
		contentPane.add(cmbPaseadores);

		JButton btnAltaPaseador = new JButton("Alta Paseador");
		btnAltaPaseador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AltaPaseador nuevoPaseador= new AltaPaseador();
				nuevoPaseador.setLocationRelativeTo(null);
				nuevoPaseador.setVisible(true);
				

			}
		});
		btnAltaPaseador.setBounds(458, 502, 164, 23);
		contentPane.add(btnAltaPaseador);

		

		JButton btnMostrarPaseadores = new JButton("Mostrar Paseadores");
		btnMostrarPaseadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cmbPaseadores.removeAllItems();

				List<Paseador> listaPaseadores = new ArrayList<>();
				PaseadorServices paseadores = new PaseadorServicesImpl();
				try {
					listaPaseadores = paseadores.getAllPaseadores();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				listaPaseadores.stream().map(x -> x.getNombre()).forEach(cmbPaseadores::addItem);
			}
		});
		btnMostrarPaseadores.setBounds(458, 455, 164, 23);
		contentPane.add(btnMostrarPaseadores);

		JLabel lblNewLabel_2_1 = new JLabel("Fecha de Retiro");
		lblNewLabel_2_1.setBounds(348, 294, 103, 20);
		contentPane.add(lblNewLabel_2_1);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(455, 261, 205, 153);
		contentPane.add(calendar);

		
		//Este Codigo es para la fecha y me bloquea el layout absolute del panel
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(161, 294, 72, 20);
		contentPane.add(spinner);
		
		JSpinner.DateEditor spinner_1 = new JSpinner.DateEditor(spinner, "HH:mm");
		spinner_1.setBounds(161, 423, 113, 20);
		contentPane.add(spinner_1);

		spinner.setEditor(spinner_1);

		SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
		formater.format(spinner.getValue());
		

		JButton btnGuardarPaseos = new JButton("Guardar");
		btnGuardarPaseos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaseoServices guardarNuevoPaseo = new PaseoServicesImpl();
				MascotaServices ms = new MascotaServicesImpl();
				PaseadorServices ps = new PaseadorServicesImpl();

				Paseo nuevoPaseo = new Paseo();
				Paseador idPaseador = new Paseador();
				Mascota idMascota = new Mascota();
				

				//Date date = new Date();
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = f.format(calendar.getDate());

				SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
				String horaElegida = formater.format(spinner.getValue());
				

				String nombreMascota = (String) cmbMascota.getSelectedItem();
				try {
					idMascota = ms.getIdMascotaByNombre(nombreMascota);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String nombrePaseador = (String)cmbPaseadores.getSelectedItem();
				try {
					idPaseador = ps.getIdPaseadorByNombre(nombrePaseador);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				nuevoPaseo.setIdMascota(idMascota);
				nuevoPaseo.setIdpaseador(idPaseador);
				nuevoPaseo.setFecha(fecha);
				nuevoPaseo.setHora(horaElegida);
				
				try {
					guardarNuevoPaseo.insert(nuevoPaseo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
							

			}
		});
		btnGuardarPaseos.setBounds(34, 565, 146, 23);
		contentPane.add(btnGuardarPaseos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//A mejorar la forma de cerrar por completo la aplicación
				System.exit(0);
				
			}
		});
		btnCancelar.setBounds(204, 565, 146, 23);
		contentPane.add(btnCancelar);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 623, 667, 2);
		contentPane.add(separator);
		
		JComboBox<Object> cmbPaseos = new JComboBox<>();
		cmbPaseos.setBounds(34, 656, 667, 22);
		contentPane.add(cmbPaseos);
		
		JButton btnPaseos = new JButton("Mostrar Paseos");
		btnPaseos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PaseoServices ps = new PaseoServicesImpl();
				List<Paseo> todosPaseos = new ArrayList<>();
				
				try {
					todosPaseos = ps.getAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				todosPaseos.forEach(cmbPaseos::addItem);
				
				
			}
		});
		btnPaseos.setBounds(34, 725, 146, 23);
		contentPane.add(btnPaseos);

	}

}
