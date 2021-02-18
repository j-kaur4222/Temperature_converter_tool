package jasleen.javaApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
public static void main(String[] args)
{ System.out.println("main");
	launch(args);

}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menubar=createMenu();
		rootNode.getChildren().add(0,menubar);


		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}
public MenuBar createMenu()
{MenuBar menubar=new MenuBar();
	Menu filemenu= new Menu("file");
	MenuItem newmenuitem=new MenuItem("new");
	newmenuitem.setOnAction(event-> System.out.println("new is on"));

	SeparatorMenuItem separator=new SeparatorMenuItem();
	MenuItem quitmenuitem=new MenuItem("quit");
	quitmenuitem.setOnAction(event -> {
		Platform.exit();
		System.out.println("exit");
		System.exit(0);

	});
	filemenu.getItems().addAll(newmenuitem,separator,quitmenuitem);

	Menu helpmenu=new Menu("help");
	MenuItem aboutapp=new MenuItem("about");
	aboutapp.setOnAction(event -> Aboutapp());
	helpmenu.getItems().addAll(aboutapp);
	
	menubar.getMenus().addAll(filemenu,helpmenu);
	return menubar;
}

	private void Aboutapp()
	{
		Alert alertDialog=new Alert(Alert.AlertType.WARNING);
		alertDialog.setTitle("My first java app");
		alertDialog.setHeaderText("Aboutapp");
		alertDialog.setContentText("This is my first converter application");
		ButtonType yesbtn=new ButtonType("yes");
		ButtonType nobtn=new ButtonType("no");
		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);
		Optional<ButtonType> clickedBtn=alertDialog.showAndWait();
		if(clickedBtn.isPresent()&&clickedBtn.get()==yesbtn)
		{
			System.out.println("yes is clicked");
		}
		else
		{
			System.out.println("no is clicked");
		}
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop");
	}
}
