package com.pabloburzomi.App.desktop.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.services.DueñoServices;
import com.pabloburzomi.services.impl.DueñoServicesImpl;

public class AltaCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreNuevoCliente;
	private JTextField txtDNINuevoCliente;
	private JTextField txtDomicilioNuevoCliente;
	private JTextField txtTelefonoNuevoCliente;
	public static AltaCliente dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new AltaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaCliente() {
		setModal(true);
		setBounds(100, 100, 450, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre y Apellido");
			lblNewLabel.setBounds(10, 22, 108, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtNombreNuevoCliente = new JTextField();
			txtNombreNuevoCliente.setBounds(10, 47, 398, 20);
			contentPanel.add(txtNombreNuevoCliente);
			txtNombreNuevoCliente.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("DNI");
			lblNewLabel_1.setBounds(10, 92, 83, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtDNINuevoCliente = new JTextField();
			txtDNINuevoCliente.setBounds(10, 117, 108, 20);
			contentPanel.add(txtDNINuevoCliente);
			txtDNINuevoCliente.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Domicilio");
			lblNewLabel_2.setBounds(10, 164, 108, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtDomicilioNuevoCliente = new JTextField();
			txtDomicilioNuevoCliente.setBounds(10, 189, 317, 20);
			contentPanel.add(txtDomicilioNuevoCliente);
			txtDomicilioNuevoCliente.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Telefono");
			lblNewLabel_3.setBounds(10, 239, 93, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtTelefonoNuevoCliente = new JTextField();
			txtTelefonoNuevoCliente.setBounds(10, 273, 143, 20);
			contentPanel.add(txtTelefonoNuevoCliente);
			txtTelefonoNuevoCliente.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("* Recordar Dar de Alta a su Mascota desde el panel Principal");
			lblNewLabel_4.setBounds(10, 326, 414, 28);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton okButton = new JButton("Dar de Alta");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						DueñoServices cliente = new DueñoServicesImpl();
						
						Dueño nuevoCliente = new Dueño();
						nuevoCliente.setNombre(txtNombreNuevoCliente.getText());
						nuevoCliente.setDomicilio(txtDomicilioNuevoCliente.getText());
						nuevoCliente.setDni(txtDNINuevoCliente.getText());
						nuevoCliente.setTelefono(txtTelefonoNuevoCliente.getText());
						
						
						try {
							cliente.crearDueño(nuevoCliente);
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
