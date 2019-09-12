package com.example.minio;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FileUploader {

    public static void main(String[] args) {
        try {
            // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
            MinioClient minioClient = new MinioClient("http://localhost:9002", "admin", "11111111");

            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists("bucket1");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                minioClient.makeBucket("bucket1");
            }

            Map<String, String> map = new HashMap();
            map.put("k1", "v1");
            map.put("k2", "v2");
            map.put("k3", "v3");
            minioClient.putObject("bucket1",
                    "hello-world-txt-" + 1,
                    new ByteArrayInputStream("hello,minio".getBytes()),
                    null,
                    map,
                    null,
                    null);
            System.out.println("successfully uploaded to `bucket1` bucket.");

        } catch(MinioException e) {
            System.out.println("Error occurred: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
