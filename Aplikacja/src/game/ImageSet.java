/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author gregory
 */
public class ImageSet {
    static final String WALLS_DIR = "walls/";
    static final String COIN_DIR = "coin/";
    static final String GHOST_DIR = "ghost1/";
    static final String PACMAN_DIR = "pacman/";
    static final int ANIM_SIZE = 8;
    
    public ImageSet(String path, int segSize) throws IOException
    {
        _segmentSize = segSize;
        _walls = new BufferedImage[6];
        
        _pacman = new BufferedImage[ANIM_SIZE];
        for(int i = 1; i <= ANIM_SIZE; ++i) {
            _pacman[i-1] = ImageIO.read(new File(path + PACMAN_DIR + i +".bmp"));            
        }
        
        _coin = ImageIO.read(new File(path + COIN_DIR + "coin.bmp"));
        //_ghost = ImageIO.read(new File(path + GHOST_DIR + "1.bmp"));
        
        _ghost = new BufferedImage[ANIM_SIZE];
        for(int i = 1; i <= ANIM_SIZE; ++i) {
            _ghost[i-1] = ImageIO.read(new File(path + GHOST_DIR + i + ".bmp"));            
        }
        
        for(int i = 0;i<6;i++)
        {
            _walls[i] = ImageIO.read(new File(String.format("%s%d.bmp",path + WALLS_DIR,i)));
        }
    }
    
    public BufferedImage getCoin()
    {
        return _coin;
    }
    
    public BufferedImage[] getPacman()
    {
        return _pacman;
    }
    
    public BufferedImage[] getGhost()
    {
        return _ghost;
    }
    
    public BufferedImage[] getWalls()
    {
        return _walls;
    }
    
    public int getSegmentSize()
    {
        return _segmentSize;
    }
    private BufferedImage[] _pacman;
    private BufferedImage[] _ghost;
    private BufferedImage _coin;
    private BufferedImage[] _walls;
    private int _segmentSize;

    
}
