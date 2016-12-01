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
    protected BufferedImage[] _images;
    private int currentImage;
    private boolean animDirection;
    
    public GameObject(BufferedImage[] images){
        _images = images;
        currentImage = 0;
        animDirection = true;
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
        if(animDirection) {
            if(currentImage == _images.length-1) {
                animDirection = !animDirection; 
            } else {
                ++currentImage;
            }
        } else {
            if(currentImage == 0) {
                animDirection = !animDirection; 
            } else {
                --currentImage;
            }
        }
        return _images[currentImage];
    }
    
    
}
