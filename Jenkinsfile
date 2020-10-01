pipeline {
    agent {
      node {
          label 'ecs-slave'
      }
    }
    stages {
        stage('Start ECS') {
            steps {
                echo "Starting the ECS service"
                withCredentials([[
                    $class: 'AmazonWebServicesCredentialsBinding',
                    credentialsId: 'aws-credential',
                    accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                    secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
                ]]) { 
                    sh '''
					    ecs-cli compose \
					    --project-name java-springboot-api-3 service \
					    up \
					    --create-log-groups \
					    --cluster cib-cross-service-fargate \
					    --launch-type FARGATE \
					    --region eu-west-2
				    '''
                }
                echo "The ECS service was started"
            }
        }
        stage('Wait User Task') {
            input {
                message "Should we continue?"
            }
            steps {
                echo "Continuing the pipeline"
            }
        }
        stage('Stop ECS') {
            steps {
                echo "Stoping the ECS service"
                withCredentials([[
                    $class: 'AmazonWebServicesCredentialsBinding',
                    credentialsId: 'aws-credential',
                    accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                    secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
                ]]) { 
                    sh '''
                        ecs-cli compose \
                        --project-name java-springboot-api-3 service \
                        down \
                        --cluster cib-cross-service-fargate \
                        --region eu-west-2
                    '''
                }
                echo "The ECS service was stopped"
            }
        }
    }
}