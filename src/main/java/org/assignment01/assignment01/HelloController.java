package org.assignment01.assignment01;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private SwingNode swingNode;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFreeChart chart = null;
        try {
            chart = createJFreeChart(createDataset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ChartPanel chartPanel = new ChartPanel(chart);
        swingNode.setContent(chartPanel);
    }
    private JFreeChart createJFreeChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Temperature for 15 Feb 2024 to 22 Feb 2024 ",
                "Date",
                "Temperature",
                dataset
        );
    }
    private CategoryDataset createDataset() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DataGather dataGather = new DataGather();
        List<List<Object>> weatherEntries;
        weatherEntries = dataGather.GetDataCURL();

        for (List<Object> singleitem : weatherEntries) {
            System.out.println(singleitem.get(1) + " ");
            dataset.addValue((Number) singleitem.getLast(), (Comparable) singleitem.get(1), (Comparable) singleitem.getFirst());
        }

        return dataset;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}