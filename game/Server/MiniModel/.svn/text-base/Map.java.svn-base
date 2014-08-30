package jc82_yw31.Server.MiniModel;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.AnnotationAttributes;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Cylinder;
import gov.nasa.worldwind.render.GlobeAnnotation;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Polyline;
import gov.nasa.worldwind.render.ShapeAttributes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;

import java.util.ArrayList;

import javax.swing.JPanel;

import jc82_yw31.Server.MiniView.MyMapPanel;
import map.MapLayer;

/**
 * this a game map for game client to use
 * @author Junren
 *
 */
public class Map extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -470877681497063609L;
	/**
	 * Constructor 
	 */
  	public MapLayer mapBase = new MapLayer();
  	public MyMapPanel mapPanel = new MyMapPanel();
  	private MapLayer layer;
 // 	private AnnotationLayer layer;
  	private GlobeAnnotation g1;
  	private GlobeAnnotation g2;
  	private int index1 = 0;
  	private int index2 = 0;
  	private RenderableLayer renderLayer;
//  	private Polygon pgon1;
//  	private Polygon pgon2;
//  	private ScreenImage screenImage1;
//  	private ScreenImage screenImage2;
  	private Cylinder cylinder1;
  	private Cylinder cylinder2;
  	@SuppressWarnings("rawtypes")
	private ArrayList positions;
  	private Polyline polyline;
    public Map(){
    	this.setBounds(200, 200, 500, 1000);
    	this.setLayout(new BorderLayout(0,0));
    	iniGUI();
    }
    /**
     *  initiate the map
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void iniGUI(){
    	//the first player
    	
    	renderLayer = new RenderableLayer();
        
    	// Create and set an attribute bundle.
        ShapeAttributes attrs1 = new BasicShapeAttributes();
        attrs1.setInteriorMaterial(Material.RED);
        attrs1.setInteriorOpacity(0.7);
        attrs1.setEnableLighting(true);
        attrs1.setOutlineMaterial(Material.RED);
        attrs1.setOutlineWidth(2d);
        attrs1.setDrawInterior(true);
        attrs1.setDrawOutline(false);
        
        // Cylinder with equal axes, ABSOLUTE altitude mode
        cylinder1 = new Cylinder(Position.fromDegrees(45, -102, 80000), 100000, 100000);
        cylinder1.setAltitudeMode(WorldWind.ABSOLUTE);
        cylinder1.setAttributes(attrs1);
        cylinder1.setVisible(true);
        cylinder1.setValue(AVKey.DISPLAY_NAME,  "Please run away from police!");
        renderLayer.addRenderable(cylinder1);
        
    	// Create and set an attribute bundle.
        ShapeAttributes attrs2 = new BasicShapeAttributes();
        attrs2.setInteriorMaterial(Material.GREEN);
        attrs2.setInteriorOpacity(0.7);
        attrs2.setEnableLighting(true);
        attrs2.setOutlineMaterial(Material.RED);
        attrs2.setOutlineWidth(2d);
        attrs2.setDrawInterior(true);
        attrs2.setDrawOutline(false);
        
        // Cylinder with equal axes, ABSOLUTE altitude mode
        cylinder2 = new Cylinder(Position.fromDegrees(47, -104, 80000), 100000, 100000);
        cylinder2.setAltitudeMode(WorldWind.ABSOLUTE);
        cylinder2.setAttributes(attrs2);
        cylinder2.setVisible(true);
        cylinder2.setValue(AVKey.DISPLAY_NAME, "Please catch the thief!");
        renderLayer.addRenderable(cylinder2);
        
        //annotation
        
        // Create an annotation with an image and some text below it
        this.layer = new MapLayer();
    //    this.layer = new AnnotationLayer();
     // Create default attributes
        AnnotationAttributes defaultAttributes = new AnnotationAttributes();
        defaultAttributes.setCornerRadius(10);
        defaultAttributes.setInsets(new Insets(8, 8, 8, 8));
        defaultAttributes.setBackgroundColor(new Color(0f, 0f, 0f, .5f));
        defaultAttributes.setTextColor(Color.WHITE);
        defaultAttributes.setDrawOffset(new Point(25, 25));
        defaultAttributes.setDistanceMinScale(.5);
        defaultAttributes.setDistanceMaxScale(2);
        defaultAttributes.setDistanceMinOpacity(.5);
        defaultAttributes.setLeaderGapWidth(14);
        defaultAttributes.setDrawOffset(new Point(20, 40));
        
        AnnotationAttributes townAttr = new AnnotationAttributes();
        townAttr.setDefaults(defaultAttributes);
        townAttr.setFont(Font.decode("Arial-BOLD-12"));
        g1 = new GlobeAnnotation("Here is the police!", Position.fromDegrees(47, -104, 0), townAttr);
        g2 = new GlobeAnnotation("Here is the thief!", Position.fromDegrees(45, -102, 0), townAttr);
//        layer.addToggleAnnotation("Here is the police!", "please catch the thief!", Position.fromDegrees(30, -110, 0));
//        layer.addToggleAnnotation("Here is the thief", "please run quicker than the police!", Position.fromDegrees(40, -120, 0));
        layer.addAnnotation(g1);
        layer.addAnnotation(g2);
        
          //polyline
        positions = new ArrayList();
        positions.add(Position.fromDegrees(45, -104));
        positions.add(Position.fromDegrees(-6, -62));
        positions.add(Position.fromDegrees(30, -41));
        positions.add(Position.fromDegrees(-21, -21));
        positions.add(Position.fromDegrees(47, 5));
        positions.add(Position.fromDegrees(9, 20));
        positions.add(Position.fromDegrees(50, 72));
        polyline = new Polyline(positions,3e4);            

        polyline.setColor(getBackground().BLUE);
        polyline.setLineWidth(3);

        
        
        renderLayer.addRenderable(polyline);

        
        mapPanel.addMapLayer(renderLayer);
        mapPanel.addMapLayer(layer);
        
        
        
        
        //mapPanel.setPosition(Position.fromDegrees(44.98, -104.36, 1089),true);
        this.add(mapPanel,BorderLayout.CENTER);
        
       
     
    }
    public void move(int teamno, int distance){
    	if(teamno == 1){
    		if(index1 < 10){
        		cylinder1.move(Position.fromDegrees(-5.1, 4.2));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(-5.1, 4.2));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(renderLayer);
//        		mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;		
    		}
    		else if(index1 >= 10 && index1 < 20){
        		cylinder1.move(Position.fromDegrees(3.6, 2.1));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(3.6, 2.1));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(renderLayer);
//        		mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;
    			
    		}
    		else if(index1 >= 20 && index1 < 30){
        		cylinder1.move(Position.fromDegrees(-5.1, 2.0));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(-5.1, 2.0));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(renderLayer);
//        		mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;
    		}
    		else if(index1 >= 30 && index1 < 40){
        		cylinder1.move(Position.fromDegrees(6.8,2.6));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(6.8,2.6));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(renderLayer);
//        		mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;
    		}
    		else if(index1 >= 40 && index1 < 50){
        		cylinder1.move(Position.fromDegrees(-3.8, 1.5));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(-3.8, 1.5));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
        		//mapPanel.addMapLayer(renderLayer);
        		//mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;
    		}
    		else if(index1 >= 50 && index1 < 60){
           		cylinder1.move(Position.fromDegrees(4.1, 5.2));
                layer.removeAnnotation(g2);
                g2.move(Position.fromDegrees(4.1, 5.2));
        		layer.addAnnotation(g2);
        		
        		renderLayer.removeAllRenderables();
                renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(renderLayer);
//        		mapPanel.addMapLayer(layer);
        		mapPanel.getwwd().redraw();
        		index1++;
    		}

    	}
    	else{
    		if(index2 < 10){
        		cylinder2.move(Position.fromDegrees(-5.1, 4.2));
        		g1.move(Position.fromDegrees(-5.1, 4.2));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    		}
    		else if(index2 >= 10 && index2 < 20){
        		cylinder2.move(Position.fromDegrees(3.6, 2.1));
        		g1.move(Position.fromDegrees(3.6, 2.1));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    			
    		}
    		else if(index2 >= 20 && index2 < 30){
        		cylinder2.move(Position.fromDegrees(-5.1,2.0));
        		g1.move(Position.fromDegrees(-5.1,2.0));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    		}
    		else if(index2 >= 30 && index2 < 40){
        		cylinder2.move(Position.fromDegrees(6.8, 2.6));
        		g1.move(Position.fromDegrees(6.8, 2.6));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    		}
    		else if(index2 >= 40 && index2 < 50){
        		cylinder2.move(Position.fromDegrees(-3.8, 1.5));
        		g1.move(Position.fromDegrees(-3.8, 1.5));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    		}
    		else if(index2 >= 50 && index2 < 60){
        		cylinder2.move(Position.fromDegrees(4.1, 5.2));
        		g1.move(Position.fromDegrees(4.1, 5.2));
        		layer.addAnnotation(g1);
        		
        		renderLayer.removeAllRenderables();
        		renderLayer.addRenderable(polyline);
        		renderLayer.addRenderable(cylinder1);
        		renderLayer.addRenderable(cylinder2);
//        		mapPanel.addMapLayer(layer);
//          		mapPanel.addMapLayer(renderLayer);
          		mapPanel.getwwd().redraw();
        		index2++;
    		}

    	}
	
    }
}
