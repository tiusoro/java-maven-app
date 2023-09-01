def buildJar() {
    echo 'building the application...' 
    sh 'mvn clean package'   

}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tiusoro/java-maven-jenkins:jma-1.6 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tiusoro/java-maven-jenkins:jma-1.6'
    } 
}
    

def deployApp() {
    echo 'deploying the application...'
    def dockerCmd = ‘docker run -p 8080:8080 -d tiusoro/java-maven-jenkins:jma-1.6’
    sshagent([‘ec2-jenkins-user’]) {
	    sh “ssh -o StrickHostKeyChecking=no ec2-user@54.242.111.137 ${dockerCmd}”
}


}


return this
