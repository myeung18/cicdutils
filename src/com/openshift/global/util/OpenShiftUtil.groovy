
package com.openshift.global.util

def call(String msg) {
    println "Hello --  ${msg}"
    def templatePath = 'https://raw.githubusercontent.com/RHsyseng/amq7/master/S2I-Base-Image/yaml_templates/amq_image_template.yaml'
    def templateSinglePath = 'https://raw.githubusercontent.com/RHsyseng/amq7/master/S2I-Base-Image/yaml_templates/amq_single_template.yaml'
    // name of the template that will be created
    def templateName = 'amq7-refarch'
    def imageName = 'amq7-image'

    openshift.withCluster( 'https://192.168.99.100:8443', 'fPGEwgpEqTLKwZ-ND4d4tA66niHehV7tnzotlCBcvT4' ) {
        openshift.withProject( 'fisdemo' ) {
            echo "Hello from project ${openshift.project()} in cluster ${openshift.cluster()}"


            openshift.newApp(templatePath) 
        }
    }
}

return this
