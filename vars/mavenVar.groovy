
def execute() {
  pipeline {
    agent any

    stages {
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
