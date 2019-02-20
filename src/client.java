import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        NaiveBaise utils = new NaiveBaise();
        FileReader fr;
        BufferedReader br;
        String[] topicsList = {"gis","security", "photo", "mathematica", "unix", "wordpress", "scifi", "electronics", "android", "apple"};
        singleDataEntry[] arr = null;
        String fileName = "/Users/soymilk/Downloads/testcases/input.txt";
        File file = new File(fileName);
        Scanner input;
        try {
            input = new Scanner(file);
            int numberOfEntries = input.nextInt();
            input.nextLine();
            arr = new singleDataEntry[numberOfEntries];
            for(int i = 0; i < numberOfEntries; i++){
                  arr[i] = extractDataFromJson(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("learning...");
        utils.learn(arr,topicsList);
        System.out.println("Hi! This program uses Naive Bayes algorithm to predict the topic of an input question");
        System.out.println("The possible topics are:\n" +
                "gis\n" +
                "security\n" +
                "photo\n" +
                "mathematica\n" +
                "unix\n" +
                "wordpress\n" +
                "scifi\n" +
                "electronics\n" +
                "android\n" +
                "apple");
        System.out.println("Press 1 to use testcases");
        System.out.println("Press 0 to provide own question");
        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        if(choice == 1){
            String examFileName = "/Users/soymilk/Downloads/testcases/input00.txt";
            File exam = new File(examFileName);
            try {
                input = new Scanner(exam);
                int numberOfEntries = input.nextInt();
                input.nextLine();
                for(int i = 0; i < numberOfEntries; i++){
                    System.out.println(utils.classify(extractQuestionFromJson(input.nextLine()),topicsList));
                }
                input.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Provide your own question then :P");
            option.nextLine();
            System.out.println(utils.classify(option.nextLine(), topicsList));

        }



    }




    private static singleDataEntry extractDataFromJson(String stackExchangeJSON){
        // if input String is empty, return early
        if(stackExchangeJSON.equals("")){
            return  null;
        }
        try{
            JSONObject jsonObject = new JSONObject(stackExchangeJSON);
            String topic = jsonObject.getString("topic");
            String question = jsonObject.getString("question");
            return new singleDataEntry(topic, question);

        }catch(JSONException e){
            System.out.print("Failed to parse JSON");
        }
        return null;
    }

    private static String extractQuestionFromJson(String stackExchangeJSON){
        // if input String is empty, return early
        if(stackExchangeJSON.equals("")){
            return  null;
        }
        try{
            JSONObject jsonObject = new JSONObject(stackExchangeJSON);

            return jsonObject.getString("question");

        }catch(JSONException e){
            System.out.print("Failed to parse JSON");
        }
        return null;
    }
}
