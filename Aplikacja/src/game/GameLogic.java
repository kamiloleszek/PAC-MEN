/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author gregory
 */
public class GameLogic {

    private ArrayList<DrawableObject> _gameObjectsCollection;
    private ArrayList<MovableObject> _gameMovableCollection;
    private ImageSet _imageSet;
    private Properties _properties;
    private MapLayout _mapLayout;

    private MovableObject _ghost1;
    private MovableObject _ghost2;
    private MovableObject _pacman1;
    private MovableObject _pacman2;

    public GameLogic(MapLayout mapLayout, Properties properties, ImageSet imageSet) {
        _gameObjectsCollection = new ArrayList<DrawableObject>();
        _gameMovableCollection= new ArrayList<MovableObject>();
        _imageSet = imageSet;
        _mapLayout = mapLayout;
        _properties = properties;

        _ghost1 = new MovableObject(_imageSet.getGhost(),2);
        _ghost2 = new MovableObject(_imageSet.getGhost(),2);

        _pacman1 = new MovableObject(_imageSet.getPacman(),2);
        _pacman2 = new MovableObject(_imageSet.getPacman(),2);
        
        _pacman1.setX(100);
        _pacman1.setY(100);

        _gameObjectsCollection.add(_ghost1);
        _gameObjectsCollection.add(_ghost2);
        _gameObjectsCollection.add(_pacman1);
        _gameObjectsCollection.add(_pacman2);
        
        _gameMovableCollection.add(_ghost1);
        _gameMovableCollection.add(_ghost2);
        _gameMovableCollection.add(_pacman1);
        _gameMovableCollection.add(_pacman2);
        

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

        if (keyCode == 37) {
            _pacman1.moveLeft();
        }
        else if (keyCode == 38) {
            _pacman1.moveUp();
        }
        else if (keyCode == 39) {
            _pacman1.moveRight();
        }
        else if (keyCode == 40) {
            _pacman1.moveDown();
        }
    }

    public void keyActionReleased(int keyCode) {

    }

    public ArrayList<DrawableObject> getGameObjects() {
        return _gameObjectsCollection;
    }

}
