node {
  stage('SCM') {
    // Checkout code from the same SCM Jenkins is configured with
    checkout scm
  }

  stage('Build & SonarQube Analysis') {
    // Use the Maven tool configured in Jenkins (Manage Jenkins -> Tools)
    def mvn = tool 'Default Maven'

    // Use the SonarQube server configured in Jenkins (Manage Jenkins -> System -> SonarQube servers)
    withSonarQubeEnv('MySonarQubeServer') {
      sh """
        ${mvn}/bin/mvn clean verify sonar:sonar \
          -Dsonar.projectKey=passwd \
          -Dsonar.projectName='my-project-1'
      """
    }
  }

  stage('Quality Gate') {
    // This will fail the build if the Quality Gate is not passed
    timeout(time: 5, unit: 'MINUTES') {
      def qg = waitForQualityGate abortPipeline: true
      echo "Quality Gate status: ${qg.status}"
    }
  }
}
