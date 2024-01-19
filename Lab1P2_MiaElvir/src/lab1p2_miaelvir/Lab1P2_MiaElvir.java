
package lab1p2_miaelvir;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lab1P2_MiaElvir {

    static Scanner papoy = new Scanner(System.in); 
    static ArrayList<Usuario> Usuarios = new ArrayList<>(); 
    
    public static void main(String[] args) throws ParseException {
       
        System.out.println("--- MENU ---\n1. Registrar Usuario\n2. Listar todo\n3. Listar por dominio\n4. Salir\nIngrese su eleccion: ");
        int elecUser = papoy.nextInt(); 
        
        while (elecUser > 0 && elecUser < 5){
        
            switch (elecUser){
                case 1: 
                    System.out.println("\n---  Registrar Usuario ---\nIngrese su nombre: ");
                    String nombreUser = papoy.next(); 
                    System.out.println("Ingrese su apellido: ");
                    String apellidoUser = papoy.next(); 
                    System.out.println("Ingrese su fecha de nacimiento en el formato (dd/mm/yyyy): ");
                    String fechaInicial = papoy.next(); 
                    
                    String [] fecha_user = fechaInicial.split("/"); 
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaFinal_user = df.parse(fechaInicial); 
                    
                    
                    Date fechaActual = new Date(); 
                    /*
                    int fechanuevadia = fechaActual.getDay()-fechafinal.getday();
                   
                    
                    
                    */
                    SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy"); 
                    String fechaHoy = df2.format(fechaActual);
                    String [] fechaA = fechaHoy.split("/"); 
                    if ((fechaActual.getYear()-fechaFinal_user.getYear())<12){
                        System.out.println("No esta en el rango de edad para crear un Usuario");
                        break; 
                    }
                    Date fechanueva = new Date(fechaActual.getYear()-fechaFinal_user.getYear(), fechaActual.getMonth()-fechaFinal_user.getMonth(), fechaActual.getDate()-fechaFinal_user.getDate()); 
                    
                    System.out.println("Ingrese su correo electronico con uno de los siguientes dominios\n- gmail - outlook - yahoo - icloud - protonmail"
                            + "- fastmail -");
                    String correoUser = papoy.next(); 
                    while (ValidacionEmail(correoUser) == false){
                        System.out.println("El correo no es valido\nVuelva a Ingresarlo: ");
                        correoUser = papoy.next();
                    }
                    System.out.println("Ingrese su contraseña: ");
                    String contraUser = papoy.next(); 
//                    while (ValidacionPass(contraUser) == false){
//                        System.out.println("La contraseña no es valida\nVuelva a Ingresarla: ");
//                        contraUser = papoy.next();
//                    }
                    
                    
//                    if (ValidacionEmail(correoUser) == true){
//                        if (correoUser.substring(correoUser.indexOf("@")).contains("gmail") || correoUser.substring(correoUser.indexOf("@")).contains("outlook")
//                                || correoUser.substring(correoUser.indexOf("@")).contains("yahoo") || correoUser.substring(correoUser.indexOf("@")).contains("icloud")
//                                || correoUser.substring(correoUser.indexOf("@")).contains("protonmail") || correoUser.substring(correoUser.indexOf("@")).contains("fastmail")){
//                            System.out.println("Ingrese su contraseña: ");
//                            String passUser = papoy.next(); 
//                        }
//                    }else{
//                        System.out.println("El correo no es admitido\nVuelvalo a Ingresar: ");
//                        correoUser = papoy.next(); 
                     Usuarios.add(new Usuario(nombreUser, apellidoUser, fechanueva, correoUser, contraUser)); 
                    break; 
                case 2: 
                    System.out.println("--- Listado ---");
                    for (int i = 0; i < Usuarios.size(); i++) {
                        Usuario impre = Usuarios.get(i); 
                        System.out.println((i+1)+". "+impre.toString());
                    }
                    break; 
                case 3: 
                    for (int i = 0; i < Usuarios.size(); i++) {
                        Usuario impre = Usuarios.get(i); 
                        if (impre.getCorreoElectronico().contains("gmail")){
                            System.out.println(impre.toString());
                        }
                    }
                    for (int i = 0; i < Usuarios.size(); i++) {
                        Usuario impre = Usuarios.get(i); 
                        if (impre.getCorreoElectronico().contains("outlook")){
                            System.out.println(impre.toString());
                        }
                    }
                    
                    break; 
                
                    
            }//fin switch
            System.out.println("--- MENU ---\n1. Registrar Usuario\n2. Listar todo\n3. Listar por dominio\n4. Salir\nIngrese su eleccion: ");
            elecUser = papoy.nextInt(); 
        
        }//fin While   
    }//fin main
    
    
    public static boolean ValidacionEmail(String correo){
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
    public static boolean ValidacionPass(String contra){
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contra);
        return matcher.matches();
    }
    
    
    
}//fin clase
