package UD22.UD22;

import Controladores.Controlador;
import Modelos.Modelo;
import Vistas.Vista;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciarVista();
	}
}
