package Ardoise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Ardoise extends JFrame{
	  private JMenuBar menuBar = new JMenuBar();
	  private JMenu menuFichier = new JMenu("Fichier");
	  private JMenu menuSSFichier = new JMenu("Sous ficher");
	  private JMenu menuEdition = new JMenu("Edition");
	  private JMenu menuForme = new JMenu("Forme du  pointeur");
	  private JMenu menuCouleur= new JMenu("Couleur du pointeur");

	  private JMenuItem effacer = new JMenuItem("Efffacer");
	  private JMenuItem quitter = new JMenuItem("Quitter");
	  private JMenuItem formeRond = new JMenuItem("Rond");
	  private JMenuItem formeCarré = new JMenuItem("Carré");
	  private JMenuItem couleurRouge = new JMenuItem("Rouge");
	  private JMenuItem couleurVert = new JMenuItem("Vert");
	  private JMenuItem couleurBleu = new JMenuItem("Bleu");



	  public static void main(String[] args){
		  Ardoise ardoise = new Ardoise();
	  }

	  public Ardoise(){
	    this.setSize(400, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    this.menuFichier.add(effacer);
	    this.menuFichier.addSeparator();
	    this.menuFichier.add(quitter);

	    this.menuEdition.add(menuForme);
	    this.menuForme.add(formeRond);
	    this.menuForme.add(formeCarré);
	    this.menuEdition.addSeparator();
	    this.menuEdition.add(menuCouleur);
	    this.menuCouleur.add(couleurRouge);
	    this.menuCouleur.add(couleurVert);	    
	    this.menuCouleur.add(couleurBleu);
	    
	    quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
		});
	    this.menuBar.add(menuFichier);
	    this.menuBar.add(menuEdition);
	    this.setJMenuBar(menuBar);
	    this.setVisible(true);
	}
}