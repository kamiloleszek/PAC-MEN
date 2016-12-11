/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;

/**
 *
 * @author gregory
 */
public class PacMan extends MovableObject{
    private MapLayout _mapLayout;
    private int _points = 0;
    public PacMan(BufferedImage[] images, int meshPosX, int meshPosY, int speed, MapLayout mapLayout)
    {
        super(images, meshPosX, meshPosY, speed);
        _mapLayout = mapLayout;
    }
    
    public int getScore()
    {
        return _points;
    }
    
    @Override
    public void update()
    {
        super.update();  
        if(_mapLayout.getCoinsByPos(_meshPosX, _meshPosY) == 1)
        {
            
            _points++;
            _mapLayout.deleteCoin(_meshPosX, _meshPosY);
        }
        
    }
}
