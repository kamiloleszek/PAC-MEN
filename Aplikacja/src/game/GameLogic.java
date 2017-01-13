/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import menu.GameOver;
import utils.Settings;

/**
 *
 * @author gregory
 */
public class GameLogic {

    private ArrayList<DrawableObject> _gameObjectsCollection;
    private ArrayList<MovableObject> _gameMovableCollection;
    private ArrayList<Ghost> _ghostCollection;
    private ArrayList<Pacman> _pacmanCollection;
    private ImageSet _imageSet;
    private MapLayout _mapLayout;
    private Settings _settings;
    
    private int _pacman1MovingDir = 0;
    private int _pacman2MovingDir = 0;
    
    private int _pacman1OrderedMovingDir = 0;
    private int _pacman2OrderedMovingDir = 0;

    private Ghost _ghost1;
    private Ghost _ghost2;
    private Ghost _ghost3;
    private Ghost _ghost4;
    private Pacman _pacman1;
    private Pacman _pacman2;
    private GameObject _coin;
    
    private boolean _gameIsRunning = true;

    public GameLogic(MapLayout mapLayout, Settings settings, ImageSet imageSet) {
        _gameObjectsCollection = new ArrayList<DrawableObject>();
        _ghostCollection = new ArrayList<>();
        _pacmanCollection = new ArrayList<>();
        _imageSet = imageSet;
        _mapLayout = mapLayout;

        setInitialObjectsPositions();

        _gameObjectsCollection.add(_ghost1);
        _gameObjectsCollection.add(_ghost2);
        _gameObjectsCollection.add(_ghost3);
        _gameObjectsCollection.add(_ghost4);
        _gameObjectsCollection.add(_pacman1);
        _gameObjectsCollection.add(_pacman2);
        
        _ghostCollection.add(_ghost1);
        _ghostCollection.add(_ghost2);
        _ghostCollection.add(_ghost3);
        _ghostCollection.add(_ghost4);
        
        _pacmanCollection.add(_pacman1);
        _pacmanCollection.add(_pacman2);

        _settings = settings;
    }

    public BufferedImage getMap() {
        return MapBuilder.createMap(_imageSet, _mapLayout);
    }

    public void updateLogic() {
        for (DrawableObject obj : _gameObjectsCollection) {
            obj.update();
            ghostUpdate();
            pacmanMovementControlUpdate();
            checkCollision();
            checkGameOver();

        }
    }
    
    private void checkGameOver()
    {
        boolean gameover = true;
        for(Pacman pacman : _pacmanCollection)
        {
            if(pacman.isAlive())gameover = false;
        }
        if(gameover && _gameIsRunning)
        {
            gameOver();
        }
    }
    
    private void gameOver()
    {
        _gameIsRunning = false;
        GameOver gameOverObj = new GameOver(_pacman1.getScore(), _pacman2.getScore());
        gameOverObj.show();
    }
    
