def jfrogCli = 'jfrog' // Replace with the actual path to the JFrog CLI executable

def username = 'admin'
def password = 'Password1'
def artifactoryUrl = 'http://35.171.28.240:8082/artifactory/example-repo-local/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar'
def repositoryKey = 'example-repo-local'
def targetPath = 'home/ubuntu/Java_app_3.0/target'
def sourceJarFile = 'kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar'

// Construct the command to push the JAR file
def pushCommand = "${jfrogCli} rt u ${sourceJarFile} ${artifactoryUrl}/${repositoryKey}/${targetPath} --user=${username} --password=${password}"

// Execute the command
def process = pushCommand.execute()
process.waitFor()

// Check the exit code
if (process.exitValue() == 0) {
    println("JAR file successfully pushed to Artifactory.")
} else {
    println("Failed to push JAR file to Artifactory. Exit code: ${process.exitValue()}")
    println("Error output:\n${process.error.text}")
