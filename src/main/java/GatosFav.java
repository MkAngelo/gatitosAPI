
import io.github.cdimascio.dotenv.Dotenv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mike
 */
public class GatosFav {
    Dotenv dotenv = Dotenv.load();
    String id;
    String image_id;
    String apikey = dotenv.get("KEY");
    Imagenx image;

    public Dotenv getDotenv() {
        return dotenv;
    }

    public void setDotenv(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen_id() {
        return image_id;
    }

    public void setImagen_id(String imagen_id) {
        this.image_id = imagen_id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Imagenx getImagen() {
        return image;
    }

    public void setImagen(Imagenx imagen) {
        this.image = imagen;
    }
}
