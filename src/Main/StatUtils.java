package Main;

import Models.Data;

import java.util.ArrayList;
import java.util.HashSet;

public class StatUtils {
    public static int getMinOf(ArrayList<Integer> list){
        return list.get(0);
    }

    public static int getMaxOf(ArrayList<Integer> list){
        return list.get(list.size()-1);
    }

    public static double getMeanOf(ArrayList<Integer> list){
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum/list.size();
    }

    public static int[] getMedianeOf (ArrayList<Integer> list){
        if(list.size()%2 == 1 ){
//            System.out.println("Position : "+list.size()/2+" , Mediane P1:" +list.get(list.size()/2));
            return new int[]{list.get(list.size() / 2), list.size()/2};
        }
//        else{
//            System.out.println("Position : ("+list.size()/2+","+(list.size()-1)/2+") , Mediane P1:" +(list.get(list.size()/2) + list.get((list.size()-1)/2))/2);
//        }
        return new int[]{(list.get(list.size() / 2) + list.get((list.size() + 1) / 2)) / 2, list.size()/2};
    }

    public static int[] getModeOf(ArrayList<Integer> list){
        int maxVal = 0;
        int maxFreq = 0, freq = 0;
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
        return new int[]{maxVal,maxFreq};
//        System.out.println("Le mode P1 : "+maxVal+", Frequence : "+ maxFreq);
    }

    public static int [] getQ1_Q3Of(ArrayList<Integer> list){
        int posQ1 = list.size()/4;
        int posQ2 = 3 * list.size()/4;
        return new int[]{list.get(posQ1),posQ1, list.get(posQ2), posQ2};
    }

    public static ArrayList<Integer> tendence(ArrayList<Integer> list, String attribute){
        list = SortUtils.sortByNumber(list);
        for (Data d:
             Home.attributes) {
            if(d.getNom().equals(attribute)){
                d.setMax(getMaxOf(list));
                d.setMin(getMinOf(list));
                d.setMean(getMeanOf(list));
                int [] mode_freq = getModeOf(list);
                d.setMode(mode_freq[0]);
                d.setModeFreq(mode_freq[1]);
                int [] mediane_pos = getMedianeOf(list);
                d.setMediane(mediane_pos[0]);
                d.setMedianePosition(mediane_pos[1]);
                int [] q1_q3 = getQ1_Q3Of(list);
                d.setQ1(q1_q3[0]);
//                System.out.println(q1_q3[0]+" "+q1_q3[1]+" "+q1_q3[2]+" "+q1_q3[3]);
                d.setQ3(q1_q3[2]);

            }
        }
        return SortUtils.sortByNumber(new HashSet<>(list));
    }
}
