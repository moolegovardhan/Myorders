node{
   stage('SCM Checkout'){
      git credentialsId: '1e1838fb-7ac7-4d0f-b7b1-cb7e897b56bf', url: 'https://github.com/moolegovardhan/MyOrders.git'
     //git 'https://github.com/moolegovardhan/MyOrders'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'maven', type: 'maven' 
      def mvnCMD = "${mvnHome}/bin/mvn"
      sh "${mvnCMD} clean package"
   }
   
   
}
