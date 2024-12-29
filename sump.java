Here’s a detailed guide to completing the task:
   - Save the file as `WelcomeApp.java`.
## CI/CD Practical: Setting Up and Automating the Pipeline

### **1. Setup a Git Repository**
1. Initialize a Git repository in the folder containing `WelcomeApp.java`:
   ```bash
   git init
   ```
2. Add the Java file to the repository:
   ```bash
   git add WelcomeApp.java
   ```
3. Commit the changes:
   ```bash
   git commit -m "Initial commit: Added WelcomeApp.java"
   ```
4. Push the code to a remote repository:
   - Create a repository on GitHub (or use a local Git server).
   - Push your code:
     ```bash
     git remote add origin <repository_url>
     git push -u origin main
     ```
### **2. Install Jenkins**
1. Download Jenkins:
   - Visit [Jenkins Official Website](https://www.jenkins.io/download/) and download the appropriate package for your operating system.
2. Install Jenkins:
   - Follow the installation instructions for your OS.
3. Start the Jenkins server:
   - On Linux/Ubuntu:
     ```bash
     sudo systemctl start jenkins
     ```
   - Open your web browser and navigate to `http://localhost:8080`.
4. Complete Jenkins setup:
   - Unlock Jenkins using the password found in:
     ```bash
     /var/lib/jenkins/secrets/initialAdminPassword
     ```
   - Install the recommended plugins.
   - Create an admin user.

### **3. Create a Jenkins Job**
1. Create a new Jenkins job:
   - Go to the Jenkins dashboard.
   - Click on "New Item" and select "Freestyle project."
2. Configure the job:
   - Under the **Source Code Management** section, select "Git."
   - Provide the Git repository URL and credentials if necessary.
3. Add build steps:
   - Under the **Build** section, add the following command:
     ```bash
     javac WelcomeApp.java
     java WelcomeApp
     ```
### **4. Automate the Build**
1. Set up a Git webhook:
   - Go to your GitHub repository.
   - Navigate to **Settings > Webhooks > Add webhook.**
   - Provide your Jenkins URL followed by `/github-webhook/` (e.g., `http://<jenkins-url>/github-webhook/`).
2. Configure Jenkins to listen for changes:
   - In your Jenkins job, under **Build Triggers**, select **GitHub hook trigger for GITScm polling**.

### **5. Deploy the Application Locally**
1. Write a deployment script:
   - Create a script named `run_app.sh`:
     ```bash
     #!/bin/bash
     java WelcomeApp
     ```
   - Make it executable:
     ```bash
     chmod +x run_app.sh
     ```
2. Add the script to Jenkins:
   - In the Jenkins job, under **Post-build Actions**, select "Execute shell" and add:
     ```bash
     ./run_app.sh
     ```---

### **6. Test the Pipeline**
1. Push changes to the Git repository:
   - Modify `WelcomeApp.java` (e.g., change the message).
   - Push the changes:
     ```bash
     git add WelcomeApp.java
     git commit -m "Updated the welcome message"
     git push
     ```
2. Observe Jenkins:
   - Jenkins should automatically trigger a build.
   - After the build completes, the application should run locally, and you should see the updated message in the console.

---

This setup provides hands-on experience with CI/CD pipelines using Git and Jenkins, demonstrating how code changes can be automatically built and deployed.
