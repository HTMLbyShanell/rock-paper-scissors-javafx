/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsfx;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RockPaperScissorsFx extends Application {

   //variable to create the button,text,string, scene and integer
   private Button rock, paper, scissors, playAgain;
   private Scene play, displayResult;
   private Text welcomeMessage, rulesMessage, startMessage, resultMessage;
   private int userSelection;
   private int compSelection;
   private String result;
   private String player1Pick;
   private String computerPick;

   // launch the javafx gui
   public static void main(String[] args) {
       launch(args);
   }

   // sets the gui layout on startup
   @Override
   public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("Rock-Paper-Scissors");

       // sets the texts for the main scene
       welcomeMessage = new Text("Welcome to Rock Paper Scissors!");
       rulesMessage = new Text("Remember that Rock beats Scissors, Paper beats Rock and Scissors beats Paper.");
       startMessage = new Text("Please make your selection below:");
       resultMessage = new Text(); //result label has not set the string

       //assign the image in variable
       Image rockImage = new Image("File:C:\\Users\\Nelli Pepper\\Documents\\NetBeansProjects\\rock2.jpg");
       Image paperImage = new Image("File:C:\\Users\\Nelli Pepper\\Documents\\NetBeansProjects\\paper2.jpg");
       Image scissorsImage = new Image("File:C:\\Users\\Nelli Pepper\\Documents\\NetBeansProjects\\scissors3.jpg");


       // set up the buttons for the main scene
       //set the image to the button in imageView
       rock = new Button(" Rock ");
       rock.setGraphic(new ImageView(rockImage));
       paper = new Button(" Paper ");
       paper.setGraphic(new ImageView(paperImage));
       scissors = new Button("Scissors");
       scissors.setGraphic(new ImageView(scissorsImage));
      
       // sets the VBox with message details
       VBox vbox = new VBox();
       vbox.getChildren().addAll(welcomeMessage, rulesMessage, startMessage);
       vbox.setAlignment(Pos.CENTER);
       // sets the HBox with the buttons
       HBox hbox1 = new HBox();
       hbox1.getChildren().addAll(rock, paper, scissors);
       hbox1.setAlignment(Pos.CENTER);
       hbox1.setPadding(new Insets(5, 5, 5, 5));
       hbox1.setSpacing(15);
       // new main layout to contain the vbox and hbox1 layouts and rules
       // button
       VBox main = new VBox(5);
       main.getChildren().addAll(vbox, hbox1);
       main.setAlignment(Pos.CENTER);
       main.setPadding(new Insets(15, 15, 15, 15));
       // sets the containing layout
       BorderPane border = new BorderPane();
       border.setCenter(main);

       // details of displayResults scene
       playAgain = new Button("Play Again");
       BorderPane border1 = new BorderPane();
       VBox results = new VBox(10);
       results.getChildren().addAll(resultMessage, playAgain);
       results.setAlignment(Pos.CENTER);
       border1.setCenter(results);

       // sets the two scenes to equal sizes
       play = new Scene(border, 600, 220);
       displayResult = new Scene(border1, 600, 220);

       // action events on button clicks what user is selected
       //check if the button1 button2 or button 3 is selected set the value string to the button click
       rock.setOnAction(e -> {
           userSelection = 1;
           player1Pick = "Rock";
           displayResults();
           primaryStage.setScene(displayResult);
       });

       paper.setOnAction(e -> {
           userSelection = 2;
           player1Pick = "Paper";
           displayResults();
           primaryStage.setScene(displayResult);
       });

       scissors.setOnAction(e -> {
           userSelection = 3;
           player1Pick = "Scissors";
           displayResults();
           primaryStage.setScene(displayResult);
       });

       playAgain.setOnAction(e -> {
           primaryStage.setScene(play);
       });

       // set the scene and display the gui
       primaryStage.setScene(play);
       primaryStage.show();

   }

   // sets a random number for the computer selection
   public int computerSelection() {
       Random random = new Random();
       compSelection = random.nextInt(3) + 1; //generate random number from 1 to 3
       //check if the computer selection is 1,2,3 set the name of the selection to the variable
       if (compSelection == 1) {
           computerPick = "Rock";
       } else if (compSelection == 2) {
           computerPick = "Paper";
       } else if (compSelection == 3) {
           computerPick = "Scissors";
       }
       return compSelection;
   }

   //applies the game logic
   public String runGame() {
       computerSelection();
       if ((userSelection == 1 && compSelection == 3)
               || (userSelection == 2 && compSelection == 1)
               || (userSelection == 3 && compSelection == 2)) {
           result = "Congratulations. You win!!";
          
       } else if ((userSelection == 1 && compSelection == 2)
               || (userSelection == 2 && compSelection == 3)
               || (userSelection == 3 && compSelection == 1)) {
           result = "The computer wins. Better luck next time!";
          
       } else {
           result = "The game was a tie! Please try again.";
          
       }
       return result;
   }

   // displays the outcome of the game
   public void displayResults() {
       runGame();
       resultMessage.setText("You picked " + player1Pick
               + " and the computer picked " + computerPick + ". " + result);
   }
}