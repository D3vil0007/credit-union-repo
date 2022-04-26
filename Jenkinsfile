pipeline {
  agent any
  stages {	
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			
			bat label: 'Compilation running', script: '''mvn -f credit-union-project/pom.xml compile'''
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			bat label: 'Test running', script: '''mvn -f credit-union-project/pom.xml test'''
	       
       		}
   	}

	stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
		}
	}
       
       stage('SonarQube'){
		steps{
				bat label: '', script: '''mvn -f credit-union-project sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.login=5fc0c4a52f4471ae10503f6e8e9000e92a955f9f'''
			}
   		}
	
	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
			bat label: 'Project packaging', script: '''mvn -f credit-union-project/pom.xml package'''
		}
	} 		
    
  }
}
