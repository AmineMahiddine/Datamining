package Main;

import Models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class updateEmployeeController implements Initializable {
    private Employee employee;
    private String sortAttribute;
    private ObservableList<String> travel = FXCollections.observableList(Arrays.asList(new String[]{"Travel_Rarely", "Travel_Frequently", "Non-Travel"}));
    private ObservableList<String> dep = FXCollections.observableList(Arrays.asList(new String[]{"Sales","Research & Development","Human Resources"}));
    private ObservableList<String> edField = FXCollections.observableList(Arrays.asList(new String[]{"Human Resources","Life Sciences","Marketing","Technical Degree","Medical","Other"}));
    private ObservableList<String> gen = FXCollections.observableList(Arrays.asList(new String[]{"Male","Female"}));
    private ObservableList<String> jb = FXCollections.observableList(Arrays.asList(new String[]{"Healthcare Representative","Human Resources","Laboratory Technician","Manager","Manufacturing Director","Research Director","Research Scientist","Sales Executive","Sales Representative"}));


    @FXML
    private ToggleGroup attrition;

    @FXML
    private ComboBox<String> businessTravel;

    @FXML
    private TextField dailyRate;

    @FXML
    private ComboBox<String> department;

    @FXML
    private TextField distanceFromHome;

    @FXML
    private TextField education;

    @FXML
    private ComboBox<String> educationField;

    @FXML
    private TextField performanceRating;

    @FXML
    private TextField employeeCount;

    @FXML
    private TextField employeeNumber;

    @FXML
    private TextField environmentSatisfaction;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private TextField hourlyRate;

    @FXML
    private TextField JobInvolvement;

    @FXML
    private TextField jobLevel;

    @FXML
    private ComboBox<String> JobRole;

    @FXML
    private TextField relationshipSatisfaction;

    @FXML
    private TextField jobSatisfaction;

    @FXML
    private TextField maritalStatus;

    @FXML
    private TextField monthlyIncome;

    @FXML
    private TextField monthlyRate;

    @FXML
    private TextField numCompaniesWorked;

//    @FXML
//    private ToggleGroup over18;

    @FXML
    private TextField overTime;

    @FXML
    private TextField percentSalaryHike;

    @FXML
    private TextField standardHours;

    @FXML
    private TextField stockOptionLevel;

    @FXML
    private TextField totalWorkingYears;

    @FXML
    private TextField trainingTimesLastYear;

    @FXML
    private TextField workLifeBalance;

    @FXML
    private TextField yearsAtCompany;

    @FXML
    private TextField yearsInCurrentRole;

    @FXML
    private TextField yearsSinceLastPromotion;

    @FXML
    private TextField yearsWithCurrManager;

    @FXML
    private TextField age;

    @FXML
    private RadioButton attYes;

    @FXML
    private RadioButton attNo;

    @FXML
    private RadioButton overYes;

    @FXML
    private RadioButton overNo;

    @FXML
    private RadioButton overTYes;

    @FXML
    private RadioButton overTNo;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        age.setText(String.valueOf(employee.getAge()));
        if (employee.getAttrition()){
            attYes.setSelected(true);
        }else{
            attNo.setSelected(true);
        }

        businessTravel.getSelectionModel().select(travel.indexOf(employee.getBusinessTravel()));
        dailyRate.setText(String.valueOf(employee.getDailyRate()));
        department.getSelectionModel().select(dep.indexOf(employee.getDepartment()));
        distanceFromHome.setText(String.valueOf(employee.getDistanceFromHome()));
        education.setText(String.valueOf(employee.getEducation()));
        educationField.getSelectionModel().select(edField.indexOf(employee.getEducationField()));
        performanceRating.setText(String.valueOf(employee.getPerformanceRating()));
        employeeCount.setText(String.valueOf(employee.getEmployeeCount()));
        employeeNumber.setText(String.valueOf(employee.getEmployeeNumber()));
        employeeNumber.setDisable(true);
        environmentSatisfaction.setText(String.valueOf(employee.getEnvironmentSatisfaction()));
        gender.getSelectionModel().select(gen.indexOf(employee.getGender()));
        hourlyRate.setText(String.valueOf(employee.getHourlyRate()));
        JobInvolvement.setText(String.valueOf(employee.getJobInvolvement()));
        jobLevel.setText(String.valueOf(employee.getJobLevel()));
        JobRole.getSelectionModel().select(jb.indexOf(employee.getJobRole()));
        relationshipSatisfaction.setText(String.valueOf(employee.getRelationshipSatisfaction()));
        jobSatisfaction.setText(String.valueOf(employee.getJobSatisfaction()));
        maritalStatus.setText(employee.getMaritalStatus());
        monthlyIncome.setText(String.valueOf(employee.getMonthlyIncome()));
        monthlyRate.setText(String.valueOf(employee.getMonthlyRate()));
        numCompaniesWorked.setText(String.valueOf(employee.getNumCompaniesWorked()));
//        over18
//        System.out.println(employee.getOverTime());
        if(employee.getOver18()){
            overYes.setSelected(true);
        }else{
            overNo.setSelected(true);
        }
        if(employee.getOverTime()){
            overTYes.setSelected(true);
        }else{
            overTNo.setSelected(true);
        }
        percentSalaryHike.setText(String.valueOf(employee.getPercentSalaryHike()));
        standardHours.setText(String.valueOf(employee.getStandardHours()));
        stockOptionLevel.setText(String.valueOf(employee.getStockOptionLevel()));
        totalWorkingYears.setText(String.valueOf(employee.getTotalWorkingYears()));
        trainingTimesLastYear.setText(String.valueOf(employee.getTrainingTimesLastYear()));
        workLifeBalance.setText(String.valueOf(employee.getWorkLifeBalance()));
        yearsAtCompany.setText(String.valueOf(employee.getYearsAtCompany()));
        yearsInCurrentRole.setText(String.valueOf(employee.getYearsInCurrentRole()));
        yearsSinceLastPromotion.setText(String.valueOf(employee.getYearsSinceLastPromotion()));
        yearsWithCurrManager.setText(String.valueOf(employee.getYearsWithCurrManager()));
    }

    public void updateEmployee(){
        int age = Integer.parseInt(this.age.getText());
        Boolean attrition;
        if(this.attYes.isSelected()){
            attrition = true;
        }else{
            attrition = false;
        }
        String businessTravel = this.businessTravel.getSelectionModel().getSelectedItem();
        int dailyRate = Integer.parseInt(this.dailyRate.getText());
        String department = this.department.getSelectionModel().getSelectedItem();
        int distanceFromHome = Integer.parseInt(this.distanceFromHome.getText());
        int education = Integer.parseInt(this.education.getText());
        String educationField = this.educationField.getSelectionModel().getSelectedItem();
        int employeeCount = Integer.parseInt(this.employeeCount.getText());
//        int employeeNumber;
        int environmentSatisfaction = Integer.parseInt(this.environmentSatisfaction.getText());
        String gender = this.gender.getSelectionModel().getSelectedItem();
        int hourlyRate = Integer.parseInt(this.hourlyRate.getText());
        int jobInvolvement = Integer.parseInt(this.JobInvolvement.getText());
        int jobLevel = Integer.parseInt(this.jobLevel.getText());
        String jobRole = this.JobRole.getSelectionModel().getSelectedItem();
        int jobSatisfaction = Integer.parseInt(this.jobSatisfaction.getText());
        String maritalStatus = this.maritalStatus.getText();
        int monthlyIncome = Integer.parseInt(this.monthlyIncome.getText());
        int monthlyRate = Integer.parseInt(this.monthlyRate.getText());
        int numCompaniesWorked = Integer.parseInt(this.numCompaniesWorked.getText());
        Boolean over18 = false;
        if (this.overYes.isSelected()){
            over18 = true;
        }
        Boolean overTime = false;
        if(this.overTYes.isSelected()){
            overTime= true;
        }
        int percentSalaryHike = Integer.parseInt(this.percentSalaryHike.getText());
        int performanceRating = Integer.parseInt(this.performanceRating.getText());
        int relationshipSatisfaction = Integer.parseInt(this.relationshipSatisfaction.getText());
        int standardHours = Integer.parseInt(this.standardHours.getText());
        int stockOptionLevel = Integer.parseInt(this.stockOptionLevel.getText());
        int totalWorkingYears = Integer.parseInt(this.totalWorkingYears.getText());
        int trainingTimesLastYear = Integer.parseInt(this.trainingTimesLastYear.getText());
        int workLifeBalance = Integer.parseInt(this.workLifeBalance.getText());
        int yearsAtCompany = Integer.parseInt(this.yearsAtCompany.getText());
        int yearsInCurrentRole = Integer.parseInt(this.yearsInCurrentRole.getText());
        int yearsSinceLastPromotion = Integer.parseInt(this.yearsSinceLastPromotion.getText());
        int yearsWithCurrManager = Integer.parseInt(this.yearsWithCurrManager.getText());
        setEmployee(new Employee(age,attrition,businessTravel,dailyRate,department,distanceFromHome,education,educationField,employeeCount,Integer.parseInt(employeeNumber.getText()),environmentSatisfaction,gender,hourlyRate,jobInvolvement,jobLevel,jobRole,jobSatisfaction,maritalStatus,monthlyIncome,monthlyRate,numCompaniesWorked,over18,overTime,percentSalaryHike,performanceRating,relationshipSatisfaction,standardHours,stockOptionLevel,totalWorkingYears,trainingTimesLastYear,workLifeBalance,yearsAtCompany,yearsInCurrentRole,yearsSinceLastPromotion,yearsWithCurrManager));
        Home.employees.put(employee.getEmployeeNumber(), employee);
        Stage stage = (Stage) this.age.getScene().getWindow();
        stage.close();
    }

    @Override
    public String toString() {
        return "updateEmployeeController{" +
                "employee=" + employee +
                '}';
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        businessTravel.setItems(travel);
        department.setItems(dep);
        educationField.setItems(edField);
        gender.setItems(gen);
        JobRole.setItems(jb);
    }

    public String getSortAttribute() {
        return sortAttribute;
    }

    public void setSortAttribute(String sortAttribute) {
        this.sortAttribute = sortAttribute;
    }
}
