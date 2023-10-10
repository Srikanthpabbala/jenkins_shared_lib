stage('Jar push JFROG : jfrog'){
 when{ expression { params.action == 'create' } }
 steps{
 script{
 }
 }
 }
 def artifactoryUrl = 'http://35.171.28.240:8081/artifactory'
 def artifactoryRepo = 'example-repo-local'
 def jarFileName = 'kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar'
 def targetPath = "${artifactoryRepo}/mamta/"
 sh """
 cd /var/lib/jenkins/workspace/jfrog-demo/target/
 chmod +x${jarFileName}
 curl-X PUT-u admin:Password1-T ${jarFileName} ${artifactoryUrl}/${targetPath}
 """
