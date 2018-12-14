
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ulloa
 */
public class LigaNacionalMain {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        lea.useDelimiter("\n");
        int elec=0;
        Equipo var= new Equipo();
        do {
            try{
                
            System.out.println("------------------P R O G R A M A   D E   L A   L I G A   N A C I O N A L ----------------------------");
            System.out.println("INGRESE EL NUMERO DE SU ELECION: ");
            System.out.println("1. AGREGAR UN EQUIPO \n2. AGREGAR UN JUGADOR \n3.MODIFICAR O ELIMINAR UN EQUIPO \n4.REPORTES \n5.SALIR");
            elec=lea.nextInt();
            
            switch(elec){
                case 1 :
                    System.out.println("AGREGAR UN EQUIPO");
                    System.out.println("Ingrese el nombre del Equipo: ");
                    String eNombre= lea.nextLine();
                    System.out.println("Ingrese el nombre de la ciudad sede del equipo: ");
                    String ciudad= lea.nextLine();
                    System.out.println("Ingrese la capacidad de aficionados del estadio del equipo: ");
                    int capacidad= lea.nextInt();
                    var.equipos(eNombre,ciudad,capacidad);
                    System.out.println("Equipo Agregado Exitosamente: ");
                    break;
                    
                case 2:
                    System.out.println("AGREGAR UN JUGADOR");
                    System.out.println("Ingrese el codigo del equipo al que pertenecera el jugador: ");
                    int codEquipo = lea.nextInt();
                    System.out.println("Ingrese el nombre completo del Jugador: ");
                    String JugaNombre = lea.nextLine();
                    System.out.println("Ingrese el dorsal del jugador: ");
                    int dorsal = lea.nextInt();
                    System.out.println("En que posicion jugara "+JugaNombre+"?");
                    System.out.println("Ingrese el numero de su eleccion: ");
                    System.out.println("1.Delantero , 2.Defensa, 3.MedioCampista, 4.Portero ");
                    int posi= lea.nextInt();
                    String posicion="";
                    if (posi==1) {
                        posicion="Del";
                    }if (posi==2) {
                        posicion="Def";
                    }if (posi==3) {
                        posicion="Med";
                    }if (posi==4) {
                        posicion="Po";
                    }
                    System.out.println("Ingrese la edad del Jugador: ");
                    int edad = lea.nextInt();
                    System.out.println("Ingrese la nacionalidad de "+JugaNombre);
                    String nacio = lea.nextLine();
                    System.out.println("Su jugador ha sido agregado exitosamente");
                    
                    var.jugadores(codEquipo,JugaNombre,dorsal,posicion,edad,nacio);
                    break;
                    
                case 3:
                    System.out.println("MODIFICAR O ELIMINAR UN EQUIPO");
                    int elecBravo=0;
                    do{
                        System.out.println("Ingrese una de las siguientes opciones: ");
                        System.out.println("1.Modificar Equipo \n2.Eliminar un Equipo \n3.Salir");
                        elecBravo = lea.nextInt();
                        switch(elecBravo){
                            case 1:
                                System.out.println("Modicar Equipo");
                                break;
                                
                            case 2:
                                System.out.println("Eliminar un equipo: ");
                                System.out.println("Ingrese el codigo del equipo: ");
                                int codigoequipp = lea.nextInt();
                                var.eliminarEquipo(codigoequipp);
                        }
                        
                    }while(elecBravo!=3);
                    break;
                    
                case 4: 
                    int elec2=0;
                    do{
                        System.out.println("REPORTES : ");
                        System.out.println("Ingrese una de las siguientes opciones del reporte a elaborar: ");
                        System.out.println("1.Listado de los Equipos \n2.Listado de todos los Jugadores \n3.Listar Equipos con Jugadores \n4.Mostrar los jugadores  de determinada posicion \n5. Atributos de Equipos");
                        elec2= lea.nextInt();
                        switch(elec2){
                            case 1: 
                                System.out.println("Listado de los Equipos");
                                var.equipos.seek(0);
                                
                        }
                    }while(elec2!=6);
                    break;
                    
                case 5: 
                    System.out.println("SALIENDO . . . . .");
            }
            
            }catch(Exception e){
                
            }
        } while (elec!=4);
        
    }
}
