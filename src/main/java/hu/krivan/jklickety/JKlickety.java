package hu.krivan.jklickety;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Fő ablakunk
 *
 * @author Balint
 */
public class JKlickety extends JFrame implements Controller {

    private static final String VERSION = "1.0.0";
    /**
     * Adatbázis kapcsolatunk
     */
    private Connection conn;
    /**
     * Toplista dialógus ablak példánya
     */
    private HallOfFame hallOfFame;
    /**
     * Eredmény-bekérő dialógus ablak példánya
     */
    private ResultDialog resultDlg;

    /**
     * Creates new form Frame
     */
    public JKlickety() {
        initDatabase();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fc = new javax.swing.JFileChooser();
        tabla = new hu.krivan.jklickety.Table(10, 15, this);
        jPanel3 = new javax.swing.JPanel();
        resetBtn = new javax.swing.JButton();
        hallOfFameBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pointsLabel = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        checkUpdateBtn = new javax.swing.JButton();

        fc.setDialogTitle("Válassz egy fájl...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JKlickety");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout tablaLayout = new javax.swing.GroupLayout(tabla);
        tabla.setLayout(tablaLayout);
        tablaLayout.setHorizontalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        tablaLayout.setVerticalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new java.awt.GridBagLayout());

        resetBtn.setText("Új játék kezdése");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel3.add(resetBtn, gridBagConstraints);

        hallOfFameBtn.setText("Toplista");
        hallOfFameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallOfFameBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel3.add(hallOfFameBtn, gridBagConstraints);

        jLabel1.setText("Pontszám: ");
        jPanel2.add(jLabel1);

        pointsLabel.setText("0");
        jPanel2.add(pointsLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel3.add(jPanel2, gridBagConstraints);

        saveBtn.setText("Mentés...");
        saveBtn.setToolTipText("");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel3.add(saveBtn, gridBagConstraints);

        loadBtn.setText("Betöltés...");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel3.add(loadBtn, gridBagConstraints);

        checkUpdateBtn.setText("Frissítés keresése...");
        checkUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUpdateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        jPanel3.add(checkUpdateBtn, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        tabla.reset();
        tabla.repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void hallOfFameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallOfFameBtnActionPerformed
        if (hallOfFame == null) { // elég egyszer létrehozni 
            hallOfFame = new HallOfFame(this, true, this);
        }
        hallOfFame.setVisible(true);
    }//GEN-LAST:event_hallOfFameBtnActionPerformed

    private void onWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowClosing
        closeDatabase();
    }//GEN-LAST:event_onWindowClosing

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            saveTable(fc.getSelectedFile());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            loadTable(fc.getSelectedFile());
        }
    }//GEN-LAST:event_loadBtnActionPerformed

    private void checkUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUpdateBtnActionPerformed
        try {
            final BufferedReader in = new BufferedReader(new InputStreamReader(new URL("http://messo.info/jklickety.version").openStream()));

            String line = in.readLine();
            if (line.equals(VERSION)) {
                JOptionPane.showMessageDialog(this, "Legfrissebb verzió!", "Jó hír", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Frissíts!", "Frissíts!", JOptionPane.WARNING_MESSAGE);
            }

            in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkUpdateBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JKlickety().setVisible(true);
                Logger.getLogger(JKlickety.class.getName()).info("Elindult a rendszer.");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkUpdateBtn;
    private javax.swing.JFileChooser fc;
    private javax.swing.JButton hallOfFameBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadBtn;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private hu.krivan.jklickety.Table tabla;
    // End of variables declaration//GEN-END:variables

    /**
     * A pontváltozás eseményére frissítjük a pontjelző {@link #pointsLabel}t.
     *
     * @param points az új pontszám, amit ki kell írnunk
     */
    @Override
    public void onPointsChanged(double points) {
        if (pointsLabel != null) {
            // ha esetleg még nem jött létre a GUI, de a táblázat már inicializálódik, akkor
            // ne legyen NPE.
            pointsLabel.setText(String.valueOf((int) points));
        }
    }

    /**
     * Amennyiben vége a játéknak, akkor bekérjük a felhasználótól a nevét, hogy
     * a toplistába el tudjuk menteni az eredményét.
     *
     * @param points végső pontszám
     */
    @Override
    public void onNoMoreMove(int points) {
        if (resultDlg == null) {
            // elég egyszer létrehozni
            resultDlg = new ResultDialog(this, true, this, points);
        }
        Logger.getLogger(JKlickety.class.getName()).info("Vége a játéknak!");
        resultDlg.setVisible(true);
    }

    /**
     * Elmentjük egy játékos nevét és a pontszámát a toplistába
     *
     * @param name játkos neve
     * @param points játékos pontszáma
     */
    @Override
    public void savePoints(String name, int points) {
        try {
            PreparedStatement prep = conn.prepareStatement("insert into points values (?, ?);");
            prep.setString(1, name);
            prep.setInt(2, points);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lekérjük az adatbázisból a toplista adatokat.
     *
     * @return a lista, pontszám szerint csökkenő sorrendben rendezve
     */
    @Override
    public List<Result> getDataFromDatabase() {
        List<Result> results = new ArrayList<Result>(5);
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from points order by points desc;");
            while (rs.next()) {
                results.add(new Result(rs.getString("name"), rs.getInt("points")));
            }
            rs.close();

            return results;
        } catch (SQLException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private void initDatabase() {
        try {
            Logger.getLogger(JKlickety.class.getName()).info("Adatbázis kapcsolat inicializálása...");
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            conn.setAutoCommit(true);

            Statement stat = conn.createStatement();
            stat.executeUpdate("create table if not exists points (name, points);");

            Logger.getLogger(JKlickety.class.getName()).info("Adatbázis kapcsolat inicializálva.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeDatabase() {
        Logger.getLogger(JKlickety.class.getName()).info("Adatbázis kapcsolatok lezárása...");
        try {
            conn.close();
            Logger.getLogger(JKlickety.class.getName()).info("Adatbázis kapcsolatok lezárva.");
        } catch (SQLException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveTable(File file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(tabla.getTableData());
            oos.close();
            Logger.getLogger(JKlickety.class.getName()).info("Sikeresen betöltve.");
        } catch (IOException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTable(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            tabla.loadTableData((TableData) ois.readObject());
            ois.close();
            Logger.getLogger(JKlickety.class.getName()).info("Sikeresen elmentve.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Hiba van a fájllal!\nLehet, hogy nem jó a formátum?", "Hiba", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JKlickety.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
