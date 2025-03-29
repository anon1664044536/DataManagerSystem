package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {
    public static void WriterTxt(String txtPath) throws IOException {
        try{
            StringBuilder title = new StringBuilder();
            for(String key:TxtReader.studentData.get(0).keySet()){
                title.append(key);
                title.append("\t");
            }

            FileWriter fileWriter = new FileWriter(txtPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(title.toString());
            bufferedWriter.newLine();

            for(Student student:DataManager.studentManager.StudentList){
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
