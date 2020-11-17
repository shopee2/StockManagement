package com.shopee2.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;

@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/s2-stockmanagement-firebase-adminsdk-xg1dm-2f2ca8622e.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://s2-stockmanagement.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
