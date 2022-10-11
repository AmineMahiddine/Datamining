package Main;

import Models.Data;
import Models.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Home implements Initializable {
    @FXML
    private Pane content;

    public static HashMap<Integer,Employee> employees = new HashMap<>();
    public static ArrayList<Data> attributes = new ArrayList<>();


    public void loadTableScene(){
        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("main.fxml"));
            content.getChildren().setAll(loader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadOverviewScene(){
        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("Overview.fxml"));
            content.getChildren().setAll(loader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void DataSetReader (){
//        ArrayList<Employee> employees = new ArrayList<>();
        Scanner myReader;
        try {
            int i = 0;
            File file = new File("D:\\Dev\\Java\\DataMining\\src\\Datasets\\Dataset1.csv");
            FileInputStream dataset = new FileInputStream(file);
            myReader = new Scanner(dataset);
            String line;
//            int age;
//            Boolean attrition;
//            String businessTravel;
//            int dailyRate;
//            String department;
//            int distanceFromHome;
//            int education;
//            String educationField;
//            int employeeCount;
//            int employeeNumber;
//            int environmentSatisfaction;
//            String gender;
//            int hourlyRate;
//            int jobInvolvement;
//            int jobLevel;
//            String jobRole;
//            int jobSatisfaction;
//            String maritalStatus;
//            int monthlyIncome;
//            int monthlyRate;
//            int numCompaniesWorked;
//            Boolean over18;
//            Boolean overTime;
//            int percentSalaryHike;
//            int performanceRating;
//            int relationshipSatisfaction;
//            int standardHours;
//            int stockOptionLevel;
//            int totalWorkingYears;
//            int trainingTimesLastYear;
//            int workLifeBalance;
//            int yearsAtCompany;
//            int yearsInCurrentRole;
//            int yearsSinceLastPromotion;
//            int yearsWithCurrManager;
            while (myReader.hasNextLine()){
                line = myReader.nextLine();
                if(!line.isEmpty()){
                    String[] data = line.split(",");
                    if(i != 0) {
                        for (int j = 0; j< data.length; j++){
                            if(data[j].isEmpty()){
                                attributes.get(j).setNoise();
                                data[j] = "-1";
                            }
                            if(data[j].equals("Yes") || data[j].equals("Y")){
                                data[j] = "true";
                            }
                            if(data[j].equals("No") || data[j].equals("N")){
                                data[j] = "false";
                            }
                        }

                        employees.put(Integer.parseInt(data[9]), new Employee(
                                Double.parseDouble(data[0]),Boolean.valueOf(data[1]),data[2],Double.parseDouble(data[3]),data[4],Double.parseDouble(data[5]),Double.parseDouble(data[6]),data[7],Double.parseDouble(data[8]),Double.parseDouble(data[9]),Double.parseDouble(data[10]),data[11],Double.parseDouble(data[12]),Double.parseDouble(data[13]),Double.parseDouble(data[14]),data[15],Double.parseDouble(data[16]),data[17],Double.parseDouble(data[18]),Double.parseDouble(data[19]),Double.parseDouble(data[20]),Boolean.valueOf(data[21]),Boolean.valueOf(data[22]),Double.parseDouble(data[23]),Double.parseDouble(data[24]),Double.parseDouble(data[25]),Double.parseDouble(data[26]),Double.parseDouble(data[27]),Double.parseDouble(data[28]),Double.parseDouble(data[29]),Double.parseDouble(data[30]),Double.parseDouble(data[31]),Double.parseDouble(data[32]),Double.parseDouble(data[33]),Double.parseDouble(data[34])
                        ));
                        if(i==1){
                            Data d;
                            Pattern patternDouble = Pattern.compile("-?\\d+(\\.\\d+)?");
                            Pattern patternInt = Pattern.compile("-?\\d+");

                            for (int j = 0; j < data.length; j++) {
                                d = attributes.get(j);
                                if(data[j].getClass().getName().equals("java.lang.String")){
                                    if(data[j].equals("Yes") || data[j].equals("Y") || data[j].equals("No") || data[j].equals("N")){
                                        d.setType("Boolean");
                                        d.setNature("Qualitative nominale");
                                        d.setExample(data[j]);
                                    }else if (patternInt.matcher(data[j]).matches()){
                                        d.setType("Integer");
                                        d.setNature("Numérique discrète ");
                                        d.setExample(data[j]);

                                    }else if(patternDouble.matcher(data[j]).matches()){
                                        d.setType("Double");
                                        d.setNature("Numérique continue ");
                                        d.setExample(data[j]);
                                    }else{
                                        d.setType("String");
                                        d.setNature("Qualitative nominale");
                                        d.setExample(data[j]);
                                    }
                                }
                            }
                            i++;
                        }
                    }else{
                        for (String att:data
                             ) {
                        attributes.add(new Data(att,"","",""));
                        }
                        i++;
                    }
                }
            }

            myReader.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataSetReader();
        loadTableScene();
    }
}
