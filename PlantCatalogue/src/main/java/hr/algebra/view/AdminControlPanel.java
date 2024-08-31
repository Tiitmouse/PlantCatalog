/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view;

import hr.algebra.dal.Context;
import hr.algebra.dal.Repository;
import hr.algebra.dal.ContextFactory;
import hr.algebra.model.Plant;
import hr.algebra.parsers.rss.PlantParser;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.PlantsTableModel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

/**
 *
 * @author lorena
 */
public class AdminControlPanel extends javax.swing.JPanel {

    private final Context context;

    private PlantsTableModel plantsTableModel;
    private int selectedPlantId;

    /**
     * Creates new form UploadPlantsPanel
     */
    public AdminControlPanel() {
        context = ContextFactory.getContext();
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

        btnUploadPlantsToDatabase = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlants = new javax.swing.JTable();
        btnDeleteSelected = new javax.swing.JButton();
        btnDeleteAllPlants = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        btnUploadPlantsToDatabase.setBackground(new java.awt.Color(137, 151, 116));
        btnUploadPlantsToDatabase.setText("Upload all plants and show");
        btnUploadPlantsToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPlantsToDatabaseActionPerformed(evt);
            }
        });

        tblPlants.setBackground(new java.awt.Color(255, 255, 255));
        tblPlants.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 151, 116), 0));
        tblPlants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPlants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlantsMouseClicked(evt);
            }
        });
        tblPlants.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPlantsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlants);

        btnDeleteSelected.setBackground(new java.awt.Color(255, 204, 204));
        btnDeleteSelected.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteSelected.setText("DELETE SELECTED PLANT");
        btnDeleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSelectedActionPerformed(evt);
            }
        });

        btnDeleteAllPlants.setBackground(new java.awt.Color(255, 204, 204));
        btnDeleteAllPlants.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteAllPlants.setText("DELETE ALL PLANTS");
        btnDeleteAllPlants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllPlantsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUploadPlantsToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteSelected)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAllPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUploadPlantsToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAllPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadPlantsToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPlantsToDatabaseActionPerformed
        try {
            PlantParser.parse();
            loadModel();
            MessageUtils.showInformationMessage("success", "good for u");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload plants");
            //TODO nemoj console logati
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnUploadPlantsToDatabaseActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();    }//GEN-LAST:event_formComponentShown

    private void btnDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSelectedActionPerformed

        try {
            var pl = context.plants.select(selectedPlantId);
            if (pl.isEmpty()) {
                MessageUtils.showInformationMessage("nope", "Plant not selected");
                return;
            }
            if (MessageUtils.showConfirmDialog(
                    "Delete plant",
                    "u sure?")) {
                try {
                    // todo should delete its downloaded picture
                    if (pl.get().getPicture_path() != null) {
                        Files.deleteIfExists(Paths.get(pl.get().getPicture_path()));
                    }
                    context.plants.delete(selectedPlantId);
                    plantsTableModel.setPlants(context.plants.selectAll());
                    
                } catch (Exception ex) {
                    Logger.getLogger(AdminControlPanel.class.getName()).log(Level.SEVERE, null, ex);
                    MessageUtils.showErrorMessage("Error", "Unable to delete plant!");
                } finally {
                    loadModel();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteSelectedActionPerformed

    private void btnDeleteAllPlantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllPlantsActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Delete all plants",
                "u sure?")) {
            try {
                 //todo should delete its downloaded picture
                 //if (selectedPlant.getPicture_path()!= null) {
                 //    Files.deleteIfExists(Paths.get(selectedPlant.getPicture_path()));
                 // }
                context.plants.deleteAll();

            } catch (Exception ex) {
                Logger.getLogger(AdminControlPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete all plants!");
            } finally {
                loadModel();
            }
        }
    }//GEN-LAST:event_btnDeleteAllPlantsActionPerformed

    private void tblPlantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlantsMouseClicked
        int selectedRow = tblPlants.getSelectedRow();
        int rowIndex = tblPlants.convertRowIndexToModel(selectedRow);
        selectedPlantId = (int) plantsTableModel.getValueAt(rowIndex, 0);
    }//GEN-LAST:event_tblPlantsMouseClicked

    private void tblPlantsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPlantsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPlantsKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAllPlants;
    private javax.swing.JButton btnDeleteSelected;
    private javax.swing.JButton btnUploadPlantsToDatabase;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPlants;
    // End of variables declaration//GEN-END:variables
    private Repository repository;

    private void init() {
        try {
            loadModel();
            initTable();

        } catch (Exception ex) {
            Logger.getLogger(AdminControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void loadModel() {
        List<Plant> plants;
        try {
            plants = context.plants.selectAll();
            plantsTableModel = new PlantsTableModel(plants);
            tblPlants.setModel(plantsTableModel);
        } catch (Exception ex) {
            Logger.getLogger(AdminControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTable() throws Exception {
        tblPlants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblPlants.setAutoCreateRowSorter(true);
        tblPlants.setRowHeight(25);
        plantsTableModel = new PlantsTableModel(context.plants.selectAll());
        tblPlants.setModel(plantsTableModel);
    }

}
