package com.openshift.global.util

def call(String msg, script) {
    println "Hello --  ${msg}"

    script.sh ${script.env.BUILD_TAG}

    openshift.withCluster( 'https://192.168.99.100:8443', 'hGku3oS9N25M69yQ_Np-2_LndFAtl6XJbGL41gXfVM8' ) {
        openshift.withProject( 'fisdemo' ) {
            echo "Creating new app in project ${openshift.project()} in cluster ${openshift.cluster()}"
            echo "=============creating============================================"


            echo "=============building============================================"

        }
    }
}

return this
