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