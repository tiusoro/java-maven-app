pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'openjdk'        
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo 'building the application...' 
                    sh 'mvn clean package' 
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t tiusoro/java-maven-jenkins:jma-1.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push tiusoro/java-maven-jenkins:jma-1.0'
                    }
                }
            }
        }
        
        stage('deploy') {
            steps {
                script {
                    echo 'deploying the application...'
                }
            
            }
            
        }
        
    }
}
