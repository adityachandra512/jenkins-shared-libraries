def call(String Project, String ImageTag) {
    withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
        sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}
