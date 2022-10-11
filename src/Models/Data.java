package Models;

import Main.Boxplot;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jfree.chart.fx.ChartViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
    private String nom, type, nature, example;
    private double size, noise, max, min, mode,mediane, modeFreq, medianePosition,Q1,Q3, etendue;
    private double mean, varience;
    private ArrayList<Double> outliers;



    public double getEtendue() {
        return etendue;
    }

    public void setEtendue(double etendue) {
        this.etendue = etendue;
    }

    public double getVarience() {
        return varience;
    }

    public void setVarience(double varience) {
        this.varience = varience;
    }

    public ArrayList<Double> getOutliers() {
        return outliers;
    }

    public void setOutliers(ArrayList<Double> outliers) {
        this.outliers = outliers;
    }

    public double getLmitLow(){
        return Q1 - 1.5*getEcartInterquartile();
    }

    public double getLmitUp(){
        return Q3 - 1.5*getEcartInterquartile();
    }

    public double getEcartInterquartile(){
        return getQ3() - getQ1();
    }

    public double getQ1() {
        return Q1;
    }

    public void setQ1(double q1) {
        Q1 = q1;
    }

    public double getQ3() {
        return Q3;
    }

    public void setQ3(double q3) {
        Q3 = q3;
    }


    public double getMedianePosition() {
        return medianePosition;
    }

    public void setMedianePosition(double medianePosition) {
        this.medianePosition = medianePosition;
    }

    public double getModeFreq() {
        return modeFreq;
    }

    public void setModeFreq(double modeFreq) {
        this.modeFreq = modeFreq;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getNoise() {
        return noise;
    }

    public void setNoise() {
        this.noise = noise+1;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMediane() {
        return mediane;
    }

    public void setMediane(double mediane) {
        this.mediane = mediane;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Data(String nom, String type, String nature, String example) {
        this.nom = nom;
        this.type = type;
        this.nature = nature;
        this.example = example;
    }

    public static ChartViewer plotBoxplot(ArrayList<Double> values, String nom)
    {
        final Boxplot demo = new Boxplot("My box plot ",values,nom);
//        Stage stage= new Stage();
//        ChartViewer viewer = new ChartViewer(demo.getChart());
        return new ChartViewer(demo.getChart());
//        stage.setScene(new Scene(viewer));
//        stage.setTitle("Boxplot");
//        stage.setWidth(600);
//        stage.setHeight(400);
//        stage.show();
    }
}
