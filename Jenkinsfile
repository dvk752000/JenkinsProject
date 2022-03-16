pipeline {
    agent any
    
    environment {
    	DOCKERHUB_CREDENTIALS=credentials('dockerhub')
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
                sh 'docker build  -t jenkinssb .'
            }
        }

    }
}