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
public class Coin extends GameObject{
    
    private MapLayout _mapLayout;
    public Coin(BufferedImage[] images, int meshPosX, int meshPosY, MapLayout mapLayout)
    {
        super(images, meshPosX, meshPosY);
        _mapLayout = mapLayout;
    }
    
    @Override
    public void update()
    {
        if(_mapLayout.getCoinsByPos(_meshPosX, _meshPosY) == 0)
        {
            setVisibility(false);
        }
        else
        {
            setVisibility(true);
        }
            
    }
    
}
