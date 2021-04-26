pipeline {
    agent {
       label "jdk-8"
    }
    tools {nodejs "node"}
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}
