/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author gregory
 */
public class GamePanel extends JPanel{
    private BufferedImage _backgroundImage;
    public GamePanel()
    {               
        MapLayout layout = new MapLayout("./res/maps/map1.cfg");
        SegmentMapContainer segment;
        try
        {
           segment = new SegmentMapContainer("./res/images/walls",32,32);
           _backgroundImage = MapBuilder.createMap(segment, layout);
           this.setSize(_backgroundImage.getWidth(), _backgroundImage.getHeight());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(12, 12, 20, 20);
        
        g2d.drawImage(_backgroundImage, null, 0, 0);
    }
    
}
