def buildJar() {
    echo 'building the application...' 
    sh 'mvn clean package'   

}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tiusoro/java-maven-jenkins:jma-2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tiusoro/java-maven-jenkins:jma-2.1'
    } 
}
    

def deployApp() {
    echo 'deploying the application...'
    sshagent([‘ec2-server-key’]) {
	sh '''
	    ssh -o StrictHostKeyChecking=no ubuntu@34.207.99.93 
	    "${docker run -p 8080:8080 -d tiusoro/java-maven-jenkins:jma-2.1}"
	    '''
    }
}


return this
