package superAgil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	ArrayList<JLabel> cajas;
	SuperController ctrl;
	int cantidadCajas;
	
	/** Team A score increment button. */
	protected JButton buscarCaja;
		
	public VistaCliente(int countcajas) {
		cantidadCajas = countcajas;
		ctrl = new SuperController(countcajas, this);
		
		ctrl.startCajas();
		createUI();
	}
	
	
	protected void createUI() {
		setTitle("Fila del Super");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		//
		JPanel cajasPane = new JPanel();
		Image warnImage = ImageLoader.getImage(VistaCliente.class, "caja_supermercado2.jpg").getScaledInstance(100,100,Image.SCALE_SMOOTH);
	    Icon warnIcon = new ImageIcon(warnImage);
	    
	    cajas = new ArrayList<JLabel>();
	    
	    cajasPane.setBackground(Color.WHITE);
	    
	    for (int i = 0 ;i<cantidadCajas; i++) {
	    	cajas.add(new JLabel ("Disponible", warnIcon, JLabel.CENTER));
	    	cajasPane.add (cajas.get(i));
	    	
	    }
	    
	    //
		buscarCaja = new JButton("Agregar Cliente");
		buscarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateCola(ctrl.cola.size() + 1);
				ctrl.queueClient(new Cliente(new Random().nextInt(20)+3));
			}
		});
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(buscarCaja);
		centerPane.add(buttonPane, BorderLayout.SOUTH);
		
	    
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		mensaje = new JLabel("0 clientes en cola.");
		
		contentPane.add(mensaje);
		contentPane.add(centerPane);
		contentPane.add(cajasPane);
		//
		pack();
	}
	public  void open() {
		setVisible(true);
	}
	
	public void updateCola (int countCola) {
		mensaje.setText(Integer.toString(countCola) + " clientes en cola.");
	}
	
	public void updateCaja (int cajaIndex, String estado) {
		cajas.get(cajaIndex).setText(estado);
	}
}