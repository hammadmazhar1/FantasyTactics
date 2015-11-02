/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Hammad
 */
public class FantasyTactics extends Application {
    Clan curClan;
    boolean menu;
    boolean playTurn;
    boolean move;
    boolean attack;
    BattleMem curMove;
    boolean turnEnd =false;
    boolean confirm = false;
    int curSelection;
    Text dmg;
    ArrayList<BattleMem> avail;
    Location cursorLoc;
    boolean missionWon = false;
    boolean missionLose = false;
    int curIndex;
    Text name;
    Text hp;
    Text mp;
    Scene scene;
    ArrayList<Location> range;
    ArrayList<ImageView> tiles;
    Mission m;
    Group root;
    TurnOrder ord;
    BattleClan play;
    Timeline timeline;
    MediaPlayer bgm;
    @Override
    
    public void start(final Stage primaryStage) {
       Start.create();
       menu = false;
       playTurn = false;
       URL u = getClass().getResource("start.mp3");
       bgm= new MediaPlayer(new Media(u.toString()));
       bgm.setCycleCount(MediaPlayer.INDEFINITE);
       bgm.play();
       root = new Group();
       Image title = new Image("fantasytactics/images/title.png",720,600,false,false);
       ImageView view = new ImageView(title);
       Image cursor = new Image("fantasytactics/images/cursor.png");
       final ImageView point = new ImageView(cursor);
       point.setX(165);
       point.setY(420);
       root.getChildren().add(view);
       root.getChildren().add(point);
        
        scene = new Scene(root, 720, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
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
                         if (loadGame(primaryStage)){
                            missionSelectPane(primaryStage);
                         } else {
                             
                         }
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
            Member mem1 = new Member("Cooper",Stats.THIEF);
            mem1.setWeap(new Item("Dagger"));
            mem1.setArmor(new Item("Leather Clothing"));
            mem1.setHat(new Item("Plumed Hat"));
            curClan.addMember(mem1);
            mem1 = new Member("Ramza",Stats.SOLDIER);
            mem1.setWeap(new Item("Shortsword"));
            mem1.setArmor(new Item("Leather Cuirass"));
            mem1.setHat(new Item("Bronze Helm"));
            curClan.addMember(mem1);
            mem1 = new Member("Luke",Stats.HEALER);
            mem1.setWeap(new Item("White Staff"));
            mem1.setArmor(new Item("Hempen Robe"));
            mem1.setHat(new Item("Plumed Hat"));
            curClan.addMember(mem1);
            mem1 = new Member("Merlin",Stats.MAGE);
            mem1.setWeap(new Item("Rod"));
            mem1.setArmor(new Item("Hempen Robe"));
            mem1.setHat(new Item("Plumed Hat"));
            curClan.addMember(mem1);
            mem1 = new Member("Link",Stats.ARCHER);
            mem1.setWeap(new Item("Shortbow"));
            mem1.setArmor(new Item("Leather Clothing"));
            mem1.setHat(new Item("Plumed Hat"));
            curClan.addMember(mem1);
        missionSelectPane(stage);
    }
    public boolean loadGame(Stage stage) {
        boolean loaded = false;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("Save.sav");
            ois = new ObjectInputStream(fis);
            curClan = (Clan)ois.readObject();
            loaded = true;
        }catch (IOException e) {
            return loaded;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return loaded;
        }
        return loaded;
    }
    public boolean saveGame() {
        boolean saved = false;
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream("Save.sav");
            out = new ObjectOutputStream(fos);
            out.writeObject(curClan);
            saved = true;
        } catch(IOException e) {
            return saved;
        }
        return saved;
    }
    public void missionSelectPane(final Stage stage) {
        bgm.stop();
        URL u = getClass().getResource("menu.mp3");
        bgm = new MediaPlayer(new Media(u.toString()));
        bgm.setCycleCount(MediaPlayer.INDEFINITE);
        bgm.play();
        final Text dText = new Text("Game Saved");
        final Text aText = new Text("Game Was Not Saved");
        root = new Group();
        Button misSelect = new Button();
        misSelect.setLayoutX(100);
        misSelect.setLayoutY(100);
        final Text misText = new Text();
        misText.setText("Click to select the next Mission to go on");
        misText.setX(350);
        misText.setY(100);
        misSelect.setText("Mission Select");
        misSelect.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event e) {
               root.getChildren().remove(dText);
               root.getChildren().remove(aText);
               root.getChildren().add(misText);
            }
        });
        misSelect.setOnMouseExited(new EventHandler() {
            @Override
            public void handle(Event e) {
                root.getChildren().remove(misText);
            }
        });
        misSelect.setOnAction(new EventHandler() {
            @Override
            public void handle(Event e) {
                showMissions(stage);
            }
        });
        root.getChildren().add(misSelect);
        Button setUpC = new Button();
        setUpC.setText("Set Up Clan");
        final Text cText = new Text("Click here to prepare your clan members for battle");
        setUpC.setLayoutX(100);
        setUpC.setLayoutY(200);
        cText.setX(350);
        cText.setY(100);
        setUpC.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event e) {
                root.getChildren().remove(dText);
                root.getChildren().remove(aText);
                root.getChildren().add(cText);
            }
        });
        setUpC.setOnMouseExited(new EventHandler() {
            @Override
            public void handle(Event e) {
                root.getChildren().remove(cText);
            }
        });
        setUpC.setOnAction(new EventHandler() {
           @Override
           public void handle(Event e) {
               showMembers(stage);
           }
        });
        root.getChildren().add(setUpC);
        Button saveGame = new Button();
        final Text sText = new Text("Click Here To Save your Game");
        
        dText.setX(350);
        dText.setY(100);
        aText.setX(350);
        aText.setY(100);
        saveGame.setLayoutX(100);
        saveGame.setLayoutY(300);
        sText.setX(350);
        sText.setY(100);
        saveGame.setText("Save Game");
        saveGame.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event e) {
                root.getChildren().remove(dText);
                root.getChildren().remove(aText);
                root.getChildren().add(sText);
            }
        });
        saveGame.setOnMouseExited(new EventHandler() {
            @Override
            public void handle(Event e) {
                root.getChildren().remove(sText);
            }
        });
        saveGame.setOnAction(new EventHandler() {
            @Override
            public void handle(Event e){
                if (saveGame()) {
                    root.getChildren().add(dText);
                } else {
                    root.getChildren().add(aText);
                }
            }
        });
        root.getChildren().add(saveGame);
        scene = new Scene(root,720,600);
        stage.setScene(scene);
        stage.show();
    }
    public void showMissions(final Stage stage) {
        root = new Group();
        int x = 100;
        int y = 100;
        
        try {
            FileInputStream fis = new FileInputStream("Missions.ifo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Mission> missions = (ArrayList<Mission>)ois.readObject();
            for (Mission i : missions) {
                if (!curClan.completed.contains(i)) {

                    final Mission a = i;
                    Button but = new Button(i.misName);
                    but.setLayoutX(x);
                    but.setLayoutY(y);
                    y+=50;
                    but.setOnAction(new EventHandler() {
                        public void handle(Event e) {
                            m = a;
                            startMission(a, stage);
                        }
                    });
                    root.getChildren().add(but);                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scene = new Scene(root,720,600);
        stage.setScene(scene);
        stage.show();
    }
    public void showMembers(final Stage stage) {
        
    }
    public void startMission(final Mission m, final Stage stage) {
        root = new Group();
        bgm.stop();
        URL u = getClass().getResource("battle.mp3");
        bgm = new MediaPlayer(new Media(u.toString()));
        bgm.setCycleCount(MediaPlayer.INDEFINITE);
        bgm.play();
        final BattleClan enemy = new BattleClan();
        final BattleClan player = new BattleClan();
        play = player;
        Image map = new Image("fantasytactics/images/"+m.mapName,m.width,m.height,false,false);
        ImageView mapView = new ImageView(map);
        mapView.setX(0);
        mapView.setY(0);
        
        root.getChildren().add(mapView);
        final Location[][] mapCoor = m.map;
        final ImageView cursor = new ImageView(new Image("fantasytactics/images/bcursor.png",66,98,false,false));
        cursorLoc = new Location(m.xLimit/2, m.yLimit/2);
        cursor.setX(mapCoor[cursorLoc.y][cursorLoc.x].x);
        cursor.setY(mapCoor[cursorLoc.y][cursorLoc.x].y);
        root.getChildren().add(cursor);
        for (Member i : m.enemy.members) {
            int index = m.enemy.members.indexOf(i);
            enemy.group.add(new BattleMem(1,i,m.enmapCoor[index],m.enCoor[index]));
        }
        for (Member i : curClan.members) {
            int index = curClan.members.indexOf(i);
            player.group.add(new BattleMem(0,i,m.playmapCoor[index],m.playCoor[index]));
        }
        final TurnOrder ord  = new TurnOrder();
        ord.create(enemy.group,player.group);
        for (BattleMem i : enemy.group) {
            root.getChildren().add(i.anm.view);
        }
        
        for (BattleMem i : player.group) {
            root.getChildren().add(i.anm.view);
        }
        
        scene = new Scene(root,m.width,m.height);
        final Button mve = new Button("Move");
        final Button atk = new Button("Attack");
        final Button wait = new Button("Wait");
        mve.setLayoutX(m.width-100);
        mve.setLayoutY(m.height-200);
        atk.setLayoutX(m.width-100);
        atk.setLayoutY(m.height-150);
        wait.setLayoutX(m.width-100);
        wait.setLayoutY(m.height -100);
        mve.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e) {
               menu = false;
               root.getChildren().remove(mve);
               root.getChildren().remove(atk);
               root.getChildren().remove(wait);
               tiles = new ArrayList<ImageView>();
               range = displayRange(tiles,curMove, mapCoor , ord.order);
               root.getChildren().addAll(1,tiles);
               scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                  public void handle(KeyEvent e) {
                      
                      if (e.getCode() == KeyCode.UP) {
                          
                          if (cursorLoc.y >= 0) {
                              
                              if (range.contains(mapCoor[cursorLoc.y-1][cursorLoc.x])) {
                                  cursorLoc.y--;
                                  
                              }
                          }
                      }
                      if (e.getCode() == KeyCode.DOWN) {
                          if (cursorLoc.y <= m.yLimit) {
                              if (range.contains(mapCoor[cursorLoc.y+1][cursorLoc.x])) {
                                  cursorLoc.y++;
                              }
                          }
                      }
                      if (e.getCode() == KeyCode.LEFT) {
                          if (cursorLoc.x >= 0) {
                              if (range.contains(mapCoor[cursorLoc.y][cursorLoc.x-1])) {
                                  cursorLoc.x--;
                              }
                          }
                      }
                      if (e.getCode() == KeyCode.RIGHT) {
                          if (cursorLoc.x <= m.xLimit) {
                              if (range.contains(mapCoor[cursorLoc.y][cursorLoc.x+1])) {
                                  cursorLoc.x++;
                              }
                          }
                      }
                      if (e.getCode() == KeyCode.ENTER) {
                          curMove.pixLoc = mapCoor[cursorLoc.y][cursorLoc.x];
                          curMove.mapLoc = new Location(cursorLoc.x,cursorLoc.y);
                          curMove.updatePosition();
                          menu = true;
                          mve.setDisable(true);
                          root.getChildren().removeAll(tiles);
                          root.getChildren().add(atk);
                          root.getChildren().add(wait);
                      }
                      cursor.setX(mapCoor[cursorLoc.y][cursorLoc.x].x);
                      cursor.setY(mapCoor[cursorLoc.y][cursorLoc.x].y);
                  } 
               });
               e.consume();
           } 
        });
        atk.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e) {
               root.getChildren().remove(mve);
               root.getChildren().remove(atk);
               root.getChildren().remove(wait);
               avail = displayAttackable(curMove,enemy);
               tiles = new ArrayList<ImageView>();
               Image t = new Image("fantasytactics/images/tile.png",66,98,false,false);
               if (!avail.isEmpty()) {
                    for (BattleMem i : avail) {
                        ImageView tile = new ImageView(t);
                        tile.setX(i.pixLoc.x);
                        tile.setY(i.pixLoc.y);
                        tiles.add(tile);
                   
                    }
                     root.getChildren().addAll(1,tiles);
               cursorLoc.x = avail.get(0).mapLoc.x;
               cursorLoc.y = avail.get(0).mapLoc.y;
               cursor.setX(mapCoor[cursorLoc.y][cursorLoc.x].x);
               cursor.setY(mapCoor[cursorLoc.y][cursorLoc.x].y);
               curSelection = 0;
               confirm = false;
               scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                   public void handle(KeyEvent e) {
                       if (e.getCode() == KeyCode.UP) {
                           if (curSelection != avail.size()-1) {
                               curSelection++;
                               
                           } else {
                               curSelection = 0;
                           }
                       }
                       if (e.getCode() == KeyCode.DOWN) {
                           if (curSelection != 0) {
                               curSelection--;
                           }
                       }
                       if (e.getCode() == KeyCode.ENTER) {
                           if (confirm == false) {
                            BattleMem en = avail.get(curSelection);
                            root.getChildren().remove(name);
                            root.getChildren().remove(hp);
                            root.getChildren().remove(mp);
                            name = new Text(en.member.getName());
                            hp = new Text("HP:  " + en.curHP + "/" + en.member.getmaxHp());
                            mp = new Text("MP:  " + en.curMP + "/" + en.member.getmaxMp());
                            name.setFont(Font.font("Impact",22));
                            hp.setFont(Font.font("Impact",22));
                            mp.setFont(Font.font("Impact",22));
                            name.setFill(Color.BLACK);
                            hp.setFill(Color.BLACK);
                            mp.setFill(Color.BLACK);
                            name.setX(0);
                            hp.setX(0);
                            mp.setX(0);
                            name.setY(m.height-150);
                            hp.setY(m.height-100);
                            mp.setY(m.height -50);
                            root.getChildren().add(name);
                            root.getChildren().add(hp);
                            root.getChildren().add(mp);
                            dmg= new Text();
                            int def = en.member.getDef();
                            int aat = curMove.member.getAtk();
                            int damg = (aat-(def/2))/2;
                            double prob = 1-((double)en.member.getEvade()/100);
                            dmg.setText("Damage: " + damg + "   Chance to Hit: "+ (prob*100) + "%");
                            dmg.setFont(Font.font("Impact", 25));
                            dmg.setFill(Color.BLACK);
                            dmg.setX(m.width-400);
                            dmg.setY(m.height-100);
                            
                            DropShadow ds = new DropShadow();
                            ds.setOffsetY(3.0f);
                            ds.setColor(Color.color(0.4f,0.4f,0.4f));
                            dmg.setEffect(ds);
                            root.getChildren().add(dmg);
                            dmg.toFront();
                            confirm = true;
                              
                           } else {
                               root.getChildren().removeAll(tiles);
                               root.getChildren().remove(dmg);
                               curMove.executeAttack(avail.get(curSelection));
                               try {
                                   Thread.sleep(400);
                               } catch (InterruptedException ex) {
                                   Logger.getLogger(FantasyTactics.class.getName()).log(Level.SEVERE, null, ex);
                               }
                               if (avail.get(curSelection).curHP <= 0) {
                                   root.getChildren().remove(avail.get(curSelection).anm.view);
                                   ord.order.remove(avail.get(curSelection));
                                   enemy.group.remove(avail.get(curSelection));
                               }
                               attack = true;
                               turnEnd = true;
                           }
                       }
                       cursorLoc.x = avail.get(curSelection).mapLoc.x;
                       cursorLoc.y = avail.get(curSelection).mapLoc.y;
                       cursor.setX(mapCoor[cursorLoc.y][cursorLoc.x].x);
                       cursor.setY(mapCoor[cursorLoc.y][cursorLoc.x].y);
                       
                   }
                   
               });
               
               } else {
                   turnEnd = true;
               }
              
           }
        });
        wait.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent e) {
                turnEnd = true;
                root.getChildren().remove(tiles);
            }
        });
        stage.setScene(scene);
        stage.show();
        
        curIndex = ord.order.size()-1;
        turnEnd = true;
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler() {
            public void handle (Event e) {
                if (!missionWon && !missionLose) {
                    if (turnEnd) {
                        if (enemy.group.size()== 0) {
                            missionWon = true;
                        } else if (player.group.size() == 0) {
                            missionLose = true;
                        }
                        for (BattleMem i : ord.order) {
                            if (i.curHP <= 0) {
                                root.getChildren().remove(i.anm.view);
                                ord.order.remove(i);
                                enemy.group.remove(i);
                                play.group.remove(i);
                                curIndex = 0;
                            }
                        }
                        if (curIndex == ord.order.size()-1) {
                            curIndex = 0;
                        } else {
                            curIndex++;
                        }
                        root.getChildren().remove(mve);
                        root.getChildren().remove(atk);
                        root.getChildren().remove(wait);
                        curMove = ord.order.get(curIndex);
                        cursorLoc.x = curMove.mapLoc.x;
                        cursorLoc.y = curMove.mapLoc.y;
                        cursor.setX(mapCoor[cursorLoc.y][cursorLoc.x].x);
                        cursor.setY(mapCoor[cursorLoc.y][cursorLoc.x].y);
                        if (enemy.group.contains(curMove)) {
                            executeTurn(player,curMove, enemy);
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FantasyTactics.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            turnEnd = true;
                        } else {
                            turnEnd = false;
                            root.getChildren().add(mve);
                            root.getChildren().add(atk);
                            root.getChildren().add(wait);
                            mve.setDisable(false);
                            move = false;
                            attack = false;
                            
                            if (curMove.curMP >= curMove.member.getmaxMp() -10) {
                                curMove.curMP = curMove.member.getmaxMp();
                            } else {
                                curMove.curMP +=10;
                            }
                            root.getChildren().remove(name);
                            root.getChildren().remove(hp);
                            root.getChildren().remove(mp);
                            name = new Text(curMove.member.getName());
                            hp = new Text("HP:  " + curMove.curHP + "/" + curMove.member.getmaxHp());
                            mp = new Text("MP:  " + curMove.curMP + "/" + curMove.member.getmaxMp());
                            name.setFont(Font.font("Impact",22));
                            hp.setFont(Font.font("Impact",22));
                            mp.setFont(Font.font("Impact",22));
                            name.setFill(Color.BLACK);
                            hp.setFill(Color.BLACK);
                            mp.setFill(Color.BLACK);
                            name.setX(0);
                            hp.setX(0);
                            mp.setX(0);
                            name.setY(m.height-150);
                            hp.setY(m.height-100);
                            mp.setY(m.height -50);
                            root.getChildren().add(name);
                            root.getChildren().add(hp);
                            root.getChildren().add(mp);
                        }
                        
                    } else {
                        if (move && attack) {
                            turnEnd = true;
                        }
                    }
                } else {
                    if (missionWon) {
                        win();
                    } else if (missionLose) {
                        lose();
                    }
                }
                
                
                for (int i = m.xLimit; i>=0;i--) {
                    for (BattleMem j : ord.order) {
                        if (j.mapLoc.x == i) {
                            j.toFront();
                        }
                    }
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void executeTurn(BattleClan enemy, BattleMem player, BattleClan allies){
        int rang = 0;
        if (player.member.getWeap().itemType == Stats.BOWS || player.member.getWeap().itemType == Stats.GREATBOWS) {
            rang = 5;
            
        } else {
            rang = 1;
        }
        int movement = player.member.getMove();
        BattleMem vic = null;
        Location moveLoc = player.mapLoc;
        for (int i = player.mapLoc.x-movement; i <= player.mapLoc.x+movement; i++) {
            for (int j = player.mapLoc.y-movement; j <=player.mapLoc.y+movement;j++) {
                boolean cant = false;
                for (BattleMem o : allies.group) {
                    if (!o.equals(player)) {
                        if (o.mapLoc.equals(new Location(i,j))) {
                            cant = true;
                        }
                    }
                }
                for (BattleMem o : enemy.group) {
                    if (!o.equals(player)) {
                        if (o.mapLoc.equals(new Location(i,j))) {
                            cant = true;
                        }
                    }
                }
                if (!cant) {
                    if (i>=0 && i <= m.xLimit ) {
                        if (j >=0 && j <=m.yLimit) {
                            if (Math.abs(i-player.mapLoc.x) +Math.abs(j-player.mapLoc.y) <= movement) {
                                if (m.map[j][i] != null ) {
                                    for (int k = i-rang; k <= i+rang;k++ ) {
                                        for (int l = j-rang; l<=j+rang;l++ ) {
                                            if (k >= 0 && k < m.xLimit) {
                                                if (l >=0 && l<m.yLimit) {
                                                    if (m.map[l][k] != null) {
                                                        for (BattleMem c : enemy.group) {
                                                            if (Math.abs(k-i)+Math.abs(l-j) <= rang) {
                                                                if (c.mapLoc.equals(new Location(k,l))){
                                                                    if (vic != null) {
                                                                        if (c.curHP < vic.curHP){
                                                                            vic = c;
                                                                            moveLoc = new Location(i,j);
                                                                        }
                                                                    } else {
                                                                        vic = c;
                                                                        moveLoc = new Location(i,j);
                                                                    }   
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (vic == null) {
            for (int i = player.mapLoc.x-movement;i <= player.mapLoc.x+movement; i++) {
                for (int j = player.mapLoc.y-movement; j <=player.mapLoc.y+movement;j++) {
                    if (j>=0 && j<m.yLimit && i>=0 && i<m.xLimit && m.map[j][i] != null) {
                        moveLoc = new Location(i,j);
                    }
                }
            }
            player.pixLoc = m.map[moveLoc.y][moveLoc.x];
            player.mapLoc = moveLoc;
            player.updatePosition();
            
        } else {
            player.mapLoc= moveLoc;
            player.pixLoc = m.map[moveLoc.y][moveLoc.x];
            player.updatePosition();
            player.executeAttack(vic);
            if (vic.curHP <= 0) {
                root.getChildren().remove(vic.anm.view);
                ord.order.remove(vic);
                play.group.remove(vic);
            }
        }
        
    }
    public ArrayList<Location> displayRange(ArrayList<ImageView> tiles, BattleMem player, Location[][] map, ArrayList<BattleMem> people) {
        ArrayList<Location> ans = new ArrayList<Location>();
        int range = player.member.getMove();
        int xLimit = map[0].length;
        int yLimit = map.length;
        for (int i = player.mapLoc.x-range; i<=player.mapLoc.x+range;i++) {
            for (int j = player.mapLoc.y-range; j<=player.mapLoc.y+range; j++) {
                if (j >= 0 && j< yLimit) {
                    if (i >= 0 && i < xLimit) {
                        if (Math.abs(j-player.mapLoc.y)+Math.abs(i-player.mapLoc.x) <= range) {
                            Image t = new Image("fantasytactics/images/tile.png",66,98,false,false);
                            boolean nonaccess = false;
                            for (BattleMem k : people) {
                                if (k.mapLoc.equals(new Location(i,j))) {
                                    nonaccess = true;
                                    break;
                                }
                            }
                            if (!nonaccess) {
                                if (map[j][i] != null) {
                                    ans.add(map[j][i]);
                                    ImageView tile = new ImageView(t);
                                    tile.setX(map[j][i].x);
                                    tile.setY(map[j][i].y);
                                    tiles.add(tile);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    public ArrayList<BattleMem> displayAttackable(BattleMem attacker,BattleClan en) {
        ArrayList<BattleMem> ans = new ArrayList<BattleMem>();
        int rang = 0;
        if (attacker.member.getWeap().itemType == Stats.BOWS || attacker.member.getWeap().itemType == Stats.GREATBOWS) {
            rang = 5;
        } else {
            rang = 1;
        }
        for (BattleMem i : en.group) {
            if (Math.abs(i.mapLoc.x - attacker.mapLoc.x) + Math.abs(i.mapLoc.y - attacker.mapLoc.y) <= rang) {
                ans.add(i);
            }
        }
        return ans;
    }
   public void win() {
       Text t = new Text("You Win");
       t.setFont(Font.font("Impact", 45));
       t.setFill(Color.BLACK);
       root.getChildren().add(t);
       timeline = new Timeline(new KeyFrame(Duration.millis(100),new EventHandler() {
           public void handle(Event e) {
               
           }
       }));
       timeline.setCycleCount(10);
       timeline.play();
       curClan.inventory.addAll(m.spoils);
       curClan.gold += m.gold;
       curClan.completed.add(m);
   }
   public void lose() {
       
   }
}
