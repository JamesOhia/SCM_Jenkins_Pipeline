pipeline{
  agent any
  tools{
    maven 'MaveName'
    gradle
    jdk
  }
  
  environment{
    VERSION = "1.1"
    CREDENTIALS = credentials('Test-Script')
  }
  parameters{
    //DataType(name, defaultValue, description)
    string(name: 'versionMain', defaultValue: '1.1', description: 'The default Version to deploy');
    choice(name: 'version', choices '[1.1, 1.2, 1.3, 1.4]', description:'')
    booleanParams(name: 'executeTest', defaultValue: true, description:'Either Test should be executed or skipped')
  }
  stages{
    stage("Build"){
      when{
        expression{
          BRANCH_NAME == "Dev" && param.executeTest
        }
      }
      steps{
        withCredentials([usernamePassword(credentials: "Test-Script", usernameVariables: "USER", passwordVariables: "PASSWORD")]){
            sh "${USER} ${PASSWORD}"
        }
        echo "This is the build stage"
        echo "The credentials is ${CREDENTIALS}"
        sh "mvn install"
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
        echo "The version we are deploying to is ${param.version}"
      }
    }
  }
}
