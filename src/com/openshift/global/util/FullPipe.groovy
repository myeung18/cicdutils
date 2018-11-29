package com.openshift.global.util

def call() {
    echo "***********************************************************"
    echo " initialize the OpenShift Environment                       "
    echo "***********************************************************"
    /*default method
        create new project 
    */
} //call

def preparationWork() {
    //user pass in array of templates for resources creation
    echo "***********************************************************"
    echo " Setup Openshift resources                                 "
    echo "***********************************************************"
    openshift.withCluster( 'eng_lab' ) {
        openshift.withProject( 'justfortesting' ) {
            echo "Creating new app in project ${openshift.project()} in cluster ${openshift.cluster()}"
            //openshift.create('amq62-openshift', ' --from=registry.access.redhat.com/jboss-amq-6/amq62-openshift', '--confirm') 
            //sh 'oc login https://master.rhdp.ocp.cloud.lab.eng.bos.redhat.com:8443 --token=rgJGPpryyoPskpGpzf5e6XMytbqoXHIeLMvcZdzKCR0 --insecure-skip-tls-verify' 
            //sh 'oc project justfortesting ; oc import-image amq62-openshift --from=registry.access.redhat.com/jboss-amq-6/amq62-openshift --confirm'

        }
    }
}

def checkOutSourceCode() {
    echo "***********************************************************"
    echo " Checkout source code from SCM                             "
    echo "***********************************************************"
    echo "job name : ${env.JOB_NAME}"


    //**** Just error handling teseting *****/
    try {
        timeout (time:3, unit:'SECONDS') {
           input message:  'Is it Ok to Continue?' 
        }
    } catch (exception) {
        echo "I didn't get user input"
    }
    git 'https://github.com/myeung18/fuse-financial-cicd.git'

}

def buildAndTest() {
    echo "***********************************************************"
    echo " Build with SCM                                            "
    echo "***********************************************************"
    echo "node name : ${env.NODE_NAME}"
    sh 'cd fisdemoaccount; ls -list; mvn clean'
}

def deploy() {
    echo "***********************************************************"
    echo " Deploy to OpenShift                                       "
    echo "***********************************************************"

    sh 'cd fisdemoaccount; ls -list;'  
    sh 'mvn fabric8:deploy -Dmysql-service-username=dbuser -Dmysql-service-password=password'
}

def moveToUAT() {

}

def moveToProd() {
    
}
return this
