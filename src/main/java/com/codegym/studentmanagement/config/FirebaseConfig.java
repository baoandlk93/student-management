package com.codegym.studentmanagement.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Value("${app.firebase-bucket}")
    private String bucket;

    @Bean
    public FirebaseApp firebaseApp() {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebaseConfig.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(bucket)
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                return FirebaseApp.initializeApp(options);
            } else {
                return FirebaseApp.getInstance();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return FirebaseApp.initializeApp();
        }
    }

    @Bean
    public Storage storage() {
        String projectId = FirebaseApp.getInstance().getOptions().getProjectId();
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setProjectId(projectId)
                .build();
        return storageOptions.getService();
    }
}
