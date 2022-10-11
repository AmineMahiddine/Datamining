package Main;

import Models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private TableView<Employee> dataFrame;
    @FXML
    private TableColumn<Employee, Integer> nCol;

    @FXML
    private TableColumn<Employee, Integer> ageCol;

    @FXML
    private TableColumn<Employee, String> genderCol;

    @FXML
    private TableColumn<Employee, String> maritalCol;

    @FXML
    private TableColumn<Employee, String> eduCol;

    @FXML
    private TableColumn<Employee, String> depCol;

    @FXML
    private TableColumn<Employee, String> jobCol;

    @FXML
    private ComboBox<String> sortByCombo;

    @FXML
    private TableColumn<Employee, String> BusinessCol;

    @FXML
    private TableColumn<Employee, Integer> DailyCol;

    @FXML
    private TableColumn<Employee, Integer> DistanceFromHomeCol;

    @FXML
    private TableColumn<Employee, Integer> EducationCol;

    @FXML
    private TableColumn<Employee, Integer> EmployeeCountCol;

    @FXML
    private TableColumn<Employee, Integer> EnvironmentSatisfactionCol;

    @FXML
    private TableColumn<Employee, Integer> HourlyRateCol;

    @FXML
    private TableColumn<Employee, Integer> JobInvolvementCol;

    @FXML
    private TableColumn<Employee, Integer> JobLevelCol;

    @FXML
    private TableColumn<Employee, Integer> JobSatisfactionCol;

    @FXML
    private TableColumn<Employee, Integer> MonthlyIncomeCol;

    @FXML
    private TableColumn<Employee, Integer> MonthlyRateCol;

    @FXML
    private TableColumn<Employee, Integer> NumCompaniesWorkedCol;

    @FXML
    private TableColumn<Employee, Boolean> Over18Col;

    @FXML
    private TableColumn<Employee, Boolean> OverTimeCol;

    @FXML
    private TableColumn<Employee, Integer> PercentSalaryHikeCol;

    @FXML
    private TableColumn<Employee, Integer> PerformanceRatingCol;

    @FXML
    private TableColumn<Employee, Integer> RelationshipSatisfactionCol;

    @FXML
    private TableColumn<Employee, Integer> StockOptionLevelCol;

    @FXML
    private TableColumn<Employee, Integer> TotalWorkingYearsCol;

    @FXML
    private TableColumn<Employee, Integer> TrainingTimesLastYearCol;

    @FXML
    private TableColumn<Employee, Integer> WorkLifeBalanceCol;

    @FXML
    private TableColumn<Employee, Integer> YearsAtCompanyCol;

    @FXML
    private TableColumn<Employee, Integer> YearsInCurrentRoleCol;

    @FXML
    private TableColumn<Employee, Integer> YearsSinceLastPromotionCol;

    @FXML
    private TableColumn<Employee, Integer> YearsWithCurrManagerCol;

    private void initTableCols (){
        nCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("EmployeeNumber"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("age"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        maritalCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("maritalStatus"));
        eduCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("educationField"));
        depCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        jobCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobRole"));
        BusinessCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("businessTravel"));
        DailyCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("dailyRate"));
        DistanceFromHomeCol.setCellValueFactory(new PropertyValueFactory<Employee,Integer >("distanceFromHome"));
        EducationCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("education"));
        EmployeeCountCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeCount"));
        EnvironmentSatisfactionCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("environmentSatisfaction"));
        HourlyRateCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("hourlyRate"));
        JobInvolvementCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("jobInvolvement"));
        JobLevelCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("jobLevel"));
        JobSatisfactionCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("jobSatisfaction"));
        MonthlyIncomeCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("monthlyIncome"));
        MonthlyRateCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("monthlyRate"));
        NumCompaniesWorkedCol.setCellValueFactory(new PropertyValueFactory<Employee,Integer >("numCompaniesWorked"));
        Over18Col.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("over18"));
        OverTimeCol.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("overTime"));
        PercentSalaryHikeCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("percentSalaryHike"));
        PerformanceRatingCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("performanceRating"));
        RelationshipSatisfactionCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("relationshipSatisfaction"));
        StockOptionLevelCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("stockOptionLevel"));
        TotalWorkingYearsCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("totalWorkingYears"));
        TrainingTimesLastYearCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("trainingTimesLastYear"));
        WorkLifeBalanceCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("workLifeBalance"));
        YearsAtCompanyCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("yearsAtCompany"));
        YearsInCurrentRoleCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("yearsInCurrentRole"));
        YearsSinceLastPromotionCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("yearsSinceLastPromotion"));
        YearsWithCurrManagerCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("yearsWithCurrManager"));

        dataFrame.getItems().setAll(sortBy("EmployeeNumber"));

        dataFrame.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 ){
                openUpdateWindow(dataFrame.getSelectionModel().getSelectedItem());
            }
        });
    }

    private ObservableList<String> attributes = FXCollections.observableList(Arrays.asList(new String[]{"Age",
            "Attrition",
            "BusinessTravel",
            "DailyRate",
            "Department",
            "DistanceFromHome",
            "Education",
            "EducationField",
            "EmployeeCount",
            "EmployeeNumber",
            "EnvironmentSatisfaction",
            "Gender",
            "HourlyRate",
            "JobInvolvement",
            "JobLevel",
            "JobRole",
            "JobSatisfaction",
            "MaritalStatus",
            "MonthlyIncome",
            "MonthlyRate",
            "NumCompaniesWorked",
            "Over18",
            "OverTime",
            "PercentSalaryHike",
            "PerformanceRating",
            "RelationshipSatisfaction",
            "StandardHours",
            "StockOptionLevel",
            "TotalWorkingYears",
            "TrainingTimesLastYear",
            "WorkLifeBalance",
            "YearsAtCompany",
            "YearsInCurrentRole",
            "YearsSinceLastPromotion",
            "YearsWithCurrManager"}));

    private ArrayList<Employee> sortBy (String attribute){
        switch (attribute){
            case  "Age" : return SortUtils.sortByAge(Home.employees.values());
            case  "Attrition" : return SortUtils.sortByAttrition(Home.employees.values());
            case  "BusinessTravel" : return SortUtils.sortByBusinessTravel(Home.employees.values());
            case  "DailyRate" : return SortUtils.sortByDailyRate(Home.employees.values());
            case  "Department" : return SortUtils.sortByDepartment(Home.employees.values());
            case  "DistanceFromHome" : return SortUtils.sortByDistanceFromHome(Home.employees.values());
            case  "Education" : return SortUtils.sortByEducation(Home.employees.values());
            case  "EducationField" : return SortUtils.sortByEducationField(Home.employees.values());
            case  "EmployeeCount" : return SortUtils.sortByEmployeeCount(Home.employees.values());
            case  "EmployeeNumber" : return SortUtils.sortByEmployeeNumber(Home.employees.values());
            case  "EnvironmentSatisfaction" : return SortUtils.sortByEnvironmentSatisfaction(Home.employees.values());
            case  "Gender" : return SortUtils.sortByGender(Home.employees.values());
            case  "HourlyRate" : return SortUtils.sortByHourlyRate(Home.employees.values());
            case  "JobInvolvement" : return SortUtils.sortByJobInvolvement(Home.employees.values());
            case  "JobLevel" : return SortUtils.sortByJobLevel(Home.employees.values());
            case  "JobRole" : return SortUtils.sortByJobRole(Home.employees.values());
            case  "JobSatisfaction" : return SortUtils.sortByJobSatisfaction(Home.employees.values());
            case  "MaritalStatus" : return SortUtils.sortByMaritalStatus(Home.employees.values());
            case  "MonthlyIncome" : return SortUtils.sortByMonthlyIncome(Home.employees.values());
            case  "MonthlyRate" : return SortUtils.sortByMonthlyRate(Home.employees.values());
            case  "NumCompaniesWorked" : return SortUtils.sortByNumCompaniesWorked(Home.employees.values());
            case  "Over18" : return SortUtils.sortByOver18(Home.employees.values());
            case  "OverTime" : return SortUtils.sortByOverTime(Home.employees.values());
            case  "PercentSalaryHike" : return SortUtils.sortByPercentSalaryHike(Home.employees.values());
            case  "PerformanceRating" : return SortUtils.sortByPerformanceRating(Home.employees.values());
            case  "RelationshipSatisfaction" : return SortUtils.sortByRelationshipSatisfaction(Home.employees.values());
            case  "StandardHours" : return SortUtils.sortByStandardHours(Home.employees.values());
            case  "StockOptionLevel" : return SortUtils.sortByStockOptionLevel(Home.employees.values());
            case  "TotalWorkingYears" : return SortUtils.sortByTotalWorkingYears(Home.employees.values());
            case  "TrainingTimesLastYear" : return SortUtils.sortByTrainingTimesLastYear(Home.employees.values());
            case  "WorkLifeBalance" : return SortUtils.sortByWorkLifeBalance(Home.employees.values());
            case  "YearsAtCompany" : return SortUtils.sortByYearsAtCompany(Home.employees.values());
            case  "YearsInCurrentRole" : return SortUtils.sortByYearsInCurrentRole(Home.employees.values());
            case  "YearsSinceLastPromotion" : return SortUtils.sortByYearsSinceLastPromotion(Home.employees.values());
            case  "YearsWithCurrManager" : return SortUtils.sortByYearsWithCurrManager(Home.employees.values());
        }
        return new ArrayList<>();
//        ArrayList<Employee> ar = new ArrayList<>(employees.values());
//        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getEmployeeNumber(), e2.getEmployeeNumber()));
//        return ar;
    }

    public void sortDataFrame (){
        dataFrame.getItems().setAll(sortBy(sortByCombo.getSelectionModel().getSelectedItem()));
    }

    public void openUpdateWindow(Employee employee) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("updateEmployeeView.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);


            updateEmployeeController ctrl = loader.getController();
            ctrl.setEmployee(employee);

            stage.showAndWait();

            dataFrame.getItems().setAll(sortBy("EmployeeNumber"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sortByCombo.setItems(attributes);
        sortByCombo.getSelectionModel().select("EmployeeNumber");
        initTableCols();
    }
}
