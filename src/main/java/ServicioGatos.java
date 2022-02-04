
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mike
 */
public class ServicioGatos {
    public static void verGatos() throws IOException{
        // Traer datos de la API
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        Response response = client.newCall(request).execute();
        
        String elJson = response.body().string();
        
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);
        
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        
        Image image = null;
        try{
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato = new ImageIcon(image);
            
            if (fondoGato.getIconWidth() > 800){
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            String menu = "Opciones:\n " + "1.  Ver otro gato\n" + "2. Favorito\n" + "3. Volver al menu\n";
            String[] botones = {"Ver otra imagen", "Favorito", "Volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);
            
            int seleccion = -1;
            for(int i=0;i<botones.length;i++){
                if(opcion.equals(botones[i])){
                    seleccion = i;
                }
            }
            
            switch (seleccion) {
                case 0:
                    verGatos();
                    break;
                case 1: 
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void favoritoGato(Gatos gato) {
        
    }
}
