package com.example.demo;

import com.example.algoritm.AntController;
import com.example.algoritm.DataMaodel;
import com.example.algoritm.FileManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@CrossOrigin
public class Controller {

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadInfo(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("r") double r, @RequestParam("iterations") int iterations) {

        System.out.println(a + " " + b + " " + r + " " + iterations + " ");

    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createAction() {

        return Optional.ofNullable("Yarik loh").map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PostMapping("/upload")////new annotation since 4.3
    public void singleFileUpload(@RequestParam("file") MultipartFile file
    ) throws IOException {

        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + "dataa"+System.nanoTime());

        file.transferTo(convFile);

        DataMaodel dataMaodel = new FileManager().getInfo(convFile);

        AntController antController = new AntController(dataMaodel);

        antController.calculate();

        convFile.delete();
    }


}
