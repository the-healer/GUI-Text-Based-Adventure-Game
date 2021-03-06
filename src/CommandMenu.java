import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CommandMenu implements CommandMenuInterface {

	private Formatter file;
	private Scanner readFile;
	
	Image icon, map;
	ImageView viewIcon, viewMap;
	TextArea displayStory, displayCommand;
	/*
	 * CONSTRUCTOR
	 */
	public CommandMenu() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * CONSTRUCTOR
	 */
	public CommandMenu(Image icon, Image map, ImageView viewIcon, ImageView viewMap, TextArea displayStory, TextArea displayCommand) {
		this.icon = icon;
		this.map = map;
		this.viewIcon = viewIcon;
		this.viewMap = viewMap;
		this.displayStory = displayStory;
		this.displayCommand = displayCommand;
	}
	
	//CENTER PANE--------------------------------------------------------------------------------------
	//PLAYER STATUS
	public void playerStats() {
		
	}
	//DISPLAY STORY
	public TextArea getDisplayStory() {
		
		return this.displayStory;
	}
	//DISPLAY SETTING
	public void setDisplayStory(TextArea displayStory) {
		this.displayStory = displayStory;
		displayStory.setEditable(false);
		displayStory.setWrapText(true);
		displayStory.setLayoutX(152);
		displayStory.setLayoutY(220);
		displayStory.setPrefHeight(315);
		displayStory.setPrefWidth(280);
	}
	
	//COMMAND MENU-------------------------------------------------------------------------------------
	public TextArea getDisplayCommand() {
		
		return this.displayCommand;
	}
	//COMMAND SETTING
	public void setDisplayCommand(TextArea displayCommand) {
		this.displayCommand = displayCommand;
		displayCommand.setEditable(false);
		displayCommand.setLayoutX(152);
		displayCommand.setLayoutY(543);
		displayCommand.setPrefHeight(130);
		displayCommand.setPrefWidth(280);
	}
	
	//SAVE GAME----------------------------------------------------------------------------------------
	public void saveGame(String fileName) {
		
		try {
			
			file = new Formatter(fileName);
			System.out.println("Game Saved");
		}
		catch(Exception e) {
			System.out.println("error: file did not save");
		}
		writeFile();
		closeFile();
	}
	//WRITE FILE
	public void writeFile() {
		/*
		 * Write saved game. Use... file.format(format, args);
		 */
	}
	//CLOSE FILE
	public void closeFile() {
		
		file.close();
	}
	
	//LOAD GAME----------------------------------------------------------------------------------------
	public void loadGame(String fileName) {
		
		try {
			
			readFile = new Scanner(new File(fileName));
		}
		catch(Exception e) {
			System.out.println("error: could not find file");
		}
		
		//Read file
		while(readFile.hasNext()) {
			/*
			 * Read what is in the saved game file
			 */
		}
		//Close File
		readFile.close();
	}
	public TextArea getLoadGameStory() {
		
		return this.displayStory;
	}
	public void setLoadGameStory(TextArea displayStory, String story) {
		int getStoryLength = this.displayStory.getLength();
		displayStory.replaceText(0, getStoryLength, story);
		this.displayStory = displayStory;
		setDisplayStory(this.displayStory);
	}
	
	public TextArea getLoadGameCommand() {
		
		return this.displayCommand;
	}
	public void setLoadGameCommand(TextArea displayCommand, String command) {
		int getCommandLength = this.displayCommand.getLength();
		displayCommand.replaceText(0, getCommandLength, command);
		this.displayCommand = displayCommand;
		setDisplayCommand(this.displayCommand);
	}

	//NAVIGATE MAP--------------------------------------------------------------------------------------
	public ImageView getNavigateMap() {
		
        return this.viewMap;
	}
	public void setNavigateMap(Image map, ImageView viewMap, int x, int y) {
		this.map = map;
        viewMap.setImage(map);
        viewMap.setLayoutX(x); //310
        viewMap.setLayoutY(y); //310
	}
	
	public ImageView getNavigateIcon() {
		
		return this.viewIcon;
	}
	public void setNavigateIcon(Image icon, ImageView viewIcon, int x, int y) {
		this.icon = icon;
		viewIcon.setImage(icon);
        viewIcon.setLayoutX(x);
        viewIcon.setLayoutY(y);
	}
	//PROMPT MESSAGE-------------------------------------------------------------------------------------
	public void prompt(Text prompt, String message) {
		
		prompt.setText("                       " + message);
		prompt.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		prompt.setFill(Color.RED);
	}
	
}
