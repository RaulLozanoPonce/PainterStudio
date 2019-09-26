package painterStudio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class Board extends javax.swing.JPanel{
    
    private Point2D[] points;
    private Map<String, Color> colorMap;
    private Color pencilColor;
    private int pencilThickness;

    public Board() {
        points = new Point2D[5];
        colorMap = new HashMap<String, Color>();
        pencilColor = Color.black;
        initColorMap();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        drawCircles(g2d, points);
    }
    
    public void paintInBoard(Point2D center){
        for (int i = 0; i < points.length - 1; i++) {
            points[i] = points[i+1];
        }
        points[points.length - 1] = center;
    }
    
    public void deleteCircles(){
        points = new Point2D[5];
    }
    
    public void changeBoardColor(String colour){
        setBackground(colorMap.get(colour));
    }
    
    public void changePencilColor(String colour){
        pencilColor = colorMap.get(colour);
    }
    
    public void changePencilThickness(int thickness){
        pencilThickness = thickness;
    }

    private void initColorMap() {
        colorMap.put("Blanco", Color.white);
        colorMap.put("Negro", Color.black);
        colorMap.put("Rojo", Color.red);
        colorMap.put("Azul", Color.blue);
    }
    
    private void drawCircles(Graphics2D g2d, Point2D[] trail){
        for (int i = 0; i < trail.length; i++) {
            g2d.setColor(pencilColor);
            if(trail[i] instanceof Point2D) g2d.fillOval((int) trail[i].getX(), 
                    (int) trail[i].getY(), pencilThickness, pencilThickness);
        }
    }
    
}