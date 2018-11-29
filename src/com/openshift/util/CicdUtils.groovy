package com.openshift.util

class CicdUtils {
    static def cmdDeploy(args) {
        sh ''' 
            
            cd ${args}

            mvn package -Dmaven.test.skip=true 
            
            oc login https://master.rhdp.ocp.cloud.lab.eng.bos.redhat.com:8443 --token=WddnuYe5y7_7CslKND9tWdS2vn6CRLR5eRu5OlOrITI 
            
            oc project justfortesting                    

            mvn fabric8:deploy -Dmaven.test.skip=true -Dmysql-service-username=root -Dmysql-service-password=ncPIGN8cKa5Aki4c   
        '''
    }
    
    static def cmdNpmDeploy(args) {
        sh '''
            cd ${args}

            oc login https://master.rhdp.ocp.cloud.lab.eng.bos.redhat.com:8443 --token=WddnuYe5y7_7CslKND9tWdS2vn6CRLR5eRu5OlOrITI 
            
            oc project justfortesting                    

            export PATH=$PATH:/usr/local/bin 
                
            npm install && npm run openshift
        '''
    }
    
    static def gBuild(script, args) {
       /* script.openshift.withCluster( 'https://192.168.99.100:8443', 'fPGEwgpEqTLKwZ-ND4d4tA66niHehV7tnzotlCBcvT4' ) {
            script.openshift.withProject( 'fisdemo' ) {
                echo "Hello from project ${script.openshift.project()} in cluster ${script.openshift.cluster()}"
            }
        } */

        println " ${args} " 
    }

}
