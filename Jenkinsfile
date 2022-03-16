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
                sh 'docker build --build-arg JAR_FILE=build/libs/\*.jar -t jenkinssb .'
            }
        }
        stage('Run Docker Image') {
            steps {
                sh 'docker run -d  -p 8081:8081 --name jenkinssb -v jendoc --network jendoc -e spring.datasource.url=jdbc:hsqldb:hsql://hsqldb/test jenkinssb'
            }
        }
    }
}