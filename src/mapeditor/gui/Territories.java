package mapeditor.gui;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mapeditor.Continent;
import mapeditor.ILoadedMap;
import mapeditor.ITerritory;
import mapeditor.Territory;

/**
 * This class is responsible to create the Territories Editor Interface.
 *
 * @author Rodolfo Miranda
 *
 */
public class Territories extends javax.swing.JFrame {

    static DefaultTableModel model;
    static DefaultTableModel model2;
    private boolean preventionFlag = false;
    public ILoadedMap loadedMapObj;

    /**
     * Creates new form Territories
     */
    public Territories(ILoadedMap loadedMapObjCons) {
        loadedMapObj = loadedMapObjCons;
        initComponents();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if(!preventionFlag){
                    selectAdjacent(jTable1.getSelectedRow());
                }
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.model = (DefaultTableModel)jTable1.getModel();
        this.model2 = (DefaultTableModel)jTable2.getModel();
        // add header of the table
        String header[] = new String[] {"Territory", "Territory X", "Territory Y", "Continent"};
        String header2[] = new String[] {"Name"};

        // add header in table model
        this.model.setColumnIdentifiers(header);
        this.model.setRowCount(0);
        this.model2.setColumnIdentifiers(header2);
        this.model2.setRowCount(0);
        ArrayList<ITerritory> territories = Territory.getTerritories();
        for(ITerritory ter : territories){
            this.model.addRow(new Object[]{ter.getTerritoryName(), ter.getX(), ter.getY(), ter.getContinent()});
        }
        jTable1.setModel(this.model);
        selectAdjacent(0);
    }


    /**
     * This method to refresh the JTable with the territories adjacents.
     *
     * @param Interger pos position select in the JTable for territories.
     */
    public void selectAdjacent(Integer pos){
        this.model2.setRowCount(0);
        ArrayList<ITerritory> terList = Territory.getTerritories();
        System.out.println(pos);
        System.out.println(terList.size());
        if(terList.size() > pos){
            ITerritory ter = terList.get(pos);
            ArrayList<String> adjacents = ter.getAdjacents();
            System.out.println(adjacents);
            for(String str : adjacents){
                this.model2.addRow(new Object[]{str});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Remove Territory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Territory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Territory Name");

        jLabel2.setText("Territory X");

        jLabel3.setText("Territory Y");

        jLabel4.setText("Continent");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Territories Adjacents");

        jScrollPane3.setViewportView(jTextPane1);

        jButton3.setText("Add Adjacents");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remove Adjacents");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton1)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel1))
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jTextField2)
                                        .addComponent(jTextField3)
                                        .addComponent(jTextField4)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addGap(12, 12, 12)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(93, 93, 93)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jButton3))
                                                .addGap(29, 29, 29)
                                                .addComponent(jButton4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)
                                                .addGap(40, 40, 40)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * This method to perform the button remove.
     *
     * @param java.awt.event.ActionEvent evt (The event).
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        preventionFlag = true;
        Integer index = jTable1.getSelectedRow();
        this.model.removeRow(index);
        ITerritory ter = Territory.getTerritories().get(index);
        loadedMapObj.deleteTerritory(ter);
        ArrayList<ITerritory> ters = Territory.getTerritories();
        ters.remove(ter);
        Territory.setTerritories(ters);
        this.updateTerritories();
        selectAdjacent(0);
        preventionFlag = false;

    }

    /**
     * This method to perform the button add territory.
     *
     * @param java.awt.event.ActionEvent evt (The event).
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Vector newRow = new Vector();
        newRow.add(jTextField1.getText());
        newRow.add(jTextField2.getText());
        newRow.add(jTextField3.getText());
        newRow.add(jTextField4.getText());
        ITerritory ter = new Territory(jTextField1.getText(), Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField3.getText()), jTextField4.getText(), new ArrayList<String>());
        loadedMapObj.addTerritory(ter);
        this.model.addRow(newRow);
        this.updateTerritories();
    }

    /**
     * This method to refresh the JTable with the territories adjacents.
     *
     * @param java.awt.event.ActionEvent evt (The event).
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Vector newRow = new Vector();
        newRow.add(jTextPane1.getText());
        this.model2.addRow(newRow);
        this.updateTerritories();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        preventionFlag = true;
        Integer index = jTable2.getSelectedRow();
        Integer indexContinent = jTable1.getSelectedRow();
        String adjacentName = (String)this.model2.getValueAt(index, 0);
        this.model2.removeRow(index);
        ITerritory ter = Territory.getTerritories().get(indexContinent);
        ter.removeAdjacent(adjacentName);
        //loadedMapObj.deleteTerritory(ter);
        //ArrayList<ITerritory> ters = Territory.getTerritories();
        //ters.remove(ter);
        //Territory.setTerritories(ters);
        this.updateTerritories();
        preventionFlag = false;
    }

    /**
     * This method to perform the action to add territories.
     *
     */
    private void updateTerritories(){
        ArrayList<ITerritory> territories = new ArrayList<ITerritory>();
        for (int count = 0; count < model.getRowCount(); count++){
            ArrayList<String> adjacentTerritories = new ArrayList<String>();
            if(this.jTable1.getSelectedRow() == count){
                if(Territory.getTerritories().size() > count){
                    for (int iterator = 0; iterator < model2.getRowCount(); iterator++){
                        adjacentTerritories.add(model2.getValueAt(iterator, 0).toString());
                    }
                }
            }else{
                if(Territory.getTerritories().size() > count){
                    adjacentTerritories = Territory.getTerritories().get(count).getAdjacents();
                }
            }
            territories.add(new Territory(model.getValueAt(count, 0).toString(),
                    Integer.parseInt(model.getValueAt(count, 1).toString()),
                    Integer.parseInt(model.getValueAt(count, 2).toString()),
                    model.getValueAt(count, 3).toString(),
                    adjacentTerritories
            ));
        }
        Territory.setTerritories(territories);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration
}
