package Ardoise;

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Ardoise extends JPanel {
	private Color pointerColor = Color.red;
	private int pointerSize = 10;
	private String pointerType = "ROND";
	private ArrayList<Point> points = new ArrayList<Point>();
	private boolean erasing = true;
	
	public Ardoise(){
	    this.addMouseListener(new MouseAdapter(){
	      public void mousePressed(MouseEvent e){
	        points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
	        repaint();
	      }
	    });
	    this.addMouseMotionListener(new MouseMotionListener(){
	      public void mouseDragged(MouseEvent e) {
	        points.add(new Point(e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2), pointerSize, pointerColor, pointerType));
	        repaint();
	      }
	      public void mouseMoved(MouseEvent e) {}
	    });
	  }   
	  // Vous la connaissez maintenant, celle-là
	  public void paintComponent(Graphics g) {

	    g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());

	    //Si on doit effacer, on ne passe pas dans le else => pas de dessin
	    if(this.erasing){
	      this.erasing = false;
	    }
	    else{
	      //On parcourt notre collection de points
	      for(Point p : this.points)
	      {
	        //On récupère la couleur
	        g.setColor(p.getColor());

	        //Selon le type de point
	        if(p.getType().equals("SQUARE")){
	          g.fillRect(p.getX(), p.getY(), p.getSize(), p.getSize());
	        }
	        else{
	          g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
	        }
	      }
	    }        
	  }

	  public void erase(){
	    this.erasing = true;
	    this.points = new ArrayList<Point>();
	    repaint();
	  }

	  public void setPointerColor(Color c){
	    this.pointerColor = c;
	  }

	  public void setPointerType(String str){
	    this.pointerType = str;
	  }      
}