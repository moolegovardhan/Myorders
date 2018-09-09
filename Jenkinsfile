node{
   stage('SCM Checkout'){
     git 'https://github.com/moolegovardhan/MyOrders'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'maven', type: 'maven' 
      def mvnCMD = "${mvnHome}/bin/mvn"
      sh "${mvnCMD} clean package"
   }
   stage('Build Docker Iamge'){
     sh 'docker build -t moolegovardhan/myorders:1.1 .'
   }
   stage('push Docker Iamge'){
      withCredentials([string(credentialsId: 'dockerpwd', variable: 'dockerHubPwd')]) {
         sh "docker login -u moolegovardhan -p ${dockerHubPwd}"
      }
      sh 'docker push moolegovardhan/myorders:1.1'
      echo "docker images push to docker hub"
   }
   stage('Run Image'){
    sh "docker run -d --rm -p 9090:9090 --name myorders moolegovardhan/myorders:1.1"
      echo "Application started on port"  
   }
   
   
}
