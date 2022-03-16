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
        stage('Push image') {
                      docker.withRegistry('https://registry.hub.docker.com', 'git') {                   app.push("${env.BUILD_NUMBER}")            
       app.push("latest")        
              }    
           }
    }
}