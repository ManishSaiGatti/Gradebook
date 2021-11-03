import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class GUI {
	private int width;
	private int height;
	private static String currentScreen;
	private static String assignmentName = "";
	
	public GUI() {
		width = 100;
		height = 100;
		StdDraw.setCanvasSize(width, height);
		homeScreen();
		currentScreen = "home";
	}
	
	public GUI(int width, int height) {
		this.width = width;
		this.height = height;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		homeScreen();
		currentScreen = "home";
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void homeScreen() {
		StdDraw.rectangle(85, 450, 80, 20);
		StdDraw.rectangle(256, 450, 80, 20);
		StdDraw.rectangle(427, 450, 80, 20);
		Font font = new Font("Arial", Font.PLAIN, 20);
		StdDraw.setFont(font);
		StdDraw.text(85, 445, "New Assignment");
		StdDraw.text(256, 445, "Edit Assignment");
		StdDraw.text(427, 445, "Display Data");
		currentScreen = "home";
	}
	
	private static void newAssignmentScreen() {
		StdDraw.clear();
		StdDraw.rectangle(256, 450, 80, 20);
		StdDraw.text(256, 445, "New Assignment");
		StdDraw.text(120, 400, "Enter Assignment Name: ");
		StdDraw.rectangle(370, 400, 140, 20);
		currentScreen = "new assignment";
	}
	
	private static void drawCursor(int x, int y) {
		//StdDraw.setPenColor(color);
		StdDraw.line(x, y - 15, x, y + 15);
		StdDraw.line(x - 8, y + 15, x + 8, y + 15);
		StdDraw.line(x - 8, y - 15, x + 8, y - 15);
	}
	
	public static void main(String[] args) {
		int numPressed = 0;
		while(true) {
			if(StdDraw.isMousePressed()) {
				double mouseX = StdDraw.mouseX();
				double mouseY = StdDraw.mouseY();
				numPressed ++;
				
				// On Home Page
				if(currentScreen.equals("home")) {
					// New Assignment
					if(mouseX > 5 && mouseX < 165 && mouseY > 430 && mouseY < 470) {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle(256, 256, 200, 50);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(256, 256, mouseX + " " + mouseY + " New Assignment " + numPressed);
						newAssignmentScreen();
					}
					
					// Edit Assignment
					if(mouseX > 176 && mouseX < 336 && mouseY > 430 && mouseY < 470) {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle(256, 256, 200, 50);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(256, 256, mouseX + " " + mouseY + " Edit Assignment " + numPressed);
						currentScreen = "edit assignment";
					}
					
					// Display Scores
					if(mouseX > 347 && mouseX < 507 && mouseY > 430 && mouseY < 470) {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle(256, 256, 200, 50);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(256, 256, mouseX + " " + mouseY + " Display Data " + numPressed);
						currentScreen = "display data";
					}
				}
				
				//StdDraw.textRight(16, 100, "M");
				
				// On New Assignment
				if(currentScreen.equals("new assignment")) {
					if(mouseX > 230 && mouseX < 510 && mouseY > 380 && mouseY < 420) {
						// typing animation
						int startX = 240;
						int startY = 400;
						
						boolean run = true;
						Color color = new Color(100, 100, 100);
						while(run) {
							if(StdDraw.isMousePressed()) {
								if(!(mouseX > 230 && mouseX < 510 && mouseY > 380 && mouseY < 420)) {
									run = false;
									System.out.println("hi");
								}
							}
							StdDraw.setPenColor(color);
							drawCursor(startX, startY);
							StdDraw.pause(500);
							if(StdDraw.isMousePressed()) {
								if(!(mouseX < 230 && mouseX > 510 && mouseY < 380 && mouseY > 420)) {
									run = false;
									System.out.println("hi");
								}
							}
							StdDraw.setPenColor(Color.WHITE);
							StdDraw.filledRectangle(startX, startY, 9, 16);
							StdDraw.pause(500);
							if(StdDraw.isMousePressed()) {
								if(!(mouseX < 230 && mouseX > 510 && mouseY < 380 && mouseY > 420)) {
									run = false;
									System.out.println("hi");
								}
							}
							
							if(StdDraw.hasNextKeyTyped()) {
								char key = StdDraw.nextKeyTyped();
								//System.out.println(key);
								if(key == '') {
									if(assignmentName.length() > 0) {
										assignmentName = assignmentName.substring(0, assignmentName.length() - 1);
									}
									//System.out.println("hui");
								} else {
									assignmentName += key;
									StdDraw.setPenColor(Color.WHITE);
									StdDraw.filledRectangle(370, 400, 139, 19);
									StdDraw.setPenColor(Color.BLACK);
									StdDraw.textLeft(235, startY, assignmentName);
									System.out.println(startX);
									startX += 1;
								}
								System.out.println(assignmentName);
							}
						}
					}
				}
				StdDraw.pause(300);
			}
		}
	}
}