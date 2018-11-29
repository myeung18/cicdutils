package com.openshift.global.util

def cmdDeploy(args) {
     println "passed in ${args} " 
    sh ''' 
        
        mvn package -Dmaven.test.skip=true 
        
        oc login https://master.rhdp.ocp.cloud.lab.eng.bos.redhat.com:8443 --token=WddnuYe5y7_7CslKND9tWdS2vn6CRLR5eRu5OlOrITI 
        
        oc project justfortesting                    

        mvn fabric8:deploy -Dmaven.test.skip=true -Dmysql-service-username=root -Dmysql-service-password=ncPIGN8cKa5Aki4c   
    '''
}


