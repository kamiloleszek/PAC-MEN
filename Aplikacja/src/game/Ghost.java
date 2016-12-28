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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Ghost(BufferedImage[] images, int meshPosX, int meshPosY, int speed) {
        super(images, meshPosX, meshPosY, speed);
    }

    public void changeDirection(PacMan pacman) {
        int min_val = Integer.MAX_VALUE;
        if (pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY) != 0 && pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY) < min_val) {
            min_val = pacman.getDistanceValueByPos(_meshPosX - 1, _meshPosY);
            direction = 1;
        }
        if (pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1) != 0 && pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1) < min_val) {
            min_val = pacman.getDistanceValueByPos(_meshPosX, _meshPosY - 1);
            direction = 2;
        }
        if (pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY) != 0 && pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY) < min_val) {
            min_val = pacman.getDistanceValueByPos(_meshPosX + 1, _meshPosY);
            direction = 3;
        }
        if (pacman.getDistanceValueByPos(_meshPosX, _meshPosY + 1) != 0 && pacman.getDistanceValueByPos(_meshPosX, _meshPosY + 1) < min_val) {
            direction = 4;
        }
    }
}
