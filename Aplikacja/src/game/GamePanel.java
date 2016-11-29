/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gregory
 */
public class GamePanel extends JPanel  implements KeyListener{
    private BufferedImage _backgroundImage;
    private ArrayList<DrawableObject> _gameObjects;
    private GameLogic _gameLogic;
    
    public GamePanel()
    {               

        try
        {
            MapLayout layout = new MapLayout("./res/maps/map1.cfg");  
            Properties properties = new Properties();
            ImageSet imageSet = new ImageSet("./res/images/", 32);     
            _gameLogic = new GameLogic(layout, properties, imageSet); 
            _backgroundImage = _gameLogic.getMap();
            _gameObjects = _gameLogic.getGameObjects();

            this.setSize(_backgroundImage.getWidth(), _backgroundImage.getHeight());
            addKeyListener(this);
            setFocusable(true);

        }
        catch(IOException ex)
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
        
        for(DrawableObject obj : _gameObjects)
        {
            g2d.drawImage(obj.getImage(), null, obj.getX(), obj.getY());
        }
    }
    
    public void updateGame()
    {
        _gameLogic.updateLogic();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        _gameLogic.keyActionPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        _gameLogic.keyActionReleased(e.getKeyCode());
    }
    
}
