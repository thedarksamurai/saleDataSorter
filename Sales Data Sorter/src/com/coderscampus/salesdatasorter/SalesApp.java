package com.coderscampus.salesdatasorter;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesApp {
    public static void main(String[] args) throws IOException {
        FileService file = new FileService();
        List<TelsaSales> model3 = file.loadSales("model3.csv");
        List<TelsaSales> modelS = file.loadSales("modelS.csv");
        List<TelsaSales> modelX = file.loadSales("modelX.csv");

        loadSalesReport(model3, "Model 3");
        loadSalesReport(modelS, "Model S");
        loadSalesReport(modelX, "Model X");
    }

    private static void loadSalesReport(List<TelsaSales> carData, String modelType) {
        System.out.println(modelType + "Annual Sales Report");
        System.out.println("----------------------------");

        Map<Integer, List<TelsaSales>> groupByYear = carData.stream().collect(Collectors.groupingBy(d -> d.getDate().getYear()));
        String totalAnnualSales = groupByYear.entrySet()
                .stream()
                .map(d->d.getKey() + "->" + d.getValue().stream().mapToInt(TelsaSales::getSales).sum())
                .collect(Collectors.joining("\n"));
        System.out.println(totalAnnualSales);
        System.out.println();

        Optional<TelsaSales> maxSales = carData.stream()
                .max(Comparator.comparing(TelsaSales::getSales));
        Optional<TelsaSales> minSales = carData.stream()
                .min(Comparator.comparing(TelsaSales::getSales));
        System.out.println("The most profitable month for " + modelType + " was: " + maxSales.orElse(new TelsaSales("Jan-70", "0")).getDate());
        System.out.println("The least profitable month for " + modelType + " was: " + minSales.orElse(new TelsaSales("Jan-70", "0")).getDate());
        System.out.println();
    }
}
