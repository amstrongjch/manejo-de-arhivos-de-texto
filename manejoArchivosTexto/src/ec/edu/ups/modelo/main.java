/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.controlador.Controlador;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Amstrong
 */
public class main {
    public static void main(String[]args) throws IOException{
        Controlador co = new Controlador();
        String ruta = "C:\\Users\\Amstrong\\Documents\\NetBeansProjects\\manejo-de-arhivos-de-texto\\manejoArchivosTexto\\src\\ec\\edu\\ups\\archivos";
            File archivo = new File(ruta);
            File[] archivos = archivo.listFiles();
            for (File newarchivo : archivos) {
                if (!newarchivo.getName().equals("Resultado.txt")) {
                    co.BOW(ruta+"\\"+newarchivo.getName());
                }
            }
        co.escribirPalabras();
    }
}
