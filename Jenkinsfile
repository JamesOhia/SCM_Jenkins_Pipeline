pipeline{
  agent any
  environment{
    VERSION = "1.1"
    CREDENTIALS = credentials('Test-Script')
  }
  parameters{
    choice(name: 'version', choices: ['1.1', '1.2', '1.3', '1.4'], description:'Version to select')
    booleanParam(name: 'executeTest', defaultValue: true, description:'Either Test should be executed or skipped')
  }
  stages{
    stage("Build"){
      when{
        expression{
          BRANCH_NAME == 'Dev'
        }
      }
      steps{
          echo "This is the build stage"
          echo "The credentials is ${CREDENTIALS}"
        } 
      }
    stage("Test"){
       when{
        expression{
          params.executeTest
        }
      }
      steps{
        echo "This is the Test stage"
        echo "This is version ${VERSION}"
      }
    }
    stage("Deploy"){
      steps{
        echo "This is the Deployment stage"
        echo "The version we are deploying is ${params.version}"
      }
    }
  }
}
