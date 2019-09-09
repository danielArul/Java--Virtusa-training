package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        //Writing to file

        File file=new File("myFile.xt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));

        for(int i=1;i<=10;i++){
             bw.write(String.valueOf(i)+"\n");
        }

        bw.close();

        //Reading from file
        BufferedReader br=new BufferedReader(new FileReader(file.getAbsolutePath()));
        String line=br.readLine();

        while(line!=null){
            System.out.println(line);
            line=br.readLine();
        }



    }
}

