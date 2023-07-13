package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.daoComputadora;
import modelo.Computadora;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class vComputadora extends JFrame {
//Atributos
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtmarca;
	private JTextField txtprocesador;
	private JTextField txtmemoriaram;
	private JTextField txtSistema;
	private JTextField txtprecio;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnLimpiar;
	daoComputadora dao = new daoComputadora();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Computadora> lista;
	private JTable tblinventario;
	int fila = -1;
	Computadora computadora = new Computadora();
	private JButton btnConsultaGeneral;
	//metodo para visualizar en el jtable los datos de la base de datos
	public void Actualizartabla () {
		
		while (modelo.getRowCount()>0) {
		modelo.removeRow (0);
		}
		lista=dao.consultaComputadoras();
		for (Computadora computadora : lista) {
			Object computer [] = new Object [6];
			computer [0]= computadora.getCodigo();
			computer [1]=computadora.getMarca();
			computer [2]=computadora.getProcesador();
			computer [3]=computadora.getMemoria();
			computer [4]=computadora.getSistema();
			computer [5]=computadora.getPrecio();
			modelo.addRow(computer);
		}
		tblinventario.setModel(modelo);
	}
	//metodo limpiar
	public void limpiar() {
		txtmarca.setText("");
		txtprocesador.setText("");
		txtmemoriaram.setText("");
		txtSistema.setText("");
		txtprecio.setText("");
		txtcodigo.setText("");
	}
	//constructor
	public vComputadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 453);
		setLocationRelativeTo(null);
		setResizable(false);
		
		iniciarcomponentes();
	//metodo iniciar componentes 
	}
	public void iniciarcomponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Inventario");
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(new Color(0, 0, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 858, 33);
		contentPane.add(lblTitulo);
		
		JLabel lblcodigo = new JLabel("Codigo:");
		lblcodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcodigo.setBounds(10, 44, 77, 26);
		contentPane.add(lblcodigo);
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtcodigo.setBounds(75, 44, 86, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblmarca = new JLabel("Marca:");
		lblmarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmarca.setBounds(10, 71, 77, 26);
		contentPane.add(lblmarca);
		
		txtmarca = new JTextField();
		txtmarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmarca.setColumns(10);
		txtmarca.setBounds(75, 71, 216, 20);
		contentPane.add(txtmarca);
		
		JLabel lblprocesador = new JLabel("Procesador:");
		lblprocesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblprocesador.setBounds(10, 102, 77, 26);
		contentPane.add(lblprocesador);
		
		txtprocesador = new JTextField();
		txtprocesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtprocesador.setColumns(10);
		txtprocesador.setBounds(96, 105, 206, 20);
		contentPane.add(txtprocesador);
		
		JLabel lblmemoriaram = new JLabel("Memoria RAM(GB):");
		lblmemoriaram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmemoriaram.setBounds(10, 129, 127, 26);
		contentPane.add(lblmemoriaram);
		
		txtmemoriaram = new JTextField();
		txtmemoriaram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmemoriaram.setColumns(10);
		txtmemoriaram.setBounds(149, 132, 64, 20);
		contentPane.add(txtmemoriaram);
		
		JLabel lblSistema = new JLabel("Sistema Operativo:\r\n");
		lblSistema.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSistema.setBounds(10, 166, 127, 26);
		contentPane.add(lblSistema);
		
		txtSistema = new JTextField();
		txtSistema.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSistema.setColumns(10);
		txtSistema.setBounds(149, 169, 159, 20);
		contentPane.add(txtSistema);
		
		JLabel lblPrecio = new JLabel("Precio($):");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 201, 77, 26);
		contentPane.add(lblPrecio);
		
		txtprecio = new JTextField();
		txtprecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtprecio.setColumns(10);
		txtprecio.setBounds(88, 203, 86, 20);
		contentPane.add(txtprecio);
		// Boton Agregar computadora
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Sentencia if para mandar mensaje en caso de tener campos vacios
					if(txtcodigo.getText().equals("")|txtmarca.getText().equals("") | txtprocesador.getText().equals("")| txtmemoriaram.getText().equals("")|txtSistema.getText().equals("")|txtprecio.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios");
						return;
					}
					else {
	
					Computadora computer = new Computadora();
					computer.setCodigo(Integer.parseInt(txtcodigo.getText()));
					computer.setMarca(txtmarca.getText());
					computer.setProcesador(txtprocesador.getText());
					computer.setMemoria(Double.parseDouble(txtmemoriaram.getText()));
					computer.setSistema(txtSistema.getText());
					computer.setPrecio(Double.parseDouble(txtprecio.getText()));
					if(dao.insertarcomputadora(computer)) {
						JOptionPane.showMessageDialog(null, "Se agrego correctamente");
						Actualizartabla();
					}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnAgregar.setBounds(20, 238, 89, 23);
		contentPane.add(btnAgregar);
		//Boton eliminar
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				//Se envia mensaje de confirmacion para evitar la eliminacion de una computadora por error
				int opcion = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar esta computadora?","Eliminar computadora",JOptionPane.YES_NO_OPTION);
			
				if(opcion ==0) {
				if(dao.eliminarcomputadora(computadora.getCodigo())) {
					Actualizartabla();
					limpiar();
					JOptionPane.showMessageDialog(null, "Se elimino correctamente");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "ERRORr");
				}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			}
		});
		btnEliminar.setBounds(119, 238, 89, 23);
		contentPane.add(btnEliminar);
		
		//Boton editar
		
		btnEditar = new JButton("Editar\r\n");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				if(txtcodigo.getText().equals("")|txtmarca.getText().equals("") | txtprocesador.getText().equals("")| txtmemoriaram.getText().equals("")|txtSistema.getText().equals("")|txtprecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos vacios");
					return;
				}
				else {
				computadora.setCodigo(Integer.parseInt(txtcodigo.getText()));
				computadora.setMarca(txtmarca.getText());
				computadora.setProcesador(txtprocesador.getText());
				computadora.setMemoria(Double.parseDouble(txtmemoriaram.getText()));
				computadora.setSistema(txtSistema.getText());
				computadora.setPrecio(Double.parseDouble(txtprecio.getText()));
				if(dao.editarcomputadora(computadora)) {
					Actualizartabla();
					limpiar();
					JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
					}
				else {
					JOptionPane.showMessageDialog(null, "No se pudo actualizar correctamente");
				}
				}
			}
			catch(Exception e2){
				JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnEditar.setBounds(20, 266, 89, 23);
		contentPane.add(btnEditar);
		//boton limpiar (solo borra la informacion de los txt)
		btnLimpiar = new JButton("Limpiar\r\n");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(119, 266, 89, 23);
		contentPane.add(btnLimpiar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 59, 530, 333);
		contentPane.add(scrollPane);
		
		tblinventario = new JTable();
		tblinventario.addMouseListener(new MouseAdapter() {
			@Override
			//Esta accion permite que al clickear un elemento de la tabla, se va llenar los txt con dicha informacion
			public void mouseClicked(MouseEvent e) {
				fila=tblinventario.getSelectedRow();
				computadora=lista.get(fila);
				txtcodigo.setText(""+computadora.getCodigo());
				txtmarca.setText(computadora.getMarca());
				txtprocesador.setText(computadora.getProcesador());
				txtmemoriaram.setText(""+computadora.getMemoria());
				txtSistema.setText(computadora.getSistema());
				txtprecio.setText(""+computadora.getPrecio());
			}
		});
		tblinventario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblinventario);
		modelo.addColumn("Codigo");
		modelo.addColumn("Marca");
		modelo.addColumn("Procesador");
		modelo.addColumn("Memoria Ram");
		modelo.addColumn("Sistema operativo");
		modelo.addColumn("Precio");
		Actualizartabla();
		//Boton consulta general (permite ingresa a una ventana dedicada a la busqueda)
		btnConsultaGeneral = new JButton("Consulta general\r\n");
		btnConsultaGeneral.setBounds(54, 302, 171, 23);
		contentPane.add(btnConsultaGeneral);
		btnConsultaGeneral.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		VentanaBusqueda miVentanaBusqueda = new VentanaBusqueda();
		miVentanaBusqueda.setdaoComputadora(dao);
		miVentanaBusqueda.setVisible(true);
					}
				});
	}
	
}
