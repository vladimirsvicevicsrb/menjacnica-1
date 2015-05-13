package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.ObjectInputStream.GetField;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Menjacnica;
import menjacnica.MenjacnicaInterface;
import menjacnica.Valuta;

public class GUIKontroler {

	private static MenjacnicaGUI glavniProzor;
	private static MenjacnicaInterface menjacnicaI;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnicaI = new Menjacnica();
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(
				glavniProzor.getContentPane(),
				"Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public static void prikaziAbout() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
				"Autor: Bojan Tomic, Verzija 1.0", "O programu Menjacnica",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void prikaziDodajKursGUI() {
		DodajKursGUI prozor = new DodajKursGUI(glavniProzor);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
		prozor.setVisible(true);
	}

	public static void prikaziObrisiKursGUI(Valuta valuta) {
		if (valuta != null) {
			ObrisiKursGUI prozor = new ObrisiKursGUI(glavniProzor, valuta);
			prozor.setLocationRelativeTo(glavniProzor.getContentPane());
			prozor.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Morate uneti jednu valutu", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				menjacnicaI.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnicaI.ucitajIzFajla(file.getAbsolutePath());
				glavniProzor.prikaziSveValute(menjacnicaI.vratiKursnuListu());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void prikaziIzvrsiZamenuGUI(Valuta valuta) {
		if (valuta != null) {
			IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI(glavniProzor, valuta);
			prozor.setLocationRelativeTo(glavniProzor.getContentPane());
			prozor.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Morate uneti jednu valutu", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void obrisiValutu(Valuta valuta) {
		try {
			menjacnicaI.obrisiValutu(valuta);

			glavniProzor.prikaziSveValute(menjacnicaI.vratiKursnuListu());
			glavniProzor.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void unesiKurs(String naziv, String skraceniNaziv,
			Integer sifra, String prodajni, String kupovni, String srednji) {
		try {
			Valuta valuta = new Valuta();

			// Punjenje podataka o valuti
			valuta.setNaziv(naziv);
			valuta.setSkraceniNaziv(skraceniNaziv);
			valuta.setSifra(sifra);
			valuta.setProdajni(Double.parseDouble(prodajni));
			valuta.setKupovni(Double.parseDouble(kupovni));
			valuta.setSrednji(Double.parseDouble(srednji));

			// Dodavanje valute u kursnu listu
			menjacnicaI.dodajValutu(valuta);

			// Osvezavanje glavnog prozora
			glavniProzor.prikaziSveValute(menjacnicaI.vratiKursnuListu());

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
}
