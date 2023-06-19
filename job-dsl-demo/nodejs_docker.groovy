job('nodejs-docker-example'){
    scm {
        git('https://github.com/JorgeRompiche/nodejs-app-demo.git') { node -> 
            node / gitConfigName('Jorge Rompiche')
            node / gitConfigEmail('jarh@mail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('jorgearh/nodejs-app-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}