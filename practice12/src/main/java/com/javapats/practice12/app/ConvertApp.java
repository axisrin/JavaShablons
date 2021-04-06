package com.javapats.practice12.app;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.util.Objects.hash;

@Component
public class ConvertApp {

    public static String file1 = "";
    public static String file2 = "/home/sumi-koon/HSE/Java Pats/practice12/src/main/java/com/javapats/practice12/sources/AfterHash.txt";

    public void setFiles(String file1,String file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    @PostConstruct
    public void init() throws IOException, NoSuchAlgorithmException {

        if (!file1.equals("")) {
            String fileNameBeforeHash = file1;
            String contentOfFileBeforeHash = readUsingFiles(fileNameBeforeHash);

            String contentOfFileAfterHash = hashContent(contentOfFileBeforeHash);

            Path fileNameAfterHash = Paths.get(file2);
            Files.writeString(fileNameAfterHash, contentOfFileAfterHash);
        } else if (file1.equals("")) {
            Path fileNameAfterHash = Paths.get(file2);
            Files.writeString(fileNameAfterHash, "null");
        }
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    @PreDestroy
    public void deleteOriginFile() throws  IOException {
        if (!file1.equals("")) {
            Path fileNameBeforeHash = Paths.get(file1);
            Files.delete(fileNameBeforeHash);
        }
    }

    private static String hashContent(String content) {
        int hash = 7;
        for (int i = 0; i < content.length(); i++) {
            hash = hash*31 + content.charAt(i);
        }
        return String.valueOf(hash);
    }

}
