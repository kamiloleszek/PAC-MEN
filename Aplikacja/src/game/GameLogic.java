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

        _ghost1 = new MovableObject(_imageSet.getGhost(),2);
        _ghost2 = new MovableObject(_imageSet.getGhost(),2);

        _pacman1 = new MovableObject(_imageSet.getPacman(),5);
        _pacman2 = new MovableObject(_imageSet.getPacman(),5);
        
        _pacman1.setX(120);
        _pacman1.setY(130);
        
        _pacman2.setX(450);
        _pacman2.setY(130);

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
            _pacman1.moveDown();
        } else if(keyCode == _settings.getPlayer1UpKeyCode()) {
            _pacman1.moveUp();
        } else if(keyCode == _settings.getPlayer1LeftKeyCode()) {
            _pacman1.moveLeft();
        } else if(keyCode == _settings.getPlayer1RightKeyCode()) {
            _pacman1.moveRight();
        } else if(keyCode == _settings.getPlayer2DownKeyCode()) {
            _pacman2.moveDown();
        } else if(keyCode == _settings.getPlayer2UpKeyCode()) {
            _pacman2.moveUp();
        } else if(keyCode == _settings.getPlayer2LeftKeyCode()) {
            _pacman2.moveLeft();
        } else if(keyCode == _settings.getPlayer2RightKeyCode()) {
            _pacman2.moveRight();
        }
    }

    public void keyActionReleased(int keyCode) {

    }

    public ArrayList<DrawableObject> getGameObjects() {
        return _gameObjectsCollection;
    }

}
