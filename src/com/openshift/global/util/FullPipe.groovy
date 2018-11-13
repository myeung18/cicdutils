package com.openshift.global.util

def call() {

    pipeline {   
      agent any
      tools {
        maven 'maven-3'
        jdk 'jdk1.8.0'
      }
      parameters {
        string(name:'UserId', defaultValue:'-userId value-', description: 'used for testing')
      }
      environment {
        TIMEZONE = "eastern"
      }
      stages{
           stage('checkout git') {
                steps {
                    git 'https://github.com/myeung18/fuse-financial-cicd.git'
                }
            }
          stage('build') {
              steps {
                  sh 'cd fisdemoaccount ; '
                  sh 'ls -list'
              }
          }

          stage ('test') {
              steps {
                  sh "ls -last"
              }
          }

          stage('deploy developmentServer'){
              steps {
                  sh "ls -last"
              }
          }

          stage('deploy staging'){
              steps {
                  sh "ls -last"
              }
          }

          stage('deploy production'){
              steps {
                  sh "ls -last"
              }
          }
          stage("Loading stage") {           
              steps { 
                  script {
                    def classCall = load("/home/myeung/git/cicdutils/src/com/openshift/global/util/Tester.groovy")
                    classCall("Please verify this Tester call.", this)

                  }
              }
          }

      } //stages
      post {
          failure {
              echo " some stage failed "
              echo " mail to: params.UserId, subject: 'Pipeline failed', body: "
          }
      }  
    }
}
