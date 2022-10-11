package Main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Histogramme {
    public static JFreeChart createHistogramChart(List<Double> l, String s, int number_bins  ) throws IOException {

        List<Double> list = l;
        String name =s;
        double[] values = new double[list.size()];
        for(int i = 0; i < list.size(); i++) values[i] = (double) list.get(i);

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, number_bins);
        dataset.setType(HistogramType.FREQUENCY);
        String title ="Histogramme de fr�quence de "+ name ;
        String x_label=name ;
        String y_lable= "fr�quences";

        JFreeChart histogram = ChartFactory.createHistogram(title ,
                x_label, y_lable, dataset, PlotOrientation.VERTICAL,
                false, false, false);
        histogram.setBackgroundPaint(Color.WHITE);

        return histogram;
    }
}
