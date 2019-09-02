docker run -d --hostname my-rabbit --name some-rabbit -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=passw0rd -p 15672:15672 -p 5672:5672 rabbitmq:3-management

http://localhost:15672