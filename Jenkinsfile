pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    docker { image 'jenkinssb' }
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
    }
}