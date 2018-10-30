
package com.openshift.global.util

def call(String msg) {
    println "Hello --  ${msg}"

    openshift.withCluster( 'https://192.168.99.100:8443', 'fPGEwgpEqTLKwZ-ND4d4tA66niHehV7tnzotlCBcvT4' ) {
        openshift.withProject( 'fisdemo' ) {
            echo "Hello from project ${openshift.project()} in cluster ${openshift.cluster()}"
        }
    }
}

return this
