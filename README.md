# orange-frontstage-api

## API Disign

[kanban](https://github.com/orgs/No-57/projects/1/views/2?pane=issue&itemId=40883586)

---

## Build docker env for orange-frontstage-api

### Steps

1. Open the Docker Desktop.

2. Change the current path to the location of orange-frontstage-api project.

3. Use Dockerfile build tomcat env image.

   ```bash
   docker image build -f Dockerfile -t orange-tomcat:1.0 .
   ```

4. Check image as this command.

   ```bash
   docker image ls -a
   ```

5. Run container use image.

   ```bash
   docker container run --name orange-frontstage-service -itd --rm -p 8080:8080 orange-tomcat:1.0
   ```

6. Check logs with container, it show tomcat logs.

   ```bash
   docker logs --details orange-frontstage-service
   ```

   also can enter container check logs
   ```bash
   docker container exec -it orange-frontstage-service /bin/bash
   cd /usr/local/apache-tomcat-10.1.16/logs/
   ls -la
   cat logfile
   ```

7. Test API use curl command or use browser.

   ```bash
   curl http://localhost:8080/main-0.0.1-SNAPSHOT/
   ```


---

