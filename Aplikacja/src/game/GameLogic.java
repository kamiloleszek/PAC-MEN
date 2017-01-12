/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import utils.Settings;

/**
 *
 * @author gregory
 */
public class GameLogic {

    private ArrayList<DrawableObject> _gameObjectsCollection;
    private ArrayList<MovableObject> _gameMovableCollection;
    private ImageSet _imageSet;
    private MapLayout _mapLayout;
    private Settings _settings;

    private Ghost _ghost1;
    private Ghost _ghost2;
    private Ghost _ghost3;
    private Ghost _ghost4;
    private PacMan _pacman1;
    private PacMan _pacman2;
    private GameObject _coin;

    public GameLogic(MapLayout mapLayout, Settings settings, ImageSet imageSet) {
        _gameObjectsCollection = new ArrayList<DrawableObject>();
        _imageSet = imageSet;
        _mapLayout = mapLayout;

        setInitialObjectsPositions();

        _gameObjectsCollection.add(_ghost1);
        _gameObjectsCollection.add(_ghost2);
        _gameObjectsCollection.add(_ghost3);
        _gameObjectsCollection.add(_ghost4);
        _gameObjectsCollection.add(_pacman1);
        _gameObjectsCollection.add(_pacman2);

        _settings = settings;
    }

    public BufferedImage getMap() {
        return MapBuilder.createMap(_imageSet, _mapLayout);
    }

    public void updateLogic() {
        for (DrawableObject obj : _gameObjectsCollection) {
            obj.update();
            ghostUpdate();

        }
    }

    private void ghostUpdate() {
        _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
        _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());
        _ghost1.changeDirection(_pacman1);
        _ghost2.changeDirection(_pacman1);
        _ghost3.changeDirection(_pacman2);
        _ghost4.changeDirection(_pacman2);
        changeImages();

