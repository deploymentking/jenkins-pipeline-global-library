package io.thinkstack.jenkinslibs

def execute() {
  pipeline {
    agent any
    options {
      buildDiscarder(logRotator(numToKeepStr: '10'))
      disableConcurrentBuilds()
      timestamps()
      timeout(time: 1, unit: 'HOURS')
    }
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
