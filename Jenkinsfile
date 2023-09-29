pipeline{
  agent any
  stages{
    stage("Install Newman"){
      steps{
        sh "npm install -g newman"
      }
    }
    stage("Run Collection"){
      steps{
        sh "newman run BAAS_Account_Enquiry.postman_collection.json -e BAAS_Environment.postman_environment.json"
      }
    }
    stage("Deploy"){
      steps{
        echo "This is the Deployment stage"
      }
    }
  }
}
