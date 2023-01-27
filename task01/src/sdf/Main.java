package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        
        String fileNAme = args[0];

        File file = new File(fileNAme);
        ArrayList<String> document = new ArrayList<>();
        String readline="";
        Map<String,Float> myMap = new HashMap<>();
        Map<String,Float> top10 = new HashMap<>();
        float wordCount=0f;
        final Float finalWordCount;

        BufferedReader br = new BufferedReader(new FileReader(file));


        while(br.ready()){

            readline = br.readLine();
            readline = readline.replaceAll("[^a-zA-Z0-9\\s]", "");
            document.add(readline);

        }

        br.close();

        int fileLength = document.size();

        for (int i = 0; i < fileLength; i++) {
            
            String line = document.get(i);

            if(line.isEmpty()){
                continue;
            }
            
            String[] str = line.split(" ");

            for (int j = 0; j < str.length; j++) {
                
                String word = str[j].toLowerCase();
                if(myMap.containsKey(word)){
                    Float count = myMap.get(word);
                    myMap.put(word, count+1f);
                }
                else{
                    myMap.put(word, 1f);
                }

                if(!word.equals("")){
                    wordCount+=1f;
                }

            }
        }

        finalWordCount= wordCount;

        top10 = myMap.entrySet().stream().sorted(Map.Entry.<String, Float> comparingByValue().reversed())
                    .limit(10).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        
        System.out.println("File Word count = " + wordCount);
        System.out.println();
        
        System.out.println("Top ten word + Frequency");
        top10.forEach((key,value)->{
            Float freq = value/finalWordCount;
            System.out.println("Word: "+ "\"" + key + "\""+ " ,count: " + value + " ,Frequency:"+freq);
        });
                

    }
} 