/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_pr_final;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author carlos
 */
public class AluCambioGr extends javax.swing.JFrame {

    /**
     * Creates new form AluCambioGr
     */
    int xmouse, ymouse;
    String alulog;
    AlumnoMainFrame context;
    
    public AluCambioGr(String alulog, AlumnoMainFrame context) {
        this.alulog = alulog;
        this.context = context;
        this.getContentPane().setBackground(new Color(0xfafafa));
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(153, 0, 0)));
        initComponents();
        
        String[] asignaturas = BD_Helper.getAsignaturasAlumno(alulog);
        jComboBox1.setModel(new DefaultComboBoxModel(asignaturas));
        
        String[] grups = BD_Helper.getGrupos((String)jComboBox1.getSelectedItem());
        jComboBox2.setModel(new DefaultComboBoxModel(grups));
        jTextField1.setEnabled(false);
        jRadioButton1.setSelected(true);
        
        inicializar();
        
        cgrupo.setText(BD_Helper.getGrupoAsigAlu(alulog, (String)jComboBox1.getSelectedItem()));
        
    }

    public void inicializar(){
        sl2.setText("----");
        sl4.setText("----");
        sm2.setText("----");
        sm4.setText("----");
        sx2.setText("----");
        sx4.setText("----");
        sj2.setText("----");
        sj4.setText("----");
        sv2.setText("----");
        sv4.setText("----");
        setEnabledFields(true ,true, true, true, true, false);
        
        jButton1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jLabel3.setEnabled(true);
        jLabel6.setEnabled(true);
        cgrupo.setEnabled(true);
        
        if(BD_Helper.getGrupoAsigAlu(alulog, (String)jComboBox1.getSelectedItem()).compareTo("-1")==0){
            jButton1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jLabel3.setEnabled(false);
            jLabel6.setEnabled(false);
            cgrupo.setEnabled(false);
        }
        
        String[][] horario = BD_Helper.getHorario((String)jComboBox1.getSelectedItem(), (String)jComboBox2.getSelectedItem());
        if(horario == null) return;
        
        if(horario[0][0].compareTo("-1")!=0){
            setEnabledFields(true, false, false, false, false, true);
            sl2.setText(horario[0][0]);
        }
        if(horario[0][1].compareTo("-1")!=0){
            setEnabledFields(true, false, false, false, false, true);
            sl4.setText(horario[0][1]);
        }
        
        if(horario[1][0].compareTo("-1")!=0){
            setEnabledFields(false, true, false, false, false, true);
            sm2.setText(horario[1][0]);
        }
        if(horario[1][1].compareTo("-1")!=0){
            setEnabledFields(false, true, false, false, false, true);
            sm4.setText(horario[1][1]);
        }
        
        if(horario[2][0].compareTo("-1")!=0){
            setEnabledFields(false, false, true, false, false, true);
            sx2.setText(horario[2][0]);
        }
        if(horario[2][1].compareTo("-1")!=0){
            setEnabledFields(false, false, true, false, false, true);
            sx4.setText(horario[2][1]);
        }
        
        if(horario[3][0].compareTo("-1")!=0){
            setEnabledFields(false, false, false, true, false, true);
            sj2.setText(horario[3][0]);
        }
        if(horario[3][1].compareTo("-1")!=0){
            setEnabledFields(false, false, false, true, false, true);
            sj4.setText(horario[3][1]);
        }
        
        if(horario[4][0].compareTo("-1")!=0){
            setEnabledFields(false, false, false, false, true, true);
            sv2.setText(horario[4][0]);
        }
        if(horario[4][1].compareTo("-1")!=0){
            setEnabledFields(false, false, false, false, true, true);
            sv4.setText(horario[4][1]);
        }
    }
    
    public final void setEnabledFields(boolean l, boolean m, boolean x, boolean j, boolean v, boolean enabled){
        if(l){
            sl.setEnabled(enabled);
            sl1.setEnabled(enabled);
            sl2.setEnabled(enabled);
            sl3.setEnabled(enabled);
            sl4.setEnabled(enabled);
        }
        if(m){
            sm.setEnabled(enabled);
            sm1.setEnabled(enabled);
            sm2.setEnabled(enabled);
            sm3.setEnabled(enabled);
            sm4.setEnabled(enabled);
        }
        if(x){
            sx.setEnabled(enabled);
            sx1.setEnabled(enabled);
            sx2.setEnabled(enabled);
            sx3.setEnabled(enabled);
            sx4.setEnabled(enabled);
        }
        if(j){
            sj.setEnabled(enabled);
            sj1.setEnabled(enabled);
            sj2.setEnabled(enabled);
            sj3.setEnabled(enabled);
            sj4.setEnabled(enabled);
        }
        if(v){
            sv.setEnabled(enabled);
            sv1.setEnabled(enabled);
            sv2.setEnabled(enabled);
            sv3.setEnabled(enabled);
            sv4.setEnabled(enabled);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sl = new javax.swing.JLabel();
        sm = new javax.swing.JLabel();
        sx = new javax.swing.JLabel();
        sj = new javax.swing.JLabel();
        sv = new javax.swing.JLabel();
        sx1 = new javax.swing.JLabel();
        sm1 = new javax.swing.JLabel();
        sl1 = new javax.swing.JLabel();
        sj1 = new javax.swing.JLabel();
        sv1 = new javax.swing.JLabel();
        sl2 = new javax.swing.JLabel();
        sm2 = new javax.swing.JLabel();
        sx2 = new javax.swing.JLabel();
        sj2 = new javax.swing.JLabel();
        sv2 = new javax.swing.JLabel();
        sl3 = new javax.swing.JLabel();
        sm3 = new javax.swing.JLabel();
        sx3 = new javax.swing.JLabel();
        sj3 = new javax.swing.JLabel();
        sv3 = new javax.swing.JLabel();
        sl4 = new javax.swing.JLabel();
        sm4 = new javax.swing.JLabel();
        sx4 = new javax.swing.JLabel();
        sj4 = new javax.swing.JLabel();
        sv4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cgrupo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ipo_pr_final/close.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Groups USAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Asignatura");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Solicitar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Motivo");

        sl.setText("Lunes");

        sm.setText("Martes");

        sx.setText("Miércoles");

        sj.setText("Jueves");

        sv.setText("Viernes");

        sx1.setText("De: ");

        sm1.setText("De: ");

        sl1.setText("De: ");

        sj1.setText("De: ");

        sv1.setText("De: ");

        sl2.setText("jLabel15");

        sm2.setText("jLabel16");

        sx2.setText("jLabel17");

        sj2.setText("jLabel18");

        sv2.setText("jLabel19");

        sl3.setText("A:");

        sm3.setText("A:");

        sx3.setText("A:");

        sj3.setText("A:");

        sv3.setText("A:");

        sl4.setText("jLabel25");

        sm4.setText("jLabel26");

        sx4.setText("jLabel27");

        sj4.setText("jLabel28");

        sv4.setText("jLabel29");

        jLabel3.setText("Solicitar cambio del grupo");

        cgrupo.setText("g");

        jLabel6.setText("al grupo");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Horario");

        jRadioButton1.setText("Preferencia");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Horario incompatible");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Otro (especifique el motivo)");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cgrupo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(sl)
                                    .addGap(34, 34, 34)
                                    .addComponent(sl1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sm)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sm1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sx)
                                            .addComponent(sj)
                                            .addComponent(sv))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sv1)
                                            .addComponent(sj1)
                                            .addComponent(sx1)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sl2)
                                .addComponent(sm2)
                                .addComponent(sx2)
                                .addComponent(sj2)
                                .addComponent(sv2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sv3)
                                .addComponent(sj3)
                                .addComponent(sx3)
                                .addComponent(sm3)
                                .addComponent(sl3))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sm4)
                                .addComponent(sl4)
                                .addComponent(sx4)
                                .addComponent(sj4)
                                .addComponent(sv4))))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextField1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cgrupo)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sl)
                    .addComponent(sl1)
                    .addComponent(sl2)
                    .addComponent(sl3)
                    .addComponent(sl4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sm)
                    .addComponent(sm1)
                    .addComponent(sm2)
                    .addComponent(sm3)
                    .addComponent(sm4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sx)
                    .addComponent(sx1)
                    .addComponent(sx2)
                    .addComponent(sx3)
                    .addComponent(sx4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sj)
                    .addComponent(sj1)
                    .addComponent(sj2)
                    .addComponent(sj3)
                    .addComponent(sj4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sv)
                    .addComponent(sv1)
                    .addComponent(sv2)
                    .addComponent(sv3)
                    .addComponent(sv4))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xpos = evt.getXOnScreen() - xmouse;
        int ypos = evt.getYOnScreen() - ymouse;
        this.setLocation(xpos, ypos);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String grupoActual = BD_Helper.getGrupoAsigAlu(alulog, (String)jComboBox1.getSelectedItem());
        String listAlumnos[] = BD_Helper.getLines(BD_Helper.ALL);
        for(int i=0; i<listAlumnos.length; i++){
            if(listAlumnos[i].contains(alulog)){
                String aux[] = listAlumnos[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo((String)jComboBox1.getSelectedItem())==0){
                        if(((String)jComboBox2.getSelectedItem()).compareTo(grupoActual)==0){
                            aux[j+3] = "-1";
                        }else{
                            aux[j+3] = (String)jComboBox2.getSelectedItem()+":";
                            if(jRadioButton1.isSelected())
                                aux[j+3]+="-1";
                            else if(jRadioButton2.isSelected())
                                aux[j+3]+="-2";
                            else if(jRadioButton3.isSelected()){
                                String texto = jTextField1.getText();
                                if(texto.length()==0) texto = " ";
                                aux[j+3]+="-3:"+texto;
                            }
                        }
                    }
                }
                String line = aux[0];
                for(int j=1; j<aux.length; j++){
                    line+=";"+aux[j];
                }
                listAlumnos[i] = line;
            }
        }
        
        BD_Helper.updateListAlus(listAlumnos);
        
        context.updateList();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cgrupo.setText(BD_Helper.getGrupoAsigAlu(alulog, (String)jComboBox1.getSelectedItem()));
        String[] grups = BD_Helper.getGrupos((String)jComboBox1.getSelectedItem());
        jComboBox2.setModel(new DefaultComboBoxModel(grups));
        inicializar();
        repaint();
        revalidate();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        inicializar();
        repaint();
        revalidate();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if(jRadioButton3.isSelected()){
            jTextField1.setEnabled(true);
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
        }else{
            jTextField1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            jTextField1.setEnabled(false);
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
        }else{
            jTextField1.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jTextField1.setEnabled(false);
            jRadioButton3.setSelected(false);
            jRadioButton2.setSelected(false);
        }else{
            jTextField1.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cgrupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel sj;
    private javax.swing.JLabel sj1;
    private javax.swing.JLabel sj2;
    private javax.swing.JLabel sj3;
    private javax.swing.JLabel sj4;
    private javax.swing.JLabel sl;
    private javax.swing.JLabel sl1;
    private javax.swing.JLabel sl2;
    private javax.swing.JLabel sl3;
    private javax.swing.JLabel sl4;
    private javax.swing.JLabel sm;
    private javax.swing.JLabel sm1;
    private javax.swing.JLabel sm2;
    private javax.swing.JLabel sm3;
    private javax.swing.JLabel sm4;
    private javax.swing.JLabel sv;
    private javax.swing.JLabel sv1;
    private javax.swing.JLabel sv2;
    private javax.swing.JLabel sv3;
    private javax.swing.JLabel sv4;
    private javax.swing.JLabel sx;
    private javax.swing.JLabel sx1;
    private javax.swing.JLabel sx2;
    private javax.swing.JLabel sx3;
    private javax.swing.JLabel sx4;
    // End of variables declaration//GEN-END:variables
}
