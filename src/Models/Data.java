package Models;

public class Data {
    private String nom, type, nature, example;
    private int size, noise, max, min, mode,mediane, modeFreq, medianePosition,Q1,Q3;
    private double mean;

    public double getLmitLow(){
        return Q1 - 1.5*getEcartInterquartile();
    }

    public double getLmitUp(){
        return Q3 - 1.5*getEcartInterquartile();
    }

    public int getEcartInterquartile(){
        return getQ3() - getQ1();
    }

    public int getQ1() {
        return Q1;
    }

    public void setQ1(int q1) {
        Q1 = q1;
    }

    public int getQ3() {
        return Q3;
    }

    public void setQ3(int q3) {
        Q3 = q3;
    }


    public int getMedianePosition() {
        return medianePosition;
    }

    public void setMedianePosition(int medianePosition) {
        this.medianePosition = medianePosition;
    }

    public int getModeFreq() {
        return modeFreq;
    }

    public void setModeFreq(int modeFreq) {
        this.modeFreq = modeFreq;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise() {
        this.noise = noise+1;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMediane() {
        return mediane;
    }

    public void setMediane(int mediane) {
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
}
