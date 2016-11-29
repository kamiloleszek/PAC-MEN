/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author gregory
 */
public class MapBuilder {
    public static BufferedImage createMap(ImageSet imageSet, MapLayout mapLayout)
    {
        
        int segmentXNum = mapLayout.getWidth();
        int segmentYNum = mapLayout.getHeight();
        int segmentSize = imageSet.getSegmentSize();
        int mapWidth = segmentSize * (mapLayout.getWidth()-2);
        int mapHeight = segmentSize * (mapLayout.getHeight()-2);
        int[][] mapLayoutData = mapLayout.getLayout();
        
        BufferedImage[] segmentImages = imageSet.getWalls();
        
        BufferedImage map = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_3BYTE_BGR);
        
        Graphics2D graphics = (Graphics2D)map.getGraphics();
        
        for(int i = 1;i<segmentXNum-1;i++)
        {
            for(int j = 1;j<segmentYNum-1;j++)
            {
                BufferedImage segmentImage = selectAndRotateSegment(i,j,mapLayoutData, segmentImages);
                graphics.drawImage(segmentImage,(i-1)*segmentSize, (j-1)*segmentSize,null);
            }
        }
        
        return map;
    }
    
    private static BufferedImage selectAndRotateSegment(int i, int j, int[][] layout, BufferedImage[] segments)
    {
        int usedSegment = 0;
        int rotation = 0;
        if(layout[i][j] == 0)usedSegment = 0;
        else
        {
            int neighbours = 0;
            if(layout[i-1][j] == 1)neighbours++;
            if(layout[i+1][j] == 1)neighbours++;
            if(layout[i][j-1] == 1)neighbours++;
            if(layout[i][j+1] == 1)neighbours++;
            
            if(neighbours == 1)
            {
                usedSegment = 4;
                if(layout[i+1][j] == 1)rotation = 180;
                if(layout[i][j-1] == 1)rotation = 90;
                if(layout[i][j+1] == 1)rotation = 270;
            }
            else if(neighbours == 2)
            {
                if(layout[i-1][j] == 1 && layout[i+1][j] == 1)usedSegment = 1;
                else if(layout[i][j-1] == 1 && layout[i][j+1] == 1)
                {
                    usedSegment = 1;
                    rotation = 90;
                }
                else if(layout[i-1][j] == 1 && layout[i][j+1] == 1)usedSegment = 5;
                else if(layout[i-1][j] == 1 && layout[i][j-1] == 1)
                {
                    usedSegment = 5;
                    rotation = 90;
                }
                else if(layout[i+1][j] == 1 && layout[i][j-1] == 1)
                {
                    usedSegment = 5;
                    rotation = 180;
                }
                else if(layout[i+1][j] == 1 && layout[i][j+1] == 1)
                {
                    usedSegment = 5;
                    rotation = 270;
                }
                    
            }
            else if(neighbours == 3)
            {
                usedSegment = 2;
                if(layout[i][j-1] == 0)rotation = 0;
                if(layout[i+1][j] == 0)rotation = 90;
                if(layout[i][j+1] == 0)rotation = 180;
                if(layout[i-1][j] == 0)rotation = 270;
            }
            else if(neighbours == 4)usedSegment = 3;

        }
        
            BufferedImage segment = new BufferedImage(segments[0].getWidth(),segments[0].getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphics = (Graphics2D) segment.getGraphics();
            AffineTransform tx1 = new AffineTransform();
            tx1.setToRotation(rotation*3.14/180, segment.getWidth()/2, segment.getHeight()/2);
            graphics.drawImage(segments[usedSegment], tx1, null);
            return segment;   
    }
    
}
