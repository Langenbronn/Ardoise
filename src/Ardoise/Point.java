package Ardoise;

import java.awt.Color;

public class Point {
private Color color = Color.red;
private int size = 10;
private int x = -10;
private int y = -10;
private String type = "ROND";

public Point(){}
public Point(int x, int y, int size, Color color, String type){
 this.size = size;
 this.x = x;
 this.y = y;
 this.color = color;
 this.type = type;
}
public Color getColor() {
 return color;
}
public void setColor(Color color) {
 this.color = color;
}
public int getSize() {
 return size;
}
public void setSize(int size) {
 this.size = size;
}
public int getX() {
 return x;
}
public void setX(int x) {
 this.x = x;
}
public int getY() {
 return y;
}
public void setY(int y) {
 this.y = y;
}
public String getType() {
 return type;
}
public void setType(String type) {
 this.type = type;
}
}