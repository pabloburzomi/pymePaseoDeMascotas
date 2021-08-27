package com.pabloburzomi.App.desktop.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.services.DueñoServices;
import com.pabloburzomi.services.MascotaServices;
import com.pabloburzomi.services.impl.DueñoServicesImpl;
import com.pabloburzomi.services.impl.MascotaServicesImpl;

public class AltaMascota extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreMascota;
	private JTextField txtRaza;
	private JTextField txtCantPaseos;
	static AltaMascota dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new AltaMascota();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaMascota() {
		setModal(true);
		setBounds(100, 100, 716, 415);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(50, 70, 70, 23);
		contentPanel.add(lblNewLabel);
		
		txtNombreMascota = new JTextField();
		txtNombreMascota.setBounds(107, 71, 151, 20);
		contentPanel.add(txtNombreMascota);
		txtNombreMascota.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Raza:");
		lblNewLabel_1.setBounds(50, 128, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Caracteristicas:");
		lblNewLabel_1_1.setBounds(322, 128, 107, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad de Paseos Diarios");
		lblNewLabel_1_1_1.setBounds(50, 208, 163, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Dueño:");
		lblNewLabel_1_1_2.setBounds(50, 289, 80, 14);
		contentPanel.add(lblNewLabel_1_1_2);
		
		txtRaza = new JTextField();
		txtRaza.setBounds(107, 125, 151, 20);
		contentPanel.add(txtRaza);
		txtRaza.setColumns(10);
		
		JTextArea txtCaracteristicas = new JTextArea();
		txtCaracteristicas.setBounds(429, 123, 242, 99);
		contentPanel.add(txtCaracteristicas);
		
		txtCantPaseos = new JTextField();
		txtCantPaseos.setBounds(224, 205, 86, 20);
		contentPanel.add(txtCantPaseos);
		txtCantPaseos.setColumns(10);
		
		JComboBox<Object> cmbClientes = new JComboBox<>();
		cmbClientes.setEditable(true);
		cmbClientes.setMaximumRowCount(10);
		cmbClientes.setBounds(152, 285, 519, 22);
		contentPanel.add(cmbClientes);
		DueñoServices dueños = new DueñoServicesImpl();
		List<Dueño> listaDueños = new ArrayList<>();
		try {
			listaDueños = dueños.findDueño();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listaDueños.stream().map(x->x.getNombre()).forEach(cmbClientes::addItem);

		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dar de Alta");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						MascotaServices mascotaServices = new MascotaServicesImpl();
						
						
						Mascota mascota = new Mascota();
						mascota.setNombre(txtNombreMascota.getText());
						mascota.setRaza(txtRaza.getText());
						mascota.setCaracteristicas(txtCaracteristicas.getText());
						int paseos = Integer.parseInt(txtCantPaseos.getText());
						
						mascota.setPaseosDiarios(paseos);
						
						DueñoServices dueñoAux = new DueñoServicesImpl();
						
						String nombre = (String) cmbClientes.getItemAt(cmbClientes.getSelectedIndex());
						

						Dueño p;
						try {
							p = dueñoAux.getDueñoByName(nombre);
							mascota.setIdcliente(p);
							
							mascotaServices.crearMascota(mascota);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						cerrarVentana();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void cerrarVentana() {
		
		this.setVisible(false);
	}
}
