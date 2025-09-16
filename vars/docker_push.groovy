def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerhubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
