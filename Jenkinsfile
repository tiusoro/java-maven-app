pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    echo 'building the application...' 
                    sh 'mvn clean package' 
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image..."
                    
                }
            }
        }
        
        stage("deploy") {
            steps {
                script {
                    echo 'deploying the application...'
                }
            
            }
            
        }
        
    }
}
