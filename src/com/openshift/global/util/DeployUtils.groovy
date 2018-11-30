package com.openshift.global.util

def cmdDeploy() {
    println "passed in  ${env.serviceName} " 
    node('maven') {
    sh ''' 
        
        cd ${serviceName}
        
        mvn package -Dmaven.test.skip=true 
        oc login ${openShiftHost} --token=${openShiftToken} 
        oc project justfortesting                    

        mvn fabric8:deploy -Dmaven.test.skip=true -Dmysql-service-username=root -Dmysql-service-password=ncPIGN8cKa5Aki4c   
        '''
    }
}

def cmdNpmDeploy() {
    println "passed in  ${env.serviceName} " 
    sh '''
        cd ${serviceName}

        oc login ${openShiftHost} --token=${openShiftToken} 
        oc project justfortesting                    

        export PATH=$PATH:/usr/local/bin 
            
        npm install && npm run openshift
    '''
}
    

