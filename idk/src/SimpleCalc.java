import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import static javafx.scene.paint.Color.*;
import javafx.stage.Stage;

public class SimpleCalc extends Application {
    @Override
    public void start(Stage s) throws Exception{
        BorderPane bPane = new BorderPane();
        TextField text = new TextField();
        GridPane grid = new GridPane();
        HBox hbox = new HBox();
        int counter = 1;
        for(int i = 0; i < 3;  i++){
            for(int j = 0; j < 3; j++){
                CircleButton setup = new CircleButton(counter + "");
                grid.add(setup, j,i );
                counter++;
                EventHandler<MouseEvent> pressed = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        setup.setColor(YELLOW);
                        text.appendText(setup.getValue());
                    }
                };
                EventHandler<MouseEvent> released = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        setup.setColor(WHITE);
                    }
                };
                setup.getButton().addEventFilter(MouseEvent.MOUSE_PRESSED, pressed);
                setup.getButton().addEventFilter(MouseEvent.MOUSE_RELEASED, released);
            }
        }

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Button sqrt = new Button("Sqrt");
        sqrt.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                int userValue = Integer.parseInt(text.getText());
                double calculate = Math.sqrt(userValue);
                text.setText(calculate + "");
            }
        }));
        Button x2 = new Button("x^2");
        x2.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                int userValue = Integer.parseInt(text.getText());
                double calculate = Math.pow(userValue, 2);
                text.setText(calculate + "");
            }
        }));
        Button clr = new Button("clr");
        clr.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                text.setText("");
            }
        }));
        hbox = new HBox(20, sqrt, x2, clr);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        bPane.setTop(text);
        bPane.setCenter(grid);
        bPane.setBottom(hbox);
        Scene scene = new Scene(bPane, 220, 300);
        s.setScene(scene);
        s.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
