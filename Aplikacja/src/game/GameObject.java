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
public class GameObject implements DrawableObject{
    
    protected int _posX;
    protected int _posY;
    protected BufferedImage _image;
    
    public GameObject(BufferedImage image){
        _image = image;
    }
    
    public void setX(int x){
        _posX = x;
    }
    
    public void setY(int y){
        _posY = y;
    }

    @Override
    public int getX() {
        return _posX;
    }

    @Override
    public int getY() {
        return _posY;
    }

    @Override
    public BufferedImage getImage() {
        return _image;
    }
    
    
}
