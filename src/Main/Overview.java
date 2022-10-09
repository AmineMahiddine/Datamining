package Main;

import Models.Data;
import Models.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;


import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;


public class Overview implements Initializable {
    @FXML
    private TableColumn<Data, String> nomCol;

    @FXML
    private TableColumn<Data, String> typeCol;

    @FXML
    private TableColumn<Data, String> natureCol;

    @FXML
    private TableColumn<Data, String> exampleCol;

    @FXML
    private TableView<Data> dataTypeTab;

    @FXML
    private WebView boxPlotPane;

    @FXML
    private Pane datasetDescPane;

    @FXML
    private Pane attributeDetailPane;

    @FXML
    private ScrollPane dataList;

    @FXML
    private Text nomDattr;

    @FXML
    private Text nbrDon;

    @FXML
    private Text nbrAttr;

    @FXML
    private Text max;

    @FXML
    private Text min;

    @FXML
    private Text mean;

    @FXML
    private Text mode;

    @FXML
    private Text mediane;

    @FXML
    private Text freq;

    @FXML
    private Text posMediane;

    @FXML
    private Text q1;

    @FXML
    private Text q3;

    @FXML
    private Text iqr;

    private WebEngine engine;



    ArrayList<?> data;

    ArrayList<Integer> Ages = new ArrayList<>();
    ArrayList<Boolean> Attritions = new ArrayList<>();
    ArrayList<String> BusinessTravels = new ArrayList<>();
    ArrayList<Integer> DailyRates = new ArrayList<>();
    ArrayList<String> Departments = new ArrayList<>();
    ArrayList<Integer> DistanceFromHomes = new ArrayList<>();
    ArrayList<Integer> Educations = new ArrayList<>();
    ArrayList<String> EducationFields = new ArrayList<>();
    ArrayList<Integer> EmployeeCounts = new ArrayList<>();
    ArrayList<Integer> EmployeeNumbers = new ArrayList<>();
    ArrayList<Integer> EnvironmentSatisfactions = new ArrayList<>();
    ArrayList<String> Genders = new ArrayList<>();
    ArrayList<Integer> HourlyRates = new ArrayList<>();
    ArrayList<Integer> JobInvolvements = new ArrayList<>();
    ArrayList<Integer> JobLevels = new ArrayList<>();
    ArrayList<String> JobRoles = new ArrayList<>();
    ArrayList<Integer> JobSatisfactions = new ArrayList<>();
    ArrayList<String> MaritalStatuss = new ArrayList<>();
    ArrayList<Integer> MonthlyIncomes = new ArrayList<>();
    ArrayList<Integer> MonthlyRates = new ArrayList<>();
    ArrayList<Integer> NumCompaniesWorkeds = new ArrayList<>();
    ArrayList<Boolean> Over18s = new ArrayList<>();
    ArrayList<Boolean> OverTimes = new ArrayList<>();
    ArrayList<Integer> PercentSalaryHikes = new ArrayList<>();
    ArrayList<Integer> PerformanceRatings = new ArrayList<>();
    ArrayList<Integer> RelationshipSatisfactions = new ArrayList<>();
    ArrayList<Integer> StandardHourss = new ArrayList<>();
    ArrayList<Integer> StockOptionLevels = new ArrayList<>();
    ArrayList<Integer> TotalWorkingYearss = new ArrayList<>();
    ArrayList<Integer> TrainingTimesLastYears = new ArrayList<>();
    ArrayList<Integer> WorkLifeBalances = new ArrayList<>();
    ArrayList<Integer> YearsAtCompanys = new ArrayList<>();
    ArrayList<Integer> YearsInCurrentRoles = new ArrayList<>();
    ArrayList<Integer> YearsSinceLastPromotions = new ArrayList<>();
    ArrayList<Integer> YearsWithCurrManagers = new ArrayList<>();

