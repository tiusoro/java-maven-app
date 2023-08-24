#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing app version...'
                }
            }
        }
        stage('build app') {
            steps {
                script {
                echo 'building application jar...'
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo 'building the docker image...'
                
                }
            }
        } 
        stage("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -p 8090:3080 -d tiusoro/java-maven-app:jma-1.0'
                    sshagent(['ec2-instance-key']) {
                            sh "ssh -o StrictHostKeyChecking=no ec2-user@35.175.139.7 ${dockerCmd}"
                    }
                }
            }               
        }
    }
}
