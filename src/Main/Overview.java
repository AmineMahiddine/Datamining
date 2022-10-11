package Main;

import Models.Data;
import Models.Employee;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.RefineryUtilities;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
    private AnchorPane boxPlotPane;

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

    @FXML
    private Text varience;

    @FXML
    private Text etendue;

    @FXML
    private Text ecarttype;




    String clickedAttribute = "Age";



    ArrayList<?> data;

    ArrayList<Double> Ages = new ArrayList<>();
    ArrayList<Boolean> Attritions = new ArrayList<>();
    ArrayList<String> BusinessTravels = new ArrayList<>();
    ArrayList<Double> DailyRates = new ArrayList<>();
    ArrayList<String> Departments = new ArrayList<>();
    ArrayList<Double> DistanceFromHomes = new ArrayList<>();
    ArrayList<Double> Educations = new ArrayList<>();
    ArrayList<String> EducationFields = new ArrayList<>();
    ArrayList<Double> EmployeeCounts = new ArrayList<>();
    ArrayList<Double> EmployeeNumbers = new ArrayList<>();
    ArrayList<Double> EnvironmentSatisfactions = new ArrayList<>();
    ArrayList<String> Genders = new ArrayList<>();
    ArrayList<Double> HourlyRates = new ArrayList<>();
    ArrayList<Double> JobInvolvements = new ArrayList<>();
    ArrayList<Double> JobLevels = new ArrayList<>();
    ArrayList<String> JobRoles = new ArrayList<>();
    ArrayList<Double> JobSatisfactions = new ArrayList<>();
    ArrayList<String> MaritalStatuss = new ArrayList<>();
    ArrayList<Double> MonthlyIncomes = new ArrayList<>();
    ArrayList<Double> MonthlyRates = new ArrayList<>();
    ArrayList<Double> NumCompaniesWorkeds = new ArrayList<>();
    ArrayList<Boolean> Over18s = new ArrayList<>();
    ArrayList<Boolean> OverTimes = new ArrayList<>();
    ArrayList<Double> PercentSalaryHikes = new ArrayList<>();
    ArrayList<Double> PerformanceRatings = new ArrayList<>();
    ArrayList<Double> RelationshipSatisfactions = new ArrayList<>();
    ArrayList<Double> StandardHourss = new ArrayList<>();
    ArrayList<Double> StockOptionLevels = new ArrayList<>();
    ArrayList<Double> TotalWorkingYearss = new ArrayList<>();
    ArrayList<Double> TrainingTimesLastYears = new ArrayList<>();
    ArrayList<Double> WorkLifeBalances = new ArrayList<>();
    ArrayList<Double> YearsAtCompanys = new ArrayList<>();
    ArrayList<Double> YearsInCurrentRoles = new ArrayList<>();
    ArrayList<Double> YearsSinceLastPromotions = new ArrayList<>();
    ArrayList<Double> YearsWithCurrManagers = new ArrayList<>();

    private void initTableDesc(){
        nomCol.setCellValueFactory(new PropertyValueFactory<Data, String>("nom"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Data, String>("type"));
        natureCol.setCellValueFactory(new PropertyValueFactory<Data, String>("nature"));
        exampleCol.setCellValueFactory(new PropertyValueFactory<Data, String>("example"));
        dataTypeTab.getItems().setAll(Home.attributes);
        dataTypeTab.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 ){
                initTabs(dataTypeTab.getSelectionModel().getSelectedItem().getNom());

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

    public void openBoxPlot() {
        if(data.size()>0 && !clickedAttribute.isEmpty()){
            initBoxPlot((ArrayList<Double>) data, clickedAttribute);
        }else{
            System.out.println("there's an error");
        }
    }

    private void initTabs(String attribute){
        clickedAttribute = attribute;
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

        HBox list = new HBox();
        StackPane p ;
        Text txt;
        for (int i = 0; i < data.size(); i++) {
            txt = new Text(data.get(i).toString());
            p = new StackPane();
            p.setMinSize(40, 40);
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
                varience.setText(String.valueOf(String.format("%.2f",d.getVarience())));
                etendue.setText(String.valueOf(d.getEtendue()));
                ecarttype.setText(String.format("%.2f",StatUtils.getEcart_type((ArrayList<Double>) data)));
            }
        }
        dataList.setContent(list);


    }

    private void initBoxPlot(ArrayList<Double> list, String attribute){
        Stage stage= new Stage();
        stage.setScene(new Scene(Data.plotBoxplot(list, attribute)));
        stage.setTitle("Boxplot");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    public void plotHistogram() throws IOException {
        ChartViewer viewer = new ChartViewer(Histogramme.createHistogramChart((java.util.List<Double>) data, clickedAttribute, 30));
        Stage stage= new Stage();
        stage.setScene(new Scene(viewer));
        stage.setTitle("JFreeChart: Histogram");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
//        HistogramDataset hds = new HistogramDataset();
//        hds.setType(HistogramType.FREQUENCY);
//        double[] dataset = new double[data.size()];
//        for (int i = 0; i < dataset.length; i++) {
//            dataset[i] =  (Double) (data.get(i));
//        }
//        hds.addSeries("", dataset, 60);
////        HashMap<Integer, Integer> map = StatUtils.dataFrequencyCounter((ArrayList<Integer>) data);
////        for (int i = 0; i < map.keySet().size(); i++) {
////            hds.addSeries(map.keySet());
////        }
//        JFreeChart histogram = ChartFactory.createHistogram("Histogram", "Ages", "Ages",  hds, PlotOrientation.VERTICAL,false,false,false);
//
//        ChartPanel chartPanel = new ChartPanel(histogram);
//        JFrame frame = new JFrame();
//        frame.add(chartPanel);
//        frame.setVisible(true);

//        ChartViewer viewer = new ChartViewer(Graphique.createHistogramChart(data, clickedAttribute, nb_bins));
//        Stage stage= new Stage();
//        stage.setScene(new Scene(viewer));
//        stage.setTitle("JFreeChart: Histogram");
//        stage.setWidth(600);
//        stage.setHeight(400);
//        stage.show();
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
    }
}

