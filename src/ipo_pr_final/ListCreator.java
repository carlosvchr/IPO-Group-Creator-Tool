/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_pr_final;

import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Carlos
 */
public class ListCreator{
    
    public static UpdateListInterface contextCaller = null;
    
    public ListCreator()
    {
        //TODO
    }
    
    public static JPanel getAlusSinGrTr(String alulog, String asignatura){
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        String lines[] = BD_Helper.getAlusSinGrTr(alulog, asignatura, false);
        if(lines==null)return createEmptyList();
        JScrollPane jsp = new JScrollPane(makeList(h, lines));
        p.add(jsp);
                
        p.setBackground(new Color(0xfafafa));
        return p;
    }
    
    
    public static JPanel getAlusMiGrupo(String alulog, String asignatura){
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        String lines[] = BD_Helper.compGrTr(alulog, asignatura);
        if(lines == null) return createEmptyList();
        JScrollPane jsp = new JScrollPane(makeList(h, lines));
        p.add(jsp);
        
        p.setBackground(new Color(0xfafafa));
        return p;
    }
    
    
    public static JPanel createEmptyList(){
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        String alumnos[] = {};
        p.add(makeList(h, alumnos));
        p.setBackground(new Color(0xfafafa));
        return p;
    }
    
    public static JPanel getGrTrPanel(String asignatura, String subgrupo, String grupo){
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        String lines[] = BD_Helper.getLines(BD_Helper.ONLY_STUDENTS);
        ArrayList<String> lista = new ArrayList<>();
        for(int i=0; i<lines.length; i++)
        {
            if(lines[i].contains(asignatura))
            {
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        if(aux[j+1].compareTo(grupo)==0 && aux[j+2].compareTo(subgrupo)==0){
                            lista.add(aux[0]);
                        }
                    }
                }
            }
        }
        
        JScrollPane jsp = new JScrollPane(makeList(h, lista.toArray(new String[lista.size()]), true, asignatura, "-1"));
        p.add(jsp);
        
        p.setBackground(new Color(0xfafafa));
        return p;
    }
    
    public static JPanel getPanelGrupos(String asignatura, String grupo)
    {
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        String[] gruposs = BD_Helper.getUniqueGrTr(asignatura, grupo);
        String lines[] = BD_Helper.getLines(BD_Helper.ONLY_STUDENTS);
        
        String[] grupos = ordenar(gruposs);
        
        for(int i=0; i<grupos.length; i++){
            ArrayList<String> alusGrupo = new ArrayList<String>();
            for(int j=0; j<lines.length; j++){
                if(lines[j].contains(asignatura)){
                    String fields[] = lines[j].split(";");
                    for(int k=0; k<fields.length; k++){
                        if(fields[k].compareTo(asignatura)==0)
                        {
                            if(fields[k+1].compareTo(grupo)==0 && fields[k+2].compareTo(grupos[i])==0)
                            {
                                alusGrupo.add(fields[0]);
                            }
                        }
                    }
                }
            }
            JScrollPane jsp = new JScrollPane(makeList(h, alusGrupo.toArray(new String[alusGrupo.size()]), true, asignatura, grupos[i]));
            jsp.setBorder(BorderFactory.createTitledBorder("GrupoTr "+grupos[i]));
            p.add(jsp);
        }
        
        p.setBackground(new Color(0xfafafa));
        return p;
    }
    
    public static String[] ordenar(String grupos[])
    {
        int ordgrupos[] = new int[grupos.length];
        for(int i=0; i<grupos.length; i++){
            ordgrupos[i] = Integer.parseInt(grupos[i]);
        }
        Arrays.sort(ordgrupos);
        for(int i=0; i<grupos.length; i++){
            grupos[i] = String.valueOf(ordgrupos[i]);
        }
        
        return grupos;
    }
    
    public static JPanel addEmptyPanel(String asignatura, String grupo)
    {
        JPanel p = getPanelGrupos(asignatura, grupo);
        TransferHandler h = new ListItemTransferHandler();
        String[] gruposs = BD_Helper.getUniqueGrTr(asignatura, grupo);
        String aux[] = {};
        
        String grupos[] = ordenar(gruposs);
        
        String mgrupo = BD_Helper.getEmptyGroupId(grupo, asignatura, true);
        JScrollPane jsp = new JScrollPane(makeList(h, aux, true, asignatura, mgrupo));
        jsp.setBorder(BorderFactory.createTitledBorder("GrupoTr "+mgrupo));
        p.add(jsp);
        
        p.setBackground(new Color(0xfafafa));
        return p;
    }

    
    public static JPanel getPanel(String userlogin, String asignatura)
    {
        JPanel p = new JPanel();
        TransferHandler h = new ListItemTransferHandler();
        p.setBorder(BorderFactory.createTitledBorder("Listado de grupos"));
        String alusAsig[] = BD_Helper.getLines(BD_Helper.ONLY_STUDENTS);
        String listGrupos[] = BD_Helper.getGrupos(asignatura);
        listGrupos = ordenar(listGrupos);
        ArrayList<String> alumnos;
        for(int i=0; i<listGrupos.length; i++){
            alumnos = new ArrayList<>();
            for(int j=0; j<alusAsig.length; j++){
                String _aux[] = alusAsig[j].split(";");
                int index = -1;
                for(int k=0; k<_aux.length; k++)
                {
                    if(_aux[k].compareTo(asignatura)==0)
                        index = k+1;
                }
                if(index!=-1){
                    if(_aux[index].compareTo(listGrupos[i])==0 && alusAsig[j].contains(asignatura))
                        alumnos.add(_aux[0]);
                }
            }
            String ngrupo = (listGrupos[i].compareTo("-1")==0)? "Sin asignar":("GRUPO "+listGrupos[i]);
            JScrollPane jsp = new JScrollPane(makeList(h, alumnos.toArray(new String[alumnos.size()]), false, asignatura, ngrupo.substring(6)));         
            String maxGrupos = BD_Helper.getMaxAlusGrupo(asignatura);
            if(maxGrupos.compareTo("-1")!=0){
                ngrupo+=" ("+alumnos.size()+"/"+BD_Helper.getMaxAlusGrupo(asignatura)+")";
            }
            jsp.setBorder(BorderFactory.createTitledBorder(ngrupo));
            TitledBorder tb = (TitledBorder)jsp.getBorder();
            if(alumnos.size() > Integer.parseInt(BD_Helper.getMaxAlusGrupo(asignatura)))
                tb.setTitleColor(Color.red);
            
            if(alumnos.size() < Integer.parseInt(BD_Helper.getMinAlusGrupo(asignatura))){
                tb.setTitleColor(Color.red);
            }
            
            p.setBackground(new Color(0xfafafa));
            p.add(jsp);            
        }
        
        return p;
    }
    
    private static JList<String> makeList(TransferHandler handler, String alumnos[]){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        for(int i=0; i<alumnos.length; i++){
            listModel.addElement(alumnos[i]);
        }
        listModel.addElement("                               ");
        
        JList<String> list = new JList<>(listModel);
        
        
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                JLabel lc = (JLabel)c;
                lc.setText(lc.getText());  
                return c;
            }
        });
        list.setSelectionModel(new DisabledItemSelectionModel());
        list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setDropMode(DropMode.INSERT);
        list.setDragEnabled(true);
        list.setTransferHandler(handler);

        //Disable row Cut, Copy, Paste
        ActionMap map = list.getActionMap();
        AbstractAction dummy = new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) { /* Dummy action */ }
        };
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),   dummy);
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),  dummy);
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME), dummy);

        list.setSize(400, 600);
        return list;
    }
    
    
    private static JList<String> makeList(TransferHandler handler, String alumnos[], boolean grtr, String asignatura, String grup) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        for(int i=0; i<alumnos.length; i++){
            listModel.addElement(alumnos[i]);
        }

        listModel.addElement("                               ");
        
        JList<String> list = new JList<>(listModel);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(list.getSelectedIndex()==list.getLastVisibleIndex()){ 
                    list.clearSelection();
                }
            }
        });
        
        list.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JList l = (JList)e.getSource();
                ListModel m = l.getModel();
                int index = l.locationToIndex(e.getPoint());
                if( index>-1 ) {
                    String gralu = getGrAlumno(m.getElementAt(index).toString(), asignatura);
                    if(gralu.contains(":")){
                        if(gralu.split(":")[1].compareTo("-3")==0){
                            l.setToolTipText(gralu.split(":")[2]);
                        }else if(gralu.split(":")[1].compareTo("-2")==0){
                            l.setToolTipText("Horarios incompatibles");
                        }else if(gralu.split(":")[1].compareTo("-1")==0){
                            l.setToolTipText("Preferencia");
                        }else{
                            l.setToolTipText(null);
                        }
                    }
                }
            }
        });
        
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                JLabel lc = (JLabel)c;
                String grtralu = getGrTrAlumno(lc.getText(), asignatura);
                String gralu = getGrAlumno(lc.getText(), asignatura);
                if(grtr && grtralu.compareTo("-1")!=0 ){
                    lc.setText(lc.getText()+" (->"+grtralu+")");
                    lc.setBackground(Color.yellow);
                }else if(!grtr && gralu.compareTo("-1")!=0 && gralu.compareTo(grup)!=0){
                    lc.setText(lc.getText()+" (->"+gralu.split(":")[0]+")");
                    if(gralu.split(":")[1].compareTo("-1")==0)
                        lc.setBackground(Color.cyan);
                    else if(gralu.split(":")[1].compareTo("-2")==0)
                        lc.setBackground(Color.yellow);
                    else
                        lc.setBackground(Color.orange);
                        
                }
                if(ProfesorMainFrame.alusearch.length()>0){
                    if(lc.getText().toLowerCase().contains(ProfesorMainFrame.alusearch)){
                        lc.setBackground(Color.green);
                    }
                }
                
                return c;
            }
        });
        list.setSelectionModel(new DisabledItemSelectionModel());
        list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setDropMode(DropMode.INSERT);
        list.setDragEnabled(true);
        list.setTransferHandler(handler);

        //Disable row Cut, Copy, Paste
        ActionMap map = list.getActionMap();
        AbstractAction dummy = new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) { /* Dummy action */ }
        };
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),   dummy);
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),  dummy);
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME), dummy);

        list.setSize(400, 600);
        return list;
    }

    public static String getGrTrAlumno(String alumno, String asignatura){
        String lines[] = BD_Helper.getLines(BD_Helper.ONLY_STUDENTS);
        for(String s : lines){
            if(s.contains(alumno)){
                String fields[] = s.split(";");
                for(int i=0; i<fields.length; i++){
                    if(fields[i].compareTo(asignatura)==0){
                        return fields[i+4];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String getGrAlumno(String alumno, String asignatura){
        String lines[] = BD_Helper.getLines(BD_Helper.ONLY_STUDENTS);
        for(String s : lines){
            if(s.contains(alumno)){
                String fields[] = s.split(";");
                for(int i=0; i<fields.length; i++){
                    if(fields[i].compareTo(asignatura)==0){
                        return fields[i+3];
                    }
                }
            }
        }
        return "-1";
    }
    
}

//Demo - BasicDnD (Drag and Drop and Data Transfer)>http://docs.oracle.com/javase/tutorial/uiswing/dnd/basicdemo.html
class ListItemTransferHandler extends TransferHandler {
    private final DataFlavor localObjectFlavor;
    private JList source;
    private int[] indices;
    private int addIndex = -1; //Location where items were added
    private int addCount; //Number of items added.

    public ListItemTransferHandler() {
        super();
        localObjectFlavor = new ActivationDataFlavor(Object[].class, DataFlavor.javaJVMLocalObjectMimeType, "Array of items");
    }
    @Override protected Transferable createTransferable(JComponent c) {
        source = (JList) c;
        indices = source.getSelectedIndices();
        @SuppressWarnings("deprecation") Object[] transferedObjects = source.getSelectedValues();
        return new DataHandler(transferedObjects, localObjectFlavor.getMimeType());
    }
    
    @Override public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDrop() && info.isDataFlavorSupported(localObjectFlavor);
    }
    @Override public int getSourceActions(JComponent c) {
        return MOVE; //TransferHandler.COPY_OR_MOVE;
    }
    @SuppressWarnings("unchecked")
    @Override public boolean importData(TransferHandler.TransferSupport info) {
        if (!canImport(info)) {
            return false;
        }
        TransferHandler.DropLocation tdl = info.getDropLocation();
        if (!(tdl instanceof JList.DropLocation)) {
            return false;
        }
        JList.DropLocation dl = (JList.DropLocation) tdl;
        JList target = (JList) info.getComponent();
        DefaultListModel listModel = (DefaultListModel) target.getModel();
        int index = dl.getIndex();
        //boolean insert = dl.isInsert();
        int max = listModel.getSize();
        if (index < 0 || index > max) {
            index = max;
        }
        addIndex = index;

        try {
            Object[] values = (Object[]) info.getTransferable().getTransferData(localObjectFlavor);
            for (int i = 0; i < values.length; i++) {
                int idx = index++;
                listModel.add(idx, values[i]);
                target.addSelectionInterval(idx, idx);
            }
            addCount = target.equals(source) ? values.length : 0;
            return true;
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override protected void exportDone(JComponent c, Transferable data, int action) {
        cleanup(c, action == MOVE);
        if(ListCreator.contextCaller != null)
        {
            ListCreator.contextCaller.updateDataBase();
        }
        
    }
    private void cleanup(JComponent c, boolean remove) {
        if (remove && indices != null) {
            //If we are moving items around in the same list, we
            //need to adjust the indices accordingly, since those
            //after the insertion point have moved.
            if (addCount > 0) {
                for (int i = 0; i < indices.length; i++) {
                    if (indices[i] >= addIndex) {
                        indices[i] += addCount;
                    }
                }
            }
            JList source = (JList) c;
            DefaultListModel model  = (DefaultListModel) source.getModel();
            for (int i = indices.length - 1; i >= 0; i--) {
                model.remove(indices[i]);
            }
        }
        indices  = null;
        addCount = 0;
        addIndex = -1;
    }
}

class DisabledItemSelectionModel extends DefaultListSelectionModel {

    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(0, index1);
    }
}

