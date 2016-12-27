/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;

/**
 *
 * @author Alicja
 */
public class Ghost extends MovableObject{
    public Ghost(BufferedImage[] images, int meshPosX, int meshPosY, int speed, PacMan pacman){
        super(images, meshPosX, meshPosY, speed);
    }
    
    public int getDirection(MapLayout mapLayout){
        int min_val = Integer.MAX_VALUE;
        int direction = 0;        
        if (mapLayout.getDistanceValueByPos(_meshPosX-1, _meshPosY) !=0 && mapLayout.getDistanceValueByPos(_meshPosX-1, _meshPosY) < min_val){
            min_val = mapLayout.getDistanceValueByPos(_meshPosX-1, _meshPosY);
            direction = 1;
        }
        if(mapLayout.getDistanceValueByPos(_meshPosX, _meshPosY-1) !=0 && mapLayout.getDistanceValueByPos(_meshPosX, _meshPosY-1) < min_val){
            min_val = mapLayout.getDistanceValueByPos(_meshPosX, _meshPosY-1);
            direction = 2;
        }
        if(mapLayout.getDistanceValueByPos(_meshPosX+1, _meshPosY) !=0 && mapLayout.getDistanceValueByPos(_meshPosX+1, _meshPosY) < min_val){
            min_val = mapLayout.getDistanceValueByPos(_meshPosX+1, _meshPosY);
            direction = 3;
        }
        if(mapLayout.getDistanceValueByPos(_meshPosX, _meshPosY+1) !=0 && mapLayout.getDistanceValueByPos(_meshPosX, _meshPosY+1) < min_val){
            direction = 4;
        }
        return direction;
    }
    
}
