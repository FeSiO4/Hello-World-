package com.fesio4.helloworld;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * Fluent-style JavaFX demo: a gradient "card" window whose main action shows a
 * modern, CSS-animated popup before printing the greeting to the terminal.
 */
public class App extends Application {

    private static final int WIDTH = 460;
    private static final int HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(18);
        root.getStyleClass().add("card");
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(32));

        Label headline = new Label("Welcome");
        headline.getStyleClass().add("headline");

        Label sub = new Label("JavaFX · CSS animations · pushed via Git & Actions");
        sub.getStyleClass().add("subtitle");

        Button hello = new Button("Hello World");
        hello.getStyleClass().add("accent");
        hello.setOnAction(e -> showModernDialog(hello.getScene().getWindow()));

        root.getChildren().addAll(headline, sub, hello);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Main window + cross-window dialog CSS in one stylesheet.
        scene.getStylesheets().add(getClass().getResource("/com/fesio4/helloworld/style.css").toExternalForm());

        // Gentle entrance fade to feel "animated & modern".
        FadeTransition intro = new FadeTransition(Duration.millis(450), root);
        intro.setFromValue(0.0);
        intro.setToValue(1.0);
        intro.play();

        stage.setTitle("FeSiO4 · Hello World");
        stage.setMinWidth(320);
        stage.setMinHeight(220);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void showModernDialog(Window owner) {
        Dialog<Void> dialog = new Dialog<>();
        if (owner != null) {
            dialog.initOwner(owner);
        }
        dialog.setTitle("Popup");
        // Apply the same stylesheet so the dialog follows our modern theme.
        String css = getClass().getResource("/com/fesio4/helloworld/style.css").toExternalForm();
        if (dialog.getDialogPane().getStylesheets().isEmpty()) {
            dialog.getDialogPane().getStylesheets().add(css);
        }
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.getDialogPane().setMinWidth(330);

        Label content = new Label("Hello World!");
        content.getStyleClass().add("pop-message");
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setPadding(new Insets(16, 8, 8, 8));
        grid.add(content, 0, 0);

        ButtonType btnOk = new ButtonType("Nice", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(btnOk);
        dialog.getDialogPane().setContent(grid);

        // Fade-in the popup body for a smooth modern feel.
        FadeTransition fade = new FadeTransition(Duration.millis(200), grid);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        dialog.showingProperty().addListener((o, was, is) -> { if (is) fade.play(); });

        dialog.setResultConverter(bt -> null);
        dialog.showAndWait();
        System.out.println("Hello World!");
    }
}
