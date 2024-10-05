package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        var content = new VBox();
        content.setSpacing(10);
        content.setStyle("""
            -fx-background-image: url('data:image/png;base64,\
            iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAAAXNSR0IArs4c6QAAAD9JREFUOE9jdHBw+M9ABDAwMCB\
            CFQMD46iBOMNpNAxxBs0QSDYFBQVE5ZQLFy4Ql1NGDcQZTqNhiDunDPpkAwC/NkahuKbC4gAAAABJRU5ErkJggg==')
            """);

        var button = new Button("Choose directory");
        button.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File dir = directoryChooser.showDialog(stage);
            File[] files = dir != null ? dir.listFiles() : null;

            content.getChildren().clear();

            if (files != null) {
                for (File file : files) {
                    String url = file.toURI().toString();
                    var image = new Image(url);
                    if (image.isError()) {
                        var label = new Label("Cannot load " + file);
                        label.setBackground(Background.fill(Color.RED));
                        label.setFont(Font.font(13));
                        label.setTextFill(Color.WHITE);
                        content.getChildren().add(label);
                    } else {
                        var label = new Label(file.toString());
                        label.setBackground(Background.fill(Color.BLACK));
                        label.setFont(Font.font(13));
                        label.setTextFill(Color.WHITE);
                        var imageView = new ImageView(image);
                        StackPane.setAlignment(label, Pos.TOP_LEFT);
                        StackPane.setAlignment(imageView, Pos.TOP_LEFT);
                        content.getChildren().add(new StackPane(imageView, label));
                    }
                }
            }
        });

        var box = new VBox();
        box.setSpacing(20);
        box.getChildren().add(new VBox(10,
            new VBox(
                new Label("Choose a directory that contains image files."),
                new Label("All images that can be loaded by JavaFX will be shown below.")),
            new HBox(5, button)
        ));

        var scrollPane = new ScrollPane(content);
        var root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setTop(box);
        root.setCenter(scrollPane);
        BorderPane.setMargin(scrollPane, new Insets(20, 0, 0, 0));

        stage.setTitle("Image loading");
        stage.setScene(new Scene(root));
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }
}
