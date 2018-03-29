package first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIProgram {

	private JFrame frame;
	private JSpinner n_squadre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIProgram window = new GUIProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textOutput = new JTextArea();
		textOutput.setFont(new Font("Calibri Light", Font.BOLD, 25));
		textOutput.setEditable(false);
		textOutput.setBounds(10, 122, 784, 338);
		frame.getContentPane().add(textOutput);

		
		JButton btnNewButton = new JButton("Genera Torneo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textOutput.setText(null);
				Griglia griglia = null ;
				boolean error = true ;
				int value = (Integer) n_squadre.getValue() ;
				while(error) {
					try {
						griglia = Main.MainAlgorithm(value) ;
						error = false ;
					} catch (Exception e) {
					}
				}
				textOutput.append(griglia.stampaGriglia());
			}
		});
		btnNewButton.setBounds(588, 41, 150, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNumeroDiSquadre = new JLabel("Numero Squadre");
		lblNumeroDiSquadre.setBounds(334, 11, 174, 14);
		frame.getContentPane().add(lblNumeroDiSquadre);
		
		n_squadre = new JSpinner();
		n_squadre.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		n_squadre.setBounds(312, 41, 143, 35);
		frame.getContentPane().add(n_squadre);
		
		JLabel lblNewLabel = new JLabel("Torneo");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblNewLabel.setBounds(345, 69, 91, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRicordaCheLe = new JLabel("Ricorda che le squadre devono essere");
		lblRicordaCheLe.setBounds(55, 41, 269, 14);
		frame.getContentPane().add(lblRicordaCheLe);
		
		JLabel lblPariEMaggiori = new JLabel(" Pari e maggiori di 0 !");
		lblPariEMaggiori.setForeground(Color.RED);
		lblPariEMaggiori.setBounds(96, 62, 184, 14);
		frame.getContentPane().add(lblPariEMaggiori);		
		
	}
}
