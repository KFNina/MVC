package modelo;

import javax.swing.JFrame;

import interfaz.CargarAlumnos;
//marco.setContentPane(panel); para cambiar el panel actual
public class App {
	private static CargarAlumnos cargar = new CargarAlumnos();
	
	public static void main(String[] args) {
		JFrame marco = new JFrame();
		
		marco.setBounds(100, 100, 800, 500);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.validate();
		marco.setVisible(true);
		
		marco.setContentPane(cargar);
		
	}
	
}
