/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import constants.GameConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author gregory
 */
public class GameFrame extends javax.swing.JFrame{

    private static boolean running = false;
    /**
     * Creates new form gameFrame
     */
    public GameFrame() {
        initComponents();
        runGameLoop();
    }
    
    public static void stopGame()
    {
        running = false;
        
    }
    
    public void runGameLoop()
    {
        running = true;
        Thread loop = new Thread()
        {
            @Override
            public void run()
            {
                gameMainLoop();
            }
        };
        loop.start();
    }
    
    public void gameMainLoop()
    {     
        while(running)
        {
            double lastRenderTime = System.nanoTime();
            drawGame();       
            updateGame();
            
            double now = System.nanoTime();
            while(now - lastRenderTime < GameConstants.TARGET_TIME_BW_FRAMES)
            {
                Thread.yield();
                try
                {
                    Thread.sleep(1);
                }
                catch(Exception e)
                {
                    
                }
                now = System.nanoTime();
            }
            
        }
        dispose();
        
    }
    
    private void updateGame()
    {
        ((GamePanel)gamePanel).updateGame();
        player1Score.setText(Integer.toString(((GamePanel)gamePanel).getPlayer1Score()));
        player2Score.setText(Integer.toString(((GamePanel)gamePanel).getPlayer2Score()));
    }
        
    private void drawGame()
    {
        gamePanel.repaint();
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new GamePanel();
        player1Name = new javax.swing.JLabel();
        player2Name = new javax.swing.JLabel();
        player1Score = new javax.swing.JLabel();
        player2Score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 740));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        gamePanel.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        player1Name.setText("Gracz 1");

        player2Name.setText("Gracz 2");

        player1Score.setText("jLabel3");

        player2Score.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1Name)
                    .addComponent(player1Score))
                .addGap(0, 0, 0)
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2Name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(player2Score, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(player1Name)
                                .addGap(47, 47, 47)
                                .addComponent(player1Score))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(player2Name)
                                .addGap(46, 46, 46)
                                .addComponent(player2Score)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel player1Name;
    private javax.swing.JLabel player1Score;
    private javax.swing.JLabel player2Name;
    private javax.swing.JLabel player2Score;
    // End of variables declaration//GEN-END:variables

}
