pipeline {
   agent any
   tools {
      jdk 'jdk8'
      maven 'maven'
   }
   stages {
      stage('test java installation') {
         steps {
            sh 'java -version'
         }
      }
      stage('test maven installation') {
         steps {
            sh 'mvn -version'
         }
      }
   }
}