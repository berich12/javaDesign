package GET;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test3 extends Application {
    private static final int TOP_WORDS_COUNT = 10;
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();

        Button chooseFileButton = new Button("view");
        TextArea resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        ImageView imageView=new ImageView();;

        chooseFileButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                List<String> topWords = getTopWords(selectedFile);
                resultTextArea.setText(String.join("\n", topWords));

                createWordCloudImage(topWords);
                Image image = new Image("file:E:\\大学\\大一\\java\\untitled1\\word_cloud.png");
                imageView.setImage(image);
            }
        });

        VBox vbox = new VBox(10, chooseFileButton, resultTextArea);
        vbox.setPadding(new Insets(10));

        vbox.getChildren().add(imageView);

        Scene scene = new Scene(vbox,600,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Word Frequency App");
        primaryStage.show();
    }

    private List<String> getTopWords(File file) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toUpperCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> topWords = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count >= TOP_WORDS_COUNT) {
                break;
            }
            topWords.add(entry.getKey());
            count++;
        }

        return topWords;
    }

    private void createWordCloudImage(List<String> topWords) {
        Pane canvas = new Pane();
        canvas.setMinSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        Random random = new Random();

        for (String word : topWords) {
            Text text = new Text(word);
            text.setFont(Font.font("Arial", FontWeight.BOLD, getRandomFontSize()));
            text.setFill(getRandomColor());
            text.setRotate(random.nextInt(90) - 45); // 随机旋转角度
            text.setLayoutX(random.nextInt(CANVAS_WIDTH - 100));
            text.setLayoutY(random.nextInt(CANVAS_HEIGHT - 50));
            canvas.getChildren().add(text);
        }

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = canvas.snapshot(params, null);

        try {
            File outputFile = new File("word_cloud.png");
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputFile);
            System.out.println("Word cloud image saved to: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getRandomFontSize() {
        return (int) (Math.random() * 30) + 50;
    }

    private Color getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}