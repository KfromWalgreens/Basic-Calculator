import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CircleButton extends StackPane {
    Label lblValue;
    Circle circle;
    Button butt;

    public CircleButton(){
        lblValue = new Label("");
        lblValue.setTextFill(Color.BLACK);
        circle = new Circle(30, Color.WHITE);
        butt = new Button();
        butt.setPrefSize(30,30);
        this.getChildren().add(butt);
        this.getChildren().add(circle);
        this.getChildren().add(lblValue);
    }

    public CircleButton(String val){
        lblValue = new Label(val);
        lblValue.setTextFill(Color.BLACK);
        circle = new Circle(30);
        circle.setFill(Color.WHITE);
        butt = new Button();
        butt.setStyle("-fx-border-color: transparent;-fx-background-color: transparent; ");
        butt.setPrefSize(30,30);
        this.getChildren().add(circle);
        this.getChildren().add(butt);
        this.getChildren().add(lblValue);
    }

    public void setColor(Paint color){
        circle.setFill(color);
    }

    public Paint getColor(){
        return circle.getFill();
    }

    public String getValue(){
        return lblValue.getText();
    }

    public Button getButton(){
        return butt;
    }
}
