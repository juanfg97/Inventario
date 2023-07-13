package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.daoComputadora;
import modelo.Computadora;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaBusqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtmarca;
	daoComputadora dao = new daoComputadora();
	ArrayList<Computadora> lista = new ArrayList<>();
	private JLabel lblcodigo_1;
	private JLabel lblProcesador_1;
	private JLabel lblMemoriaRam_1;
	private JLabel lblSistemaOperativo_1;
	private JLabel lblPrecio_1;
	public VentanaBusqueda() {
	
		setBounds(100, 100, 379, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarcomponentes();
		
	}

	public void iniciarcomponentes() {
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("Consulta General\r\n");
		lblTitulo.setBackground(new Color(0, 0, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 363, 36);
		lblTitulo.setOpaque(true);
		contentPane.add(lblTitulo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(10, 47, 46, 19);
		contentPane.add(lblMarca);
		
		txtmarca = new JTextField();
		txtmarca.setBounds(55, 48, 86, 20);
		contentPane.add(txtmarca);
		txtmarca.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista=dao.consultaComputadoras();
				String marca = txtmarca.getText();
				boolean Encontrar=false;
					for (Computadora computadora : lista) {
						if(computadora.getMarca().equals(marca)) {
							lblcodigo_1.setText(""+computadora.getCodigo());
							lblProcesador_1.setText(computadora.getProcesador());
							lblMemoriaRam_1.setText(""+computadora.getMemoria());
							lblSistemaOperativo_1.setText(computadora.getSistema());
							lblPrecio_1.setText(""+computadora.getPrecio());
							Encontrar=true;
							break;
						}
							
					}
					if (Encontrar==true) {
						JOptionPane.showMessageDialog(null, "Se encontro la computador");
					} else {
						JOptionPane.showMessageDialog(null, "No se encontro la computador");
					}
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(125, 236, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblcodigo = new JLabel("Codigo:\r\n");
		lblcodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcodigo.setBounds(10, 77, 58, 19);
		contentPane.add(lblcodigo);
		
		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProcesador.setBounds(10, 107, 86, 19);
		contentPane.add(lblProcesador);
		
		JLabel lblMemoriaRam = new JLabel("Memoria ram(GB):\r\n");
		lblMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMemoriaRam.setBounds(10, 137, 131, 19);
		contentPane.add(lblMemoriaRam);
		
		JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:\r\n");
		lblSistemaOperativo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSistemaOperativo.setBounds(10, 167, 131, 19);
		contentPane.add(lblSistemaOperativo);
		
		JLabel lblPrecio = new JLabel("Precio($):\r\n");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 197, 74, 19);
		contentPane.add(lblPrecio);
		
		lblcodigo_1 = new JLabel("");
		lblcodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcodigo_1.setBounds(83, 79, 58, 19);
		contentPane.add(lblcodigo_1);
		
		lblProcesador_1 = new JLabel("");
		lblProcesador_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProcesador_1.setBounds(104, 107, 168, 19);
		contentPane.add(lblProcesador_1);
		
		lblMemoriaRam_1 = new JLabel("\r\n");
		lblMemoriaRam_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMemoriaRam_1.setBounds(141, 137, 131, 19);
		contentPane.add(lblMemoriaRam_1);
		
		lblSistemaOperativo_1 = new JLabel("");
		lblSistemaOperativo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSistemaOperativo_1.setBounds(141, 167, 152, 19);
		contentPane.add(lblSistemaOperativo_1);
		
		lblPrecio_1 = new JLabel("\r\n");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio_1.setBounds(83, 197, 46, 19);
		contentPane.add(lblPrecio_1);
		
	}

	public void setdaoComputadora(daoComputadora dao) {
		
		this.dao=dao;
	}
}
