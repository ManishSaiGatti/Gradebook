import java.awt.Font;

public class GUI {
	private int width;
	private int height;
	private static String currentScreen;
	
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
	
	public void homeScreen() {
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
	
	public static void main(String[] args) {
		int numPressed = 0;
		while(true) {
			if(StdDraw.isMousePressed()) {
				double mouseX = StdDraw.mouseX();
				double mouseY = StdDraw.mouseY();
				numPressed ++;
				
				if(currentScreen.equals("home")) {
					// New Assignment
					if(mouseX > 5 && mouseX < 165 && mouseY > 430 && mouseY < 470) {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle(256, 256, 200, 50);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.text(256, 256, mouseX + " " + mouseY + " New Assignment " + numPressed);
						currentScreen = "new assignment";
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
				StdDraw.pause(300);
			}
		}
	}
}