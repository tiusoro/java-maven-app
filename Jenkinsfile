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
                    echo 'deploying docker image to EC2...'

                    // def shellCmd = "bash ./server-cmds.sh ${IMAGE_NAME}"
                    // def ec2Instance = "ec2-user@18.184.54.160"

                    // sshagent(['ec2-server-key']) {
                    //     sh "scp server-cmds.sh ec2-user@{ec2Instance}:/home/ec2-user"
                    //     sh "scp docker-compose.yaml ec2-user@{ec2Instance}:/home/ec2-user"
                    //     sh "ssh -o StrictHostKeyChecking=no ec2-user@{ec2Instance} ${shellCmd}"
                    // }
                }
            }               
        }
    }
}
