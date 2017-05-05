package ipo_pr_final;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class BD_Helper {
    
    public static String PROFESOR = "PROFESOR";
    public static String ESTUDIANTE = "ESTUDIANTE";
    public static String pathHorarios = System.getProperty("user.dir")+File.separator+"horarios.txt";
    public static String path = System.getProperty("user.dir")+File.separator+"database.txt";
    public static String pathProfesor = System.getProperty("user.dir")+File.separator+"databaseProfesor.txt";
    public static int ALL = 0;
    public static int ONLY_STUDENTS = 1;
/* NOMBRE;CONTRASEÑA;ROL;EMAIL;ASIGNATURA;GRUPO;SUBGRUPO;ASIGNATURA...*/
    public static String[] getLines(int flag){
        ArrayList<String> lista = new ArrayList<>();
        try {
            FileReader f = new FileReader(path);
            BufferedReader b = new BufferedReader(f);
            String aux;
            while((aux = b.readLine())!=null){
                if(aux.split(";")[2].compareTo(PROFESOR)!=0 || flag==ALL)
                    lista.add(aux);
            }
            b.close();
        } catch (FileNotFoundException ex) {
            createNewBD();
            getLines(flag);
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista.toArray(new String[lista.size()]);
    }
    
    private static String getAluGr(String alulog, String asignatura){
        String lines[] = getLines(ONLY_STUDENTS);
        for(String s : lines){
            if(s.contains(alulog)){
                String aux[] = s.split(";");
                for(int i=0; i<aux.length; i++){
                    if(aux[i].compareTo(asignatura)==0){
                        return aux[i+1];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String getMaxAlusGrupo(String asignatura){
        String lines[] = getProfLines();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(asignatura)){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        return aux[j+3];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String[] getCompas(String asignatura, String grupo, String grupopr){
        String lines[] = getLines(ONLY_STUDENTS);
        ArrayList<String> members = new ArrayList<>();
        if(grupo.compareTo("-1")!=0 && grupopr.compareTo("-1")!=0){
            for(int i=0; i<lines.length; i++){
                if(lines[i].contains(asignatura)){
                    String aux[] = lines[i].split(";");
                    for(int j=0; j<aux.length; j++){
                        if(aux[j].compareTo(asignatura)==0){
                            if(aux[j+1].compareTo(grupo)==0 && aux[j+2].compareTo(grupopr)==0){
                                members.add(aux[0]);
                            }
                        }
                    }
                }
            }
        }
        return members.toArray(new String[members.size()]);
    }
    
    public static String getMinAlusGrupo(String asignatura){
        String lines[] = getProfLines();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(asignatura)){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        return aux[j+2];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String getStudentLine(String userlog){
        String lines[] = getLines(ONLY_STUDENTS);
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(";"+userlog+";")){
                return lines[i];
            }
        }
        return null;
    }
    
    private static String getAluGrTr(String alulog, String asignatura){
        String lines[] = getLines(ONLY_STUDENTS);
        for(String s : lines){
            if(s.contains(alulog)){
                String aux[] = s.split(";");
                for(int i=0; i<aux.length; i++){
                    if(aux[i].compareTo(asignatura)==0){
                        return aux[i+2];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String[] compGrTr(String alulog, String asignatura){
        String alugr = getAluGr(alulog, asignatura);
        String myGrTr = getAluGrTr(alulog, asignatura);
        if(myGrTr.compareTo("-1")==0) return null;
        
        String lines[] = getLines(ONLY_STUDENTS);
        ArrayList<String> alus = new ArrayList<>();
        for(String s : lines){
            if(s.contains(asignatura)){
                String aux[] = s.split(";");
                for(int i=0; i<aux.length; i++){
                    if(aux[i].compareTo(asignatura)==0){
                        if(aux[i+1].compareTo(alugr)==0 && aux[i+2].compareTo(myGrTr)==0){
                            alus.add(aux[0]);
                        }
                    }
                }
            }
        }
        return alus.toArray(new String[alus.size()]);
    }
    
    
    public static String[] getAlusSinGrTr(String alulog, String asignatura, boolean nombre){
        String alugr;
        if(nombre)
            alugr = alulog;
        else
            alugr = getAluGr(alulog, asignatura);
        String lines[] = getLines(ONLY_STUDENTS);
        ArrayList<String> alus = new ArrayList<>();
        for(String s : lines){
            if(s.contains(asignatura)){
                String aux[] = s.split(";");
                for(int i=0; i<aux.length; i++){
                    if(aux[i].compareTo(asignatura)==0){
                        if(aux[i+1].compareTo(alugr)==0 && aux[i+2].compareTo("-1")==0){
                            alus.add(aux[0]);
                        }
                    }
                }
            }
        }
        return alus.toArray(new String[alus.size()]);
    }
    
    public static String[][] getAlumnosAsigaturaGrupo(String asignatura){
        String lista[] = getLines(ONLY_STUDENTS);
        ArrayList<String[]> names = new ArrayList<>();
        
        for(int i=0; i<lista.length; i++){
            if(lista[i].contains(asignatura)){
                String[] aux = new String[2];
                String fields[] = lista[i].split(";");
                aux[0] = fields[0];
                aux[1] = fields[1];
                names.add(aux);
            }
        }
        return names.toArray(new String[names.size()][2]);
    }
    
    /* NOMBRE;CONTRASEÑA;GRUPO;GRUPOTRABAJO */
    public static String[] getAlumnos(){
        String[] lista = getLines(ONLY_STUDENTS);
        String[] names = new String[lista.length];
        for(int i=0; i<lista.length; i++){
            names[i] = (lista[i].split(";"))[0];
        }
        return names;
    }
    
    public static String[][] getAlusAsig(String asignatura){
        String lista[] = getLines(ONLY_STUDENTS);
        ArrayList<String[]> names = new ArrayList<>();
        for(int i=0; i<lista.length; i++){
            if(lista[i].contains(asignatura)){
                String n[] = new String[2];
                n[0] = lista[i].split(";")[0];
                n[1] = lista[i].split(";")[1];
                names.add(n);
            }
        }
        return names.toArray(new String[names.size()][2]);
    }
    
    public static String[] getAlumnos(String asignatura, String grupo){
        String[] lista = getLines(ONLY_STUDENTS);
        ArrayList<String> names = new ArrayList<>();
        for(int i=0; i<lista.length; i++){
            String[] fields = lista[i].split(";");
            for(int k=1; k<fields.length; k++){
                if(fields[k-1].compareTo(asignatura)==0 && fields[k].compareTo(grupo)==0){
                    names.add(fields[0]);
                }
            }
        }
        return names.toArray(new String[names.size()]);
    }
    /* NOMBRE;CONTRASEÑA;ROL;EMAIL;ASIGNATURA;GRUPO;SUBGRUPO;ASIGNATURA...*/
    public static String getName(String login){
        String list[] = getLines(ALL);
        for(int i=0; i<list.length; i++){
            String aux[] = list[i].split(";");
            if(aux[3].compareTo(login)==0) return aux[0];
        }
        return "UNKNOWN";
    }
    
    public static String[][] getAlumnosTrabajo(String grupo){
        String[] lista = getLines(ONLY_STUDENTS);
        ArrayList<String[]> names = new ArrayList<>();
        for(int i=0; i<lista.length; i++){
            String[] fields = lista[i].split(";");
            for(int k=0; k<fields.length; k++){
                if(fields[k].compareTo(grupo)==0){
                    String aux[] = {fields[0], fields[k+2]};
                    names.add(aux);
                }
            }
        }
        return names.toArray(new String[names.size()][2]);
    }
    
    public static String[] getProfLines(){
        ArrayList<String> lista = new ArrayList<>();
        try {
            FileReader f = new FileReader(pathProfesor);
            BufferedReader b = new BufferedReader(f);
            String aux;
            while((aux = b.readLine())!=null){
                lista.add(aux);
            }
            b.close();
        } catch (FileNotFoundException ex) {
            createNewBD();
            getLines(ALL);
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista.toArray(new String[lista.size()]);
    }
    
    public static void setGrTrAlu(String aluname, String asignatura, String newGrTr, JFrame context, AlumnoMainFrame ctx2){
        String lines[] = getLines(ALL);
        
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(aluname+";")){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        aux[j+2] = newGrTr;
                    }
                }
                lines[i] = aux[0];
                for(int k=1; k<aux.length; k++){
                    lines[i]+=";"+aux[k];
                }
            }
        }
        
        if(ctx2!=null){
            ConfirmDialog cd = new ConfirmDialog(lines, context, ctx2);
            int npx = context.getX()+context.getWidth()/2-cd.getWidth()/2;
            int npy = context.getY()+context.getHeight()/2-cd.getHeight()/2;
            cd.setLocation(npx, npy);        
            cd.setVisible(true);
        }else{
            BD_Helper.updateListAlus(lines);
        }
    }
    
    public static String getEmptyGroupIdWithCache(String alulog, String asignatura, boolean nombre, ArrayList<String> cache){
        String lines[] = getLines(ONLY_STUDENTS);
        String grup;
        if(nombre)
            grup = alulog;
        else
            grup = getAluGr(alulog, asignatura);
        ArrayList<String> lista = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            String aux[] = lines[i].split(";");
            for(int j=0; j<aux.length; j++){
                if(aux[j].compareTo(asignatura)==0){
                    if(aux[j+1].compareTo(grup)==0){
                        if(!isGroupContained(aux[j+2], lista)){
                            lista.add(aux[j+2]);
                        }
                    }
                }
            }
        }
        lista = ordenar(lista);
        int k;
        for(k=1; k<(lista.size()+1); k++){
            if(!isGroupContained(String.valueOf(k), lista) && !isGroupContained(String.valueOf(k), cache)){              
                return String.valueOf(k);
            }
        }
        return String.valueOf(k);
    }
    
    public static String getEmptyGroupId(String alulog, String asignatura, boolean nombre){
        String lines[] = getLines(ONLY_STUDENTS);
        String grup;
        if(nombre)
            grup = alulog;
        else
            grup = getAluGr(alulog, asignatura);
        ArrayList<String> lista = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            String aux[] = lines[i].split(";");
            for(int j=0; j<aux.length; j++){
                if(aux[j].compareTo(asignatura)==0){
                    if(aux[j+1].compareTo(grup)==0){
                        if(!isGroupContained(aux[j+2], lista)){
                            lista.add(aux[j+2]);
                        }
                    }
                }
            }
        }
        lista = ordenar(lista);
        int k;
        for(k=1; k<(lista.size()+1); k++){
            if(!isGroupContained(String.valueOf(k), lista)){             
                return String.valueOf(k);
            }
        }
        return String.valueOf(k);
    }
    
    public static ArrayList<String> ordenar(ArrayList<String> gruposs)
    {
        String grupos[] = gruposs.toArray(new String[gruposs.size()]);
        int ordgrupos[] = new int[grupos.length];
        for(int i=0; i<grupos.length; i++){
            ordgrupos[i] = Integer.parseInt(grupos[i]);
        }
        Arrays.sort(ordgrupos);
        for(int i=0; i<grupos.length; i++){
            grupos[i] = String.valueOf(ordgrupos[i]);
        }
        
        ArrayList<String> aux = new ArrayList<>(grupos.length);
        aux.addAll(Arrays.asList(grupos));
        return aux;
    }
    
    public static String[] getAsignaturas(String loginProfesor){
        String lista[] = getProfLines();
        String aux[] = null;
        for(int i=0; i<lista.length; i++){
            if(lista[i].split(";")[0].compareTo(loginProfesor)==0){
                aux = lista[i].split(";");
                break;
            }
        }
        if(aux==null)return null;
        
        ArrayList<String> names = new ArrayList<>();
        for(int i=1; i<aux.length; i+=8){
            names.add(aux[i]);
        }
        return names.toArray(new String[names.size()]);
    }
    
    public static void updateListAlus(String[] listAlumnos){
        String lProf[] = getProfLines();
        updateList(listAlumnos, lProf);
    }
    
    public static void updateList(String[] listAlumnos, String[] listProfesor){
        FileWriter fichero = null;
        FileWriter ficheroProf = null;
        try {
            /* NOMBRE;CONTRASEÑA;ROL;EMAIL;ASIGNATURA;GRUPO;SUBGRUPO;ASIGNATURA...*/
            fichero = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fichero);
            for(int i=0; i<listAlumnos.length; i++){
                pw.println(listAlumnos[i]);
            }   
            ficheroProf = new FileWriter(pathProfesor);
            pw = new PrintWriter(ficheroProf);
            for(int i=0; i<listProfesor.length; i++){
                pw.println(listProfesor[i]);
            } 
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichero.close();
                ficheroProf.close();
            } catch (IOException ex) {
                Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String[] getGrupos(String asignatura){
        String[] alumnosAsig = getLines(ONLY_STUDENTS);
        ArrayList<String> grupos = new ArrayList<>();
        for(int i=0; i<alumnosAsig.length; i++){
            String aux[] = alumnosAsig[i].split(";");
            if(alumnosAsig[i].contains(asignatura)){
                int index = -1;
                for(int k=0; k<aux.length; k++){
                    if(aux[k].compareTo(asignatura)==0)
                        index = k+1;
                }
                if(index!=-1){
                    if(!isGroupContained(aux[index], grupos)){
                        grupos.add(aux[index]);
                    }   
                }
            }
        }
        return grupos.toArray(new String[grupos.size()]);
    }
    
    private static boolean isGroupContained(String item, ArrayList<String> list){
        for(int i=0; i<list.size(); i++){
            if(item.compareTo(list.get(i))==0) return true;
        }
        return false;
    }
    
    /*-1 mal, 0 alumno, 1 profesor*/
    public static int checkLogin(String user, String password){
        String bdlist[] = getLines(ALL);
        for(int i=0; i<bdlist.length; i++){
            String fields[] = bdlist[i].split(";");
            if(fields[3].compareTo(user)==0 && fields[1].compareTo(password)==0){
                if(fields[2].compareTo(PROFESOR)==0) return 1;
                else return 0;
            }
        }
        return -1;
    }
    
    public static String[] getUniqueGrTr(String asignatura, String grupo){
        String lines[] = getLines(ONLY_STUDENTS);
        ArrayList<String> grupos = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(asignatura)){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        if(aux[j+1].compareTo(grupo)==0 && aux[j+2].compareTo("-1")!=0){
                            if(!isGroupContained(aux[j+2], grupos))
                                grupos.add(aux[j+2]);
                        }
                    }
                }
            }
        }
        return grupos.toArray(new String[grupos.size()]);
    }
    
    public static String[] getHorarioLines(){
        ArrayList<String> lista = new ArrayList<>();
        try{
            FileReader f = new FileReader(pathHorarios);
            BufferedReader b = new BufferedReader(f);
            String aux;
            while((aux = b.readLine())!=null){
                lista.add(aux);
            }
            b.close();
        } catch (FileNotFoundException ex) {
            createHorarioBD();
            getHorarioLines();
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista.toArray(new String[lista.size()]);
    }
    
    public static String[] getAsignaturasProfesor(String proflog){
        return getAsignaturas(proflog);
    }
    
    public static String getGrupoAsigAlu(String alulog, String asignatura){
        String lines[] = getLines(ONLY_STUDENTS);
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(alulog)){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        return aux[j+1];
                    }
                }
            }
        }
        return "-1";
    }
    
    public static String[] getGruposAsignaturaProfesor(String proflog, String asignatura){
        String lines[] = getProfLines();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(proflog)){
                String aux[] = lines[i].split(";");
                for(int j=0; j<aux.length; j++){
                    if(aux[j].compareTo(asignatura)==0){
                        int nGrupos = Integer.parseInt(aux[j+1]);
                        if(nGrupos < 1) return null;
                        String grupos[] = new String[nGrupos];
                        for(int k=0; k<nGrupos; k++){
                            grupos[k] = String.valueOf(k+1);
                        }
                        return ListCreator.ordenar(grupos);
                    }
                }
            }
        }
        return null;
    }
    
    // PROFESOR;ASIGNATURA;GRUPO;LI;LF;MI;MF;XI;XF;JI;JF;VI;VF
    public static void updateHorario(String asignatura, String grupo, String formatedLine){
        String alines[] = getHorarioLines();
        boolean found = false;
        for(int i=0; i<alines.length; i++){
            String aux[] = alines[i].split(";");
            if(aux[1].compareTo(asignatura)==0 && aux[2].compareTo(grupo)==0){
                alines[i] = formatedLine;
                found = true;
            }
        }
        
        String lines[];
        
        if(!found){
            lines = new String[alines.length+1];
            int i;
            for(i=0; i<alines.length; i++){
                lines[i] = alines[i];
            }
            lines[i] = formatedLine;
        }else{
            lines = alines;
        }
        
        FileWriter fichero = null;
        try {
            /* NOMBRE;CONTRASEÑA;ROL;EMAIL;ASIGNATURA;GRUPO;SUBGRUPO;ASIGNATURA...*/
            fichero = new FileWriter(pathHorarios);
            PrintWriter pw = new PrintWriter(fichero);
            for(int i=0; i<lines.length; i++){
                pw.println(lines[i]);
            }   
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String[] getAsignaturasAlumno(String alulog){
        String lines[] = getLines(ONLY_STUDENTS);
        ArrayList<String> asigs = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(alulog)){
                String aux[] = lines[i].split(";");
                for(int j=4; j<aux.length; j+=5){
                    asigs.add(aux[j]);
                }
                return asigs.toArray(new String[asigs.size()]);
            }
        }
        return null;
    }
    
    public static String[] getAsignaturasAlumnoGrupoAbierto(String alulog){
        String asignaturas[] = getAsignaturasAlumno(alulog);
        ArrayList<String> filtered = new ArrayList<>();
        for(String s : asignaturas){
            if(isGroupOpen(s))
                filtered.add(s);
        }
        return filtered.toArray(new String[filtered.size()]);
    }
    
    public static boolean isGroupOpen(String asignatura){
        String lines[] = getProfLines();
        for(int i=0; i<lines.length; i++){
            if(lines[i].contains(asignatura+";")){
                String aux[] = lines[i].split(";");
                for(int k=0; k<aux.length; k++){
                    if(aux[k].compareTo(asignatura)==0)
                        return (aux[k+7].compareTo("0") != 0);
                }
            }
        }
        return false;
    }
    
    public static String[][] getHorario(String asignatura, String grupo){
        String horario[][] = new String[5][2];
        String lines[] = getHorarioLines();
        if(lines == null) return null;
        for(int i=0; i<lines.length; i++){
            String aux[] = lines[i].split(";");
            if(aux[1].compareTo(asignatura)==0 && aux[2].compareTo(grupo)==0){
                horario[0][0] = aux[3];
                horario[0][1] = aux[4];
                horario[1][0] = aux[5];
                horario[1][1] = aux[6];
                horario[2][0] = aux[7];
                horario[2][1] = aux[8];
                horario[3][0] = aux[9];
                horario[3][1] = aux[10];
                horario[4][0] = aux[11];
                horario[4][1] = aux[12];
                return horario;
            }
        }
        return null;
    }
 
    public static void createHorarioBD(){
        FileWriter fichero = null;
        try{
            fichero = new FileWriter(pathHorarios);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try {
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void createNewBD(){
        FileWriter fichero = null;
        FileWriter ficheroProf = null;
        File f1 = new File(path), f2 = new File(pathProfesor);
        if(f1.exists() && f2.exists())return;
        
        try {
            /* NOMBRE;CONTRASEÑA;ROL;EMAIL;ASIGNATURA;GRUPO;SUBGRUPO;CAMBIOGRUPO;CAMBIOSUBGRUPO;ASIGNATURA...*/
            fichero = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fichero);
            pw.println("Profesor 1;1234;"+PROFESOR+";profesor1@usal.es;");
            pw.println("Profesor 2;1234;"+PROFESOR+";profesor2@usal.es;");
            for(int i=0; i<60; i++){
                if(i%3==0){
                    pw.println("Alumno "+(i+1)+";1234;"+ESTUDIANTE+";alumno"+(i+1)+"@usal.es;Diseño de Interfaces;-1;-1;-1;-1;Tecnología de Computadores A;-1;-1;-1;-1");
                }else if (i%3==1){
                    pw.println("Alumno "+(i+1)+";1234;"+ESTUDIANTE+";alumno"+(i+1)+"@usal.es;Tecnología de Computadores B;-1;-1;-1;-1;Interacción Persona-Ordenador A;-1;-1;-1;-1");
                }else{
                    pw.println("Alumno "+(i+1)+";1234;"+ESTUDIANTE+";alumno"+(i+1)+"@usal.es;Tecnología de Computadores C;-1;-1;-1;-1;Interacción Persona-Ordenador B;-1;-1;-1;-1;Diseño de Interfaces;-1;-1;-1;-1;");
                }
            }       
         
            ficheroProf = new FileWriter(pathProfesor);
            pw = new PrintWriter(ficheroProf);
            /*NOMBRE;ASIG1;NGRUPOS;MIN;MAX;GTR;MIN;MAX;GRTRABIERTO;ASIG2...*/
            pw.println("profesor1@usal.es;Interacción Persona-Ordenador A;0;0;0;0;0;0;0;Interacción Persona-Ordenador B;0;0;0;0;0;0;0;Diseño de Interfaces;0;0;0;0;0;0;0");
            pw.println("profesor2@usal.es;Tecnología de Computadores A;0;0;0;0;0;0;0;Tecnología de Computadores B;0;0;0;0;0;0;0;Tecnología de Computadores C;0;0;0;0;0;0;0");
        } catch (IOException ex) {
            Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichero.close();
                ficheroProf.close();
            } catch (IOException ex) {
                Logger.getLogger(BD_Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

