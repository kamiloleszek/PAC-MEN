/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author karol
 */
public class Settings {
    
    public Settings() {
        this.properties = new Properties();
    }
    
    public void saveSettings(String difficulty, String player1Up, String player1Down, String player1Left, String player1Right,
            String player2Up, String player2Down, String player2Left, String player2Right) {
        try {
            output = new FileOutputStream("application.properties");
            properties.setProperty("difficulty", difficulty);
            properties.setProperty("player1Up", player1Up);
            properties.setProperty("player1Down", player1Down);
            properties.setProperty("player1Left", player1Left);
            properties.setProperty("player1Right", player1Right);
            properties.setProperty("player2Up", player2Up);
            properties.setProperty("player2Down", player2Down);
            properties.setProperty("player2Left", player2Left);
            properties.setProperty("player2Right", player2Right);
            properties.store(output, null);
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
    
    private final Properties properties;
    private OutputStream output;
}
