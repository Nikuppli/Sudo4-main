package view;
import javafx.scene.Parent;
import java.io.IOException;
//FXML Loader


public class FXMLLoader {
    private FXMLLoader() {
    }

    public static Parent loadFXML(String fxmlFile, String resourceFolder) throws IOException {
        javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(FXMLLoader.class.getResource(String.format("/%s/%s.fxml", resourceFolder, fxmlFile)));
        return fxmlLoader.load();
    }
}
