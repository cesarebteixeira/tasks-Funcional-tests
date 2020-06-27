pipeline {
	agent any
	stages {
		stage ('Build test funcional') {
			steps {
				bat 'mvn clean package -DskipTests=true'
			}
		}			
	}
}

 