pipeline {
    agent {
        docker { image 'jenkinssb' }
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
    	
	    
        stage('Build') {
            steps {
                
    			sh './gradlew build'
            }
        }
         stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Build Docker Image') {
            steps {
                app = docker.build("vadudduk/jenkinssbj") 
            }
        }

    }
}