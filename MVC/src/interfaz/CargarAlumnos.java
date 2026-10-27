package interfaz;

import javax.swing.JPanel;

import javax.swing.JTextField;

import bdd.Conexion;
import modelo.Alumno;
import modelo.Meses;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.*;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Checkbox;

public class CargarAlumnos extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JComboBox comboBox;
	private JLabel labelEstudios;
	private JLabel labelFechaNacimiento;
	private JLabel labelNombre;
	private Conexion c = new Conexion();
	private JButton botonCargar; 
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAño;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAño;
	private Checkbox checkbox;
	private JTextField textFieldDNI;
	private JLabel lblDNI;
	private JComboBox comboBoxMes;
	private Meses m;
	public CargarAlumnos() {
		setLayout(null);
		setBounds(100, 100, 800, 500);
		crearLabels();
		crearTextFields();
		crearBotones();
		crearCheckBox();
		crearComboBox();
		crearSpinner();
		eventoBotones();
		

	}
	
	
	public void crearLabels() {
		labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(79, 67, 46, 14);
		add(labelNombre);
		
		labelFechaNacimiento = new JLabel("Fecha Nacimiento");
		labelFechaNacimiento.setBounds(49, 138, 95, 14);
		add(labelFechaNacimiento);

		lblDia = new JLabel("Dia");
		lblDia.setBounds(221, 109, 46, 14);
		add(lblDia);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(322, 109, 46, 14);
		add(lblMes);
		
		lblAño = new JLabel("Año");
		lblAño.setBounds(413, 109, 46, 14);
		add(lblAño);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(79, 303, 46, 14);
		add(lblDNI);
		
		labelEstudios = new JLabel("Estudios");
		labelEstudios.setBounds(49, 184, 46, 14);
		add(labelEstudios);
	}
	public void crearTextFields() {
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(211, 57, 95, 34);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(211, 300, 86, 20);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
	}
	public void crearBotones() {
		botonCargar = new JButton("Cargar");
		botonCargar.setBounds(206, 353, 89, 23);
		add(botonCargar);
		
	}
	public void crearComboBox() {
		comboBox = new JComboBox();
		comboBox.setBounds(209, 184, 220, 54);
		add(comboBox);
		
		comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(294, 135, 74, 20);
		add(comboBoxMes);
		
		for(String s : c.elementosComboBox()) {
			comboBox.addItem(s);
		}
		for(Meses m:m.values()) {
			comboBoxMes.addItem(m);
		}
			
		
	}
	public void crearCheckBox() {
		checkbox = new Checkbox("HIJOS?");
		checkbox.setBounds(206, 256, 95, 22);
		add(checkbox);
	}
	public void crearSpinner() {
		spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(209, 135, 52, 20);
		add(spinnerDia);
		
		spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(1, 1, 2026, 1));
		spinnerAño.setBounds(401, 135, 58, 20);
		add(spinnerAño);
		
	}
	public void eventoBotones() {
		botonCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkeoMeses((int) spinnerMes.getValue());
				c.agregarAlumno(cargar());
				
			}
		});
		
	}
	
	public void checkeoMeses(int id) {
		
		validate();
	}
	
	public Alumno cargar() {
		Alumno personita;
		//m.toString(); para pasar el nombre del enum a string
		
		int dia =(int) spinnerDia.getValue();
		int mes = (int) comboBox.getSelectedIndex();
		int año = (int) spinnerAño.getValue();
		LocalDate fechaCompleta = LocalDate.of(año, mes, dia);
		
		String nombre = textFieldNombre.getText();
		
		boolean hijos = checkbox.getState();
		
		int idEstudio = (int) comboBox.getSelectedIndex();
		
		String dni = textFieldDNI.getText(); 
		
		//String dni,String nombre, LocalDate fecha, boolean tieneHijo, int idEstudio
		personita = new Alumno(dni, nombre, fechaCompleta, hijos, idEstudio);
		
		return personita;
	}
}
