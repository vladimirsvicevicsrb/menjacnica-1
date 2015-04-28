package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovni;
	private JLabel lblProdajniKurs;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblValuta;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JLabel lblVrstaTransakcije;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;
	private JTextField textField_2;
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovni());
		contentPane.add(getLabel_1());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getLblValuta());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		contentPane.add(getTextField_2());
		contentPane.add(getSlider());
	}
	private JLabel getLblKupovni() {
		if (lblKupovni == null) {
			lblKupovni = new JLabel("Kupovni kurs");
			lblKupovni.setPreferredSize(new Dimension(91, 25));
			lblKupovni.setBounds(10, 10, 108, 25);
		}
		return lblKupovni;
	}
	private JLabel getLabel_1() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(276, 10, 134, 25);
		}
		return lblProdajniKurs;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(10, 34, 160, 25);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(276, 34, 160, 25);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblValuta() {
		if (lblValuta == null) {
			lblValuta = new JLabel("Valuta");
			lblValuta.setBounds(177, 10, 79, 25);
		}
		return lblValuta;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "DOL", "CHF"}));
			comboBox.setBounds(182, 34, 82, 24);
		}
		return comboBox;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 84, 160, 25);
		}
		return lblIznos;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			rdbtnKupovina.setBounds(232, 116, 149, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			rdbtnProdaja.setBounds(232, 142, 149, 23);
		}
		return rdbtnProdaja;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(222, 84, 200, 25);
		}
		return lblVrstaTransakcije;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.setBounds(24, 234, 160, 25);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setBounds(250, 234, 160, 25);
		}
		return btnOdustani;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(10, 115, 200, 25);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					textField_2.setText(""+slider.getValue());
				}
			});
			slider.setPaintLabels(true);
			slider.setSnapToTicks(true);
			slider.setPaintTicks(true);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setBounds(10, 173, 426, 42);
		}
		return slider;
	}
}
