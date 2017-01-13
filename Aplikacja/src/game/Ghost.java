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
public class Ghost extends MovableObject {

    private int direction = 0;
    private Pacman _pacman;
    private boolean _alive = true;
    
    public void assignPacman(Pacman pacman)
    {
        _pacman = pacman;
    }
    
    public void kill()
    {
        setVisibility(false);
        _alive = false;
    }
    
    public boolean isAlive()
    {
        return _alive;
    }
    
    public Pacman getPacman()
    {
        return _pacman;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Ghost(BufferedImage[] images, int meshPosX, int meshPosY, int speed, MapLayout mapLayout) {
        super(images, meshPosX, meshPosY, speed, mapLayout);
    }

    public void changeDirection() {
        if(_pacman != null)
        {
            int min_val = Integer.MAX_VALUE;
            if (_pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY) != 0 && _pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY) < min_val) {
                min_val = _pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY);
                direction = 1;
            }
            if (_pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1) != 0 && _pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1) < min_val) {
                min_val = _pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1);
                direction = 2;
            }
            if (_pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY) != 0 && _pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY) < min_val) {
                min_val = _pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY);
                direction = 3;
            }
            if (_pacman.getDistanceValueByPos(_meshPosX, _meshPosY + 1) != 0 && _pacman.getDistanceValueByPos(_meshPosX, _meshPosY + 1) < min_val) {
                direction = 4;
            }
        }
    }
}
