pipeline {
    agent any

    tools {
        maven 'Maven'
      
    }

    environment {
        IMAGE_NAME = "traineeapi"
        DOCKERHUB_USER = "shreya2908"
        CONTAINER_NAME = "traineeapi-container"
    }

    stages {

        stage('Build JAR') {
            steps {
             
                    bat 'mvn clean package -DskipTests'
                
            }
        }

        stage('Build Docker Image') {
            steps {
             
                    bat 'docker build -t traineeapi .'
                
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'jenkins',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    bat '''
            docker logout
            docker login -u %USER% -p %PASS%
            '''
                }
            }
        }

        stage('Tag Image') {
            steps {
                bat 'docker tag traineeapi %DOCKERHUB_USER%/traineeapi:latest'
            }
        }

        stage('Push to DockerHub') {
            steps {
                bat 'docker push %DOCKERHUB_USER%/traineeapi:latest'
            }
        }

        stage('Deploy using Docker Compose') {
            steps {
                bat '''
                    docker-compose down
                    docker-compose up -d --build
                    '''
            }
        }
    }
}
