package sample.Utility;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Data.ItemDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadCSV {

    public ObservableList<String>  csvqueryDropDownList(String mealType, String meal){

       // ArrayList<String> strList = new ArrayList<String>();
        ObservableList<String> strList = FXCollections.observableArrayList();
        String csvFile = "src/sample/Data/data.csv";
        //BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] food = line.split(cvsSplitBy);
                if(mealType.equals(food[1]) && food[0].equals(meal)) {
                    strList.add(food[2]);
                    System.out.println("Country [MealType= " + food[0] + " , Meal Name=" + food[2] + "]");
                    // System.out.println("Country [MealType= " + food[2] + " , Meal Name=" + food[5] + "]");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    return strList;
    }

    public ObservableList<ItemDetails>  csvqueryLoadTableData(String Food, String Beverage){

        // ArrayList<String> strList = new ArrayList<String>();
        float Tenergy=0,TProtien=0,TCarbohydrate=0,TFat=0,TFibre=0,TPrice=0;
        ObservableList<ItemDetails> strList = FXCollections.observableArrayList();
        String csvFile = "src/sample/Data/data.csv";
        //BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] food = line.split(cvsSplitBy);
                if(Food.equals(food[2]) || food[2].equals(Beverage)) {
                    //strList.add(food[2]);
                    ItemDetails ID=new ItemDetails(food[2],food[4],food[5],food[6],food[7],food[8],food[3]);
                    strList.add(ID);
                    System.out.println("Country [MealType= " + food[2] + " , Meal Name=" + food[4] + " , Meal Name=" + food[5] + " , Meal Name=" + food[6] + " , Meal Name=" + food[7] + " , Meal Name=" + food[8] + " , Meal Name=" + food[3] + "]");
                    // System.out.println("Country [MealType= " + food[2] + " , Meal Name=" + food[5] + "]");
                    Tenergy=Float.valueOf(food[4])+Tenergy;
                    TProtien=Float.valueOf(food[5])+TProtien;
                    TCarbohydrate=Float.valueOf(food[6])+TCarbohydrate;
                    TFat=Float.valueOf(food[7])+TFat;
                    TFibre=Float.valueOf(food[8])+TFibre;
                    TPrice=Float.valueOf(food[3])+TPrice;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ItemDetails ID=new ItemDetails("Total",Float.toString(Tenergy),Float.toString(TProtien),Float.toString(TCarbohydrate),Float.toString(TFat),Float.toString(TFibre),Float.toString(TPrice));
        strList.add(ID);
        return strList;
    }




}
