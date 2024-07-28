package org.example.BookHubCode.Controller;

import org.example.BookHubCode.JavaVersion;
import org.example.BookHubCode.Language;
import org.example.BookHubCode.SpringBootVersion;
import org.example.BookHubCode.TypeBox;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class springController {
    /*https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.1
    &baseDir=demo&groupId=com.example
    &artifactId=demo&name=demo&description=Demo project for Spring Boot
    &packageName=com.example.demo&dependencies=web
    */

    static String saveFilePath = "downloaded.zip";


    public static void getRequest(String groupName, String name, JavaVersion javaVersion, SpringBootVersion springBootVersion, TypeBox typeBox, Language language){
        String fileURL = "https://start.spring.io/starter.zip?type="+typeBox+"&language="+language+"&bootVersion="+springBootVersion+"&baseDir="+name+"&groupId="+groupName+"&artifactId="+groupName+"&name="+name+"&description="+""+"&packageName="+name+"&dependencies=web";
        try{
            URL url = new URL(fileURL);

            System.out.println(url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: "+responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(inputStream);
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                // Print the response
//                System.out.println("Response: " + response.toString());
//            } else {
//                System.out.println("GET request failed.");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
                FileOutputStream fos = new FileOutputStream(saveFilePath);

                // Read the input stream and write to the file
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                // Close streams
                fos.close();
                bis.close();

                System.out.println("File downloaded: " + saveFilePath);
            } else {
                System.out.println("No file to download. Server replied with code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

