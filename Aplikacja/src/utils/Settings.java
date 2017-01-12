/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author karol
 */
public class Settings {
    
    public Settings() {
        this.properties = new Properties();
        this.setKeyCodes();       
    }
    
    public void saveSettings(String player1Up, String player1Down, String player1Left, String player1Right,
            String player2Up, String player2Down, String player2Left, String player2Right) {
        try {
            output = new FileOutputStream(PROPERTIES_FILENAME);
            properties.setProperty("player1Up", player1Up.toUpperCase());
            properties.setProperty("player1Down", player1Down.toUpperCase());
            properties.setProperty("player1Left", player1Left.toUpperCase());
            properties.setProperty("player1Right", player1Right.toUpperCase());
            properties.setProperty("player2Up", player2Up.toUpperCase());
            properties.setProperty("player2Down", player2Down.toUpperCase());
            properties.setProperty("player2Left", player2Left.toUpperCase());
            properties.setProperty("player2Right", player2Right.toUpperCase());
            properties.store(output, null);
            setKeyCodes();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if(output != null) {
                try {
                        output.close();
                } catch(IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }
    
    private void setKeyCodes() {
        InputStream input = null;
        try {
            input = new FileInputStream(PROPERTIES_FILENAME);
            properties.load(input);
            player1UpKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player1Up").charAt(0), 0).getKeyCode();
            player1DownKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player1Down").charAt(0), 0).getKeyCode();
            player1LeftKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player1Left").charAt(0), 0).getKeyCode();
            player1RightKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player1Right").charAt(0), 0).getKeyCode();        
            player2UpKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player2Up").charAt(0), 0).getKeyCode();
            player2DownKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player2Down").charAt(0), 0).getKeyCode();
            player2LeftKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player2Left").charAt(0), 0).getKeyCode();
            player2RightKeyCode = KeyStroke.getKeyStroke(properties.getProperty("player2Right").charAt(0), 0).getKeyCode();        
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch(IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }
    
    public int getPlayer1UpKeyCode() {
       return player1UpKeyCode;
    }
    
    public int getPlayer1DownKeyCode() {
       return player1DownKeyCode; 
    }
    
    public int getPlayer1LeftKeyCode() {
       return player1LeftKeyCode; 
    }
    
    public int getPlayer1RightKeyCode() {
       return player1RightKeyCode; 
    }
        
    public int getPlayer2UpKeyCode() {
       return player2UpKeyCode;
    }
    
    public int getPlayer2DownKeyCode() {
       return player2DownKeyCode; 
    }
    
    public int getPlayer2LeftKeyCode() {
       return player2LeftKeyCode; 
    }
    
    public int getPlayer2RightKeyCode() {
       return player2RightKeyCode; 
    }
    
    public String getPlayer1DownButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player1Down");
    }
    
    public String getPlayer1UpButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player1Up");
    }
    
    public String getPlayer1LeftButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player1Left");
    }
    
    public String getPlayer1RightButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player1Right");
    }
    
    public String getPlayer2DownButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player2Down");
    }
    
    public String getPlayer2UpButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player2Up");
    }
    
    public String getPlayer2LeftButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player2Left");
    }
    
    public String getPlayer2RightButton() throws IOException {
        InputStream input = new FileInputStream(PROPERTIES_FILENAME);
        properties.load(input);
        return properties.getProperty("player2Right");
    }
    
    
    private final Properties properties;
    private OutputStream output;
    private int player1UpKeyCode;
    private int player1DownKeyCode;
    private int player1LeftKeyCode;
    private int player1RightKeyCode;
    private int player2UpKeyCode;
    private int player2DownKeyCode;
    private int player2LeftKeyCode;
    private int player2RightKeyCode;
    private static final String PROPERTIES_FILENAME = "application.properties";
}
