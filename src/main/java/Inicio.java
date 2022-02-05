
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mike
 */
public class Inicio {
    public static void main(String[] args) throws IOException{
        int opcionMenu = -1;
        String[] botones = {"1. Ver Gatos", "2. Ver Favoritos","3. Salir"};
        
        do{
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            
            for(int i=0;i<botones.length;i++){
                if(opcion.equals(botones[i])){
                    opcionMenu = i;
                }
            }
            
            switch(opcionMenu){
                case 0:
                    ServicioGatos.verGatos();
                    break;
                case 1:
                    Gatos gato = new Gatos();
                    ServicioGatos.verFavorito(gato.getApikey());
                    break;
                default:
                    break;
            }
        } while(opcionMenu != 1);
    }
}
