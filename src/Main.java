
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form main1
     */
    public Main() {
        initComponents();
        //Loading Timer
    Timer loading=  new Timer();
    int startingTime=0000; //2 seconds
    int delayTime=500; // 1/2 second
     loading.schedule(new TimerTask()
       {int i=0;
       @Override
        public void run() { 
            l2.setText(10-i +"   "+ "Seconds Left Please Wait...");
         p1.setValue(i*10);
        i++;
      if(i==11){loading.cancel();
      Home h=new Home();
      h.setVisible(true);
      dispose();}  }
      },startingTime,delayTime);
   // Image Changing Timer
     //
     //
     
     Timer timer = new Timer();
     int imageTime=0000; //0 seconds
    int changeTime=3000; // 3 second
     timer.schedule(new TimerTask()
       {int i=0;
       @Override
        public void run() { 
            ImageIcon Logo  = new ImageIcon("F:/Nehal/images/main.png");
            ImageIcon Logo1 = new ImageIcon("F:/Nehal/images/main1.png");
            ImageIcon Logo2 = new ImageIcon("F:/Nehal/images/main2.png");
            ImageIcon Logo3 = new ImageIcon("F:/Nehal/images/main3.png");
            ImageIcon Logo4 = new ImageIcon("F:/Nehal/images/main4.png");
            if(i==0)l1.setIcon(Logo);if(i==1)l1.setIcon(Logo1);if(i==2)l1.setIcon(Logo2);if(i==3)l1.setIcon(Logo3);if(i==4)l1.setIcon(Logo4);
        i++;
        if(i==5){i=0;}
        }
      },imageTime,changeTime);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        p1 = new javax.swing.JProgressBar();
        l2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Y! Messenger [ Loading... ]");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setLocationByPlatform(true);

        l1.setBackground(new java.awt.Color(255, 255, 255));
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\main.png")); // NOI18N
        l1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        l1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l1.setIconTextGap(0);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel1.setText("LOADING...");

        p1.setBackground(new java.awt.Color(0, 0, 0));
        p1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        p1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        p1.setEnabled(false);
        p1.setOpaque(true);

        l2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\yahoo-icon.png")); // NOI18N
        jLabel2.setText("Y! Messenger");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        l4.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        l4.setText(",Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(l1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JOptionPane.showMessageDialog(this,"Y! Messenger. \n\nCreated On : 10-NOV-1999. \nCreated By : Nehal Gajjar.\nVersion : 1.2\nLast Update :20-05-2016\nCopyRight 2015-2016. ");
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l4;
    private javax.swing.JProgressBar p1;
    // End of variables declaration//GEN-END:variables
}
