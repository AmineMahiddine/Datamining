package Main;

import Models.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class StatUtils {
    public static double getMinOf(ArrayList<Double> list){
        return list.get(0);
    }

    public static double getMaxOf(ArrayList<Double> list){
        return list.get(list.size()-1);
    }

    public static double getMeanOf(ArrayList<Double> list){
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum/list.size();
    }

    public static double[] getMedianeOf (ArrayList<Double> list){
        if(list.size()%2 == 1 ){
//            System.out.prdoubleln("Position : "+list.size()/2+" , Mediane P1:" +list.get(list.size()/2));
            return new double[]{list.get(list.size() / 2), list.size()/2};
        }
//        else{
//            System.out.prdoubleln("Position : ("+list.size()/2+","+(list.size()-1)/2+") , Mediane P1:" +(list.get(list.size()/2) + list.get((list.size()-1)/2))/2);
//        }
        return new double[]{(list.get(list.size() / 2) + list.get((list.size() + 1) / 2)) / 2, list.size()/2};
    }

    public static double[] getModeOf(ArrayList<Double> list){
        double maxVal = 0;
        double maxFreq = 0, freq = 0;
        for (int i = 0; i < list.size(); i++) {
            freq = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j)){
                    freq++;
                }
            }
            if(freq>maxFreq){
                maxFreq = freq;
                maxVal = list.get(i);
            }
        }
        return new double[]{maxVal,maxFreq};
//        System.out.prdoubleln("Le mode P1 : "+maxVal+", Frequence : "+ maxFreq);
    }

    public static double [] getQ1_Q3Of(ArrayList<Double> list){
        int posQ1 = list.size()/4;
        int posQ2 = 3 * list.size()/4;
        return new double[]{list.get(posQ1),posQ1, list.get(posQ2), posQ2};
    }

    public static double getEtendueOf(ArrayList<Double> list){
        return list.get(list.size()-1) - list.get(0);
    }

    public static double getVarienceOf(ArrayList<Double> list){
        double mean = getMeanOf(list);
        double accumulator = 0;
        for (int i = 0; i < list.size(); i++) {
            accumulator+=Math.pow(list.get(i)-mean,2);
        }
//        return list.stream().reduce(0d, (accumulator, current)-> accumulator + Math.pow(current - getMeanOf(list),2)) / list.size();
    return accumulator/list.size();
    }

    public static double getEcart_type(ArrayList<Double> list){
        return Math.sqrt(getVarienceOf(list));
    }

    public static boolean isSymetric(ArrayList<Double> list){
        double delta = 0.5;
        return ((Math.abs(getModeOf(list)[0] - getMedianeOf(list)[0]) < delta) &&
                (Math.abs(getMedianeOf(list)[0] - getMeanOf(list)) < delta) &&
                (Math.abs(getMeanOf(list) - getModeOf(list)[0]) < delta));
    }

    public static double corelationAttribute(ArrayList<Double> list){
        return 0.0;
    }

    public static ArrayList<Double> getOutlierOf(ArrayList<Double> list) {
        double[] q1_q3 = getQ1_Q3Of(list);
        double iqr = q1_q3[2] - q1_q3[0];
        return (ArrayList<Double>) list.stream().filter(val -> val > q1_q3[2] + iqr || val < q1_q3[0] - iqr).collect(Collectors.toList());
    }


    public static ArrayList<Double> tendence(ArrayList<Double> list, String attribute){
        list = SortUtils.sortByNumber(list);
        for (Data d:
             Home.attributes) {
            if(d.getNom().equals(attribute)){
                d.setMax(getMaxOf(list));
                d.setMin(getMinOf(list));
                d.setMean(getMeanOf(list));
                double [] mode_freq = getModeOf(list);
                d.setMode(mode_freq[0]);
                d.setModeFreq(mode_freq[1]);
                double [] mediane_pos = getMedianeOf(list);
                d.setMediane(mediane_pos[0]);
                d.setMedianePosition(mediane_pos[1]);
                double [] q1_q3 = getQ1_Q3Of(list);
                d.setQ1(q1_q3[0]);
//                System.out.prdoubleln(q1_q3[0]+" "+q1_q3[1]+" "+q1_q3[2]+" "+q1_q3[3]);
                d.setQ3(q1_q3[2]);

                d.setOutliers(getOutlierOf(list));
                d.setEtendue(getEtendueOf(list));
                d.setVarience(getVarienceOf(list));

            }
        }

        return SortUtils.sortByNumber(new HashSet<Double>(list));
    }

    public static HashMap<Double,Double> dataFrequencyCounter(ArrayList<Double> list){
        HashMap<Double,Double> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), map.get(list.get(i))+1);
        }
        return map;
    }
}
