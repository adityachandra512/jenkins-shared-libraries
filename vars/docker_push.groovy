def call(String Project, String ImageTag, String DockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerhubcred',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
        sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
    }
}