    private void checkCollision()
    {
        for(Pacman pacman : _pacmanCollection)
        {
            for(Ghost ghost : _ghostCollection)
            {
                if(ghost.isAlive() && pacman.isAlive())
                {
                    int xDist = Math.abs(pacman._posX - ghost._posX);
                    int yDist = Math.abs(pacman._posY - ghost._posY);
                    if(xDist <= pacman._segmentSize && yDist <= pacman._segmentSize)
                    {
                        pacman.kill();
                        for(Ghost ghost2 : _ghostCollection)
                        {
                            if(ghost2.getPacman() == pacman)
                            {
                                ghost2.kill();
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void pacmanMovementControlUpdate()
    {
 
        if(checkMoveOnObject(_pacman1, _pacman1OrderedMovingDir))
        {
            _pacman1MovingDir = _pacman1OrderedMovingDir;
        }
        
        if(checkMoveOnObject(_pacman2, _pacman2OrderedMovingDir))
        {
            _pacman2MovingDir = _pacman2OrderedMovingDir;
        }

        if(_pacman1.ready())
        {
        if (_pacman1MovingDir == 4) {
            if (checkMoveOnObject(_pacman1, 4)) {
                _pacman1.setImages(_imageSet.getPacman_down());
                _pacman1.moveDown();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
            }
        } else if (_pacman1MovingDir == 2) {
            if (checkMoveOnObject(_pacman1, 2)) {
                _pacman1.setImages(_imageSet.getPacman_up());
                _pacman1.moveUp();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
            }
        } else if (_pacman1MovingDir == 1) {
            if (checkMoveOnObject(_pacman1, 1)) {
                _pacman1.setImages(_imageSet.getPacman_left());
                _pacman1.moveLeft();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());

            }
        } else if (_pacman1MovingDir == 3) {
            if (checkMoveOnObject(_pacman1, 3)) {
                _pacman1.setImages(_imageSet.getPacman_right());
                _pacman1.moveRight();
                _pacman1.clearDistanceLayout();
                _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());

            }
            
        }
        } 
        
        if(_pacman2.ready())
        {
        if (_pacman2MovingDir == 4) {
            if (checkMoveOnObject(_pacman2, 4)) {
                _pacman2.setImages(_imageSet.getPacman_down());
                _pacman2.moveDown();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (_pacman2MovingDir == 2) {
            if (checkMoveOnObject(_pacman2, 2)) {
                _pacman2.setImages(_imageSet.getPacman_up());
                _pacman2.moveUp();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (_pacman2MovingDir == 1) {
            if (checkMoveOnObject(_pacman2, 1)) {
                _pacman2.setImages(_imageSet.getPacman_left());
                _pacman2.moveLeft();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        } else if (_pacman2MovingDir == 3) {
            if (checkMoveOnObject(_pacman2, 3)) {
                _pacman2.setImages(_imageSet.getPacman_right());
                _pacman2.moveRight();
                _pacman2.clearDistanceLayout();
                _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());

            }
        }
        }
              

    }

    private void ghostUpdate() {
        _pacman1.setDistanceLayout(_pacman1.getMeshPosX(), _pacman1.getMeshPosY());
        _pacman2.setDistanceLayout(_pacman2.getMeshPosX(), _pacman2.getMeshPosY());
        _ghost1.changeDirection();
        _ghost2.changeDirection();
        _ghost3.changeDirection();
        _ghost4.changeDirection();
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
            _pacman1OrderedMovingDir = 4;
        } else if (keyCode == _settings.getPlayer1UpKeyCode()) {
            _pacman1OrderedMovingDir = 2;
        } else if (keyCode == _settings.getPlayer1LeftKeyCode()) {
            _pacman1OrderedMovingDir = 1;
        } else if (keyCode == _settings.getPlayer1RightKeyCode()) {
            _pacman1OrderedMovingDir = 3;
        } else if (keyCode == _settings.getPlayer2DownKeyCode()) {
            _pacman2OrderedMovingDir = 4;
        } else if (keyCode == _settings.getPlayer2UpKeyCode()) {
            _pacman2OrderedMovingDir = 2;
        } else if (keyCode == _settings.getPlayer2LeftKeyCode()) {
            _pacman2OrderedMovingDir = 1;
        } else if (keyCode == _settings.getPlayer2RightKeyCode()) {
            _pacman2OrderedMovingDir = 3;
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
                        _pacman1 = new Pacman(_imageSet.getPacman_right(), i, j, 4, _mapLayout);
                        break;
                    case 4:
                        _pacman2 = new Pacman(_imageSet.getPacman_left(), i, j, 4, _mapLayout);
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
        _ghost1.assignPacman(_pacman1);
        _ghost2.assignPacman(_pacman1);
        _ghost3.assignPacman(_pacman2);
        _ghost4.assignPacman(_pacman2);
    }
}
