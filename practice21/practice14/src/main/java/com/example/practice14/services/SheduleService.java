package com.example.practice14.services;

import com.example.practice14.controllers.PostController;
import com.example.practice14.models.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@ManagedResource(
        objectName = "Practice22MBeans:category=MBeans,name=DataScheduler"
)
public class SheduleService {
    private final UserService userService;
    private final PostService postService;
    private final String path = "temp_dir";

    public static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    //every minute
    @Scheduled(cron = "0 * * * * *")
    @ManagedOperation(
            description = "Deletes all contents of the directory and " +
                    "writes all data from the database to it every 30 minutes"
    )
    public void start() throws IOException, NullPointerException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        LOGGER.info("SCHEDULED task started at {}", formatter.format(date));

        File dir = ResourceUtils.getFile(path);
        Arrays.stream(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
            if (file.isFile()) {
                LOGGER.info("File " + file.getName() + " was deleted: " + file.delete());
            }
        });


        BufferedWriter iBufWriter = createWriter(path, "items.txt");;
        iBufWriter.write("id|name|creationDate|price\n");
        userService.getAll().forEach(user ->
        {
            try{
                iBufWriter.write(
                        String.format(
                                "%d|%s|%s|%s\n",
                                user.getId(),
                                user.getFirstName(),
                                user.getBirthDate(),
                                user.getLastName()
                        )
                );
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        iBufWriter.close();

        BufferedWriter oBufWriter = createWriter(path, "orders.txt");
        oBufWriter.write("id|order_date\n");
        postService.getAll()
                .forEach(post -> {
                    try {
                        oBufWriter.write(
                                String.format(
                                        "%d|%s\n",
                                        post.getId(),
                                        post.getCreationDate())
                        );
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                });
        oBufWriter.close();
        LOGGER.info("SCHEDULED task finished.");
    }

    private BufferedWriter createWriter(String dir, String filename) throws IOException {
        return new BufferedWriter(new FileWriter(String.format("%s/%s", dir, filename)));
    }
}