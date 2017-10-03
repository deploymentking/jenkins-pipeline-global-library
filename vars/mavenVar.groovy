def call(int buildNumber) {
  pipeline {
    agent any

    stages {
      stage('Debug Build Number') {
        steps {
          echo "The build number is ${buildNumber}"
        }
      }
      stage('Debug Branch Name') {
        when {
          branch '*/master'
        }
        steps {
          echo "The branch name is ${env.BRANCH_NAME}"
        }
      }
//      stage('MVN Clean') {
//        steps {
//          sh 'mvn clean'
//        }
//      }
    }
    post {
      always {
        deleteDir()
      }
    }
  }
}
