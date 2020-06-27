pipeline {
	agent any
	stages {
		stage ('Build test funcional mas sem os testes') {
			steps {
				bat 'mvn clean package -DskipTests=true'
			}
		}	
		stage ('Testes unitários') {
			steps {
				bat 'mvn test'
			}
		}		
	}
}

 