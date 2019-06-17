/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Palabras;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Edison
 */

public class Controlador {

    private String linea;
    private List<Palabras> lista;

    public Controlador() {
        lista = new ArrayList<>();
    }
    
    

    public void BOW(String ruta) throws IOException {
        linea = "";
        try {           
           FileReader archivo = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivo);
            while (linea != null) {
                linea = lectura.readLine();
                if(linea != null){
                    leerLinea();
                }              
            }
           
            

            
        } catch (FileNotFoundException ex) {
            System.out.println("no existe el archivo");
        } catch (IOException e) {
            System.err.println("Error de escritura");
        }

    }

    private void leerLinea() {
        String palabras[] = linea.split(" ");
        for(int i = 0; i <palabras.length;i++){
            compararPalabra(palabras[i].toLowerCase());
        }
    }

    private void compararPalabra(String palabra) {
        int con = 0;
        for (Palabras  palabralista: lista) {
            if (palabralista.getNombre().equals(palabra)) {
                palabralista.setCantidad(palabralista.getCantidad()+1);
                con = 1;
                break;
            }
        }
        if(con == 0){
            Palabras newPalabra = new Palabras();
            newPalabra.setNombre(palabra);
            newPalabra.setCantidad(1);
            lista.add(newPalabra);
        }
    }

    public void escribirPalabras() throws IOException {
        Collections.sort(lista, new Comparator<Palabras>(){
            public int compare(Palabras p1, Palabras p2){
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });
        try {
            String ruta = "Resultado.txt";
            FileWriter archio = new FileWriter(ruta, false);
            
            BufferedWriter escritura = new BufferedWriter(archio);
            for (Palabras palabraEscribir : lista) {
                escritura.append(palabraEscribir.getNombre()+" "+palabraEscribir.getCantidad());
                escritura.newLine();
            }
            
            escritura.close();
            archio.close();
            
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error de Escritura");
        }
    }
}
