# orange-frontstage-api

## API Disign

[kanban](https://github.com/orgs/No-57/projects/1/views/2?pane=issue&itemId=40883586)

---

## Build VSCode devcontainer env

### Steps

1. Install [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) in VSCode.

   **If you want to directly use the file `devcontainer.json` pulled down from Git, without reconfiguring or creating a new `devcontainer.json`,  you can skip to step 9.**

2. Press Windows use `Ctrl+Shift+P` or Mac use `Cmd+Shift+P` to open command palette.

3. Type `Dev Containers: Add Dev Container Configuration Files ...` and press `Enter`. 

4. Select `From 'Dockerfile'`.

5. Select `OK`.
   Note: In the current project, additional extensions will not be needed for the time being.

6. Select `Keep Defaults`.

7. After completion, the project directory will have an additional folder named `.devcontainer`, indicating that the configuration has been generated. 

8. Edit file `.devcontainer/devcontainer.json`
   Add the following line of code to the file:

    ```bash
   "postStartCommand": ["catalina.sh", "run"]
    ```

   Note: atfer container start finish, start tomcat service command.

9. If you want **start** devcontainer, press the >< icon in the bottom-left corner of VSCode, or use the Command Palette to execute the Dev Container. The option is `Reopen in Container`.

10. In VSCode, both the bottom-left corner and the window title will display `Dev Container: Existing Dockerfile @ ....`
    It indicates the currently active Dev Container that has been launched.

11. Open a web browser and enter the [URL](http://localhost:8080/main-0.0.1-SNAPSHOT/)  to test the connection.

12. If you want **stop** devcontainer, press the >< icon in the bottom-left corner of VSCode, or use the Command Palette to execute the `Remote: Close Remote Connection`.

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

