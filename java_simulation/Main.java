import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		// The main menu, create a GUI object and define it's parameters 
		try{
			Gui theGui = new Gui();
			theGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			theGui.setSize(700, 700); 
			theGui.setVisible(true);
		}catch (Exception e){
			System.out.println("Erroe accured: " + e.getMessage());
		}		
	}
}
