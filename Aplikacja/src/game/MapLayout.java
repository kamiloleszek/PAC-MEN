/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gregory
 */
public class MapLayout {
    public MapLayout(int width, int heigth, int[][] layout)
    {
        _width = width;
        _height = heigth;
        _layout = layout;
    }
    
    public MapLayout(String filename)
    {
        try
        {
            BufferedReader textBufReader = new BufferedReader(new FileReader(filename));
            String line = textBufReader.readLine();
            int dataLineNum = 0;
            while((line = textBufReader.readLine()) != null)
            {
                line = line.replaceAll("\\s+", "");
                if(!line.startsWith("#"))
                {
                    if(dataLineNum == 0)
                    {
                        String[] fields = line.split(",",3);
                        if(fields.length != 2)
                        {
                            throw new Exception("Wrong data content");
                        }
                        _width = Integer.parseInt(fields[0]);
                        _height = Integer.parseInt(fields[1]);
                        _layout = new int[_width][_height];
                    }
                    else
                    {
                        if(dataLineNum > _height + 1)
                        {
                            throw new Exception("Wrong data format");
                        }
                        String[] fields = line.split(",",_width+1);
                        if(fields.length != _width)
                        {
                            throw new Exception("Wrong data format");
                        }
                        for(int i = 0;i<_width;i++)
                        {
                            _layout[i][dataLineNum-1] = Integer.parseInt(fields[i]);
                        }
                    }
                    dataLineNum++;
                }
            }
            textBufReader.close();
        }
        catch (Exception ex) 
        {
            System.err.println("Map file not found");
        }
        
    }
    
    public int getWidth()
    {
        return _width;
    }
    
    public int getHeight()
    {
        return _height;
    }
    
    public int[][] getLayout()
    {
        return _layout;
    }
    
    public int getValueByPos(int x, int y)
    {
        if(x >= 0 && x < _width && y >= 0 && y < _height)
        {
            return _layout[x][y];
        }
        return 0;
    }
    
    private int _width;
    private int _height;
    private int[][] _layout;
    
}
