import java.util.*;

public class NaiveBaise {

    // NaiveBaseKnowledgeBase to store probability of each word in Vocab given the respective topic
    private HashMap<String, Double> gisMap = new HashMap<String, Double>();
    private HashMap<String, Double> securityMap = new HashMap<String, Double>();
    private HashMap<String, Double> photoMap = new HashMap<String, Double>();
    private HashMap<String, Double> mathMap = new HashMap<String, Double>();
    private HashMap<String, Double> unixMap = new HashMap<String, Double>();
    private HashMap<String, Double> wpMap = new HashMap<String, Double>();
    private HashMap<String, Double> scifiMap = new HashMap<String, Double>();
    private HashMap<String, Double> electronicsMap = new HashMap<String, Double>();
    private HashMap<String, Double> androidMap = new HashMap<String, Double>();
    private HashMap<String, Double> appleMap = new HashMap<String, Double>();

    List<singleDataEntry> gisSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> securitySubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> photoSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> mathematicaSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> unixSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> wordpressSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> scificSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> electronicsSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> androidSubset = new ArrayList<singleDataEntry>();
    List<singleDataEntry> appleSubset = new ArrayList<singleDataEntry>();


    // Collection of all tokens in training data
    HashMap<String, Integer> Vocabulary = new HashMap<>();

    public void learn(singleDataEntry[] set, String[] topicsList) {
        String[] tokens;

        // 1. Collect tokens and add to Vocabulary
        for (singleDataEntry e : set) {
            for (String s : e.getQuestion().trim().split("[!{,?._'@ ]+")) {
                addToVocab(s);
            }
        }

        // 2. Calculate P(topic) and P(word|topic)
        for (String topic : topicsList) {
            // variables
            double countOfDocumentByTopic = 0;
            String textForTopic = "";
            String[] allWordsInText;
            // Key: Each word in topic  Value: Number of occurrences
            HashMap<String, Integer> wordOccurrenceMap = new HashMap<String, Integer>();
            int allWordsInTextCount; // = n

            // find singleDataEntry for which .getTopic == topic
            for (singleDataEntry entry : set) {
                if (entry.getTopic().equals(topic)) {
                    // store in docs for this topic, purpose is to find numberOfThisTopic/numberOfTotalTopics
                    // storeByTopic(entry, topic);
                    //countOfDocumentByTopic++;
                    textForTopic += entry.getQuestion() + " ";
                }
            }
            allWordsInText = textForTopic.trim().split("[!{}:\\\",?._'@ ]+");
            allWordsInTextCount = allWordsInText.length;



            // get number of occurrence of each word in text
            for (String w : allWordsInText) {

                wordOccurrenceMap.compute(w, (k, v) -> (v == null) ? 1 : v + 1); // !error nothing added

            }

            // TODO: use m-estimate
            // double probabilityOfTopic = countOfDocumentByTopic/set.length;

            for (String w : Vocabulary.keySet()) { //problem

                // number of times word occurs in text

                double numberOfWordInText = (wordOccurrenceMap.get(w)==null)?0:wordOccurrenceMap.get(w); // nk, seems too big



                double probabilityOfWordGivenClass = (numberOfWordInText + 1) / (allWordsInTextCount + Vocabulary.keySet().size()); // ROOT PROBLEM: TOO SMALL

                storeInKnowledgeBase(topic, w, probabilityOfWordGivenClass);


            }



        }

        //Troubleshoot efficacy of tokenizer
        //for(String token:Vocabulary.keySet()){
        //  System.out.println(token);
        //}
        //

    }

    public String classify(String aQuestion, String[] topicList){

        String [] wordsFromQuestion = aQuestion.trim().split("[!{}:\\\",?._'@ ]+");
        List<String> wordsThatAlsoAppearInVocab = new ArrayList<String>();
        for(String w:wordsFromQuestion){
            if(Vocabulary.containsKey(w)){
                wordsThatAlsoAppearInVocab.add(w);
            }
        }
        Map<String,Double> mapToFindMax = new HashMap<String, Double>();



        for(String topic : topicList){

            double probabilityIsThisTopic = 1;

            for(String word : wordsThatAlsoAppearInVocab){

            probabilityIsThisTopic = probabilityIsThisTopic * collectFromKnowledgeBase(topic, word); // !ERROR: FILLED WITH ZEROES


            }

            mapToFindMax.put(topic, probabilityIsThisTopic);


        }

        Map.Entry<String, Double> maxEntry = null;
        for(Map.Entry<String, Double> entry: mapToFindMax.entrySet()){

            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry; // !ERROR: keep returning first one because probabilities are 0
            }

        }

        return maxEntry.getKey();

    };



    private void addToVocab(String token) {
        Vocabulary.compute(token, (k, v) -> (v == null) ? 1 : v + 1);
    }

    private void storeInKnowledgeBase(String topic, String word, double itsProbabilityGivenClass) {

        switch (topic) {
            case "electronics":
                electronicsMap.put(word, itsProbabilityGivenClass);
                break;
            case "mathematica":
                mathMap.put(word, itsProbabilityGivenClass);
                break;
            case "gis":
                gisMap.put(word, itsProbabilityGivenClass);
                break;
            case "security":
                securityMap.put(word, itsProbabilityGivenClass);
                break;
            case "scifi":
                scifiMap.put(word, itsProbabilityGivenClass);
                break;
            case "photo":
                photoMap.put(word, itsProbabilityGivenClass);
                break;
            case "unix":
                unixMap.put(word, itsProbabilityGivenClass);
                break;
            case "android":
                androidMap.put(word, itsProbabilityGivenClass);
                break;
            case "apple":
                appleMap.put(word, itsProbabilityGivenClass);
                break;
            case "wordpress":
                wpMap.put(word, itsProbabilityGivenClass);
                break;

        }


    }

    private double collectFromKnowledgeBase(String topic, String word) {

        switch (topic) {
            case "electronics":
                return electronicsMap.get(word); // 0s

            case "mathematica":
                return mathMap.get(word);

            case "gis":
                return gisMap.get(word);

            case "security":
                return securityMap.get(word);

            case "scifi":
                return scifiMap.get(word);

            case "photo":
                return photoMap.get(word);

            case "unix":
                return unixMap.get(word);

            case "android":
                return androidMap.get(word);

            case "apple":
                return appleMap.get(word);

            case "wordpress":
                return wpMap.get(word);


        }

        return 0;
    }
/*
    public void storeByTopic(singleDataEntry entry, String topic){

        switch(topic){
            case "electronics":
                electronicsSubset.add(entry);
                break;
            case "mathematica":
                mathematicaSubset.add(entry);
                break;
            case "gis":
                gisSubset.add(entry);
                break;
            case "security":
                securitySubset.add(entry);
                break;
            case "scifi":
                scificSubset.add(entry);
                break;
            case "photo":
                photoSubset.add(entry);
                break;
            case "unix":
                unixSubset.add(entry);
                break;
            case "android":
                androidSubset.add(entry);
                break;
            case "apple":
                appleSubset.add(entry);
                break;
            case "wordpress":
                wordpressSubset.add(entry);
                break;

        }

    }
*/
}
