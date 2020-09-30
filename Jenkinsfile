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
                sh '''
					ecs-cli compose \
					--project-name java-springboot-api service \
					up \
					--create-log-groups \
					--cluster cib-cross-service-fargate \
					--launch-type FARGATE \
					--region eu-west-2 \
					--aws-profile default
				'''
                echo "The ECS service was started"
            }
        }
        stage('Wait user permittions') {
            input {
                message "Should we continue?"
            }
        }
        stage('Stop ECS') {
            steps {
                echo "Stoping the ECS service"
               sh '''
                    ecs-cli compose \
                    --project-name java-springboot-api service \
                    down \
                    --cluster cib-cross-service-fargate \
                    --region eu-west-2 \
                    --aws-profile default
                '''
                echo "The ECS service was stopped"
            }
        }
    }
}