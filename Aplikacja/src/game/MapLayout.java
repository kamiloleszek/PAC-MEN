/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
    
    private int _width;
    private int _height;
    private int[][] _layout;
    
}
