import requests

# JFrog Artifactory details
artifactory_url = "http://35.171.28.240:8082/artifactory/example-repo-local/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar"
username = "admin"
password = "Password1"
repo_key = "example-repo-local"  # The target repository key in Artifactory

# Path to the JAR file
jar_file_path = "kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar"

# Construct the upload URL
upload_url = f"{artifactory_url}/{repo_key}/{jar_file_path}"

# Set up the authentication
auth = (username, password)

# Upload the JAR file
try:
    with open(jar_file_path, 'rb') as jar_file:
        response = requests.put(upload_url, data=jar_file, auth=auth)

    if response.status_code == 201:
        print("Upload successful!")
    else:
        print(f"Upload failed with status code: {response.status_code}")
        print(response.text)

except Exception as e:
    print(f"An error occurred: {str(e)}")