        if (checkMoveOnObject(_ghost1, _ghost1.getDirection())) {
            _ghost1.move(_ghost1.getDirection());
        }
        if (checkMoveOnObject(_ghost2, _ghost2.getDirection())) {
            _ghost2.move(_ghost2.getDirection());
        }
        if (checkMoveOnObject(_ghost3, _ghost3.getDirection())) {
            _ghost3.move(_ghost3.getDirection());
        }
        if (checkMoveOnObject(_ghost4, _ghost4.getDirection())) {
            _ghost4.move(_ghost4.getDirection());
        }

    }

    private void changeImages() {
        switch (_ghost1.getDirection()) {
            case 1:
                _ghost1.setImages(_imageSet.getGhost1_left());
                break;
            case 2:
                _ghost1.setImages(_imageSet.getGhost1_up());
                break;
            case 3:
                _ghost1.setImages(_imageSet.getGhost1_right());
                break;
            case 4:
                _ghost1.setImages(_imageSet.getGhost1_down());
                break;
            default:
                _ghost1.setImages(_imageSet.getGhost1_right());
        }
        switch (_ghost2.getDirection()) {
            case 1:
                _ghost2.setImages(_imageSet.getGhost2_left());
                break;
            case 2:
                _ghost2.setImages(_imageSet.getGhost2_up());
                break;
            case 3:
                _ghost2.setImages(_imageSet.getGhost2_right());
                break;
            case 4:
                _ghost2.setImages(_imageSet.getGhost2_down());
                break;
            default:
                _ghost2.setImages(_imageSet.getGhost2_right());
        }
        switch (_ghost3.getDirection()) {
            case 1:
                _ghost3.setImages(_imageSet.getGhost3_left());
                break;
            case 2:
                _ghost3.setImages(_imageSet.getGhost3_up());
                break;
            case 3:
                _ghost3.setImages(_imageSet.getGhost3_right());
                break;
            case 4:
                _ghost3.setImages(_imageSet.getGhost3_down());
                break;
            default:
                _ghost3.setImages(_imageSet.getGhost3_right());
        }
        switch (_ghost4.getDirection()) {
            case 1:
                _ghost4.setImages(_imageSet.getGhost4_left());
                break;
            case 2:
                _ghost4.setImages(_imageSet.getGhost4_up());
                break;
            case 3:
                _ghost4.setImages(_imageSet.getGhost4_right());
                break;
            case 4:
                _ghost4.setImages(_imageSet.getGhost4_down());
                break;
            default:
                _ghost4.setImages(_imageSet.getGhost4_right());
        }

    }

    public void keyActionPressed(int keyCode) {
        if (keyCode == _settings.getPlayer1DownKeyCode()) {
            if (checkMoveOnObject(_pacman1, 4)) {
                _pacman1.setImages(_imageSet.getPacman_down());
                _pacman1.moveDown();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
            }
        } else if (keyCode == _settings.getPlayer1UpKeyCode()) {
            if (checkMoveOnObject(_pacman1, 2)) {
                _pacman1.setImages(_imageSet.getPacman_up());
                _pacman1.moveUp();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
            }
        } else if (keyCode == _settings.getPlayer1LeftKeyCode()) {
            if (checkMoveOnObject(_pacman1, 1)) {
                _pacman1.setImages(_imageSet.getPacman_left());
                _pacman1.moveLeft();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());

            }
        } else if (keyCode == _settings.getPlayer1RightKeyCode()) {
            if (checkMoveOnObject(_pacman1, 3)) {
                _pacman1.setImages(_imageSet.getPacman_right());
                _pacman1.moveRight();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());

            }
        } else if (keyCode == _settings.getPlayer2DownKeyCode()) {
            if (checkMoveOnObject(_pacman2, 4)) {
                _pacman2.setImages(_imageSet.getPacman_down());
                _pacman2.moveDown();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (keyCode == _settings.getPlayer2UpKeyCode()) {
            if (checkMoveOnObject(_pacman2, 2)) {
                _pacman2.setImages(_imageSet.getPacman_up());
                _pacman2.moveUp();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (keyCode == _settings.getPlayer2LeftKeyCode()) {
            if (checkMoveOnObject(_pacman2, 1)) {
                _pacman2.setImages(_imageSet.getPacman_left());
                _pacman2.moveLeft();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (keyCode == _settings.getPlayer2RightKeyCode()) {
            if (checkMoveOnObject(_pacman2, 3)) {
                _pacman2.setImages(_imageSet.getPacman_right());
                _pacman2.moveRight();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        }

    }

    public void keyActionReleased(int keyCode) {

    }

    public ArrayList<DrawableObject> getGameObjects() {
        return _gameObjectsCollection;
    }

    private boolean checkMoveOnObject(MovableObject obj, int moveDirection) {
        return checkMove(obj.getMeshPosX(), obj.getMeshPosY(), moveDirection);
    }

    //Move direction ->  1 - left, 2 - up, 3 - right, 4 down
    private boolean checkMove(int posX, int posY, int moveDirection) {
        switch (moveDirection) {
            case 1:
                return _mapLayout.getValueByPos(posX - 1, posY) != 1;
            case 2:
                return _mapLayout.getValueByPos(posX, posY - 1) != 1;
            case 3:
                return _mapLayout.getValueByPos(posX + 1, posY) != 1;
            case 4:
                return _mapLayout.getValueByPos(posX, posY + 1) != 1;
            default:
                return false;
        }
    }

    public int getPlayer1Score() {
        return _pacman1.getScore();
    }

    public int getPlayer2Score() {
        return _pacman2.getScore();
    }

    private void setInitialObjectsPositions() {
        int segmentXNum = _mapLayout.getWidth() - 1;
        int segmentYNum = _mapLayout.getHeight() - 1;

        for (int i = 1; i < segmentXNum; ++i) {
            for (int j = 1; j < segmentYNum; ++j) {
                if (_mapLayout.getCoinsByPos(i, j) == 1) {
                    _gameObjectsCollection.add(new Coin(_imageSet.getCoin(), i, j, _mapLayout));
                }
            }
        }

        for (int i = 1; i < segmentXNum; ++i) {
            for (int j = 1; j < segmentYNum; ++j) {
                switch (_mapLayout.getValueByPos(i, j)) {
                    case 3:
                        _pacman1 = new PacMan(_imageSet.getPacman_right(), i, j, 4, _mapLayout);
                        break;
                    case 4:
                        _pacman2 = new PacMan(_imageSet.getPacman_left(), i, j, 4, _mapLayout);
                        break;
                    case 5:
                        _ghost1 = new Ghost(_imageSet.getGhost1_right(), i, j, 2, _mapLayout);
                        break;
                    case 6:
                        _ghost2 = new Ghost(_imageSet.getGhost2_left(), i, j, 2, _mapLayout);
                        break;
                    case 7:
                        _ghost3 = new Ghost(_imageSet.getGhost3_right(), i, j, 2, _mapLayout);
                        break;
                    case 8:
                        _ghost4 = new Ghost(_imageSet.getGhost4_left(), i, j, 2, _mapLayout);
                        break;
                }
            }
        }
    }
}
