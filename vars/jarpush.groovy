def call(){
    sh'./jfrog.py'

    sh """
 cd /var/lib/jenkins/workspace/jfrog-demo/target/
 chmod +x${jarFileName}
 curl-X PUT-u admin:Password1 -T ${jarFileName} ${artifactoryUrl}/${targetPath}
 """  
}
