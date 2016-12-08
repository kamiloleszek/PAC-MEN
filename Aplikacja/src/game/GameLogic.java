/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Properties;
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

    private MovableObject _ghost1;
    private MovableObject _ghost2;
    private MovableObject _pacman1;
    private MovableObject _pacman2;

    public GameLogic(MapLayout mapLayout, Settings settings, ImageSet imageSet) {
        _gameObjectsCollection = new ArrayList<DrawableObject>();
        _gameMovableCollection= new ArrayList<MovableObject>();
        _imageSet = imageSet;
        _mapLayout = mapLayout;

        _ghost1 = new MovableObject(_imageSet.getGhost(),3,3,4);
        _ghost2 = new MovableObject(_imageSet.getGhost(),3,4,4);

        _pacman1 = new MovableObject(_imageSet.getPacman(),3,5,4);
        _pacman2 = new MovableObject(_imageSet.getPacman(),3,6,4);
        
        _gameObjectsCollection.add(_ghost1);
        _gameObjectsCollection.add(_ghost2);
        _gameObjectsCollection.add(_pacman1);
        _gameObjectsCollection.add(_pacman2);
        
        _gameMovableCollection.add(_ghost1);
        _gameMovableCollection.add(_ghost2);
        _gameMovableCollection.add(_pacman1);
        _gameMovableCollection.add(_pacman2);
        
        _settings = settings;
    }

    public BufferedImage getMap() {
        return MapBuilder.createMap(_imageSet, _mapLayout);
    }

    public void updateLogic() {
        for(MovableObject obj : _gameMovableCollection)
        {
            obj.update();
        }

    }

    public void keyActionPressed(int keyCode) {             
        if(keyCode == _settings.getPlayer1DownKeyCode()) {
            if(checkMoveOnObject(_pacman1,4))_pacman1.moveDown();
        } else if(keyCode == _settings.getPlayer1UpKeyCode()) {
            if(checkMoveOnObject(_pacman1,2))_pacman1.moveUp();
        } else if(keyCode == _settings.getPlayer1LeftKeyCode()) {
            if(checkMoveOnObject(_pacman1,1))_pacman1.moveLeft();
        } else if(keyCode == _settings.getPlayer1RightKeyCode()) {
            if(checkMoveOnObject(_pacman1,3))_pacman1.moveRight();
        } else if(keyCode == _settings.getPlayer2DownKeyCode()) {
            if(checkMoveOnObject(_pacman2,4))_pacman2.moveDown();
        } else if(keyCode == _settings.getPlayer2UpKeyCode()) {
            if(checkMoveOnObject(_pacman2,2))_pacman2.moveUp();
        } else if(keyCode == _settings.getPlayer2LeftKeyCode()) {
            if(checkMoveOnObject(_pacman2,1))_pacman2.moveLeft();
        } else if(keyCode == _settings.getPlayer2RightKeyCode()) {
            if(checkMoveOnObject(_pacman2,3))_pacman2.moveRight();
        }
    }

    public void keyActionReleased(int keyCode) {

    }

    public ArrayList<DrawableObject> getGameObjects() {
        return _gameObjectsCollection;
    }
    
    private boolean checkMoveOnObject(MovableObject obj, int moveDirection)
    {
        return checkMove(obj.getMeshPosX(),obj.getMeshPosY(),moveDirection);
    }
    
    //Move direction ->  1 - left, 2 - up, 3 - right, 4 down
    private boolean checkMove(int posX, int posY, int moveDirection)
    {
        switch(moveDirection){
            case 1:
                return _mapLayout.getValueByPos(posX-1, posY) == 0;
            case 2:
                return _mapLayout.getValueByPos(posX, posY-1) == 0;
            case 3:
                return _mapLayout.getValueByPos(posX+1, posY) == 0;
            case 4:
                return _mapLayout.getValueByPos(posX, posY+1) == 0;
            default:
                return false;
        }

    }

}
