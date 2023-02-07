import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.*;
public class Number_Guessing extends Application{

public static void main(String[] args){
launch(args);
}
private int rno;
public void start(Stage primaryStage) throws Exception {
   Random random=new Random();
   rno=random.nextInt(100)+1; //
   Label label = new Label("Enter a no between 1 and 100 :");
   TextField textField = new TextField();
   Button button = new Button("Guess !");
   button.setOnAction(event ->{
        int my_guess = Integer.valueOf(textField.getText());
        if(my_guess==rno){
              label.setText("Correct ! You guessed correctly . You Win ");
}
        else if(my_guess < rno){
           label.setText("Too Low ! ");
}
       else if(my_guess>rno){
          label.setText("Too High !");
}
});
HBox root = new HBox (label , textField , button );
root.setAlignment(Pos.CENTER);
Scene scene = new Scene(root,Color.RED);
primaryStage.setScene(scene);
primaryStage.setTitle("Task 2 - Number Guessing Game ");
primaryStage.show();
}
}


















