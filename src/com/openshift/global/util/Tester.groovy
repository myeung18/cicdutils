package com.openshift.global.util

def call(String msg) {
    println "Hello --  ${msg}"
    
    println "Environment Variables : {TIMEZONE} and ${params.TOKEN} "

    sh "ls -last"

    pipeline {
        agent any
        stages {
            stage("fix it") {
                steps {
                    script {
                        //first define openshift credential and cluster entry in Jenkins console
                        openshift.withCluster() {
                            openshift.withProject( 'justfortesting' ) {
                                echo "Creating new app in project ${openshift.project()} in cluster ${openshift.cluster()}"
                                echo "=============creating============================================"


                                echo "=============building=======${params.TEMPLATE_PATH}=============="

                            }
                        }
                    }
                }
            }
        }
    }
     
}

def buildArtifact() {
    stage("build the artifact") {
        echo "build it"
        sh "ls -last"
    }
}

return this
