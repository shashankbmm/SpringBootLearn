pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "shashank3006/shashankapp"
        DOCKER_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/shashankbmm/SpringBootLearn'
            }
        }

        stage('Build JAR') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: 'dockerhub-creds', url: '' ]) {
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh """
                docker stop shashankapp || true
                docker rm shashankapp || true
                docker run -d --name shashankapp -p 8080:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}
                """
            }
        }
    }
}
