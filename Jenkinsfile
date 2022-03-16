pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
    	
    	stage('Init'){
    	    steps{
    	        sh './BasicRestApplication/gradlew init' 
    	    }

    	}

	    
        stage('Build') {
            steps {
                
    			sh './BasicRestApplication/gradlew build'
            }
        }
         stage('Test') {
            steps {
                sh './BasicRestApplication/gradlew test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh './BasicRestApplication/gradlew docker'
            }
        }
        stage('Run Docker Image') {
            steps {
                sh './BasicRestApplication/gradlew dockerRun'
            }
        }
    }
}