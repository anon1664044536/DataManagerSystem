package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TxtReader {
    public static List<Map<String,String>> studentData = new ArrayList<>();

    public static void ReadTxt(String txtPath) {
        try {
            FileReader fileReader = new FileReader(txtPath);
            BufferedReader reader = new BufferedReader(fileReader);

            // 读取第一行（标签行）
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("文件是空的");
                return;
            }

            // 分割标签行，假设标签之间以空格分隔
            String[] headers = headerLine.split("\\s+");
            Map<String, Integer> headerMap = new LinkedHashMap<>();
            for (int i = 0; i < headers.length; i++) {
                headerMap.put(headers[i], i);
            }
            System.out.println(headerMap);

            // 读取后续行数据
            String line;
            while ((line = reader.readLine()) != null) {

                // 分割每行的数据
                String[] values = line.split("\\s+");
                if(values[0].isEmpty()){
                    break;
                }

                Map<String, String> subMap = new LinkedHashMap<>(); //每一个学生
                //for each遍历字典
                for (String header : headerMap.keySet()) {

                    //通过get方法来用key获取到value
                    int index = headerMap.get(header);

                    if (index < values.length) {
                        subMap.put(header, values[index]);
                    }
                    else {
                        subMap.put(header, ""); // 如果该行数据不足，使用空字符串填充
                    }
                }
                studentData.add(subMap);
            }

            reader.close();
            fileReader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

