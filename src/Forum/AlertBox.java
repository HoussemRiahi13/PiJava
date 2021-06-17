/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Forum;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author kais
 */
public class AlertBox {
    
    public static void display(String title,String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);
        Label label= new Label();
        label.setText(message);
        Button close=new Button("Close");
        close.setOnAction(e->window.close());
        VBox layout=new VBox(10);
        layout.getChildren().addAll(label,close);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}
