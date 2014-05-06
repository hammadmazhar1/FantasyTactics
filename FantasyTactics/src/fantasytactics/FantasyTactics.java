/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;

/**
 *
 * @author Hammad
 */
public class FantasyTactics extends Application {
    Clan curClan;
    @Override
    public void start(final Stage primaryStage) {
       Group root = new Group();
       Image title = new Image("fantasytactics/images/title.png",720,600,false,false);
       ImageView view = new ImageView(title);
       Image cursor = new Image("fantasytactics/images/cursor.png");
       final ImageView point = new ImageView(cursor);
       point.setX(165);
       point.setY(420);
       root.getChildren().add(view);
       root.getChildren().add(point);
        
        Scene scene = new Scene(root, 720, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent e) {
             switch(e.getCode()) {
                 case DOWN:
                     if (point.getY() == 420) {
                         point.setY(460);
                    }
                    break;
                 case UP:
                     if (point.getY() == 460) {
                         point.setY(420);
                     }
                    break;
                 case ENTER:
                     if (point.getY() == 420) {
                         newGame(primaryStage);
                     } else if (point.getY() == 460) {
                         loadGame(primaryStage);
                     }
             }
         }   
        });
        primaryStage.setTitle("Fantasy Tactics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void newGame(Stage stage) {
        String name = null;
        curClan = new Clan(name);
        curClan.addMember(new Member("Ramza",Stats.SOLDIER));
        curClan.addMember(new Member("Cloud",Stats.THIEF));
        curClan.addMember(new Member("Link",Stats.ARCHER));
        curClan.addMember(new Member("Marche",Stats.HEALER));
        curClan.addMember(new Member("Marc",Stats.MAGE));
    }
    public void loadGame(Stage stage) {
        
    }
}
