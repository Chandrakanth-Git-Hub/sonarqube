node {
  stage('SCM') {
    checkout scm
  }

  stage('Build & SonarQube Analysis') {
    def mvn = tool 'Default Maven'

    withSonarQubeEnv('MySonarQubeServer') {
      sh """
        ${mvn}/bin/mvn clean verify sonar:sonar \
          -Dsonar.projectKey=passwd \
          -Dsonar.projectName='my-project-1' \
          -Dsonar.token=$SONAR_AUTH_TOKEN
      """
    }
  }

  stage('Quality Gate') {
    timeout(time: 15, unit: 'MINUTES') {
      def qg = waitForQualityGate abortPipeline: true
      echo "Quality Gate status: ${qg.status}"
    }
  }
}

