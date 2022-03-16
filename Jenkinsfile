pipeline {
    agent any
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
                sh './gradlew bootBuildImage --imageName=jenkinssb'
            }
        }
        stage('Run Docker Image') {
            steps {
                sh 'docker run -it -p8080:8080 jenkinssb'
            }
        }
    }
}