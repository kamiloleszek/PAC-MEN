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
                        _coinsLayout = new int[_width][_height];
                        _distanceLayout = new int[_width][_height];
                    }
                    else
                    {
                        if(dataLineNum > _height*2 + 1)
                        {
                            throw new Exception("Wrong data format");
                        }
                        String[] fields = line.split(",",_width+1);
                        if(fields.length != _width)
                        {
                            throw new Exception("Wrong data format");
                        }
                        
                        if(dataLineNum >= 1 && dataLineNum <= _height)
                        {
                            for(int i = 0;i<_width;i++)
                            {
                                _layout[i][dataLineNum-1] = Integer.parseInt(fields[i]);
                            }
                        }
                        else
                        {
                            for(int i = 0;i<_width;i++)
                            {
                                int value = Integer.parseInt(fields[i]);
                                if(value == 1)_totalCoins++;
                                _coinsLayout[i][dataLineNum-1-_height] = value;
                            }
                        }
                    }
                    dataLineNum++;
                }
            }
            textBufReader.close();
        }
        catch (Exception ex) 
        {
            System.err.println("Problem with loading map file " + ex.toString());
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
    
    public int[][] getCoinLayout()
    {
        return _coinsLayout;
    }
    
    public void clearDistanceLayout(int x, int y){
        for(int i = 0; i < _width; i++){
            for(int j = 0; j< _height; j++){
                _distanceLayout[i][j] = 0;
            }
        }
    }
    
    public void setDistanceLayout(int x, int y, int x_g, int y_g){
        if(x==x_g && y==y_g) return;
        if(x >= 0 && x < _width && y-1 >= 0 && y-1 < _height)
            if(getValueByPos(x,y-1)!= 1 && (_distanceLayout[x][y-1]==0 || _distanceLayout[x][y]+1 < _distanceLayout[x][y-1])){
                _distanceLayout[x][y-1] = _distanceLayout[x][y]+1;
                setDistanceLayout(x,y-1, x_g, y_g);
            }
        
        if(x >= 0 && x < _width && y+1 >= 0 && y+1 < _height)
            if(getValueByPos(x,y+1)!= 1 && (_distanceLayout[x][y+1]==0 || _distanceLayout[x][y]+1 < _distanceLayout[x][y+1])){
                _distanceLayout[x][y+1] = _distanceLayout[x][y]+1;
                setDistanceLayout(x,y+1,x_g, y_g);
            }
        
        if(x-1 >= 0 && x-1 < _width && y-1 >= 0 && y-1 < _height)
            if(getValueByPos(x-1,y)!= 1 && (_distanceLayout[x-1][y]==0 || _distanceLayout[x][y]+1 < _distanceLayout[x-1][y])){
                _distanceLayout[x-1][y] = _distanceLayout[x][y]+1;
                setDistanceLayout(x-1,y,x_g, y_g);
            }
        
        if(x+1 >= 0 && x+1 < _width && y-1 >= 0 && y-1 < _height)
            if(getValueByPos(x+1,y)!= 1 && (_distanceLayout[x+1][y]==0 || _distanceLayout[x][y]+1 < _distanceLayout[x+1][y])){
                _distanceLayout[x+1][y] = _distanceLayout[x][y]+1;
                setDistanceLayout(x+1,y,x_g, y_g);
            }
    }
    
    public int getDistanceValueByPos(int x, int y)
    {
        if(x >= 0 && x < _width && y >= 0 && y < _height)
        {
            return _distanceLayout[x][y];
        }
        return 0;
    }
    
    public int getCoinsByPos(int x, int y)
    {
        if(x >= 0 && x < _width && y >= 0 && y < _height)
        {
            return _coinsLayout[x][y];
        }
        return 0;
    }
    
    public void deleteCoin(int x, int y)
    {
        if(x >= 0 && x < _width && y >= 0 && y < _height)
        {
            _coinsLayout[x][y] = 0;
            _totalCoins--;
        }
    }
    
    public int getValueByPos(int x, int y)
    {
        if(x >= 0 && x < _width && y >= 0 && y < _height)
        {
            return _layout[x][y];
        }
        return 0;
    }
    
    public int getTotalCoins()
    {
        return _totalCoins;
    }
    
    private int _width;
    private int _height;
    private int[][] _layout;
    private int[][] _coinsLayout;
    private int[][] _distanceLayout;
    private int _totalCoins = 0;
    
}
