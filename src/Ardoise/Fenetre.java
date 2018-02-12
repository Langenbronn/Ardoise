package Ardoise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;

public class Fenetre extends JFrame{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier"),
	              menuEdition = new JMenu("Edition"),
	              menuForme = new JMenu("Forme du  pointeur"),
	              menuCouleur= new JMenu("Couleur du pointeur");
    private JMenuItem effacer = new JMenuItem("Efffacer"),
					  quitter = new JMenuItem("Quitter"),
					  formeRond = new JMenuItem("Rond"),
					  formeCarré = new JMenuItem("Carré"),
					  couleurRouge = new JMenuItem("Rouge"),
					  couleurVert = new JMenuItem("Vert"),
					  couleurBleu = new JMenuItem("Bleu");

    private JToolBar toolBar = new JToolBar();

    private JButton carre = new JButton(new ImageIcon("images/carré.png")),
    				rond = new JButton(new ImageIcon("images/rond.png")),
    				red = new JButton(new ImageIcon("images/red.png")),
    				green = new JButton(new ImageIcon("images/green.png")),
    				blue = new JButton(new ImageIcon("images/blue.png"));
    private Color fondBouton = Color.white;
	private Ardoise ardoise = new Ardoise();


	  public static void main(String[] args){
		  Fenetre fen = new Fenetre();
	  }

	  public Fenetre(){
	    this.setSize(600, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.InitMenu();
	    this.initToolBar();
	    this.getContentPane().add(ardoise, BorderLayout.CENTER);  
	    quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
		});
	    this.setVisible(true);
	}
	public void InitMenu(){
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
	    this.menuBar.add(menuFichier);
	    this.menuBar.add(menuEdition);
	    this.setJMenuBar(menuBar);
	}
	  private void initToolBar(){
		    this.carre.setEnabled(false);
		    this.carre.setBackground(fondBouton);
		    this.toolBar.add(carre);
		    this.rond.setEnabled(false);
		    this.rond.setBackground(fondBouton);
		    this.toolBar.add(rond);
		    
		    this.red.setEnabled(false);
		    this.red.setBackground(fondBouton);
		    this.toolBar.add(red);
		    this.green.setEnabled(false);
		    this.green.setBackground(fondBouton);
		    this.toolBar.add(green);
		    this.blue.setEnabled(false);
		    this.blue.setBackground(fondBouton);
		    this.toolBar.add(blue);
		    
		    this.getContentPane().add(toolBar, BorderLayout.NORTH);    
		  }
}