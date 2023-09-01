def buildJar() {
    echo 'building the application...' 
    sh 'mvn clean package'   

}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tiusoro/java-maven-jenkins:jma-1.8 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tiusoro/java-maven-jenkins:jma-1.8'
    } 
}
    

def deployApp() {
    echo 'deploying the application...'
    sshagent([‘ec2-server-key’]) {
	sh “ssh -o StrictHostKeyChecking=no ec2-user@35.180.251.121 ${docker run -p 8080:8080 -d tiusoro/java-maven-app:jma1.8}”
    }
}


return this
