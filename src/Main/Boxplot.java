package Main;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;

@SuppressWarnings("serial")
public class Boxplot extends ApplicationFrame {
    private final ArrayList<Double> values=new ArrayList<>();
    private  String name;
    private  JFreeChart chart;
    public ChartPanel chartPanel;

    public Boxplot(String title, ArrayList<Double> values, String name)   {

        super(title);
        this.values.addAll(values);
        this.name=name;
        final DefaultBoxAndWhiskerCategoryDataset dataset = createDataset();
        createChart(dataset);

        this.chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(320, 600));


        setContentPane(chartPanel);
//        this.add(chartPanel, BorderLayout.CENTER);
//        this.pack();
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);

    }


    private DefaultBoxAndWhiskerCategoryDataset  createDataset()
    {

        DefaultBoxAndWhiskerCategoryDataset data = new DefaultBoxAndWhiskerCategoryDataset();
        data.add(values, this.name , this.name);

        return data;
    }
    private void createChart(
            final DefaultBoxAndWhiskerCategoryDataset dataset) {
        /*JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
                "Boxplot of"+" "+name, name, "Value", dataset, true);*/
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setFillBox(true);

        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.LIGHT_GRAY);
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesOutlinePaint(1, Color.BLACK);
        renderer.setAutoPopulateSeriesShape(false);
        renderer.setUseOutlinePaintForWhiskers(true );
        Font legendFont = new Font("SansSerif", Font.PLAIN, 16);
        renderer.setLegendTextFont(0, legendFont);
        renderer.setLegendTextFont(1, legendFont);
        renderer.setMedianVisible(true);
        renderer.setMeanVisible(false);
        renderer.setWhiskerWidth(0.5);;
        renderer.setMaximumBarWidth(0.15);

        CategoryAxis categoryAxis = new CategoryAxis("");
        NumberAxis valueAxis = new NumberAxis("");
        valueAxis.setAutoRangeIncludesZero(true);

        CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis,
                renderer);
        this.chart = new JFreeChart(plot);
        this.chart.setBackgroundPaint(new Color(255, 255, 255));


    }

    public JFreeChart getChart() {
        return chart;
    }
}
