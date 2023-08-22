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
                echo 'building application jar...'
                
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
                }                }
            }               
        }
    }
}
