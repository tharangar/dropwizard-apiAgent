package com.example.helloworld.cu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellComand {

	public static void main(String[] args) {

		ExecuteShellComand obj = new ExecuteShellComand();

		String domainName = "google.com";
		
		//in mac oxs
		String command = "ping -c 3 " + domainName;
		
		//in windows
		//String command = "ping -n 3 " + domainName;
		
		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
        }
        
        System.out.println("output is "+output);

		return output.toString();

	}

    public String getCommandOut(String commandString, String parameters){
        String SS = "-";
        String s = null;
        try{
            Runtime rt = Runtime.getRuntime();
        //String[] commands = {"system.exe","-get t"};
        String[] commands = {"docker exec emailserver freshclam",""};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new 
            InputStreamReader(proc.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        
        while ((s = stdInput.readLine()) != null) {
            SS = SS + s;
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
       
        }catch(Exception e){
            e.printStackTrace();
        }
        return SS;


    }

}