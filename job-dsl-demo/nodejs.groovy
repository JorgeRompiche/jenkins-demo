job('nodejs-example') {
    scm {
        git('https://github.com/JorgeRompiche/nodejs-app-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Jorge Rompiche')
            node / gitConfigEmail('jarh@mail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}