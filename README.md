# Think Stack Pipeline Global Library (ThinkStackJenkinsLibs)

## Table of contents

<!-- toc -->

- [Introduction](#introduction)
- [Boilerplate Jenkinsfile](#boilerplate-jenkinsfile)
- [Example Groovy build script](#example-groovy-build-script)
- [References](#references)

<!-- tocstop -->

## Introduction
The pipeline library will contain all the groovy scripts required to test Jenkinsfile functionality.

## Boilerplate Jenkinsfile
The following example shows the kind of boilerplate code that should be defined in a Jenkinsfile.
```groovy
@Library('ThinkStackJenkinsLibs')
def runner = new io.thinkstack.jenkinslibs.maven()
runner.execute()
```

## Example Groovy build script
```groovy
def execute() {
	pipeline {
	    agent any
	    tools {
	        maven 'Maven 3.3.9'
	        jdk 'jdk8'
	    }
	    stages {
	        stage ('Initialize') {
	            steps {
	                sh '''
	                    echo "PATH = ${PATH}"
	                    echo "M2_HOME = ${M2_HOME}"
	                '''
	            }
	        }

	        stage ('Build') {
	            steps {
	                sh 'mvn -Dmaven.test.failure.ignore=true install'
	            }
	            post {
	                success {
	                    junit 'target/surefire-reports/**/*.xml'
	                }
	            }
	        }
	    }
	}
}
```

## References
See this [documentation](https://jenkins.io/doc/book/pipeline/shared-libraries/) for details on shared libraries
See this [article](https://jenkins.io/blog/2017/02/07/declarative-maven-project/) for details on using Maven in a declarative pipeline
