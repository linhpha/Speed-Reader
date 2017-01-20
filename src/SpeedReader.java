import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.IOException;




public class SpeedReader {
	/**
	 *
	 * @param filename, width, height, fontSize, wpm
	 * @purpose reads in a file and displays it in the RSVP style.
	 * The words of the file are centered based on the width and height of the window
	 */
	public static void demonstratePanel(String filename, int width, int height, int fontSize,
			int wpm) throws IOException, InterruptedException {
		WordGenerator file = new WordGenerator(filename);
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		FontMetrics metrics = g.getFontMetrics();
		while (file.hasNext()) {
			Font f = new Font("Courier", Font.BOLD, fontSize);
			g.setFont(f);
			String currentWord = file.next();
			int x = (width/2) - (metrics.stringWidth(currentWord))/2;
			int y = (height - metrics.getHeight()) / 2;
			g.drawString(currentWord, x, y);
			Thread.sleep(60000/wpm);
			panel.clear();
		}      
		System.out.println("Number of words: " + file.getWordCount());
		System.out.println("Number of sentences: " + file.getSentenceCount());

	}
	
	/**
	 *
	 * @param filename, width, height, fontSize, wpm
	 * @purpose reads in a file and displays it in the RSVP style with .
	 * The words of the file are centered and colored based on the width and height of the window
	 */

	public static void focusLetter (String filename, int width, int height, int fontSize,
			int wpm) throws IOException, InterruptedException {
		WordGenerator file = new WordGenerator(filename);
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		FontMetrics metrics = g.getFontMetrics();
		while (file.hasNext()) {
			Font f = new Font("Courier", Font.BOLD, fontSize);
			g.setFont(f);
			String currentWord = file.next();
			if (currentWord.length()<2){
				g.setColor(Color.red);
				g.drawString((currentWord.substring(0,1)),
						((width/2)-metrics.charWidth(currentWord.charAt(0)/2)),
						((height-metrics.getHeight())/2));
				Thread.sleep(60000/wpm);
				panel.clear();
			} else if (currentWord.length()>=2 && currentWord.length() < 6){
				g.setColor(Color.red);
				g.drawString((currentWord.substring(1,2)),
						((width/2)-metrics.charWidth(currentWord.charAt(1)/2)),
						((height-metrics.getHeight())/2));
				g.setColor(Color.black);
				g.drawString(currentWord.substring(2),
						((width/2)-metrics.charWidth(currentWord.charAt(1)/2))+ 
						metrics.charWidth(currentWord.charAt(1)) + metrics.stringWidth(" "), 
						((height-metrics.getHeight())/2));

				g.drawString(currentWord.substring(0,1),
						((width/2)-metrics.charWidth(currentWord.charAt(1)/2))- 
						metrics.charWidth(currentWord.charAt(1))-metrics.stringWidth(" "), 
						((height-metrics.getHeight())/2));
				Thread.sleep(60000/wpm);
				panel.clear();
				
			} else if (currentWord.length()>5 && currentWord.length() < 10){
				g.setColor(Color.red);
				g.drawString((currentWord.substring(2,3)),
						((width/2)-metrics.charWidth(currentWord.charAt(2)/2)),
						((height-metrics.getHeight())/2));
				g.setColor(Color.black);
				g.drawString(currentWord.substring(3),
						((width/2)-metrics.charWidth(currentWord.charAt(2)/2))+
						metrics.charWidth(currentWord.charAt(2)) + metrics.stringWidth(" "), 
						((height-metrics.getHeight())/2));


				g.drawString(currentWord.substring(0,2),
						((width/2)-metrics.charWidth(currentWord.charAt(2)/2))- 
						2 * metrics.charWidth(currentWord.charAt(2))-2 * metrics.stringWidth(" "),
						((height-metrics.getHeight())/2));
				Thread.sleep(60000/wpm);
				panel.clear();
			}else if (currentWord.length()>9 && currentWord.length() < 14){
				g.setColor(Color.red);
				g.drawString((currentWord.substring(3,4)),
						((width/2)-metrics.charWidth(currentWord.charAt(3)/2)),
						((height-metrics.getHeight())/2));
				g.setColor(Color.black);
				g.drawString(currentWord.substring(4),((width/2)-
						metrics.charWidth(currentWord.charAt(3)/2)) +
						metrics.charWidth(currentWord.charAt(3)) + metrics.stringWidth(" "),
						((height-metrics.getHeight())/2));


				g.drawString(currentWord.substring(0,3),
						((width/2)-metrics.charWidth(currentWord.charAt(3)/2))- 
						3 * metrics.charWidth(currentWord.charAt(3))-3 * metrics.stringWidth(" "), 
						((height-metrics.getHeight())/2));
				Thread.sleep(60000/wpm);
				panel.clear();
			}else {
				g.setColor(Color.red);
				g.drawString((currentWord.substring(4,5)),((width/2) -
						metrics.charWidth(currentWord.charAt(4)/2)),
						((height-metrics.getHeight())/2));


				g.setColor(Color.black);
				g.drawString(currentWord.substring(5),((width/2) -
						metrics.charWidth(currentWord.charAt(4)/2)) + 
						metrics.charWidth(currentWord.charAt(4)) + 
						metrics.stringWidth(" "), ((height-metrics.getHeight())/2));


				g.drawString(currentWord.substring(0,4),((width/2) - 
						metrics.charWidth(currentWord.charAt(4)/2))- 
						4 * metrics.charWidth(currentWord.charAt(4)) -
						4 * metrics.stringWidth(" "), ((height-metrics.getHeight())/2));
				Thread.sleep(60000/wpm);
				panel.clear();
			}
		}
		System.out.println("Number of words: " + file.getWordCount());
		System.out.println("Number of sentences: " + file.getSentenceCount());
	}

			public static void main (String[] args) throws InterruptedException, IOException {          
				if(args.length != 5) {
					System.out.println("Invalid arguments.");
					System.out.println("Arguments have form <filename> <width> <height> "
							+ "<font size> <wpm>");
				} else {
					String filename = args[0];
					int width = Integer.parseInt(args[1]);
					int height = Integer.parseInt(args[2]);
					int fontSize = Integer.parseInt(args[3]);
					int wpm = Integer.parseInt(args[4]);
					demonstratePanel(filename, width, height, fontSize, wpm);
					focusLetter(filename, width, height, fontSize, wpm);
				}
			}
		}