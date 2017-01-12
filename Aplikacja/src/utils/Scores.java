/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import javax.swing.JOptionPane;


public class Scores {
    
    public Scores() {}
    
    public ArrayList<Score> getResults() {
        return loadResults();
    }
    
    public void saveResult(String name, int points) {
        Score result = new Score(name, points);
        ArrayList<Score> results = loadResults();
        results.add(result);
        Collections.sort(results, new Comparator<Score>() {
            @Override
            public int compare(Score result1, Score result2) {
                return -(result1.getPoints() - result2.getPoints());
            }
        });
        results.remove(RESULTS_LENGTH);
        saveResults(results);
    }
    
    private void saveResults(ArrayList<Score> results) {
        try {
            Properties properties = new Properties();
            FileOutputStream fileOutputStream = new FileOutputStream(RESULTS_FILE);
            properties.setProperty("player1Name", results.get(0).getName());
            properties.setProperty("player1Score", "" + results.get(0).getPoints());
            properties.setProperty("player2Name", results.get(1).getName());
            properties.setProperty("player2Score", "" + results.get(1).getPoints());
            properties.setProperty("player3Name", results.get(2).getName());
            properties.setProperty("player3Score", "" + results.get(2).getPoints());
            properties.setProperty("player4Name", results.get(3).getName());
            properties.setProperty("player4Score", "" + results.get(3).getPoints());
            properties.setProperty("player5Name", results.get(4).getName());
            properties.setProperty("player5Score", "" + results.get(4).getPoints());
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }  
    
    private ArrayList<Score> loadResults() {
        ArrayList<Score> results = null;
        FileInputStream fileInputStream = null;
        try {
            if(new File(RESULTS_FILE).exists()) {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(RESULTS_FILE);
                properties.load(fileInputStream);
                results = new ArrayList<>();
                results.add(new Score(properties.getProperty("player1Name"), 
                        Integer.parseInt(properties.getProperty("player1Score"))));
                results.add(new Score(properties.getProperty("player2Name"), 
                        Integer.parseInt(properties.getProperty("player2Score"))));
                results.add(new Score(properties.getProperty("player3Name"), 
                        Integer.parseInt(properties.getProperty("player3Score"))));
                results.add(new Score(properties.getProperty("player4Name"), 
                        Integer.parseInt(properties.getProperty("player4Score"))));
                results.add(new Score(properties.getProperty("player5Name"), 
                        Integer.parseInt(properties.getProperty("player5Score"))));
                fileInputStream.close();
            } else {
                results = new ArrayList<>();
                for(int i = 0; i < RESULTS_LENGTH; ++i) {
                    results.add(new Score("", 0));
                }
                saveResults(results);
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return results;
    }
    
    private static final String RESULTS_FILE = "scores.txt";
    private static final int RESULTS_LENGTH = 5;
}
