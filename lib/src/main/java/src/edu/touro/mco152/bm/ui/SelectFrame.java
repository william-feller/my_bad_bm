package src.edu.touro.mco152.bm.ui;

import src.edu.touro.mco152.bm.App;

import java.io.File;

/**
 * @author Eli <p>
 * This class specifies the data location functionality provided with in the GUI.
 * The declaration:<p>{@code private javax.swing.JFileChooser jFileChooser1;}</p>
 * has the purpose to eventually determine which file the user selected.
 *
 * @see javax.swing.JFileChooser
 * @see javax.swing.JFrame
 */
public class SelectFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;

    /**
     * Creates new form SelectFrame
     */
    public SelectFrame() {
        initComponents();
        setLocationRelativeTo(Gui.mainFrame);
        if (App.locationDir == null) {
            App.locationDir = new File(System.getProperty("user.home"));
            App.dataDir = new File(App.locationDir.getAbsolutePath()
                    + File.separator + App.DATADIRNAME);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose Location");

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method has a case for both approving and canceling any given selection.
     * If case is "ApproveSelection", get selected files, set the properties with
     * the location directory, and pass the location directory to set the location
     * used by the Gui mainframe. In any case, set the instance of this surrounding class
     * to visible and release all appropriate native screen resources.
     *
     * @see MainFrame
     * @param evt - the ActionEvent taken in for identifying if the user approves or cancels selection
     */

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        System.out.println(evt);
        switch (evt.getActionCommand()) {
            case "ApproveSelection":
                App.locationDir = jFileChooser1.getSelectedFile();
                App.saveConfig();
                Gui.mainFrame.setLocation(App.locationDir.getAbsolutePath());
                break;
            case "CancelSelection":
                break;
        }
        Gui.selFrame.setVisible(false);
        Gui.selFrame.dispose();
    }//GEN-LAST:event_jFileChooser1ActionPerformed
    // End of variables declaration//GEN-END:variables

    void setInitDir(File file) {
        jFileChooser1.setSelectedFile(file);
    }

}