    private void initTableDesc(){
        nomCol.setCellValueFactory(new PropertyValueFactory<Data, String>("nom"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Data, String>("type"));
        natureCol.setCellValueFactory(new PropertyValueFactory<Data, String>("nature"));
        exampleCol.setCellValueFactory(new PropertyValueFactory<Data, String>("example"));
        dataTypeTab.getItems().setAll(Home.attributes);
        dataTypeTab.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 ){
                initTabs(dataTypeTab.getSelectionModel().getSelectedItem().getNom());
                initBoxPlot();
            }
        });
    }

    private void initLists(){
        for (Employee e:
             Home.employees.values()) {
            Ages.add(e.getAge());
            Attritions.add(e.getAttrition());
            BusinessTravels.add(e.getBusinessTravel());
            DailyRates.add(e.getDailyRate());
            Departments.add(e.getDepartment());
            DistanceFromHomes.add(e.getDistanceFromHome());
            Educations.add(e.getEducation());
            EducationFields.add(e.getEducationField());
            EmployeeCounts.add(e.getEmployeeCount());
            EmployeeNumbers.add(e.getEmployeeNumber());
            EnvironmentSatisfactions.add(e.getEnvironmentSatisfaction());
            Genders.add(e.getGender());
            HourlyRates.add(e.getHourlyRate());
            JobInvolvements.add(e.getJobInvolvement());
            JobLevels.add(e.getJobLevel());
            JobRoles.add(e.getJobRole());
            JobSatisfactions.add(e.getJobSatisfaction());
            MaritalStatuss.add(e.getMaritalStatus());
            MonthlyIncomes.add(e.getMonthlyIncome());
            MonthlyRates.add(e.getMonthlyRate());
            NumCompaniesWorkeds.add(e.getNumCompaniesWorked());
            Over18s.add(e.getOver18());
            OverTimes.add(e.getOverTime());
            PercentSalaryHikes.add(e.getPercentSalaryHike());
            PerformanceRatings.add(e.getPerformanceRating());
            RelationshipSatisfactions.add(e.getRelationshipSatisfaction());
            StandardHourss.add(e.getStandardHours());
            StockOptionLevels.add(e.getStockOptionLevel());
            TotalWorkingYearss.add(e.getTotalWorkingYears());
            TrainingTimesLastYears.add(e.getTrainingTimesLastYear());
            WorkLifeBalances.add(e.getWorkLifeBalance());
            YearsAtCompanys.add(e.getYearsAtCompany());
            YearsInCurrentRoles.add(e.getYearsInCurrentRole());
            YearsSinceLastPromotions.add(e.getYearsSinceLastPromotion());
            YearsWithCurrManagers.add(e.getYearsWithCurrManager());
        }
        // update the attributes of object Data;
    }

    private void initTabs(String attribute){
        switch (attribute){
            case "Age" : data = StatUtils.tendence(Ages, "Age");  break;
            case "Education" : data = StatUtils.tendence(Educations,"Education"); break;
            case "EmployeeCount" : data = StatUtils.tendence(EmployeeCounts,"EmployeeCount"); break;
            case "EmployeeNumber" : data = StatUtils.tendence(EmployeeNumbers,"EmployeeNumber"); break;
            case "DistanceFromHome" : data = StatUtils.tendence(DistanceFromHomes,"DistanceFromHome"); break;
            case "EnvironmentSatisfaction" : data = StatUtils.tendence(EnvironmentSatisfactions,"EnvironmentSatisfaction"); break;
            case "HourlyRate" : data = StatUtils.tendence(HourlyRates,"HourlyRate"); break;
            case "JobInvolvement" : data = StatUtils.tendence(JobInvolvements,"JobInvolvement"); break;
            case "JobLevel" : data = StatUtils.tendence(JobLevels,"JobLevel"); break;
            case "JobSatisfaction" : data = StatUtils.tendence(JobSatisfactions,"JobSatisfaction"); break;
            case "MonthlyIncome" : data = StatUtils.tendence(MonthlyIncomes,"MonthlyIncome"); break;
            case "MonthlyRate" : data = StatUtils.tendence(MonthlyRates,"MonthlyRate"); break;
            case "NumCompaniesWorked" : data = StatUtils.tendence(NumCompaniesWorkeds,"NumCompaniesWorked"); break;
            case "PercentSalaryHike" : data = StatUtils.tendence(PercentSalaryHikes,"PercentSalaryHike"); break;
            case "PerformanceRating" : data = StatUtils.tendence(PerformanceRatings,"PerformanceRating"); break;
            case "RelationshipSatisfaction" : data = StatUtils.tendence(RelationshipSatisfactions,"RelationshipSatisfaction"); break;
            case "StandardHours" : data = StatUtils.tendence(StandardHourss,"StandardHours"); break;
            case "StockOptionLevel" : data = StatUtils.tendence(StockOptionLevels,"StockOptionLevel"); break;
            case "TotalWorkingYears" : data = StatUtils.tendence(TotalWorkingYearss,"TotalWorkingYears"); break;
            case "TrainingTimesLastYear" : data = StatUtils.tendence(TrainingTimesLastYears,"TrainingTimesLastYear"); break;
            case "WorkLifeBalance" : data = StatUtils.tendence(WorkLifeBalances,"WorkLifeBalance"); break;
            case "YearsAtCompany" : data = StatUtils.tendence(YearsAtCompanys,"YearsAtCompany"); break;
            case "YearsInCurrentRole" : data = StatUtils.tendence(YearsInCurrentRoles,"YearsInCurrentRole"); break;
            case "YearsSinceLastPromotion" : data = StatUtils.tendence(YearsSinceLastPromotions,"YearsSinceLastPromotion"); break;
            case "YearsWithCurrManager" : data = StatUtils.tendence(YearsWithCurrManagers,"YearsWithCurrManager"); break;
            case "DailyRate" : data = StatUtils.tendence(DailyRates,"DailyRate"); break;
            case "Attrition" : data = SortUtils.sortByBoolean(new HashSet<>(Attritions)); break;
            case "Over18" : data = SortUtils.sortByBoolean(new HashSet<>(Over18s)); break;
            case "OverTime" : data = SortUtils.sortByBoolean(new HashSet<>(OverTimes)); break;
            case "BusinessTravel" : data = SortUtils.sortByString(new HashSet<>(BusinessTravels)); break;
            case "Department" : data = SortUtils.sortByString(new HashSet<>(Departments)); break;
            case "EducationField" : data = SortUtils.sortByString(new HashSet<>(EducationFields)); break;
            case "Gender" : data = SortUtils.sortByString(new HashSet<>(Genders)); break;
            case "JobRole" : data = SortUtils.sortByString(new HashSet<>(JobRoles)); break;
            case "MaritalStatus" : data = SortUtils.sortByString(new HashSet<>(MaritalStatuss)); break;
        }

        VBox list = new VBox();
        StackPane p ;
        Text txt;
        for (int i = 0; i < data.size(); i++) {
            txt = new Text(data.get(i).toString());
            p = new StackPane();
            p.setMinSize(250, 20);
            p.setStyle("-fx-border-color:#e2e2e2;");

            p.getChildren().add(txt);
            p.setAlignment(txt, Pos.CENTER );

            list.getChildren().add(p);
        }
        nbrDon.setText(String.valueOf(Home.employees.size()));
        for (Data d:
             Home.attributes) {
            if(d.getNom().equals(attribute)){
                nomDattr.setText(attribute);
                max.setText(String.valueOf(d.getMax()));
                min.setText(String.valueOf(d.getMin()));
                mean.setText(String.valueOf(String.format("%.2f",d.getMean())));
                mediane.setText(String.valueOf(d.getMediane()));
                mode.setText(String.valueOf(d.getMode()));
                freq.setText(String.valueOf(d.getModeFreq()));
                posMediane.setText(String.valueOf(d.getMedianePosition()));
                nbrAttr.setText(String.valueOf(d.getNoise()));
                q1.setText(String.valueOf(d.getQ1()));
                q3.setText(String.valueOf(d.getQ3()));
                iqr.setText(String.valueOf(d.getEcartInterquartile()));
            }
        }
        dataList.setContent(list);


    }

    private void initBoxPlot(){
        engine = boxPlotPane.getEngine();
//        WebEngine webEngine = new WebEngine();
//        webView.getEngine().loadContent("D:\\Dev\\Java\\DataMining\\src\\web\\index.html");
//        System.out.println(getClass().getResource("/web/index.html").toString());
        engine.load(getClass().getResource("/web/index.html").toString());
//        engine.executeScript("plotBoxPlot(" + transformToJavascriptArray((ArrayList<Integer>) data) + ")");
//        File index = new File("D:\\Dev\\Java\\DataMining\\src\\web\\index.html");
//        webEngine.load(index.toURI().toString());
    }

    private String transformToJavascriptArray(ArrayList<Integer> arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (Integer val : arr)
            sb.append(val).append(", ");

        if (sb.length() > 1)
            sb.replace(sb.length() - 2, sb.length(), "");

        sb.append("]");
//        System.out.println(sb.toString());
        return sb.toString();
    }

