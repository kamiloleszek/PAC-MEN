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
    static final String GHOST1_DIR = "ghost1/";
    static final String GHOST2_DIR = "ghost2/";
    static final String GHOST3_DIR = "ghost3/";
    static final String GHOST4_DIR = "ghost4/";
    static final String PACMAN_DIR = "pacman/";
    static final int ANIM_SIZE = 15;
    
    public ImageSet(String path, int segSize) throws IOException
    {
        _segmentSize = segSize;
        _walls = new BufferedImage[6];
        
        _pacman = new BufferedImage[ANIM_SIZE];
        for(int i = 1; i <= ANIM_SIZE; ++i) {
            _pacman[i-1] = ImageIO.read(new File(path + PACMAN_DIR + i +".bmp"));            
        }
        
        _coin = new BufferedImage[1];
        _coin[0] = ImageIO.read(new File(path + COIN_DIR + "coin.bmp"));
       
        _ghost1 = new BufferedImage[ANIM_SIZE];
        _ghost2 = new BufferedImage[ANIM_SIZE];
        _ghost3 = new BufferedImage[ANIM_SIZE];
        _ghost4 = new BufferedImage[ANIM_SIZE];
        for(int i = 1; i <= ANIM_SIZE; ++i) {
            _ghost1[i-1] = ImageIO.read(new File(path + GHOST1_DIR + i + ".bmp"));            
            _ghost2[i-1] = ImageIO.read(new File(path + GHOST2_DIR + i + ".bmp"));            
            _ghost3[i-1] = ImageIO.read(new File(path + GHOST3_DIR + i + ".bmp"));            
            _ghost4[i-1] = ImageIO.read(new File(path + GHOST4_DIR + i + ".bmp"));            
        }
        
        for(int i = 0;i<6;i++)
        {
            _walls[i] = ImageIO.read(new File(String.format("%s%d.bmp",path + WALLS_DIR,i)));
        }
    }
    
    public BufferedImage[] getCoin()
    {
        return _coin;
    }
    
    public BufferedImage[] getPacman()
    {
        return _pacman;
    }
    
    public BufferedImage[] getGhost1()
    {
        return _ghost1;
    }
    
    public BufferedImage[] getGhost2()
    {
        return _ghost2;
    }
    
    public BufferedImage[] getGhost3()
    {
        return _ghost3;
    }
    
    public BufferedImage[] getGhost4()
    {
        return _ghost4;
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
    private BufferedImage[] _ghost1;
    private BufferedImage[] _ghost2;
    private BufferedImage[] _ghost3;
    private BufferedImage[] _ghost4;
    private BufferedImage[] _coin;
    private BufferedImage[] _walls;
    private int _segmentSize;

    
}
