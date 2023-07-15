import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class FizzBuzz {

    private static SimpleAttributeSet attrs, textAttrs;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FizzBuzz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        textPane.setEditable(false);

        attrs = new SimpleAttributeSet();
        textAttrs = new SimpleAttributeSet();

        StyleConstants.setAlignment(textAttrs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(textAttrs, 20); // Set font size to 20

        try {
            BufferedImage originalImage = ImageIO.read(new File("assets/images/garcon.png")); // Replace with the path
            // to your image
            Image scaledImage = originalImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            StyleConstants.setIcon(attrs, new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a new JButton
        JButton button = new JButton("Start FizzBuzz");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> results = getFizzBuzz();
                textPane.setText(""); // Clear the text pane

                for (int i = 0; i < results.size(); i++) {
                    String result = results.get(i);
                    try {
                        textPane.getDocument().insertString(textPane.getDocument().getLength(), " ", attrs);
                        textPane.getDocument().insertString(textPane.getDocument().getLength(), result + "\n",
                                textAttrs);
                        System.out.println(result); // Print to the console
                        textPane.setParagraphAttributes(textAttrs, false);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add the button and scroll pane to the frame
        frame.add(button, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Load the background image
        try {
            BufferedImage bgImage = ImageIO.read(new File("assets/images/background.jpg")); // Replace with the path to

            JLabel bgLabel = new JLabel(new ImageIcon(bgImage));
            frame.setContentPane(bgLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);
    }

    public static List<String> getFizzBuzz() {
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            String result = "";
            if (i % 3 == 0 || Integer.toString(i).contains("3")) {
                result += "Fizz";
            }
            if (i % 5 == 0 || Integer.toString(i).contains("5")) {
                result += "Buzz";
            }
            if (result.isEmpty()) {
                result = Integer.toString(i);
            }
            results.add(result);
        }
        return results;
    }
}