//    private int getSizeOf(String attribute){
//        switch (attribute){
//            case "Age" : return Ages.size();
//            case "Attrition" : return Attritions.size();
//            case "BusinessTravel" : return BusinessTravels.size();
//            case "DailyRate" : return DailyRates.size();
//            case "Department" : return Departments.size();
//            case "DistanceFromHome" : return DistanceFromHomes.size();
//            case "Education" : return Educations.size();
//            case "EducationField" : return EducationFields.size();
//            case "EmployeeCount" : return EmployeeCounts.size();
//            case "EmployeeNumber" : return EmployeeNumbers.size();
//            case "EnvironmentSatisfaction" : return EnvironmentSatisfactions.size();
//            case "Gender" : return Genders.size();
//            case "HourlyRate" : return HourlyRates.size();
//            case "JobInvolvement" : return JobInvolvements.size();
//            case "JobLevel" : return JobLevels.size();
//            case "JobRole" : return JobRoles.size();
//            case "JobSatisfaction" : return JobSatisfactions.size();
//            case "MaritalStatus" : return MaritalStatuss.size();
//            case "MonthlyIncome" : return MonthlyIncomes.size();
//            case "MonthlyRate" : return MonthlyRates.size();
//            case "NumCompaniesWorked" : return NumCompaniesWorkeds.size();
//            case "Over18" : return Over18s.size();
//            case "OverTime" : return OverTimes.size();
//            case "PercentSalaryHike" : return PercentSalaryHikes.size();
//            case "PerformanceRating" : return PerformanceRatings.size();
//            case "RelationshipSatisfaction" : return RelationshipSatisfactions.size();
//            case "StandardHours" : return StandardHourss.size();
//            case "StockOptionLevel" : return StockOptionLevels.size();
//            case "TotalWorkingYears" : return TotalWorkingYearss.size();
//            case "TrainingTimesLastYear" : return TrainingTimesLastYears.size();
//            case "WorkLifeBalance" : return WorkLifeBalances.size();
//            case "YearsAtCompany" : return YearsAtCompanys.size();
//            case "YearsInCurrentRole" : return YearsInCurrentRoles.size();
//            case "YearsSinceLastPromotion" : return YearsSinceLastPromotions.size();
//            case "YearsWithCurrManager" : return YearsWithCurrManagers.size();
//        }
//        return 0;
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTableDesc();
        initLists();
        initTabs("Age");
        initBoxPlot();
    }
}

