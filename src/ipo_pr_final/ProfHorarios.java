/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_pr_final;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class ProfHorarios extends javax.swing.JFrame {

    /**
     * Creates new form ProfHorarios
     */
    int xmouse, ymouse;
    String userlog;
    
    public ProfHorarios(String userlog) {
        this.userlog = userlog;
        this.getContentPane().setBackground(new Color(0xfafafa));
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(153, 0, 0)));
        initComponents();
        
        String[] asignaturas = BD_Helper.getAsignaturasProfesor(userlog);
        jComboBox1.setModel(new DefaultComboBoxModel(asignaturas));
        
        String[] grupos = BD_Helper.getGruposAsignaturaProfesor(userlog, (String)jComboBox1.getSelectedItem());
        if(grupos != null)
            jComboBox2.setModel(new DefaultComboBoxModel(grupos));
        jButton1.setEnabled(false);
        
        inicializar();
    }
    
    public void inicializar(){
        String horarios[][] = BD_Helper.getHorario((String)jComboBox1.getSelectedItem(), (String)jComboBox2.getSelectedItem());
        setEnabledFields(true, true, true, true, true, false);
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        lunestxt1.setText("");
        lunestxt2.setText("");
        martestxt1.setText("");
        martestxt2.setText("");
        miercolestxt1.setText("");
        miercolestxt2.setText("");
        juevestxt1.setText("");
        juevestxt2.setText("");
        viernestxt1.setText("");
        viernestxt2.setText("");
        
        if(horarios==null) return;
            
        if(horarios[0][0].compareTo("-1")!=0){
            jCheckBox1.setSelected(true);
            setEnabledFields(true, false, false, false, false, true);
            lunestxt1.setText(horarios[0][0]);
        }
        if(horarios[0][1].compareTo("-1")!=0){
            jCheckBox1.setSelected(true);
            setEnabledFields(true, false, false, false, false, true);
            lunestxt2.setText(horarios[0][1]);
        }
        if(horarios[1][0].compareTo("-1")!=0){
            jCheckBox2.setSelected(true);
            setEnabledFields(false, true, false, false, false, true);
            martestxt1.setText(horarios[1][0]);
        }
        if(horarios[1][1].compareTo("-1")!=0){
            jCheckBox2.setSelected(true);
            setEnabledFields(false, true, false, false, false, true);
            martestxt2.setText(horarios[1][1]);
        }
        if(horarios[2][0].compareTo("-1")!=0){
            jCheckBox3.setSelected(true);
            setEnabledFields(false, false, true, false, false, true);
            miercolestxt1.setText(horarios[2][0]);
        }
        if(horarios[2][1].compareTo("-1")!=0){
            jCheckBox3.setSelected(true);
            setEnabledFields(false, false, true, false, false, true);
            miercolestxt2.setText(horarios[2][1]);
        }
        if(horarios[3][0].compareTo("-1")!=0){
            jCheckBox4.setSelected(true);
            setEnabledFields(false, false, false, true, false, true);
            juevestxt1.setText(horarios[3][0]);
        }
        if(horarios[3][1].compareTo("-1")!=0){
            jCheckBox4.setSelected(true);
            setEnabledFields(false, false, false, true, false, true);
            juevestxt2.setText(horarios[3][1]);
        }
        if(horarios[4][0].compareTo("-1")!=0){
            jCheckBox5.setSelected(true);
            setEnabledFields(false, false, false, false, true, true);
            viernestxt1.setText(horarios[4][0]);
        }
        if(horarios[4][1].compareTo("-1")!=0){
            jCheckBox5.setSelected(true);
            setEnabledFields(false, false, false, false, true, true);
            viernestxt2.setText(horarios[4][1]);
        }
    }
    
    public final void setEnabledFields(boolean l, boolean m, boolean x, boolean j, boolean v, boolean enabled){
        if(l){
            luneslbl1.setEnabled(enabled);
            luneslbl2.setEnabled(enabled);
            lunestxt1.setEnabled(enabled);
            lunestxt2.setEnabled(enabled);
        }
        if(m){
            marteslbl1.setEnabled(enabled);
            marteslbl2.setEnabled(enabled);
            martestxt1.setEnabled(enabled);
            martestxt2.setEnabled(enabled);
        }
        if(x){
            miercoleslbl1.setEnabled(enabled);
            miercoleslbl2.setEnabled(enabled);
            miercolestxt1.setEnabled(enabled);
            miercolestxt2.setEnabled(enabled);
        }
        if(j){
            jueveslbl1.setEnabled(enabled);
            jueveslbl2.setEnabled(enabled);
            juevestxt1.setEnabled(enabled);
            juevestxt2.setEnabled(enabled);
        }
        if(v){
            vierneslbl1.setEnabled(enabled);
            vierneslbl2.setEnabled(enabled);
            viernestxt1.setEnabled(enabled);
            viernestxt2.setEnabled(enabled);
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

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        miercoleslbl1 = new javax.swing.JLabel();
        miercolestxt1 = new javax.swing.JTextField();
        miercoleslbl2 = new javax.swing.JLabel();
        miercolestxt2 = new javax.swing.JTextField();
        martestxt2 = new javax.swing.JTextField();
        marteslbl2 = new javax.swing.JLabel();
        martestxt1 = new javax.swing.JTextField();
        marteslbl1 = new javax.swing.JLabel();
        lunestxt2 = new javax.swing.JTextField();
        luneslbl2 = new javax.swing.JLabel();
        lunestxt1 = new javax.swing.JTextField();
        luneslbl1 = new javax.swing.JLabel();
        juevestxt2 = new javax.swing.JTextField();
        jueveslbl2 = new javax.swing.JLabel();
        juevestxt1 = new javax.swing.JTextField();
        jueveslbl1 = new javax.swing.JLabel();
        viernestxt2 = new javax.swing.JTextField();
        vierneslbl2 = new javax.swing.JLabel();
        viernestxt1 = new javax.swing.JTextField();
        vierneslbl1 = new javax.swing.JLabel();

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Grupo");

        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Lunes");
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Martes");
        jCheckBox2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Miércoles");
        jCheckBox3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Jueves");
        jCheckBox4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Viernes");
        jCheckBox5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        miercoleslbl1.setText("De:");

        miercolestxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                miercolestxt1KeyTyped(evt);
            }
        });

        miercoleslbl2.setText("A:");

        miercolestxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                miercolestxt2KeyTyped(evt);
            }
        });

        martestxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                martestxt2KeyTyped(evt);
            }
        });

        marteslbl2.setText("A:");

        martestxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                martestxt1KeyTyped(evt);
            }
        });

        marteslbl1.setText("De:");

        lunestxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lunestxt2KeyTyped(evt);
            }
        });

        luneslbl2.setText("A:");

        lunestxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lunestxt1KeyTyped(evt);
            }
        });

        luneslbl1.setText("De:");

        juevestxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                juevestxt2KeyTyped(evt);
            }
        });

        jueveslbl2.setText("A:");

        juevestxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                juevestxt1KeyTyped(evt);
            }
        });

        jueveslbl1.setText("De:");

        viernestxt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                viernestxt2KeyTyped(evt);
            }
        });

        vierneslbl2.setText("A:");

        viernestxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                viernestxt1KeyTyped(evt);
            }
        });

        vierneslbl1.setText("De:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jueveslbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(juevestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jueveslbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(juevestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(luneslbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lunestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(luneslbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lunestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(marteslbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(martestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marteslbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(martestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(miercoleslbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(miercolestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(miercoleslbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(miercolestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vierneslbl1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(viernestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vierneslbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viernestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(137, 137, 137)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(luneslbl1)
                    .addComponent(lunestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luneslbl2)
                    .addComponent(lunestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(marteslbl1)
                    .addComponent(martestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marteslbl2)
                    .addComponent(martestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(miercoleslbl1)
                    .addComponent(miercolestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miercoleslbl2)
                    .addComponent(miercolestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jueveslbl1)
                    .addComponent(juevestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jueveslbl2)
                    .addComponent(juevestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(vierneslbl1)
                    .addComponent(viernestxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vierneslbl2)
                    .addComponent(viernestxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        setExtendedState(JFrame.NORMAL);
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

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected())
            setEnabledFields(false, true, false, false, false, true);
        else
            setEnabledFields(false, true, false, false, false, false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String formatedLine = userlog+";"+(String)jComboBox1.getSelectedItem()+";"+(String)jComboBox2.getSelectedItem()+";";
        String l1, l2, m1, m2, x1, x2, j1, j2, v1, v2;
        
        if(jCheckBox1.isEnabled()){
            if(lunestxt1.getText().replace(";", "").trim().length() == 0)
                l1 = "-1";
            else
                l1 = lunestxt1.getText().replace(";", "");
            if(lunestxt2.getText().replace(";", "").trim().length() == 0)
                l2 = "-1";
            else
                l2 = lunestxt2.getText().replace(";", "");
        }else{
            l1 = "-1";
            l2 = "-1";
        }
        if(jCheckBox2.isEnabled()){
            if(martestxt2.getText().replace(";", "").trim().length() == 0)
                m1 = "-1";
            else
                m1 = martestxt1.getText().replace(";", "");
            if(martestxt2.getText().replace(";", "").trim().length() == 0)
                m2 = "-1";
            else
                m2 = lunestxt2.getText().replace(";", "");
        }else{
            m1 = "-1";
            m2 = "-1";
        }
        if(jCheckBox3.isEnabled()){
            if(miercolestxt1.getText().replace(";", "").trim().length() == 0)
                x1 = "-1";
            else
                x1 = miercolestxt1.getText().replace(";", "");
            if(miercolestxt2.getText().replace(";", "").trim().length() == 0)
                x2 = "-1";
            else
                x2 = miercolestxt2.getText().replace(";", "");
        }else{
            x1 = "-1";
            x2 = "-1";
        }
        if(jCheckBox4.isEnabled()){
            if(juevestxt1.getText().replace(";", "").trim().length() == 0)
                j1 = "-1";
            else
                j1 = juevestxt1.getText().replace(";", "");
            if(juevestxt2.getText().replace(";", "").trim().length() == 0)
                j2 = "-1";
            else
                j2 = juevestxt2.getText().replace(";", "");
        }else{
            j1 = "-1";
            j2 = "-1";
        }
        if(jCheckBox5.isEnabled()){
            if(viernestxt1.getText().replace(";", "").trim().length() == 0)
                v1 = "-1";
            else
                v1 = viernestxt1.getText().replace(";", "");
            if(viernestxt2.getText().replace(";", "").trim().length() == 0)
                v2 = "-1";
            else
                v2 = viernestxt2.getText().replace(";", "");
        }else{
            v1 = "-1";
            v2 = "-1";
        }
        
        formatedLine += l1+";"+l2+";"+m1+";"+m2+";"+x1+";"+x2+";"+j1+";"+j2+";"+v1+";"+v2;
        BD_Helper.updateHorario((String)jComboBox1.getSelectedItem(), (String)jComboBox2.getSelectedItem(), formatedLine);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String[] grupos = BD_Helper.getGruposAsignaturaProfesor(userlog, (String)jComboBox1.getSelectedItem());
        if(grupos != null)
            jComboBox2.setModel(new DefaultComboBoxModel(grupos));
        inicializar();
        repaint();
        revalidate();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        inicializar();
        repaint();
        revalidate();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
            setEnabledFields(true, false, false, false, false, true);
        else
            setEnabledFields(true, false, false, false, false, false);
        
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected())
            setEnabledFields(false, false, true, false, false, true);
        else
            setEnabledFields(false, false, true, false, false, false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if(jCheckBox4.isSelected())
            setEnabledFields(false, false, false, true, false, true);
        else
            setEnabledFields(false, false, false, true, false, false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected())
            setEnabledFields(false, false, false, false, true, true);
        else
            setEnabledFields(false, false, false, false, true, false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void lunestxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lunestxt1KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_lunestxt1KeyTyped

    private void lunestxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lunestxt2KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_lunestxt2KeyTyped

    private void martestxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_martestxt1KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_martestxt1KeyTyped

    private void martestxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_martestxt2KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_martestxt2KeyTyped

    private void miercolestxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miercolestxt1KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_miercolestxt1KeyTyped

    private void miercolestxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miercolestxt2KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_miercolestxt2KeyTyped

    private void juevestxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_juevestxt1KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_juevestxt1KeyTyped

    private void juevestxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_juevestxt2KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_juevestxt2KeyTyped

    private void viernestxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_viernestxt1KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_viernestxt1KeyTyped

    private void viernestxt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_viernestxt2KeyTyped
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_viernestxt2KeyTyped
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jueveslbl1;
    private javax.swing.JLabel jueveslbl2;
    private javax.swing.JTextField juevestxt1;
    private javax.swing.JTextField juevestxt2;
    private javax.swing.JLabel luneslbl1;
    private javax.swing.JLabel luneslbl2;
    private javax.swing.JTextField lunestxt1;
    private javax.swing.JTextField lunestxt2;
    private javax.swing.JLabel marteslbl1;
    private javax.swing.JLabel marteslbl2;
    private javax.swing.JTextField martestxt1;
    private javax.swing.JTextField martestxt2;
    private javax.swing.JLabel miercoleslbl1;
    private javax.swing.JLabel miercoleslbl2;
    private javax.swing.JTextField miercolestxt1;
    private javax.swing.JTextField miercolestxt2;
    private javax.swing.JLabel vierneslbl1;
    private javax.swing.JLabel vierneslbl2;
    private javax.swing.JTextField viernestxt1;
    private javax.swing.JTextField viernestxt2;
    // End of variables declaration//GEN-END:variables
}
