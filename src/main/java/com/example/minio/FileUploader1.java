package com.example.minio;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FileUploader1 {

    public static void main(String[] args) {
        try {
            // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
            MinioClient minioClient = new MinioClient("http://localhost:9002", "admin", "11111111");



            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists("bucket1");

            System.out.println(isExist);
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // Make a new bucket called asiatrip to hold a zip file of photos.
                minioClient.makeBucket("bucket1");
            }

//            minioClient.makeBucket("bucket1");

//            final NotificationConfiguration notificationConfiguration = minioClient.getBucketNotification("bucket1");
//            final List<QueueConfiguration> queueConfigurations =
//                    notificationConfiguration.queueConfigurationList();
//            final QueueConfiguration queueConfiguration =
//                    new QueueConfiguration();
//            queueConfiguration.setQueue("arn:minio:sqs::1:amqp");
//            queueConfiguration.setEvents(Arrays.asList(EventType.OBJECT_CREATED_ANY, EventType.OBJECT_REMOVED_ANY));
//////
//            Filter filter = new Filter();
//            filter.setPrefixRule("*");
//            filter.setSuffixRule("*");
//            queueConfiguration.setFilter(filter);
//
//            queueConfigurations.add(queueConfiguration);
//            notificationConfiguration.setQueueConfigurationList(queueConfigurations);
//
//            // Set updated notification configuration.
//            minioClient.setBucketNotification("bucket1", notificationConfiguration);

            // Upload the zip file to the bucket with putObject
//            minioClient.putObject("bucket1","kmx-ui.zip", "/home/guanxine/dev.kmx.k2data.com.cn:5001#k2data#kmx-ui#2.1.3.tgz");

//            minioClient.listenBucketNotification("bucket1", "*", "*", new String[]{EventType.OBJECT_CREATED_ANY.toString(), EventType.OBJECT_REMOVED_ANY.toString()}, new BucketEventListener() {
//                public void updateEvent(NotificationInfo info) {
//                    System.out.println(info);
//                }
//            });
//

//            for (int i = 0; i <= 10000; i ++) {
//                Map<String, String> map = new HashMap();
//                map.put("k1", "v1");
//                map.put("k2", "v2");
//                map.put("k3", "v3");
//                minioClient.putObject("bucket1",
//                        "hello-world-txt-" + i,
//                        "/home/guanxine/work/git/learn-minio/src/main/resources/hello-world.txt",
//                        null,
//                        map,
//                        null,
//                        null);
//                System.out.println(i);
//            }

//            Map<String, String> map = new HashMap();
//            map.put("k1", "v1");
//            map.put("k2", "v2");
//            map.put("k3", "v3");
//            minioClient.putObject("bucket1",
//                    "hello-world-txt-" + 1,
//                    "/home/guanxine/work/git/learn-minio/src/main/resources/hello-world.txt",
//                    null,
//                    map,
//                    null,
//                    null);
//
//
//            System.out.println("/home/guanxine/dev.kmx.k2data.com.cn:5001#k2data#kmx-ui#2.1.3.tgz is successfully uploaded as kmx-ui.zip to `bucket1` bucket.");
//
//            String bucket1 = minioClient.getObjectUrl("bucket1", "kmx-ui-metadata.zip");
//            System.out.println(bucket1);
//            String bucket11 = minioClient.presignedGetObject("bucket1", "kmx-ui-metadata.zip");
//            System.out.println(bucket11);
//            Iterable<Result<Item>> bucket12 =
//                    minioClient.listObjects("bucket1");
//            System.out.println(bucket12);
//            ObjectStat bucket13 = minioClient.statObject("bucket1", "kmx-ui-metadata.zip");
//            System.out.println(bucket13);
//            for (Result<Item> result : bucket12) {
//                System.out.println(result);
//            }

//            final InputStream bucket1 = minioClient.getObject("bucket1", "kmx-ui-metadata.zip");

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
