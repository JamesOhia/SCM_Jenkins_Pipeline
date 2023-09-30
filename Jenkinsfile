pipeline{
  agent any
  environment{
    VERSION = "1.30"
  }
  stages{
    stage("Build"){
      steps{
        when{
          expression{
            BRANCH_NAME == "Dev"
          }
        }
        echo "This is the build stage"
      }
    }
    stage("Test"){
      steps{
        echo "This is the Test stage"
        echo "The version is ${VERSION}"
      }
    }
    stage("Deploy"){
      steps{
        echo "This is the Deployment stage"
      }
    }
  }
}
