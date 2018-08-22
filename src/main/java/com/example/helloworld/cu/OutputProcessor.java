package com.example.helloworld.cu;

public class OutputProcessor{




    public String refreshClam(String input){
        String output = "";

        /**
         * Sample input
         * 
        Tue Aug 21 05:21:06 2018 -> ClamAV update process started at Tue Aug 21 05:21:06 2018
        Tue Aug 21 05:21:06 2018 -> main.cvd is up to date (version: 58, sigs: 4566249, f-level: 60, builder: sigmgr)
        Tue Aug 21 05:21:06 2018 -> daily.cvd is up to date (version: 24861, sigs: 2056272, f-level: 63, builder: neo)
        Tue Aug 21 05:21:06 2018 -> bytecode.cvd is up to date (version: 327, sigs: 91, f-level: 63, builder: neo)
        
        * Expected output
        
        Tue Aug 21 05:21:06 2018 -> ClamAV update process started 

        */

        // find the first index of the word started
        int a = input.indexOf("started");
        // get the substring in between
        if(a != -1){
        output  = input.substring(0,a);
        }else{
            output = "Process abondoned";
        }



        return output;



    }





}