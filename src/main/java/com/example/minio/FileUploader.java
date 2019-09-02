package com.example.minio;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FileUploader {

    public static void main(String[] args) {
        try {
            // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
            MinioClient minioClient = new MinioClient("http://localhost:9000", "admin", "11111111");

            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists("bucket1");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // Make a new bucket called asiatrip to hold a zip file of photos.
                minioClient.makeBucket("bucket1");
            }

            // Upload the zip file to the bucket with putObject
//            minioClient.putObject("bucket1","kmx-ui.zip", "/home/guanxine/dev.kmx.k2data.com.cn:5001#k2data#kmx-ui#2.1.3.tgz");
//
//            Map<String, String> map = new HashMap();
//            map.put("k1", "v1");
//            map.put("k2", "v2");
//            map.put("k3", "v3");
//            minioClient.putObject("bucket1", "kmx-ui-metadata.zip", "/home/guanxine/dev.kmx.k2data.com.cn:5001#k2data#kmx-ui#2.1.3.tgz", null, map, null, null);
//            System.out.println("/home/guanxine/dev.kmx.k2data.com.cn:5001#k2data#kmx-ui#2.1.3.tgz is successfully uploaded as kmx-ui.zip to `bucket1` bucket.");

            String bucket1 = minioClient.getObjectUrl("bucket1", "kmx-ui-metadata.zip");
            System.out.println(bucket1);
            String bucket11 = minioClient.presignedGetObject("bucket1", "kmx-ui-metadata.zip");
            System.out.println(bucket11);
            Iterable<Result<Item>> bucket12 =
                    minioClient.listObjects("bucket1");
            System.out.println(bucket12);
            ObjectStat bucket13 = minioClient.statObject("bucket1", "kmx-ui-metadata.zip");
            System.out.println(bucket13);
            for (Result<Item> result : bucket12) {
                System.out.println(result);
            }
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
