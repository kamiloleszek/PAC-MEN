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
public class PacMan extends MovableObject {

    private MapLayout _mapLayout;
    private int _points = 0;
    private int[][] _distanceLayout;
    private int _width, _height;

    public PacMan(BufferedImage[] images, int _meshPosX, int _meshPosY, int speed, MapLayout mapLayout) {
        super(images, _meshPosX, _meshPosY, speed);
        _mapLayout = mapLayout;
        _width = _mapLayout.getWidth();
        _height = _mapLayout.getHeight();
        _distanceLayout = new int[_width][_height];

    }

    public int getScore() {
        return _points;
    }

    @Override
    public void update() {
        super.update();
        if (_mapLayout.getCoinsByPos(_meshPosX, _meshPosY) == 1) {

            _points++;
            _mapLayout.deleteCoin(_meshPosX, _meshPosY);
        }

    }

    public void clearDistanceLayout() {
        for (int i = 0; i < _width; i++) {
            for (int j = 0; j < _height; j++) {
                _distanceLayout[i][j] = 0;
            }
        }
    }

    public void setDistanceLayout(int x, int y) {
        if (x >= 0 && x < _width && y - 1 >= 0 && y - 1 < _height) {
            if (_mapLayout.getValueByPos(x, y - 1) != 1 && (_distanceLayout[x][y - 1] == 0 || _distanceLayout[x][y] + 1 < _distanceLayout[x][y - 1])) {
                _distanceLayout[x][y - 1] = _distanceLayout[x][y] + 1;
                setDistanceLayout(x, y - 1);
            }
        }

        if (x >= 0 && x < _width && y + 1 >= 0 && y + 1 < _height) {
            if (_mapLayout.getValueByPos(x, y + 1) != 1 && (_distanceLayout[x][y + 1] == 0 || _distanceLayout[x][y] + 1 < _distanceLayout[x][y + 1])) {
                _distanceLayout[x][y + 1] = _distanceLayout[x][y] + 1;
                setDistanceLayout(x, y + 1);
            }
        }

        if (x - 1 >= 0 && x - 1 < _width && y - 1 >= 0 && y - 1 < _height) {
            if (_mapLayout.getValueByPos(x - 1, y) != 1 && (_distanceLayout[x - 1][y] == 0 || _distanceLayout[x][y] + 1 < _distanceLayout[x - 1][y])) {
                _distanceLayout[x - 1][y] = _distanceLayout[x][y] + 1;
                setDistanceLayout(x - 1, y);
            }
        }

        if (x + 1 >= 0 && x + 1 < _width && y - 1 >= 0 && y - 1 < _height) {
            if (_mapLayout.getValueByPos(x + 1, y) != 1 && (_distanceLayout[x + 1][y] == 0 || _distanceLayout[x][y] + 1 < _distanceLayout[x + 1][y])) {
                _distanceLayout[x + 1][y] = _distanceLayout[x][y] + 1;
                setDistanceLayout(x + 1, y);
            }
        }
    }

    public int getDistanceValueByPos(int x, int y) {
        if (x >= 0 && x < _width && y >= 0 && y < _height) {
            return _distanceLayout[x][y];
        }
        return 0;
    }
}
