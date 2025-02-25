package com.example.demo.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseStorageService {

    private final Storage storage;

    public FirebaseStorageService() throws IOException {
        InputStream serviceAccount = new ClassPathResource("firebase-service-account.json").getInputStream();
        storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
                .getService();
    }

    public String uploadFile(byte[] fileBytes, String fileName) {
        String bucketName = "testlapelota-7ac49.appspot.com";
        Blob blob = storage.create(BlobInfo.newBuilder(bucketName, fileName).build(), fileBytes);
        return blob.getMediaLink();  // Returns public URL of the image
    }
}

