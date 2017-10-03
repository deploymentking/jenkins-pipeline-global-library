
def execute(int buildNumber) {
  pipeline {
    agent any

    stages {
      stage('Debug Build Number') {
        steps {
          echo "The build number is ${buildNumber}"
        }
      }
      stage('MVN Clean') {
        steps {
          sh 'mvn clean'
        }
      }
    }
    post {
      success {
      }
      always {
        deleteDir()
      }
    }
  }
}
