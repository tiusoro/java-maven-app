#!/usr/bin/env groovy

@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'openjdk'        
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('Build Jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    buildImage()
                }
            }
        }
        
        stage('deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            
            }
            
        }
        
    }
}
