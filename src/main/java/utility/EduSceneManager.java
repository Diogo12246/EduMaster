package utility;

//import Controller.PlanetCatalogController;
import javafx.scene.layout.AnchorPane;


public class EduSceneManager {

//    private static PlanetCatalogController planetCatalogger;

    public static void getPlaceHolderAnchorPane(AnchorPane box) {
//        planetCatalogger = planetCatalogger == null ? new PlanetCatalogController() : planetCatalogger;
//        config(box, planetCatalogger);
    }

    public static void config(AnchorPane box, AnchorPane content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}
