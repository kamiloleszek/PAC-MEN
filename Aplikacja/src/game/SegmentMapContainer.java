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
public class SegmentMapContainer {
    public SegmentMapContainer(String path, int width, int height) throws IOException
    {
        for(int i = 0;i<6;i++)
        {
            _images[i] = ImageIO.read(new File(String.format("%s/%d.bmp",path,i)));
        }
        _segmentWidth = width;
        _segmentHeight = height;
    }
    
    public BufferedImage[] getImages()
    {
        return _images;
    }
        
    public int getSegmentWidth()
    {
        return _segmentWidth;
    }
    
    public int getSegmentHeight()
    {
        return _segmentHeight;
    }

    
    private BufferedImage[] _images = new BufferedImage[6];
    private int _segmentWidth;
    private int _segmentHeight;
    
}
