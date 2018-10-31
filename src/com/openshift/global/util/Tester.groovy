package com.openshift.global.util

def call(String msg, script) {
    println "Hello --  ${msg}"
    
    println "Environment Variables : ${TIMEZONE} and ${params.TOKEN} "

    sh "ls -last"
 
    //first define openshift credential and cluster entry in Jenkins console
    openshift.withCluster( 'localhost') {
        openshift.withProject( 'fisdemo' ) {
            echo "Creating new app in project ${openshift.project()} in cluster ${openshift.cluster()}"
            echo "=============creating============================================"


            echo "=============building=======${params.TEMPLATE_PATH}====================================="

        }
    }
}

return this
