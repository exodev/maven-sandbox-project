#!groovy
node('ci-docker') {

  stage 'Check Jenkinsfile'
  readTrusted 'Jenkinsfile'

  stage 'Pull eXo Docker Image'
  def eXoJDKMaven = docker.image('exoplatform/ci:jdk8-maven32');
  eXoJDKMaven.pull()

  stage 'Checkout SCM'
  checkout scm

  stage 'Build'

  try {
      // Use custom settings.xml file on project workspace directory
       wrap([$class: 'ConfigFileBuildWrapper', managedFiles: [[fileId: 'exo-ci-maven-settings', targetLocation: 'settings.xml', variable: '']]]) {
         eXoJDKMaven.inside() {
           sh 'mvn install -s settings.xml'
         }
       }
  } finally {
       //clean local copy
       sh 'rm -f settings.xml'
  }
}