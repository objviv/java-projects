pipeline {
  agent any
  stages {
    stage('git pull') {
      steps {
        git(url: 'git@github.com:objviv/java-projects.git', branch: 'master', changelog: true)
      }
    }

  }
}