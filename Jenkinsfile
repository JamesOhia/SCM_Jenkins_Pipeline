pipeline{
  agent any
  stages{
    stage("Install Newman"){
      steps{
        // Install Node.js if it's not already installed
                    def nodeVersion = sh(script: 'node -v', returnStatus: true)
                    if (nodeVersion != 0) {
                        sh 'curl -sL https://deb.nodesource.com/setup_14.x | sudo -E bash -'
                        sh 'sudo apt-get install -y nodejs'
                    }

                    // Install Newman using npm
                    sh 'npm install -g newman'
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
