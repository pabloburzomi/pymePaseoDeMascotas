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

import com.pabloburzomi.domain.Paseador;
import com.pabloburzomi.services.PaseadorServices;
import com.pabloburzomi.services.impl.PaseadorServicesImpl;
import java.awt.Window.Type;

public class AltaPaseador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombrePaseador;
	private JTextField txtDniPaseador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			AltaPaseador dialog = new AltaPaseador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaPaseador() {
		setModal(true);
		
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre y Apellido:");
		lblNewLabel.setBounds(28, 40, 132, 14);
		contentPanel.add(lblNewLabel);
		
		txtNombrePaseador = new JTextField();
		txtNombrePaseador.setBounds(28, 71, 272, 20);
		contentPanel.add(txtNombrePaseador);
		txtNombrePaseador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(28, 120, 86, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtDniPaseador = new JTextField();
		txtDniPaseador.setBounds(28, 162, 132, 20);
		contentPanel.add(txtDniPaseador);
		txtDniPaseador.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAltaPaseador = new JButton("Dar de Alta Paseador");
				btnAltaPaseador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						PaseadorServices paseador = new PaseadorServicesImpl();
						
						String nombrePaseador = txtNombrePaseador.getText();
						String dniPaseador = txtDniPaseador.getText();
						
						Paseador nuevoPaseador = new Paseador();
						nuevoPaseador.setNombre(nombrePaseador);
						nuevoPaseador.setDni(dniPaseador);
						
						try {
							paseador.insert(nuevoPaseador);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				btnAltaPaseador.setActionCommand("OK");
				buttonPane.add(btnAltaPaseador);
				getRootPane().setDefaultButton(btnAltaPaseador);
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
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(false);
	}


}
