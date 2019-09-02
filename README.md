
## minio server
docker run -d -p 9000:9000 --name minio1   -e "MINIO_ACCESS_KEY=admin"   -e "MINIO_SECRET_KEY=11111111"   -v /mnt/data:/data   minio/minio server /data

http://localhost:9000

```

"amqp": {
    "1": {
        "enable": true,
        "url": "amqp://root:passw0rd@localhost:5672",
        "exchange": "bucketevents",
        "routingKey": "bucketlogs",
        "exchangeType": "fanout",
        "deliveryMode": 0,
        "mandatory": false,
        "immediate": false,
        "durable": false,
        "internal": false,
        "noWait": false,
        "autoDeleted": false,
        "queueDir": "",
        "queueLimit": 0
    }
}
```


## minio client

docker run -itd --entrypoint=/bin/sh minio/mc

 mc config host  add local http://10.1.10.77:9000 admin 11111111
 
```$xslt
/ # mc ls local
[2019-08-30 08:37:03 UTC]      0B bucket1/
/ # mc mb local/bucket2
Bucket created successfully `local/bucket2`.
/ # mc ls local
[2019-08-30 08:37:03 UTC]      0B bucket1/
[2019-09-02 08:20:34 UTC]      0B bucket2/

```

mc admin config get local > /tmp/myconfig

```$xslt
{
    "cache": {
        "drives": [],
        "exclude": [],
        "expiry": 90,
        "maxuse": 80
    },
    "compress": {
        "enabled": false,
        "extensions": [
            ".txt",
            ".log",
            ".csv",
            ".json"
        ],
        "mime-types": [
            "text/csv",
            "text/plain",
            "application/json"
        ]
    },
    "credential": {
        "accessKey": "admin",
        "expiration": "1970-01-01T00:00:00Z",
        "secretKey": "11111111",
        "status": "enabled"
    },
    "kms": {
        "vault": {
            "auth": {
                "approle": {
                    "id": "",
                    "secret": ""
                },
                "type": ""
            },
            "endpoint": "",
            "key-id": {
                "name": "",
                "version": 0
            }
        }
    },
    "logger": {
        "console": {
            "enabled": true
        },
        "http": {
            "target1": {
                "enabled": false,
                "endpoint": "https://username:password@example.com/api"
            }
        }
    },
    "notify": {
        "amqp": {
            "1": {
                "enable": true,
                "url": "amqp://root:passw0rd@10.1.10.77:5672",
                "exchange": "bucketevents",
                "routingKey": "bucketlogs",
                "exchangeType": "fanout",
                "deliveryMode": 0,
                "mandatory": false,
                "immediate": false,
                "durable": false,
                "internal": false,
                "noWait": false,
                "autoDeleted": false,
                "queueDir": "",
                "queueLimit": 0
            }
        },
        "elasticsearch": {
            "1": {
                "enable": false,
                "format": "",
                "index": "",
                "queueDir": "",
                "queueLimit": 0,
                "url": ""
            }
        },
        "kafka": {
            "1": {
                "brokers": null,
                "enable": false,
                "queueDir": "",
                "queueLimit": 0,
                "sasl": {
                    "enable": false,
                    "password": "",
                    "username": ""
                },
                "tls": {
                    "clientAuth": 0,
                    "enable": false,
                    "skipVerify": false
                },
                "topic": ""
            }
        },
        "mqtt": {
            "1": {
                "broker": "",
                "enable": false,
                "keepAliveInterval": 0,
                "password": "",
                "qos": 0,
                "queueDir": "",
                "queueLimit": 0,
                "reconnectInterval": 0,
                "topic": "",
                "username": ""
            }
        },
        "mysql": {
            "1": {
                "database": "",
                "dsnString": "",
                "enable": false,
                "format": "",
                "host": "",
                "password": "",
                "port": "",
                "queueDir": "",
                "queueLimit": 0,
                "table": "",
                "user": ""
            }
        },
        "nats": {
            "1": {
                "address": "",
                "enable": false,
                "password": "",
                "pingInterval": 0,
                "queueDir": "",
                "queueLimit": 0,
                "secure": false,
                "streaming": {
                    "async": false,
                    "clusterID": "",
                    "enable": false,
                    "maxPubAcksInflight": 0
                },
                "subject": "",
                "token": "",
                "username": ""
            }
        },
        "nsq": {
            "1": {
                "enable": false,
                "nsqdAddress": "",
                "queueDir": "",
                "queueLimit": 0,
                "tls": {
                    "enable": false,
                    "skipVerify": false
                },
                "topic": ""
            }
        },
        "postgresql": {
            "1": {
                "connectionString": "",
                "database": "",
                "enable": false,
                "format": "",
                "host": "",
                "password": "",
                "port": "",
                "queueDir": "",
                "queueLimit": 0,
                "table": "",
                "user": ""
            }
        },
        "redis": {
            "1": {
                "address": "",
                "enable": false,
                "format": "",
                "key": "",
                "password": "",
                "queueDir": "",
                "queueLimit": 0
            }
        },
        "webhook": {
            "1": {
                "enable": false,
                "endpoint": "",
                "queueDir": "",
                "queueLimit": 0
            }
        }
    },
    "openid": {
        "jwks": {
            "url": null
        }
    },
    "policy": {
        "opa": {
            "authToken": "",
            "url": null
        }
    },
    "region": "",
    "storageclass": {
        "rrs": "",
        "standard": ""
    },
    "version": "33",
    "worm": "off"
}
```

/ # mc admin config set local < /tmp/myconfig
Setting new MinIO configuration file has been successful.
Please restart your server with `mc admin service restart local`.

/ # mc admin service restart local
Restart command successfully sent to `local`.
Restarted `local` successfully.


guanxine@gx:~/work/git$ docker logs 3ca
Endpoint:  http://172.17.0.3:9000  http://127.0.0.1:9000

Browser Access:
   http://172.17.0.3:9000  http://127.0.0.1:9000

Object API (Amazon S3 compatible):
   Go:         https://docs.min.io/docs/golang-client-quickstart-guide
   Java:       https://docs.min.io/docs/java-client-quickstart-guide
   Python:     https://docs.min.io/docs/python-client-quickstart-guide
   JavaScript: https://docs.min.io/docs/javascript-client-quickstart-guide
   .NET:       https://docs.min.io/docs/dotnet-client-quickstart-guide
Restarting on service signal
Endpoint:  http://172.17.0.3:9000  http://127.0.0.1:9000
SQS ARNs:  arn:minio:sqs::1:amqp

Browser Access:
   http://172.17.0.3:9000  http://127.0.0.1:9000

Object API (Amazon S3 compatible):
   Go:         https://docs.min.io/docs/golang-client-quickstart-guide
   Java:       https://docs.min.io/docs/java-client-quickstart-guide
   Python:     https://docs.min.io/docs/python-client-quickstart-guide
   JavaScript: https://docs.min.io/docs/javascript-client-quickstart-guide
   .NET:       https://docs.min.io/docs/dotnet-client-quickstart-guide
