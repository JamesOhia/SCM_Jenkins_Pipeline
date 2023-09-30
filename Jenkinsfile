pipeline{
  agent any
  stages{
    stage("Build"){
      steps{
        when{
          expression{
            BRANCH_NAME == 'Dev'
          }
        }
        echo "This is the build stage"
      }
    }
    stage("Test"){
      steps{
        echo "This is the Test stage"
      }
    }
    stage("Deploy"){
      steps{
        echo "This is the Deployment stage"
      }
    }
  }
}
