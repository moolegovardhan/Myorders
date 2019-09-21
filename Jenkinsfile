node{
   stage('SCM Checkout'){
      git credentialsId: '1e1838fb-7ac7-4d0f-b7b1-cb7e897b56bf', url: 'https://github.com/moolegovardhan/MyOrders.git'
     //git 'https://github.com/moolegovardhan/MyOrders'
   }
   stage('Compile-Package'){
      // Get maven home path
      //def mvnHome =  tool name: 'Maven-3', type: 'maven' 
      def mvnHome = tool name: 'maven', type: 'maven'
      def mvnCMD = "${mvnHome}/bin/mvn"
      sh "${mvnCMD} clean install package"
   }
   stage('Build Docker Iamge'){
      sh 'docker build -t moolegovardhan/myorders:3.0.0 .'
   }
    stage('Push Docker Iamge'){
       withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
          sh "docker login -u moolegovardhan -p ${dockerHubPwd}"
     }
      
      sh 'docker push moolegovardhan/myorders:3.0.0'
   }
   stage('Run Container on Dev Server'){
      def dockerRun = 'docker run -p 8090:8090 -d -name MyOrders moolegovardhan/myorders:3.0.0'
      sshagent(['dev-server']) {
         sh 'ssh -o StrictHostKeyChecking=no centos@52.22.254.168 ${dockerRun}'
   } 
   }
}
