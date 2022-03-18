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

		
		stage('Stop docker container'){
            steps{
                script{
                
                    def doc_containers = sh(returnStdout: true, script: "docker ps --filter name=jenkinssb --format '{{.Names}}'").replaceAll("\n", " ") 
                    if (doc_containers) {
                        sh "docker stop ${doc_containers}"
                    }
                    
                }
            }
        }
		
		stage('Remove docker containers'){
            steps{
                script{
                
                    def doc_containers = sh(returnStdout: true, script: "docker ps --filter status=exited --filter name=jenkinssb --format '{{.Names}}'").replaceAll("\n", " ") 
                    if (doc_containers) {
                        sh "docker rm ${doc_containers}"
                    }
                    
                }
            }
        }
        
		stage('Push and Run') {

			steps {
				sh 'docker image tag jenkinssb jenkinssb'
				
				sh 'docker run -d  -p 8081:8081 --name jenkinssb -v jendoc --network jendoc -e spring.datasource.url=jdbc:hsqldb:hsql://hsqldb/test jenkinssb'
			}
		}

    }
}