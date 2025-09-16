def call(String Project, String ImageTag) {
    withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
       sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
