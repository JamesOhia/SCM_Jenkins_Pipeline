def gv
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
    stage("init"){
      steps{
        script{
          gv = load "ExternalScript.groovy"
        }
      }
    }
    stage("Build"){
      when{
        expression{
          BRANCH_NAME == 'Dev'
        }
      }
      steps{
          script{
            gv.build();
          }
        } 
      }
    stage("Test"){
       when{
        expression{
          params.executeTest
        }
      }
      steps{
        script{
          gv.test();
        }
      }
    }
    stage("Deploy"){
      steps{
       script{
        gv.deploy();
       }
      }
    }
  }
}
