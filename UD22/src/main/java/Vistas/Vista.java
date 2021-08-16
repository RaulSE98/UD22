package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

	
	private JPanel panel, panel2;
	public JButton insertar, borrar, select, update;
	public JLabel respuesta;
	public JTextField texto;
	
	public Vista () {
		getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		insertar = new JButton ("Insertar");
		borrar = new JButton ("Borrar");
		select = new JButton ("Select");
		update = new JButton ("Udpate");
		
		respuesta = new JLabel("Respuesta: ");
		texto = new JTextField(20);
		
		panel.add(borrar);
		panel.add(insertar);
		panel.add(select);
		panel.add(update);
		
		panel2.add(respuesta);
		
		add(texto, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		add(panel2, BorderLayout.CENTER);
	}

}
