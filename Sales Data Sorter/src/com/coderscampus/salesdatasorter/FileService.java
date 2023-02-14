package com.coderscampus.salesdatasorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<TelsaSales> loadSales (String filePath) throws IOException{
        List<TelsaSales> sales = new ArrayList<>();
        BufferedReader bufferedReader = null;
      try {
          bufferedReader = new BufferedReader(new BufferedReader(new FileReader(filePath)));
          String line = bufferedReader.readLine();
          while ((line= bufferedReader.readLine()) != null){
              String[] v = line.split(",");
              sales.add(new TelsaSales(v[0], v[1]));
          }
          return sales;
      }finally {

      }
    }
}
