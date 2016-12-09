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
    protected int _meshPosX;
    protected int _meshPosY;
    protected int _segmentSize;
    protected BufferedImage[] _images;
    private int currentImage;
    //private boolean animDirection;
    
    public GameObject(BufferedImage[] images, int meshPosX, int meshPosY){
        _images = images;
        _meshPosX = meshPosX;
        _meshPosY = meshPosY;
        _segmentSize = images[0].getHeight();
        currentImage = -1;
        _posX = (meshPosX-1) * _segmentSize;
        _posY = (meshPosY-1) * _segmentSize;
        //animDirection = true;
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
    
    public int getMeshPosX()
    {
        return _meshPosX;
    }
    
    public int getMeshPosY()
    {
        return _meshPosY;
    }

    @Override
    public BufferedImage getImage() {
        currentImage = ++currentImage % _images.length;
        return _images[currentImage ];
    }
    
    
}
