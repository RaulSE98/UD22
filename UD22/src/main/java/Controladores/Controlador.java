package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import Modelos.Modelo;
import Vistas.Vista;

public class Controlador implements ActionListener {
	private Modelo modelo;
	private Vista vista;
	private String query;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.borrar.addActionListener(this);
		this.vista.insertar.addActionListener(this);
		this.vista.select.addActionListener(this);
		this.vista.update.addActionListener(this);
	}

	public void iniciarVista() {
		vista.setTitle("SQL");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {	
		query = vista.texto.getText();
		if (vista.insertar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
			
				modelo.setQuery("insert into cliente  (nombre, apellido, direccion, dni, fecha) values (" + query + ");");
				modelo.insertarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		} else if (vista.borrar == e.getSource()) {
			if (!"".equals(vista.texto.getText())) {
				modelo.setQuery("delete from cliente " + query);
				modelo.borrarDatos();
				vista.respuesta.setText(modelo.getRespuesta());
			}
		} else if (vista.update == e.getSource()) {
            if (!"".equals(vista.texto.getText())) {
                query = vista.texto.getText();
                modelo.setQuery("update cliente set " + query );
                modelo.actualizarDatos();
                vista.respuesta.setText(modelo.getRespuesta());
            }
        } else if (vista.select == e.getSource()) {
            if (!"".equals(vista.texto.getText())) {
                query = vista.texto.getText();
                modelo.setQuery(query );
                modelo.select();
                vista.respuesta.setText(modelo.getRespuesta());
            }
        }
	}
}
