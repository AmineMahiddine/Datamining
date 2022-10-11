package Main;

import Models.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class SortUtils {

    public static ArrayList<Employee> sortByAge(Collection <Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getAge(), e2.getAge()));
        return ar;
    }
    public static ArrayList<Employee> sortByAttrition(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Boolean.compare(e1.getAttrition(), e2.getAttrition()));
        return ar;
    }
    public static ArrayList<Employee> sortByBusinessTravel(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getBusinessTravel(), e2.getBusinessTravel()));
        return ar;
    }
    public static ArrayList<Employee> sortByDailyRate(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getDailyRate(), e2.getDailyRate()));
        return ar;
    }
    public static ArrayList<Employee> sortByDepartment(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getDepartment(), e2.getDepartment()));
        return ar;
    }
    public static ArrayList<Employee> sortByDistanceFromHome(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getDistanceFromHome(), e2.getDistanceFromHome()));
        return ar;
    }
    public static ArrayList<Employee> sortByEducation(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getEducation(), e2.getEducation()));
        return ar;
    }
    public static ArrayList<Employee> sortByEducationField(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getEducationField(), e2.getEducationField()));
        return ar;
    }
    public static ArrayList<Employee> sortByEmployeeCount(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getEmployeeCount(), e2.getEmployeeCount()));
        return ar;
    }
    public static ArrayList<Employee> sortByEmployeeNumber(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getEmployeeNumber(), e2.getEmployeeNumber()));
        return ar;
    }
    public static ArrayList<Employee> sortByEnvironmentSatisfaction(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getEnvironmentSatisfaction(), e2.getEnvironmentSatisfaction()));
        return ar;
    }
    public static ArrayList<Employee> sortByGender(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getGender(), e2.getGender()));
        return ar;
    }
    public static ArrayList<Employee> sortByHourlyRate(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getHourlyRate(), e2.getHourlyRate()));
        return ar;
    }
    public static ArrayList<Employee> sortByJobInvolvement(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getJobInvolvement(), e2.getJobInvolvement()));
        return ar;
    }
    public static ArrayList<Employee> sortByJobLevel(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getJobLevel(), e2.getJobLevel()));
        return ar;
    }
    public static ArrayList<Employee> sortByJobRole(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getJobRole(), e2.getJobRole()));
        return ar;
    }
    public static ArrayList<Employee> sortByJobSatisfaction(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getJobSatisfaction(), e2.getJobSatisfaction()));
        return ar;
    }
    public static ArrayList<Employee> sortByMaritalStatus(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) -> CharSequence.compare(e1.getMaritalStatus(), e2.getMaritalStatus()));
        return ar;
    }
    public static ArrayList<Employee> sortByMonthlyIncome(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getMonthlyIncome(), e2.getMonthlyIncome()));
        return ar;
    }
    public static ArrayList<Employee> sortByMonthlyRate(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getMonthlyRate(), e2.getMonthlyRate()));
        return ar;
    }
    public static ArrayList<Employee> sortByNumCompaniesWorked(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getNumCompaniesWorked(), e2.getNumCompaniesWorked()));
        return ar;
    }
    public static ArrayList<Employee> sortByOver18(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Boolean.compare(e1.getOver18(), e2.getOver18()));
        return ar;
    }
    public static ArrayList<Employee> sortByOverTime(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Boolean.compare(e1.getOverTime(), e2.getOverTime()));
        return ar;
    }
    public static ArrayList<Employee> sortByPercentSalaryHike(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getPercentSalaryHike(), e2.getPercentSalaryHike()));
        return ar;
    }
    public static ArrayList<Employee> sortByPerformanceRating(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getPerformanceRating(), e2.getPerformanceRating()));
        return ar;
    }
    public static ArrayList<Employee> sortByRelationshipSatisfaction(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getRelationshipSatisfaction(), e2.getRelationshipSatisfaction()));
        return ar;
    }
    public static ArrayList<Employee> sortByStandardHours(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getStandardHours(), e2.getStandardHours()));
        return ar;
    }
    public static ArrayList<Employee> sortByStockOptionLevel(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getStockOptionLevel(), e2.getStockOptionLevel()));
        return ar;
    }
    public static ArrayList<Employee> sortByTotalWorkingYears(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getTotalWorkingYears(), e2.getTotalWorkingYears()));
        return ar;
    }
    public static ArrayList<Employee> sortByTrainingTimesLastYear(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getTrainingTimesLastYear(), e2.getTrainingTimesLastYear()));
        return ar;
    }
    public static ArrayList<Employee> sortByWorkLifeBalance(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getWorkLifeBalance(), e2.getWorkLifeBalance()));
        return ar;
    }
    public static ArrayList<Employee> sortByYearsAtCompany(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getYearsAtCompany(), e2.getYearsAtCompany()));
        return ar;
    }
    public static ArrayList<Employee> sortByYearsInCurrentRole(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getYearsInCurrentRole(), e2.getYearsInCurrentRole()));
        return ar;
    }
    public static ArrayList<Employee> sortByYearsSinceLastPromotion(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getYearsSinceLastPromotion(), e2.getYearsSinceLastPromotion()));
        return ar;
    }
    public static ArrayList<Employee> sortByYearsWithCurrManager(Collection<Employee> employees){
        ArrayList<Employee> ar = new ArrayList<>(employees);
        Collections.sort(ar, (e1, e2) ->Double.compare(e1.getYearsWithCurrManager(), e2.getYearsWithCurrManager()));
        return ar;
    }

    // Sort methodes that i will use :
    public static ArrayList<Double> sortByNumber(HashSet<Double> employees){
        ArrayList<Double> emp = new ArrayList<>(employees);
        Collections.sort(emp, (e1, e2) ->Double.compare(e1, e2));
        return emp;
    }

    public static ArrayList<Boolean> sortByBoolean(HashSet<Boolean> employees){
        ArrayList<Boolean> emp = new ArrayList<>(employees);
        Collections.sort(emp, (e1, e2) ->Boolean.compare(e1, e2));
        return emp;
    }

    public static ArrayList<String> sortByString(HashSet<String> employees){
        ArrayList<String> emp = new ArrayList<>(employees);
        Collections.sort(emp, (e1, e2) -> CharSequence.compare(e1, e2));
        return emp;
    }

    public static ArrayList<Double> sortByNumber(ArrayList<Double> employees){
        Collections.sort(employees, (e1, e2) ->Double.compare(e1, e2));
        return employees;
    }

    public static ArrayList<Boolean> sortByBoolean(ArrayList<Boolean> employees){
        Collections.sort(employees, (e1, e2) ->Boolean.compare(e1, e2));
        return employees;
    }

    public static ArrayList<String> sortByString(ArrayList<String> employees){
        Collections.sort(employees, (e1, e2) -> CharSequence.compare(e1, e2));
        return employees;
    }
}
