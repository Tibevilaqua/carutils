package com.caroffice.infrastructure.oil;

import com.caroffice.business.OilBusiness;
import com.caroffice.endpoint.oil.OilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by root on 23/12/16.
 */
@Component
public class OilImageScheduler {


    @Autowired
    private OilBusiness oilBusiness;


    private static final int FIVE_MINUTES = 300000;

    private static final String DATA_TO_IMPORT ="src/main/resources/images/";

    @Scheduled(initialDelay = 2000, fixedDelay = FIVE_MINUTES)
    private void importDataFromFiles() throws IOException {
        System.out.println("----- Importing data from files to the repository -----");


        Path dataDirectory = Paths.get(DATA_TO_IMPORT);

        //Just in case it does not exist
        Files.createDirectories(dataDirectory);

        OilDTO aOil = oilBusiness.getOilBy("A");

        // Always 1 (A.jpg)
        List<Path> filesToImport = Files.find(dataDirectory, 1, (path, fileAttributes) -> fileAttributes.isRegularFile()).collect(Collectors.toList());

        for (Path eachFile : filesToImport) {
            byte[] imageInBytes = Files.readAllBytes(eachFile);
            aOil.setImage(imageInBytes);
            oilBusiness.update(aOil);
        }

        System.out.println("----- Import finished -----");

    }



}
