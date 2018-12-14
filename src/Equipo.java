/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author ulloa
 */
public class Equipo {
    RandomAccessFile codigo,jugadores,equipos;
    public Equipo(){
        try{
            new File("ligaNacional").mkdirs();
            codigo= new RandomAccessFile("ligaNacional/codigo.txt","rw");
            jugadores= new RandomAccessFile("ligaNacional/jugadores.txt","rw");
            equipos = new RandomAccessFile("ligaNacional/equipos.txt","rw");
            initCodes();
        }catch(Exception e){
            
        }
    }
    
    private void initCodes()throws IOException{
        if(codigo.length()==0){
            codigo.writeInt(1);
            codigo.writeInt(1);
            codigo.writeInt(1);
            codigo.writeInt(1);
            
        }
    }
    //---------------------------------------------------------------------------------------------------------
    private int getCodigo()throws IOException{
        codigo.seek(0);
        int code=codigo.readInt();
        codigo.seek(0);
        codigo.writeInt(code+1);
        return code;
    }
    //---------------------------------------------------------------------------------------------------------
    public void equipos(String nombre, String ciudad, int capaEstadio)throws IOException{
        equipos.seek(equipos.length());
        int code = getCodigo();
        equipos.writeInt(code);
        equipos.writeUTF(nombre);
        equipos.writeUTF(ciudad);
        equipos.writeInt(capaEstadio);
    }
    
    //---------------------------------------------------------------------------------------------------
    public void jugadores(int equipo, String nombre,int dorsal,String posicion,int edad,String Nacionalidad)throws IOException{
        jugadores.seek(jugadores.length());
        
        
        jugadores.writeInt(equipo);
        jugadores.writeUTF(nombre);
        jugadores.writeInt(dorsal);
        jugadores.writeUTF(posicion);
        jugadores.writeInt(edad);
        jugadores.writeUTF(Nacionalidad);
    }
    
    public boolean eliminarEquipo(int code)throws IOException{
     equipos.seek(0);
     int codigo;
     while(equipos.getFilePointer()<equipos.length()){
         codigo=equipos.readInt();
      
         if(codigo==code){
         equipos.writeUTF(null);
         equipos.writeUTF(null);
         equipos.writeInt(0);
         }
             
     
     }
     System.out.println("Codigo no existe");
     return false;
     }
    
}
