pipeline{
  agent any
  environment{
    VERSION = "1.1"
  }
  stages{
    stage("Build"){
      when{
        expression{
          BRANCH_NAME == "Dev"
        }
      }
      steps{
        echo "This is the build stage"
      }
    }
    stage("Test"){
      steps{
        echo "This is the Test stage"
        echo "This is version ${VERSION}"
      }
    }
    stage("Deploy"){
      steps{
        echo "This is the Deployment stage"
      }
    }
  }
}
