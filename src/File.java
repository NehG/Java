
import javax.swing.JFileChooser;
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
public class File extends javax.swing.JFrame {

    /**
     * Creates new form File
     */
    public File() {this.setUndecorated(true);
        initComponents();
    }
public void genCode(String a){
    user.setVisible(false);
    user.setText(a);
}public void genCode1(String a1){
    to.setVisible(false);
    to.setText(a1);
}public void genCode2(String a2){
    sub.setVisible(false);
    sub.setText(a2);
}public void genCode3(String a3){
    msg.setVisible(false);
    msg.setText(a3);
}
    File(String someabsolutepathmyfileext) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        sub = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        f1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));
        getContentPane().add(user);
        getContentPane().add(to);
        getContentPane().add(sub);
        getContentPane().add(msg);

        f1.setBackground(new java.awt.Color(204, 204, 204));
        f1.setFileHidingEnabled(true);
        f1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        f1.setAutoscrolls(true);
        f1.setOpaque(true);
        f1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1ActionPerformed(evt);
            }
        });
        getContentPane().add(f1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1ActionPerformed
 f1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
f1.setAcceptAllFileFilterUsed(false);
java.io.File file = f1.getSelectedFile();
String a = file.getAbsolutePath(); String name = file.getName();
String ext = "";
int i = a.lastIndexOf('.');
int p = Math.max(a.lastIndexOf('/'), a.lastIndexOf('\\'));
if (i > p) {ext = a.substring(i+1);String extension="."+ext;
System.out.print(ext); System.out.print(name);
byte[] b = new byte[(int)file.length()];
if( file.length()>10000000){
    JOptionPane.showMessageDialog(this,"File Too Large");
}else{
Profile pr = new Profile();
pr.geCode1(a);pr.geCode2(extension);pr.genCode2(user.getText());
pr.genTo(to.getText());pr.genSub(sub.getText());pr.genMsg(msg.getText());
pr.setVisible(true);
this.dispose();
}}
        // TODO add your handling code here:
    }//GEN-LAST:event_f1ActionPerformed

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
            java.util.logging.Logger.getLogger(File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new File().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser f1;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel sub;
    private javax.swing.JLabel to;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
