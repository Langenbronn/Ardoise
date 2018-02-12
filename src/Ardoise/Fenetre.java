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
	    this.setVisible(true);
	}
	public void InitMenu(){
	    this.menuFichier.add(effacer);
	    effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ardoise.erase();			
			}
		});
	    this.menuFichier.addSeparator();
	    this.menuFichier.add(quitter);
	    quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
		});
	    this.menuEdition.add(menuForme);
	    this.menuForme.add(formeRond);
	    this.menuForme.add(formeCarré);
	    formeRond.addActionListener(new FormeListener());
	    formeCarré.addActionListener(new FormeListener());  
	    this.menuEdition.addSeparator();
	    this.menuEdition.add(menuCouleur);
	    this.menuCouleur.add(couleurRouge);
	    this.menuCouleur.add(couleurVert);	    
	    this.menuCouleur.add(couleurBleu);
	    couleurRouge.addActionListener(new CouleurListener());
	    couleurVert.addActionListener(new CouleurListener());
	    couleurBleu.addActionListener(new CouleurListener());
	    this.menuBar.add(menuFichier);
	    this.menuBar.add(menuEdition);
	    this.setJMenuBar(menuBar);
	}
	  private void initToolBar(){  		  
		  this.carre.setBackground(fondBouton);		  
		  this.toolBar.add(carre);		  		  
		  this.rond.setBackground(fondBouton);		  
		  this.toolBar.add(rond);
		  carre.addActionListener(new FormeListener());
		  rond.addActionListener(new FormeListener());    
		  this.red.setBackground(fondBouton);
		  this.toolBar.add(red);
		  this.green.setBackground(fondBouton);
		  this.toolBar.add(green);
		  this.blue.setBackground(fondBouton);
		  this.toolBar.add(blue);
		  red.addActionListener(new CouleurListener());
		  green.addActionListener(new CouleurListener());
		  blue.addActionListener(new CouleurListener());
		   
		  this.getContentPane().add(toolBar, BorderLayout.NORTH);    		 
	  }
	  class FormeListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		      if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")){
		        if(e.getSource()==formeCarré) ardoise.setPointerType("SQUARE");
		        else ardoise.setPointerType("CIRCLE");
		      }
		      else{
		        if(e.getSource()==carre)ardoise.setPointerType("SQUARE");
		        else ardoise.setPointerType("CIRCLE");        
		      }
		    }    
		  }
	  class CouleurListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		        if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")){
		          if(e.getSource()==couleurVert)ardoise.setPointerColor(Color.green);
		          else if(e.getSource()==couleurBleu)ardoise.setPointerColor(Color.blue);
		          else ardoise.setPointerColor(Color.red);
		        }
		        else{
		          if(e.getSource()==green)ardoise.setPointerColor(Color.green);
		          else if(e.getSource()==blue)ardoise.setPointerColor(Color.blue);
		          else ardoise.setPointerColor(Color.red);        
		        }
		      }    
		    }
}