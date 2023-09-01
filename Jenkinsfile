pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'openjdk'        
    }
    stages {

        stage('Build Jar') {
            steps {
                script {
                   echo 'building the application...' 
                    sh 'mvn clean package'  
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                   echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t tiusoro/java-maven-jenkins:jma-2.1 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push tiusoro/java-maven-jenkins:jma-2.1'
                    }  
                }
            }
        }
        
        stage('deploy') {
            steps {
                script {
                    echo 'deploying the application...'
                    sshagent([‘ec2-jenkins-user’]) {
                    sh "
                        ssh -o StrictHostKeyChecking=no ec2-user@54.242.111.137 
                        "${docker run -p 8080:8080 -d tiusoro/java-maven-jenkins:jma-2.1}"
                        "
                    }
                }
            
            }
            
        }
        
    }
}
