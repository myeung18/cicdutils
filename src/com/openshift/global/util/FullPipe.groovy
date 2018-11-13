package com.openshift.global.util

def call() {
    //default method

    echo "default method"
} //call

def preparationWork() {
    //user pass in array of templates for resources creation

}
def checkOutAndBuild() {
    echo "job name : ${env.JOB_NAME}"

    echo "node name : ${env.NODE_NAME}"
    echo "EXECUTOR_NUMBER name : ${env.EXECUTOR_NUMBER}"
    echo "node name : ${env.NODE_NAME}"
    sh 'cd fisdemoaccount;  ls -list; mvn clean'
}

def checkout() {
}

return this
