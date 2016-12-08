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
public class MovableObject extends GameObject {

    private float _movingSteps;
    private int _speed;
    private int _moveState = 0; //0 - none, 1 - left, 2 - up, 3 - right, 4 down
    private int _destX;
    private int _destY;
    private int _movingProgress = 0;

    public MovableObject(BufferedImage[] images, int meshPosX, int meshPosY, int speed) {
        super(images, meshPosX, meshPosY);
        _speed = speed;
        _movingSteps = (float) _segmentSize / _speed;
    }

    public void update() {
        if (!ready()) {
            _movingProgress++;
            if (_movingProgress >= _movingSteps) {
                _movingProgress = 0;
                _posX = _destX;
                _posY = _destY;
                _moveState = 0;
            } else {
                switch (_moveState) {
                    case 1:
                        _posX -= _speed;
                        break;
                    case 2:
                        _posY -= _speed;
                        break;
                    case 3:
                        _posX += _speed;
                        break;
                    case 4:
                        _posY += _speed;
                        break;
                }

            }

        }
    }

    public boolean ready() {
        return _moveState == 0;
    }
    
    // direction -> 1 - left, 2 - up, 3 - right, 4 down
    public void move(int direction)
    {
        switch(direction)
        {
            case 1:
                moveLeft();
                break;
            case 2:
                moveUp();
                break;
            case 3:
                moveRight();
                break;
            case 4:
                moveDown();
                break;
        }
    }

    public void moveUp() {
        if (ready()) {
            _meshPosY--;
            _destX = _posX;
            _destY = _posY - _segmentSize;
            _movingProgress = 0;
            _moveState = 2;
        }
    }

    public void moveDown() {
        if (ready()) {
            _meshPosY++;
            _destX = _posX;
            _destY = _posY + _segmentSize;
            _movingProgress = 0;
            _moveState = 4;
        }
    }

    public void moveLeft() {
        if (ready()) {
            _meshPosX--;
            _destX = _posX - _segmentSize;
            _destY = _posY;
            _movingProgress = 0;
            _moveState = 1;
        }
    }

    public void moveRight() {
        if (ready()) {
            _meshPosX++;
            _destX = _posX + _segmentSize;
            _destY = _posY;
            _movingProgress = 0;
            _moveState = 3;
        }
    }

}
