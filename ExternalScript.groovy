def build(){
    echo "This is an external script function";
    echo "This is the build stage"
    echo "The credentials is ${CREDENTIALS}"
}

def test(){
    echo "This is the Test stage"
    echo "This is version ${VERSION}"
}

def deploy(){
     echo "This is the Deployment stage"
    echo "The version we are deploying is ${params.version}"
}

def newmanInstall(){
    bat "npm install -g newman"
    bat "npm install -g newman-reporter-htmlextra"
}

def newmanRun(){
    bat "newman run BAAS_Account_Enquiry.postman_collection.json -e BAAS_Environment.postman_environment.json --disable-unicode -r htmlextra"
}

return this