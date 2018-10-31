
package com.openshift.global.util

def call(String msg) {
    println "Hello --  ${msg}"
    def templatePath = 'https://raw.githubusercontent.com/RHsyseng/amq7/master/S2I-Base-Image/yaml_templates/amq_image_template.yaml'
    def templateSinglePath = 'https://raw.githubusercontent.com/RHsyseng/amq7/master/S2I-Base-Image/yaml_templates/amq_single_template.yaml'
    // name of the template that will be created
    def templateName = 'amq7-refarch'
    def imageName = 'amq7-image'

    openshift.withCluster( 'https://192.168.99.100:8443', 'hGku3oS9N25M69yQ_Np-2_LndFAtl6XJbGL41gXfVM8' ) {
        openshift.withProject( 'fisdemo' ) {
            echo "Creating new app in project ${openshift.project()} in cluster ${openshift.cluster()}"
            echo "=============creating============================================"

            openshift.newApp(templatePath)

            echo "=============building============================================"

            def bld = openshift.startBuild(imageName)
            bld.untilEach {
                return (it.object().status.phase == "Complete")
            }
            bld.logs('-f')

        }
    }
}

return this
