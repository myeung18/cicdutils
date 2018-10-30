package com.openshift.util

class CicdUtils {
    static def gBuild(script, args) {
       /* script.openshift.withCluster( 'https://192.168.99.100:8443', 'fPGEwgpEqTLKwZ-ND4d4tA66niHehV7tnzotlCBcvT4' ) {
            script.openshift.withProject( 'fisdemo' ) {
                echo "Hello from project ${script.openshift.project()} in cluster ${script.openshift.cluster()}"
            }
        } */

        println " ${args} " 
    }

}
return new CicdUtils()
