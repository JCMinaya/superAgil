package superAgil;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.Cliente;

@SuppressWarnings("serial")
public class VistaCliente extends JFrame  {
	/** Team A score label. */
	protected JLabel mensaje;
	
	/** Team A score increment button. */
	protected JButton buscarCaja;
		
	public VistaCliente() {
		createUI();
	}
	
	
	protected void createUI() {
		setTitle("Fila del Super");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		//
		buscarCaja = new JButton("Buscar Caja");
		buscarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String pts = "";
				//TODO Algo que hacer aquí
			}
		});
		JPanel buttonPane = new JPanel();
		buttonPane.add(buscarCaja);
		centerPane.add(buttonPane, BorderLayout.SOUTH);
		//
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		mensaje = new JLabel("---");
		
		contentPane.add(mensaje);
		contentPane.add(centerPane);
		//
		pack();
	}	
}