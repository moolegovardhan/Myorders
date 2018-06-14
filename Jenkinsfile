pipeline{
		agent any
		stages{
			stage('Build'){
				steps {
			sh 'mvn clean package'
			    }
			}
			post{
				echo 'now archiving...'
				archiveArtifacts artifacts: '**target/*.war
				
			}
		}
	}