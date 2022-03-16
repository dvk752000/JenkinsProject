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
                sh 'docker build --build-arg JAR_FILE=build/libs/*.jar -t jenkinssb .'
            }
        }
        
        stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker image tag jenkinssb vadudduk/jenkinssbj'
				sh 'docker push vadudduk/jenkinssbj'
			}
		}

    }
}