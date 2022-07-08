def call(credId,userName,ipAddrs){
  sshagent(['credId']) {
 
    ipAddrs.each{ipAddr->
        sh "mv target/*.war target/santhosh.war"
        sh "scp -o StrictHostKeyChecking=no target/santhosh.war ${userName}@${ipAddr}:/opt/tomcat9/webapps/"
        sh "ssh ${userName}@${ipAddr} /opt/tomcat9/bin/shutdown.sh"
        sh "ssh ${userName}@${ipAddr} /opt/tomcat9/bin/startup.sh"
    }
  }
}
